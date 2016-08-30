package com.rab.scalarasa

import org.specs2.mutable.Specification

class UsesRandomSpec extends Specification {

  val random = new UsesRandom {}

  "The UsesRandom trait" should {
    "be able to pick any value from set" in {
      val values = Seq(1, 2, 3, 4)
      val result = Iterator.fill(1000)(random.pickOne(values))

      result must contain(1, 2, 3, 4)
    }
  }

}
