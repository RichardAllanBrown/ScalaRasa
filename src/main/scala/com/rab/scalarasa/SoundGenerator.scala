package com.rab.scalarasa

import com.rab.scalarasa.sounds._
import scala.util.Random

class SoundGenerator(vowels: VowelSoundSet, consonants: ConsonantSoundSet, sibilants: SibilantSoundSet,
                     liquids: LiquidSoundSet, finals: FinalSoundSet, syllables: SyllableStructure, validator: SyllableValidator) {

  def generateValidSyllable: Seq[String] = {
    Iterator.continually(generateSyllable).filter(s => validator.isValid(s.mkString)).next()
  }

  private def generateSyllable: Seq[String] = {
    syllables.letters.flatMap {
      case r: RequiredLetterType => Some(r)
      case o: OptionalLetterType[_] if Random.nextBoolean() => Some(o.letterType)
      case _ => None
    }.map {
      case Consonant => consonants.pickNext
      case Vowel => vowels.pickNext
      case Sibilant => sibilants.pickNext
      case Liquid => liquids.pickNext
      case Final => finals.pickNext
    }
  }

}
