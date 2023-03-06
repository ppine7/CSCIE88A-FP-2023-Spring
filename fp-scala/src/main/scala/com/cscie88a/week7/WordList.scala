package com.cscie88a.week7

import scala.collection.parallel.CollectionConverters._
object WordList {
  val poem: String = """
  You get a wife, you get a house,
	Eventually you get a mouse.
	You get some words regarding mice,
	You get a kitty in a trice.
	
	By two a.m. or thereabouts,
	The mouse is in, the cat is out.
	It dawns upon you, in your cot,
	The mouse is silent, the cat is not.
	
	Instead of kitty, says your spouse,
	You should have got another mouse.
  """

  val poemWords: List[String] = poem
    .replaceAll("[\\.|,\n]", "")
    .split(" ")
    .map(_.trim)
    .filter(_.size > 0)
    .toList

  def groupByFirstCharRegular(words: List[String]): Map[String, List[String]] = ???

  def groupByFirstCharConcurrent(
      words: List[String]
    ): Map[String, List[String]] = ???

}
