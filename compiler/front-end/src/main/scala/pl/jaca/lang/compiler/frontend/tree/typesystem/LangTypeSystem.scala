package pl.jaca.lang.compiler.frontend.tree.typesystem

import pl.jaca.lang.compiler.frontend.tree.typesystem.TypeSystem.ValType

/**
  * @author Jaca777
  *         Created 2016-03-29 at 13
  */
class LangTypeSystem(types: Set[Type] = LangTypeSystem.LangTypes) extends TypeSystem {
  override def forName(name: String): Option[Type] = types.find(_.name == name)

  def extend(t: Type): LangTypeSystem = new LangTypeSystem(types + t)
}

object LangTypeSystem {

  val IntType = ValType("int")

  val LangTypes = Set[Type] {
    IntType
  }

}
