package com.rab.scalarasa.sounds

class ConsonantSoundSet(name: String, sounds: Seq[String]) extends BiasDistributionSoundSet(name, sounds)

object ConsonantSoundSet {

  def apply(name: String, sounds: Seq[String]) = new ConsonantSoundSet(name, sounds)

  val minimal = ConsonantSoundSet("Minimal", Seq("p", "t", "k", "m", "n", "l", "s"))
  val englishLike = ConsonantSoundSet("English Like", Seq("p", "t", "k", "b", "d", "g", "m", "n", "l", "r", "s", "ʃ", "z", "ʒ", "ʧ"))
  val piraha = ConsonantSoundSet("Pirahã", Seq("p", "t", "k", "m", "n", "h"))
  val hawaiianLike = ConsonantSoundSet("Hawaiian Like", Seq("h", "k", "l", "m", "n", "p", "w", "ʔ"))
  val greenlandicLike = ConsonantSoundSet("Greenlandic Like", Seq("p", "t", "k", "q", "v", "s", "g", "r", "m", "n", "ŋ", "l", "j"))
  val arabicLike = ConsonantSoundSet("Arabic Like", Seq("t", "k", "s", "ʃ", "d", "b", "q", "ɣ", "x", "m", "n", "l", "r", "w", "j"))
  val arabicLite = ConsonantSoundSet("Arabic Lighter", Seq("t", "k", "d", "g", "m", "n", "s", "ʃ"))
  val englishLite = ConsonantSoundSet("English Lighter", Seq("p", "t", "k", "b", "d", "g", "m", "n", "s", "z", "ʒ", "ʧ", "h", "j", "w"))

  val standardSets = Seq(minimal, englishLike, piraha, hawaiianLike, greenlandicLike, arabicLike, arabicLite, englishLite)

}
