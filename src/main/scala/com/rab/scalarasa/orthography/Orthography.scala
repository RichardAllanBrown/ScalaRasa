package com.rab.scalarasa.orthography

class Orthography(val name: String, val soundMap: Map[String, String]) {

  def convert(c: String): String = soundMap.getOrElse(c, c.toString)

}
