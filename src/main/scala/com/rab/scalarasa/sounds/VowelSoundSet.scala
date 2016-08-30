package com.rab.scalarasa.sounds

class VowelSoundSet(name: String, sounds: Seq[String]) extends EvenlyDistributedSoundSet(name, sounds)

object VowelSoundSet {

  def apply(name: String, sounds: Seq[String]) = new VowelSoundSet(name, sounds)

  val Standard = VowelSoundSet("Standard", Seq("a", "e", "i", "o", "u"))
  val SimpleThree = VowelSoundSet("Simple Three - a i u", Seq("a", "i", "u"))
  val SimpleThreeAlt = VowelSoundSet("Simple Three - e o u", Seq("e", "o", "u"))
  val RepeatedAEI = VowelSoundSet("Extended - A E I", Seq("a", "e", "i", "o", "u", "A", "E", "I"))
  val RepeatedU = VowelSoundSet("Extended - U", Seq("a", "e", "i", "o", "u", "U"))
  val RepeatedAOU = VowelSoundSet("Extended - A O U", Seq("a", "e", "i", "o", "u", "A", "O", "U"))
  val AlternativeThree = VowelSoundSet("Alternative Three", Seq("a", "i", "u", "A", "I"))

  val standardSets = Seq(Standard, SimpleThree, SimpleThreeAlt, RepeatedAEI, RepeatedU, RepeatedAOU, AlternativeThree)

}
