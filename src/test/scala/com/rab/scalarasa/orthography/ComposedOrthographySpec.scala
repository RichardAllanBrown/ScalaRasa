package com.rab.scalarasa.orthography

import org.specs2.mutable.Specification

class ComposedOrthographySpec extends Specification {

  "Converting a string" should {
    "return the expected standard letter" in {
      val testOrthography = ComposedOrthography(ConsonantOrthography.empty, VowelOrthography.empty)
      testOrthography.convert("ʧ") must be_==("ch")
    }

    "return the expected defined letter" in {
      "consonant orthography" in {
        val testOrthography = ComposedOrthography(ConsonantOrthography("", Map("test" -> "RESULT")), VowelOrthography.empty)
        testOrthography.convert("test") must be_==("RESULT")
      }

      "vowel orthography" in {
        val testOrthography = ComposedOrthography(ConsonantOrthography.empty, VowelOrthography("", Map("test" -> "RESULT")))
        testOrthography.convert("test") must be_==("RESULT")
      }
    }

    "return the source string when a mapping is unavailable" in {
      val testOrthography = ComposedOrthography(ConsonantOrthography.empty, VowelOrthography.empty)
      testOrthography.convert("NOT_PRESENT") must be_==("NOT_PRESENT")
    }

    "return a letter that overrides a base letter" in {
      val testOrthography = ComposedOrthography(ConsonantOrthography("", Map("ʃ" -> "OVERRIDDEN")), VowelOrthography.empty)
      testOrthography.convert("ʃ") must be_==("OVERRIDDEN")
    }
  }

  "The orthography name" should {
    "be composed of the two sub orthography names" in {
      val testOrthography = ComposedOrthography(ConsonantOrthography("CON_NAME", Map()), VowelOrthography("VOWEL_NAME", Map()))
      testOrthography.name must contain("CON_NAME")
      testOrthography.name must contain("VOWEL_NAME")
    }
  }

}
