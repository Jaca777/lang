package pl.jaca.lang.compiler.frontend.tree.typesystem

/**
  * @author Jaca777
  *         Created 2016-03-29 at 12
  */
abstract class TypeSystem {
  def forName(name: String): Type
}

object TypeSystem {

  object AnyType extends Type("any") {
    override def isSubtypeOf(t: Type): Boolean = false
  }

  case class ValType(override val name: String, supertype: Type = AnyType) extends Type(name) {
    override def isSubtypeOf(t: Type): Boolean =
      supertype == t || t.isSubtypeOf(supertype)
  }

}

