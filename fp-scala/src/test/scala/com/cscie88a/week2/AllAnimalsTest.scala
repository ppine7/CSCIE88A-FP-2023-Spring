package com.cscie88a.week2

import com.cscie88a.testutils.StandardTest

class AllAnimalsTest extends StandardTest {
  "Animal" should {

    
    "cat does not take medicine" in {
      val cat1 = Cat("kitty", "blue", "brown")
      cat1.takeMedicine(true).shouldBe(false)
    }

    "dog takes medicine" in {
      val dog1 = Dog("fido", "brown", "black")
      dog1.takeMedicine(true).shouldBe(true)
    }

  }
  
}
