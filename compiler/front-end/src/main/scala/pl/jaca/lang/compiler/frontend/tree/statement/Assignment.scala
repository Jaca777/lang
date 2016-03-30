package pl.jaca.lang.compiler.frontend.tree.statement

import pl.jaca.lang.compiler.frontend.tree.expression.Expression
import pl.jaca.lang.compiler.frontend.tree.{Context, Node, Visitor}

/**
  * @author Jaca777
  *         Created 2016-03-28 at 21
  */
case class Assignment(varName: String, value: Expression, override val context: Context = Context.EmptyContext) extends Statement(context) {
  override def accept[T](visitor: Visitor[T]): T = {
    visitor.visitAssignment(this)
  }
}
