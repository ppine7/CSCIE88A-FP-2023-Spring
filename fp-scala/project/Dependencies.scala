import sbt._

object Dependencies {
  lazy val scalaTest = Seq(
    "org.scalatest" %% "scalatest" % "3.2.13" % Test
  )

  val circeVersion = "0.13.0"

  lazy val core = Seq(
    // cats FP libary
    "org.typelevel" %% "cats-core" % "2.2.0",

    // support for JSON formats
    "io.circe" %% "circe-core" % circeVersion,
    "io.circe" %% "circe-generic" % circeVersion,

    // parallel collections
    "org.scala-lang.modules" %% "scala-parallel-collections" % "1.0.4",
    
    // akka streams
    "com.typesafe.akka" %% "akka-stream" % "2.6.19",

    // kafka streams
    "org.apache.kafka" %% "kafka-streams-scala" % "2.7.0",
    "com.goyeau" %% "kafka-streams-circe" % "0.6.3",
    
    // support for typesafe configuration
    "com.github.pureconfig" %% "pureconfig" % "0.15.0",

    // logging
    "com.typesafe.scala-logging" %% "scala-logging" % "3.9.2",
    "ch.qos.logback" % "logback-classic" % "1.2.3"
  )
}
