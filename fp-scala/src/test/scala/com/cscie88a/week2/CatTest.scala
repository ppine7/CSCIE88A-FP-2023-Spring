package com.cscie88a.week2

import com.cscie88a.testutils.StandardTest

class CatTest extends StandardTest {

  "Cat" should {
    val cat1 = Cat("kitty", "blue", "brown")
    "not take medicine" in {
      cat1.takeMedicine(true).shouldBe(false)
    }
  }
}
