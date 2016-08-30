package com.rab.scalarasa.sounds

class ConsonantSoundSet(name: String, shortName: String, sounds: Seq[String]) extends BiasDistributionSoundSet(name, shortName, sounds)

object ConsonantSoundSet {

  def apply(name: String, shortName: String, sounds: Seq[String]) = new ConsonantSoundSet(name, shortName, sounds)

  val minimal = ConsonantSoundSet("Minimal", "min", Seq("p", "t", "k", "m", "n", "l", "s"))
  val englishLike = ConsonantSoundSet("English Like", "eng", Seq("p", "t", "k", "b", "d", "g", "m", "n", "l", "r", "s", "ʃ", "z", "ʒ", "ʧ"))
  val piraha = ConsonantSoundSet("Pirahã", "pir", Seq("p", "t", "k", "m", "n", "h"))
  val hawaiianLike = ConsonantSoundSet("Hawaiian Like", "haw", Seq("h", "k", "l", "m", "n", "p", "w", "ʔ"))
  val greenlandicLike = ConsonantSoundSet("Greenlandic Like", "grn", Seq("p", "t", "k", "q", "v", "s", "g", "r", "m", "n", "ŋ", "l", "j"))
  val arabicLike = ConsonantSoundSet("Arabic Like", "arb", Seq("t", "k", "s", "ʃ", "d", "b", "q", "ɣ", "x", "m", "n", "l", "r", "w", "j"))
  val arabicLite = ConsonantSoundSet("Arabic Lighter", "arbl", Seq("t", "k", "d", "g", "m", "n", "s", "ʃ"))
  val englishLite = ConsonantSoundSet("English Lighter", "engl", Seq("p", "t", "k", "b", "d", "g", "m", "n", "s", "z", "ʒ", "ʧ", "h", "j", "w"))

  val standardSets = Seq(minimal, englishLike, piraha, hawaiianLike, greenlandicLike, arabicLike, arabicLite, englishLite)

}
