package com.rab.scalarasa

import org.specs2.mutable.Specification

class SyllableStructureSpec extends Specification {

  "Parsing syllable structures" should {
    "work with single word type" in {
      SyllableStructure("C") must be_==(SyllableStructure(Seq(Consonant)))
    }

    "work with single optional words" in {
      SyllableStructure("V?") must be_==(SyllableStructure(Seq(OptionalLetterType(Vowel))))
    }

    "work with a more complete example" in {
      SyllableStructure("CVC") must be_==(SyllableStructure(Seq(Consonant, Vowel, Consonant)))
    }

    "work with possible multiple optional words" in {
      SyllableStructure("C?VLC?") must be_==(SyllableStructure(Seq(OptionalLetterType(Consonant), Vowel, Liquid, OptionalLetterType(Consonant))))
    }

    "throw a parse exception when given an unrecognised word type" in {
      SyllableStructure("INVALID") must throwA[LetterTypeParseException]
    }
  }

  "Default syllable structures" should {
    val expectedDefaultCount = 21

    "contain the expected number of structures" in {
      SyllableStructure.defaults.size must be_==(expectedDefaultCount)
    }

    "all be distinct" in {
      SyllableStructure.defaults.distinct.size must be_==(expectedDefaultCount)
    }
  }

}
