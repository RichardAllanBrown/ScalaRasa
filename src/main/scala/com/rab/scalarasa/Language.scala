package com.rab.scalarasa

import com.rab.scalarasa.orthography.Orthography

import scala.util.Random

class Language(soundGenerator: SoundGenerator, orthography: Orthography, minLength: Int, maxLength: Int) {

  def createWord(): String = capitaliseFirst(createWord(randLen))

  private def randLen = {
    if (minLength == maxLength) minLength
    else minLength + Random.nextInt(maxLength - minLength)
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
