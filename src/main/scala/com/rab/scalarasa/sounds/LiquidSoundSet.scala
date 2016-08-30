package com.rab.scalarasa.sounds

class LiquidSoundSet(name: String, sounds: Seq[String]) extends EvenlyDistributedSoundSet(name, sounds)

object LiquidSoundSet {

  def apply(name: String, sounds: Seq[String]) = new LiquidSoundSet(name, sounds)

  val Standard = LiquidSoundSet("Standard", Seq("r", "l"))
  val OnlyR = LiquidSoundSet("Only R", Seq("r"))
  val OnlyL = LiquidSoundSet("Only L", Seq("l"))
  val Alternative = LiquidSoundSet("Alternative", Seq("w", "j"))
  val Full = LiquidSoundSet("Full", Seq("r", "l", "w", "j"))

  val standardSets = Seq(Standard, OnlyR, OnlyL, Alternative, Full)

}
