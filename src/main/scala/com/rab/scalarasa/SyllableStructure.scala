package com.rab.scalarasa

case class SyllableStructure(letters: Seq[LetterType]) {
  override def toString: String = letters.map(_.toString).mkString
}

object SyllableStructure {

  def apply(structure: String): SyllableStructure = buildSyllableStructure(splitWordTypes(structure))

  private def buildSyllableStructure(wordTypes: Seq[String]) = SyllableStructure(wordTypes.map(LetterType.apply))

  lazy val defaults = Seq("CVC", "CVV?C", "CVVC?", "CVC?", "CV", "CVF", "C?VC", "CVF?",
      "CL?VC", "CL?VF", "S?CVC", "S?CVF", "S?CVC?", "C?VF", "C?VC?", "C?VF?", "C?L?VC", "VC",
      "CVL?C?", "C?VL?C", "C?VLC?")
    .map(SyllableStructure.apply)

  private val syllableRegex = """[A-Za-z]{1}\??""".r
  private def splitWordTypes(syllableSequence: String): Seq[String] = {
    syllableRegex.findAllMatchIn(syllableSequence).map(_.group(0)).toSeq
  }

}
