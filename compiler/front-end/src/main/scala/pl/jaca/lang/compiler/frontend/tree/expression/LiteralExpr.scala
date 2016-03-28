package pl.jaca.lang.compiler.frontend.tree.expression

import pl.jaca.lang.compiler.frontend.tree.Visitor

/**
  * @author Jaca777
  *         Created 2016-03-28 at 21
  */
case class LiteralExpr() extends Expression {
  override def accept[T](visitor: Visitor[T]): T = {
    visitor.visitLiteral(this)
  }
}

