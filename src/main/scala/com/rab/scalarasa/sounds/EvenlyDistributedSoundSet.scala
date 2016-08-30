package com.rab.scalarasa.sounds

import com.rab.scalarasa.{NamedComponent, UsesRandom}

import scala.util.Random

trait SoundSet extends NamedComponent {
  val available: Iterator[String]
  def pickNext: String
}

abstract class EvenlyDistributedSoundSet(val name: String, val shortName: String, sounds: Seq[String]) extends SoundSet with UsesRandom {

  val available = sounds.iterator

  override def pickNext = pickOne(sounds)

}

abstract class BiasDistributionSoundSet(val name: String, val shortName: String, sounds: Seq[String]) extends SoundSet with UsesRandom {

  private val baseInstances = sounds.size / 2
  private val shuffledSounds = Random.shuffle(sounds)
  private val indexesWithBias = sounds.indices.flatMap(i => Iterator.fill(baseInstances + i)(i))

  override val available = shuffledSounds.iterator

  // TODO: Better, more controllable and statistically predictable bias
  override def pickNext = shuffledSounds(pickOne(indexesWithBias))

}
