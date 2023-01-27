package com.cscie88a.prereq

import java.io.File
import java.io.PrintWriter

import scala.io.Source
import com.cscie88a.config.ConfigUtils
import pureconfig.generic.auto._
import com.typesafe.scalalogging.LazyLogging

import scala.util.Try

// config for input and output paths
case class DataConfig(celsiusdata: String, fahrenheitdata: String)

object Prerequisite extends LazyLogging {

  /** converts celsius to fahrenheit
    * (a pure function for testability)
    * @param temp
    * @return
    */
  def celsiusToFahrenheit(temp: Double): Double = 32.0 + (temp * 9.0 / 5.0)

  /** convert raw string to Double ignoring
    * 1. any lines that start with '#'
    * 2. conversion errors
    * (a pure function for testability)
    * @param line
    * @return
    */
  def stringToTemperature(line: String): Option[Double] =
    if (line.startsWith("#"))
      None
    else {
      Try {
        line.toDouble
      }.toOption
    }

  /** processing pipeline (a pure function for testability)
    * @param lines
    * @return
    */
  def processLines(lines: List[String]): List[Double] =
    lines
      .map(stringToTemperature) // 1. convert strings to Double
      .flatten // 2. ignore unprocessed lines
      .map(celsiusToFahrenheit) // 3. convert to fahrenheit

  /** Main program that reads configuration and calls processing functions
    * @param args
    */
  def main(args: Array[String]) = {
    // get file location from config
    val fileConfig =
      ConfigUtils.loadAppConfig[DataConfig]("com.cscie88a.problem1")
    logger.info(
      s"reading from ${fileConfig.celsiusdata} and writing to ${fileConfig.fahrenheitdata}"
    )

    val fahrenheitLines: List[Double] =
      (readFileLines _ andThen processLines)(fileConfig.celsiusdata)

    writeToFile(fileConfig.fahrenheitdata, fahrenheitLines.mkString("\n"))
    logger.info(s"${fahrenheitLines.size} lines converted")
  }

  // read from file
  def readFileLines(path: String): List[String] =
    Source
      .fromFile(path)
      .getLines()
      .toList

  // write to file
  def writeToFile(path: String, contents: String): Unit = {
    val writer = new PrintWriter(new File(path))
    writer.write(contents)
    writer.close()
  }
}
