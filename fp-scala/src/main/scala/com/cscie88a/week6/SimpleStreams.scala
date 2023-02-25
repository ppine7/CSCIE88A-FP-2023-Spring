package com.cscie88a.week6

import java.util.UUID
import scala.util.Random

object SimpleStreams {
  // string uuid generator
  def uuid = UUID.randomUUID().toString().replaceAll("-", "")
  // random generator
  val rnd = new Random()

  val mult5: LazyList[Int] = ???
  
  val randomAge: LazyList[Int] = ???

  val allDogs: LazyList[Dog] = ???

  def healthyDogs(dogs: LazyList[Dog]): LazyList[Dog] = ???

  def averageHealthyAge(dogs: LazyList[Dog], sampleSize: Int): Double = ???

  def dogsByHealthStatus(dogs: LazyList[Dog]): (LazyList[Dog], LazyList[Dog]) = ???

  def pairHealthyUnhealthyDogs(dogs: LazyList[Dog]): LazyList[(Dog, Dog)] = ???

  def oldestDogs(dogs: LazyList[Dog]): LazyList[Dog] = ???
  
  def pythTest(triplet: Tuple3[Int, Int, Int]): Boolean = ???

  val upto100: LazyList[Int] = ???

  val pythTriples: LazyList[Tuple3[Int, Int, Int]] = ???
}
