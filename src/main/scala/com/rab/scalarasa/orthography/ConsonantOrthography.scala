package com.rab.scalarasa.orthography

class ConsonantOrthography(name: String, soundMap: Map[String, String]) extends Orthography(name, soundMap)

object ConsonantOrthography {

  def apply(name: String, soundMap: Map[String, String]) = new ConsonantOrthography(name, soundMap)

  val empty = ConsonantOrthography("Empty", Map())

  val slavic = ConsonantOrthography("Slavic", Map(
    "ʃ" -> "š",
    "ʒ" -> "ž",
    "ʧ" -> "č",
    "ʤ" -> "ǧ",
    "j" -> "j"
  ))

  val germanic = ConsonantOrthography("Germanic", Map(
    "ʃ" -> "sch",
    "ʒ" -> "zh",
    "ʧ" -> "tsch",
    "ʤ" -> "dz",
    "j" -> "j",
    "x" -> "ch"
  ))

  val french = ConsonantOrthography("French", Map(
    "ʃ" -> "ch",
    "ʒ" -> "j",
    "ʧ" -> "tch",
    "ʤ" -> "dj",
    "x" -> "kh"
  ))

  val chinese = ConsonantOrthography("Chinese", Map(
    "ʃ" -> "x",
    "ʧ" -> "q",
    "ʤ" -> "j"
  ))

  val standardOrthographies = Seq(slavic, germanic, french, chinese)

}
