package com.rab.scalarasa

sealed abstract class LetterType(val representation: String) {
  override def toString: String = representation
}

object LetterType {

  def apply (letterType: String): LetterType = {
    require(letterType.length == 1 || letterType.length == 2, "letterType should be length 1 or 2")

    val requiredType = letterType.head.toUpper match {
      case 'C' => Consonant
      case 'V' => Vowel
      case 'S' => Sibilant
      case 'L' => Liquid
      case 'F' => Final
      case _ => throw new LetterTypeParseException(s"'$letterType' is not a recognised LetterType, please only use 'C', 'V', 'S', 'L' or 'F' optionally followed by '?'")
    }

    if (letterType.last == '?') OptionalLetterType(requiredType)
    else requiredType
  }

}

sealed abstract class RequiredLetterType(representation: String) extends LetterType(representation)
case class OptionalLetterType[T<:RequiredLetterType](letterType: T) extends LetterType(letterType.representation + "?")

case object Consonant extends RequiredLetterType("C")
case object Vowel extends RequiredLetterType("V")
case object Sibilant extends RequiredLetterType("S")
case object Liquid extends RequiredLetterType("L")
case object Final extends RequiredLetterType("F")

class LetterTypeParseException(message: String) extends IllegalArgumentException(message)
