package pl.jaca.lang.compiler.frontend.tree.expression

import pl.jaca.lang.compiler.frontend.tree.{Node, Visitor}

/**
  * @author Jaca777
  *         Created 2016-03-28 at 21
  */
case class Else(expr: Expression) extends Expression(expr.`type`){
  override def accept[T](visitor: Visitor[T]): T = {
    visitor.visitElse(this)
  }
}
