package com.cscie88a.week2

import com.cscie88a.testutils.StandardTest

class DogTest extends StandardTest {

  "Dog" should {
    val dog1 = Dog("fido", "brown", "black")

    "take medicine with treat" in {
      dog1.takeMedicine(true) shouldBe true
    }

  }
}
