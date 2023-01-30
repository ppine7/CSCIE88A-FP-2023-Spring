package com.cscie88a.week2

class Animal(
    name: String,
    eyeColor: String,
    bodyColor: String
  ) {
  def takeMedicine(withTreat: Boolean): Boolean =
    if (withTreat) true else false
}
