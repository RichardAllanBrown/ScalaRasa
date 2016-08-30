package com.rab.scalarasa.orthography

class VowelOrthography(name: String, soundMap: Map[String, String]) extends Orthography(name, soundMap)

object VowelOrthography {

  def apply(name: String, soundMap: Map[String, String]) = new VowelOrthography(name, soundMap)

  val empty = VowelOrthography("Empty", Map())

  val umlauts = VowelOrthography("Umlauts", Map(
    "A" -> "ä",
    "E" -> "ë",
    "I" -> "ï",
    "O" -> "ö",
    "U" -> "ü"
  ))

  val welsh = VowelOrthography("Welsh", Map(
    "A" -> "â",
    "E" -> "ê",
    "I" -> "y",
    "O" -> "ô",
    "U" -> "w"
  ))

  val dipthongs = VowelOrthography("Dipthongs", Map(
    "A" -> "au",
    "E" -> "ei",
    "I" -> "ie",
    "O" -> "ou",
    "U" -> "oo"
  ))

  val doubles = VowelOrthography("Doubles", Map(
    "A" -> "aa",
    "E" -> "ee",
    "I" -> "ii",
    "O" -> "oo",
    "U" -> "uu"
  ))

  val standardOrthographies = Seq(umlauts, welsh, dipthongs, doubles)

}
