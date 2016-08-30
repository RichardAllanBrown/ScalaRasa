package com.rab.scalarasa

import com.rab.scalarasa.orthography._
import com.rab.scalarasa.sounds._
import org.specs2.mutable.Specification

class LanguageIntegrationTest extends Specification {

  "Generating words in a language" should {
    "should return words of expected length with simple sets" in {
      val soundGen = new SoundGenerator(VowelSoundSet.Standard, ConsonantSoundSet.minimal, SibilantSoundSet.Standard,
        LiquidSoundSet.Standard, FinalSoundSet.Hums, SyllableStructure("CVC"), SyllableValidator.None)
      val langGen = new Language(soundGen, ComposedOrthography(ConsonantOrthography.empty, VowelOrthography.empty), ConstantSyllableCount(2))

      val result = langGen.createWord()
      println(s"Word made: $result")
      result.length must be_==(6)
    }
  }

}
