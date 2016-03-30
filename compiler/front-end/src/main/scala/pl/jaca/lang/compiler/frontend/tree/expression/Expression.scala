package pl.jaca.lang.compiler.frontend.tree.expression

import pl.jaca.lang.compiler.frontend.tree.{Context, Node}
import pl.jaca.lang.compiler.frontend.tree.statement.Statement
import pl.jaca.lang.compiler.frontend.tree.typesystem.Type
import pl.jaca.lang.compiler.frontend.tree.typesystem.TypeSystem.UnitType

/**
  * @author Jaca777
  *         Created 2016-03-28 at 21
  */
abstract class Expression(val `type`: Type, context: Context) extends Statement(context) {
  override def returnType = `type`
}
