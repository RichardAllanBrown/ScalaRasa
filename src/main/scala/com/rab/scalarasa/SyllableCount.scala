package com.rab.scalarasa

sealed trait SyllableCount
case class ConstantSyllableCount(len: Int) extends SyllableCount
case class VariableSyllableCount(min: Int, max: Int) extends SyllableCount
