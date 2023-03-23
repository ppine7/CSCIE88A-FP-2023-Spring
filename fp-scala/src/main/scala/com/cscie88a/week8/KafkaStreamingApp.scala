package com.cscie88a.week8

import com.typesafe.scalalogging.{ LazyLogging }
import java.time.Duration
import java.util.Properties
import org.apache.kafka.streams.kstream.Materialized
import org.apache.kafka.streams.scala.ImplicitConversions._
import org.apache.kafka.streams.{ KafkaStreams, StreamsConfig, Topology }
import org.apache.kafka.streams.scala.{ Serdes, StreamsBuilder }
import org.apache.kafka.streams.scala.kstream.{ KStream, KTable }
import org.apache.kafka.streams.kstream.{ Suppressed, TimeWindows, Windowed }
import org.apache.kafka.streams.scala.Serdes._
import com.goyeau.kafka.streams.circe.CirceSerdes._
import io.circe.generic.auto._
import cats._
import cats.implicits._
import io.circe.parser.decode
import io.circe.syntax._
import io.circe
import org.apache.kafka.streams.kstream.SessionWindows
import org.apache.kafka.streams.kstream.JoinWindows

object KafkaStreamingApp extends LazyLogging {

  // main entry point for kafka streaming application
  // run using
  // sbt -Dinput.topic=input_topic -Doutput.topic=output_topic "runMain com.cscie88a.week8.KafkaStreamingApp"
  def main(args: Array[String]): Unit = {
    // read input and output topics
    val inputTopic = KafkaConfig.getSystemProperty("input.topic", "input_topic")
    val outputTopic = KafkaConfig.getSystemProperty("output.topic", "output_topic")
    logger.info(s"using input topic: $inputTopic")
    logger.info(s"using output topic: $outputTopic")
    val props = KafkaConfig.kafkaConfig
    logger.info(s"using bootstrap servers: ${props.getProperty(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG)}")
    runStreamingApp(inputTopic, outputTopic, props)
  }

  // create and run streaming data pipeline
  private def runStreamingApp(
    inputTopic: String,
    outputTopic: String,
    kafkaProps: Properties
    ) = {
    val stream: KafkaStreams = new KafkaStreams(
      sensorEventByZip(inputTopic, outputTopic,"weather-counts3-by-zip"),
      kafkaProps
    )
    stream.start()
    sys.ShutdownHookThread {
      stream.close(Duration.ofSeconds(10))
    }
  }

  /**
    * aggregate weather events by zip code
    * A weather event record is of the form:
    * Topic input_topic[0], offset: 296, key: -61315227, \
    * payload: {
    *   "eventId":"f655ca97-07c1-467a-bc12-3b57d6f65444",
    *   "sensorId":"sensor-id-3",
    *   "sensorType":"sensorTypeF",
    *   "windDirection":"W",
    *   "eventTimestamp":1679381253675,
    *   "zipCode":"01832",
    *   "humidityPercentage":87.121735,
    *   "windSpeedInMPH":74,
    *   "pressureInAtm":0.0,
    *   "temperatureInCelcius":30.0
    * }
    * 
    * read data from input topic -> aggregate and transform data -> write to output topic
    * @param inputTopic
    * @param outputTopic
    * @param storeName
    * @return
    */
  def sensorEventByZip(
      inputTopic: String,
      outputTopic: String,
      storeName: String
    ): Topology = {

    // import for automatic serializer/deserializer
    import Serdes._

    // read data from input topic
    val builder = new StreamsBuilder
    val source: KStream[String, SensorEvent] =
      builder.stream[String, SensorEvent](inputTopic)

    // aggregate and transform data
    val transform: KTable[String, String] = 
      source
        .map((_, e) =>
          (e.zipCode, 1L)
        )                                           // 1. key by zipCode, map value to a count
        .groupByKey                                 // 2. group by zipCode
        .reduce(_ + _)(Materialized.as(storeName))  // 3. sum counts
        .mapValues {
          v => s"count: $v"
        }

    // write results to output topic
    transform.toStream.to(outputTopic)
    builder.build()
  }
  
}
