package com.cscie88a.prereq

import org.scalatest.{ BeforeAndAfterAll, Matchers, WordSpec }

class PrerequisiteTest extends WordSpec with Matchers with BeforeAndAfterAll {

  val eps = 0.01 // specify error range for loss of precision with Double

  "celsiusToFahrenheit" should {
    "convert correctly for 0" in {
      Prerequisite.celsiusToFahrenheit(0.0) shouldBe 32.0
    }
    "convert correctly for 32" in {
      Prerequisite.celsiusToFahrenheit(
        -17.78
      ) shouldBe 0.0 +- eps // specify error range for loss of precision with Double
    }
    "convert correctly for 100" in {
      Prerequisite.celsiusToFahrenheit(100) shouldBe 212.0
    }
  }

  "stringToTemperature" should {
    "convert a valid double string" in {
      Prerequisite.stringToTemperature("12.2") shouldBe Some(12.2)
    }
    "skip a comment line" in {
      Prerequisite.stringToTemperature("# should be skipped") shouldBe None
    }
    "skip a invalid string" in {
      Prerequisite.stringToTemperature("12.2X") shouldBe None
    }
  }

  "processLines" should {
    val processedLines = List("10", "15", "20")
    val unprocessedLines = List("# ignored", "30-xx")

    "convert all valid lines" in {
      Prerequisite.processLines(processedLines).size shouldBe 3
    }
    "ignore all invalid lines" in {
      Prerequisite.processLines(unprocessedLines).size shouldBe 0
    }
    "convert only valid lines in list with valid and invalid lines" in {
      Prerequisite
        .processLines(processedLines ++ unprocessedLines ++ processedLines)
        .size shouldBe 6
    }

  }

}
