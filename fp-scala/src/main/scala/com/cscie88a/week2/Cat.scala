package com.cscie88a.week2

final case class Cat(
    name: String,
    eyeColor: String,
    bodyColor: String
  ) extends Animal(name, eyeColor, bodyColor) {
  
  override def takeMedicine(withTreat: Boolean): Boolean = {
    println("you cant trick me")
    false
  }

}
