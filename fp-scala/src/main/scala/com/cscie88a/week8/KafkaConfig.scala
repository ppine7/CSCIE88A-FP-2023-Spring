package com.cscie88a.week8

import java.util.Properties
import org.apache.kafka.streams.StreamsConfig
import org.apache.kafka.common.serialization._
import java.nio.file.Paths

/**
  * provides common configuration setup for kafka streaming applications
  */
object KafkaConfig {

  def getSystemProperty(propName: String, defaultValue: String): String = 
    System.getProperty(propName,defaultValue)
  
  /**
   * creates a new Kafka configuration with the transaction config properties
   * pass in the parameters in the command line using the flags below
   * -Dapplication.id="myapp" -Dbootstrap.servers="localhost:9092" -Dclient.id="myclient"
   * @return
   */
  def kafkaConfig: Properties = {
    val applicationId = getSystemProperty(StreamsConfig.APPLICATION_ID_CONFIG, "kafka-streams-app2")
    val config = new Properties()
    val bootstrapServers = getSystemProperty(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092")
    val clientId = getSystemProperty(StreamsConfig.CLIENT_ID_CONFIG, "kafka-streams-client-1")
    config.setProperty(StreamsConfig.APPLICATION_ID_CONFIG, applicationId)
    config.setProperty(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers)
    config.setProperty(StreamsConfig.CLIENT_ID_CONFIG, clientId)
    config.setProperty(
      StreamsConfig.COMMIT_INTERVAL_MS_CONFIG,
      10000.toString()
    ) // commit every 10 seconds
    config
  }

  
}
