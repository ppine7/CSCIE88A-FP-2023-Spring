package com.cscie88a.week2

final case class Dog(
    name: String,
    eyeColor: String,
    bodyColor: String
  ) extends Animal(name, eyeColor, bodyColor)
       with Trainable {

  override def doTrick(trickName: String): Boolean = {
    println(
      s"${name} says - dogs love doing tricks. I'm doing a trick ${trickName} now"
    )
    true
  }

}
