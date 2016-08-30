package com.rab.scalarasa

import com.rab.scalarasa.orthography.{ComposedOrthography, ConsonantOrthography, VowelOrthography}
import com.rab.scalarasa.sounds._

object ScalaRasaApp extends App with UsesRandom {

  private def buildSoundGen(options: CliOptions) = {
    val vowelSet = fetchOrPickRandom(options.vowelSetName.toOption, "vowel", VowelSoundSet.standardSets)
    val consonantSet = fetchOrPickRandom(options.consonantSetName.toOption, "consonant", ConsonantSoundSet.standardSets)
    val sibilantSet = fetchOrPickRandom(options.sibilantSetName.toOption, "sibilant", SibilantSoundSet.standardSets)
    val liquidSet = fetchOrPickRandom(options.liquidSetName.toOption, "liquid", LiquidSoundSet.standardSets)
    val finalSet = fetchOrPickRandom(options.finalSetName.toOption, "final", FinalSoundSet.standardSets)

    val syllableStructure = pickOne(SyllableStructure.defaults)
    println(s"Using syllable structure: ${syllableStructure.toString}")

    val syllableValidator = pickOne(SyllableValidator.standardSet)

    new SoundGenerator(vowelSet, consonantSet, sibilantSet, liquidSet, finalSet, syllableStructure, syllableValidator)
  }

  private def fetchOrPickRandom[T<:SoundSet](option: Option[String], letterType: String, available: Seq[T]): T = {
    val result = option match {
      case Some(name) => NamedComponent.pick(available, name).getOrElse(throw new IllegalArgumentException(s"Unrecognised $letterType letter set name"))
      case None => pickOne(available)
    }

    println(s"Using $letterType set ${result.name}: ${result.available.mkString("[", ", ", "]")}")
    result
  }

  private def buildOrthography = {
    val vowels = pickOne(VowelOrthography.standardOrthographies)
    val consonants = pickOne(ConsonantOrthography.standardOrthographies)

    val result = ComposedOrthography(consonants, vowels)
    println(result.name)

    result
  }

  val parsedArgs = new CliOptions(args)
  val langGen = new Language(buildSoundGen(parsedArgs), buildOrthography, parsedArgs.range())
  val result = Iterator.fill(parsedArgs.wordCount())(langGen.createWord()).mkString("Words generated: ", ", ", "\n")
  println(result)

}
