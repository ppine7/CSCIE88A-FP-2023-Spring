package com.cscie88a.week3

import com.cscie88a.testutils.StandardTest

// TODO complete unit tests below
class AdoptionServiceTest extends StandardTest {
  "AdoptionService" when {
    val service = AdoptionService

    "adopting with no args" should {

      "adopt animal if animal is ready for adoption and fee paid" in {
        false shouldBe false
      }

      "not adopt animal if animal is not ready for adoption and fee paid" in {
        true shouldBe true
      }
    }

    "adopting with one arg" should {

      "adopt animal if animal is not ready for adoption and fee paid" in {
        false shouldBe false
      }

      "not adopt animal if animal is not ready for adoption and fee paid" in {
        true shouldBe true
      }
    }

  }

}
