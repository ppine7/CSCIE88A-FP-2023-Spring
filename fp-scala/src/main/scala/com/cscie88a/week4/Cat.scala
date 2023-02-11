package com.cscie88a.week4

final case class Cat(
    name: String,
    eyeColor: String,
    bodyColor: String,
  )

object Cat {

  val allCatsMap: Map[Int, Cat] = ???

  def uppercaseNames(catList: List[Cat]): List[Cat] = ???

  def averageAge(catList: List[Cat]): Double = ???

  def averageCheckedAge(catList: List[Cat]): Double = ???

  def resetHealthCheck(catsMap: Map[Int, Cat]): Map[Int, Cat] = ???

  def anonymizeData(catsMap: Map[Int, Cat]): List[(String, String, Int)] = ???

  def printAnonymizedCSV(catsMap: Map[Int, Cat]): Unit = ???
}
