package com.rab.scalarasa.orthography

class ComposedOrthography(name: String, soundMap: Map[String, String]) extends Orthography(name, soundMap)

object ComposedOrthography {

  val defaultSoundMap = Map(
    "ʃ" -> "sh",
    "ʒ" -> "zh",
    "ʧ" -> "ch",
    "ʤ" -> "j",
    "ŋ" -> "ng",
    "j" -> "y",
    "x" -> "kh",
    "ɣ" -> "gh",
    "ʔ" -> "‘",
    "A" -> "á",
    "E" -> "é",
    "I" -> "í",
    "O" -> "ó",
    "U" -> "ú"
  )

  def apply(consonantOrthography: ConsonantOrthography, vowelOrthography: VowelOrthography) = {
    val composed = defaultSoundMap ++ consonantOrthography.soundMap ++ vowelOrthography.soundMap
    val name = s"Orthography using ${consonantOrthography.name} consonants and ${vowelOrthography.name} vowels"

    new ComposedOrthography(name, composed)
  }

}
