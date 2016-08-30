package com.rab.scalarasa

trait NamedComponent {
  val name: String
  val shortName: String
}

object NamedComponent {

  def pick[T<:NamedComponent](options: Seq[T], name: String): Option[T] = {
    val lowered = name.toLowerCase
    options.find(_.shortName.toLowerCase == lowered).orElse(options.find(_.name.toLowerCase == lowered))
  }

}
