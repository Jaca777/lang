package pl.jaca.lang.compiler.frontend.tree.typesystem

/**
  * @author Jaca777
  *         Created 2016-03-29 at 12
  */
abstract class Type(val name: String) {
  def isSubtypeOf(t: Type): Boolean
  def isSupertypeOf(t: Type): Boolean = t.isSubtypeOf(this)
}
