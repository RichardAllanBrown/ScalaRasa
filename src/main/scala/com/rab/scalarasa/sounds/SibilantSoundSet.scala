package com.rab.scalarasa.sounds

class SibilantSoundSet(name: String, shortName: String, sounds: Seq[String]) extends EvenlyDistributedSoundSet(name, shortName, sounds)

object SibilantSoundSet {

  def apply(name: String, shortName: String, sounds: Seq[String]) = new SibilantSoundSet(name, shortName, sounds)

  val Limited = SibilantSoundSet("Limited", "l", Seq("s"))
  val Standard = SibilantSoundSet("Standard", "s", Seq("s", "ʃ"))
  val Extended = SibilantSoundSet("Extended", "e", Seq("s", "ʃ", "f"))

  val standardSets = Seq(Limited, Standard, Extended)

}
