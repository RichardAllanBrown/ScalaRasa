package com.rab.scalarasa

import org.rogach.scallop._

class CliOptions(args: Seq[String]) extends ScallopConf(args) {

  implicit private val rangeConversion = CliOptions.rangeConverter

  val range = opt[SyllableCount]("syllables", 's', "Number of syllables to include in words", default = Some(VariableSyllableCount(2, 4)))
  val wordCount = opt[Int]("words", 'w', "Number of words to generate", default = Some(10))
  val vowelSetName = opt[String]("vowelSet", 'v', s"Vowel set to use")
  val consonantSetName = opt[String]("consonantSet", 'c', "Consonant set to use")
  val sibilantSetName = opt[String]("sibilantSet", 'i', "Sibilant set to use")
  val liquidSetName = opt[String]("liquidSet", 'l', "Liquid set to use")
  val finalSetName = opt[String]("finalSet", 'f', "Final set to use")

  verify()

}

object CliOptions {

  def apply(args: Seq[String]) = new CliOptions(args)

  val rangeConverter = singleArgConverter[SyllableCount] { arg =>
    arg.trim.split('-') match {
      case Array(constant) => ConstantSyllableCount(constant.toInt)
      case Array(from, to) => VariableSyllableCount(from.toInt, to.toInt)
      case _ => throw new IllegalArgumentException("Range arguments should be like '1-4' or '3'")
    }
  }

}

