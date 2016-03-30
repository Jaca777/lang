package pl.jaca.lang.compiler.frontend.tree.statement

import pl.jaca.lang.compiler.frontend.tree.typesystem.{Type, TypeSystem}
import pl.jaca.lang.compiler.frontend.tree.{Context, Node}

/**
  * @author Jaca777
  *         Created 2016-03-28 at 23
  */
abstract class Statement(context: Context) extends Node(context) {
  def returnType: Type = TypeSystem.UnitType
}