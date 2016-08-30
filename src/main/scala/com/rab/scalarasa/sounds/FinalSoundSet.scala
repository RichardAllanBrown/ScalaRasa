package com.rab.scalarasa.sounds

class FinalSoundSet(name: String, sounds: Seq[String]) extends EvenlyDistributedSoundSet(name, sounds)

object FinalSoundSet {

  def apply(name: String, sounds: Seq[String]) = new FinalSoundSet(name, sounds)

  val Hums = FinalSoundSet("Hums", Seq("m", "n"))
  val SandK = FinalSoundSet("s and k", Seq("s", "k"))
  val HumsExtended = FinalSoundSet("Hums Extended", Seq("m", "n", "ŋ"))
  val CloseTeeth = FinalSoundSet("Close Teeth", Seq("s", "ʃ", "z", "ʒ"))

  val standardSets = Seq(Hums, SandK, HumsExtended, CloseTeeth)

}
