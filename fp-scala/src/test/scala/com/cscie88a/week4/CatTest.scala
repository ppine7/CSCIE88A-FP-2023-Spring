package com.cscie88a.week4

import com.cscie88a.testutils.StandardTest

class CatTest extends StandardTest {
  // TODO: write your unit tests below
  "Cat collections" when {

    // val catList: List[Cat] = ???

    "calling averageAge" should {
      "calculate average age in a list of cats" in {
        succeed
      }
    }

    "calling averageCheckedAge" should {
      "calculate average age only for cats with completed health checks" in {
        succeed
      }
    }


  }
}
