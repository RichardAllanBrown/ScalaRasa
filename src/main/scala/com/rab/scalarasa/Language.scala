package com.rab.scalarasa

import com.rab.scalarasa.orthography.Orthography

import scala.util.Random

class Language(soundGenerator: SoundGenerator, orthography: Orthography, syllableCount: SyllableCount) {

  def createWord(): String = capitaliseFirst(createWord(randLen))

  private def randLen = {
    syllableCount match {
      case ConstantSyllableCount(len) => len
      case VariableSyllableCount(min, max) => min + Random.nextInt(max - min)
    }
  }

  private def createWord(syllableCount: Int): String = {
    val sound = Iterator.fill(syllableCount)(soundGenerator.generateValidSyllable).flatten
    sound.map(orthography.convert).mkString
  }

  private def capitaliseFirst(source: String): String = {
    if (source.length == 0) throw new IllegalArgumentException("Source string must have some length")
    else source.head.toUpper + source.tail.toLowerCase
  }

}
