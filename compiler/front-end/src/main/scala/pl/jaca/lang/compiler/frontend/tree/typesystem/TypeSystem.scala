package pl.jaca.lang.compiler.frontend.tree.typesystem

/**
  * @author Jaca777
  *         Created 2016-03-29 at 12
  */
abstract class TypeSystem {
  def forName(name: String): Type
}

object TypeSystem {

  object UnitType extends Type("unit") {
    override def isSubtypeOf(t: Type): Boolean = false
  }

  object AnyType extends Type("any") {
    override def isSubtypeOf(t: Type): Boolean = false
  }

  case class ValType(override val name: String, supertype: Type = AnyType) extends Type(name) {
    override def isSubtypeOf(t: Type): Boolean =
      t == supertype || t.isSupertypeOf(supertype)
  }

}

