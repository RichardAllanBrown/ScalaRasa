package com.rab.scalarasa

class SyllableValidator(bannedRegex: String*) {

  def isNotValid(syllable: String) = bannedRegex.exists(syllable.matches)

  def isValid(syllable: String) = !isNotValid(syllable)

}

object SyllableValidator {

  def apply(deciders: String*) = new SyllableValidator(deciders: _*)

  val None = SyllableValidator()
  val NoDoubles = SyllableValidator("""(.)\1""")
  val NoDoublesOrHardSounds = SyllableValidator("""(.)\1""", """[sʃf][sʃ]""", """[rl][rl]""")

  val standardSet = Seq(None, NoDoubles, NoDoublesOrHardSounds)

}
