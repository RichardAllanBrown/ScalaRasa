package com.rab.scalarasa.sounds

class SibilantSoundSet(name: String, sounds: Seq[String]) extends EvenlyDistributedSoundSet(name, sounds)

object SibilantSoundSet {

  def apply(name: String, sounds: Seq[String]) = new SibilantSoundSet(name, sounds)

  val Limited = SibilantSoundSet("Limited", Seq("s"))
  val Standard = SibilantSoundSet("Standard", Seq("s", "ʃ"))
  val Extended = SibilantSoundSet("Extended", Seq("s", "ʃ", "f"))

  val standardSets = Seq(Limited, Standard, Extended)

}
