package com.rab.scalarasa.sounds

class VowelSoundSet(name: String, shortName: String, sounds: Seq[String]) extends EvenlyDistributedSoundSet(name, shortName, sounds)

object VowelSoundSet {

  def apply(name: String, shortName: String, sounds: Seq[String]) = new VowelSoundSet(name, shortName, sounds)

  val Standard = VowelSoundSet("Standard", "s", Seq("a", "e", "i", "o", "u"))
  val SimpleThree = VowelSoundSet("Simple Three - a i u", "aiu", Seq("a", "i", "u"))
  val SimpleThreeAlt = VowelSoundSet("Simple Three - e o u", "eou", Seq("e", "o", "u"))
  val RepeatedAEI = VowelSoundSet("Extended - A E I", "e_aei", Seq("a", "e", "i", "o", "u", "A", "E", "I"))
  val RepeatedU = VowelSoundSet("Extended - U", "e_u", Seq("a", "e", "i", "o", "u", "U"))
  val RepeatedAOU = VowelSoundSet("Extended - A O U", "e_aou", Seq("a", "e", "i", "o", "u", "A", "O", "U"))
  val AlternativeThree = VowelSoundSet("Alternative Three", "alt", Seq("a", "i", "u", "A", "I"))

  val standardSets = Seq(Standard, SimpleThree, SimpleThreeAlt, RepeatedAEI, RepeatedU, RepeatedAOU, AlternativeThree)

}
