package com.rab.scalarasa

import com.rab.scalarasa.orthography.{ComposedOrthography, ConsonantOrthography, VowelOrthography}
import com.rab.scalarasa.sounds._

object ScalaRasaApp extends App with UsesRandom {

  private def buildSoundGen = {
    val vowelSet = pickOne(VowelSoundSet.standardSets)
    printGenType("vowel", vowelSet)

    val consonantSet = pickOne(ConsonantSoundSet.standardSets)
    printGenType("consonant", consonantSet)

    val sibilantSet = pickOne(SibilantSoundSet.standardSets)
    printGenType("sibilant", sibilantSet)

    val liquidSet = pickOne(LiquidSoundSet.standardSets)
    printGenType("liquid", liquidSet)

    val finalSet = pickOne(FinalSoundSet.standardSets)
    printGenType("final", finalSet)

    val syllableStructure = pickOne(SyllableStructure.defaults)
    println(s"Using syllable structure: ${syllableStructure.toString}")

    val syllableValidator = pickOne(SyllableValidator.standardSet)

    new SoundGenerator(vowelSet, consonantSet, sibilantSet, liquidSet, finalSet, syllableStructure, syllableValidator)
  }

  private def printGenType(letterType: String, set: SoundSet) = println(s"Using $letterType set ${set.name}: ${set.available.mkString("[", ", ", "]")}")

  private def buildOrthography = {
    val vowels = pickOne(VowelOrthography.standardOrthographies)
    val consonants = pickOne(ConsonantOrthography.standardOrthographies)

    val result = ComposedOrthography(consonants, vowels)
    println(result.name)

    result
  }

  val parsedArgs = new CliOptions(args)
  val langGen = new Language(buildSoundGen, buildOrthography, parsedArgs.range())
  val result = Iterator.fill(parsedArgs.wordCount())(langGen.createWord()).mkString("Words generated: ", ", ", "\n")
  println(result)

}
