package com.rab.scalarasa.sounds

import com.rab.scalarasa.UsesRandom

import scala.util.Random

trait SoundSet {
  val name: String
  val available: Iterator[String]
  def pickNext: String
}

abstract class EvenlyDistributedSoundSet(val name: String, sounds: Seq[String]) extends SoundSet with UsesRandom {

  val available = sounds.iterator

  override def pickNext = pickOne(sounds)

}

abstract class BiasDistributionSoundSet(val name: String, sounds: Seq[String]) extends SoundSet with UsesRandom {

  private val baseInstances = sounds.size / 2
  private val shuffledSounds = Random.shuffle(sounds)
  private val indexesWithBias = sounds.indices.flatMap(i => Iterator.fill(baseInstances + i)(i))

  override val available = shuffledSounds.iterator

  // TODO: Better, more controllable and statistically predictable bias
  override def pickNext = shuffledSounds(pickOne(indexesWithBias))

}
