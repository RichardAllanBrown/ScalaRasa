package com.rab.scalarasa

import scala.util.Random

trait UsesRandom {

  val entropy = new Random()

  def pickOne[T](values: Seq[T]): T = {
    values(entropy.nextInt(values.size))
  }

}
