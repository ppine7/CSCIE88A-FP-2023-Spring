package com.cscie88a.week7

import com.cscie88a.testutils.{StandardTest}

// TODO: Complete the unit tests below
class WordListTest extends StandardTest {
  "WordList" when {
    val words = "streams are lazy and lists are eager".split(" ").toList

    "using group by operations" should {

      "create groups of words starting with the first letter sequentially" in {
        succeed
      }

      "create groups of words starting with the first letter concurrently" in {
        succeed
      }

    }
  }

}
