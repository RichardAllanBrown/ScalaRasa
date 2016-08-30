package com.rab.scalarasa.sounds

class LiquidSoundSet(name: String, shortName: String, sounds: Seq[String]) extends EvenlyDistributedSoundSet(name, shortName, sounds)

object LiquidSoundSet {

  def apply(name: String, shortName: String, sounds: Seq[String]) = new LiquidSoundSet(name, shortName, sounds)

  val Standard = LiquidSoundSet("Standard", "s", Seq("r", "l"))
  val OnlyR = LiquidSoundSet("Only R", "r", Seq("r"))
  val OnlyL = LiquidSoundSet("Only L", "l", Seq("l"))
  val Alternative = LiquidSoundSet("Alternative", "a", Seq("w", "j"))
  val Full = LiquidSoundSet("Full", "f", Seq("r", "l", "w", "j"))

  val standardSets = Seq(Standard, OnlyR, OnlyL, Alternative, Full)

}
