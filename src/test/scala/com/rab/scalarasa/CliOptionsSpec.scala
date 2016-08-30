package com.rab.scalarasa

import org.specs2.mutable.Specification

class CliOptionsSpec extends Specification {

  "Parsing the count of syllables" should {
    "default to an expected value" in {
      CliOptions(Seq()).range() must be_==(VariableSyllableCount(2, 4))
    }

    "parse a constant value" in {
      CliOptions(Seq("-s", "5")).range() must be_==(ConstantSyllableCount(5))
    }

    "parse a range" in {
      CliOptions(Seq("-s", "1-3")).range() must be_==(VariableSyllableCount(1, 3))
    }
  }

  "Parsing the number of words to generate" should {
    "default to an expected value" in {
      CliOptions(Seq()).wordCount() must be_==(10)
    }

    "can be configured" in {
      CliOptions(Seq("-w", "25")).wordCount() must be_==(25)
    }
  }

}
