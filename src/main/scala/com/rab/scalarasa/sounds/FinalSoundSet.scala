package com.rab.scalarasa.sounds

class FinalSoundSet(name: String, shortName: String, sounds: Seq[String]) extends EvenlyDistributedSoundSet(name, shortName, sounds)

object FinalSoundSet {

  def apply(name: String, shortName: String, sounds: Seq[String]) = new FinalSoundSet(name, shortName, sounds)

  val Hums = FinalSoundSet("Hums", "h", Seq("m", "n"))
  val SandK = FinalSoundSet("s and k", "sk", Seq("s", "k"))
  val HumsExtended = FinalSoundSet("Hums Extended", "he", Seq("m", "n", "ŋ"))
  val CloseTeeth = FinalSoundSet("Close Teeth", "ct", Seq("s", "ʃ", "z", "ʒ"))

  val standardSets = Seq(Hums, SandK, HumsExtended, CloseTeeth)

}
