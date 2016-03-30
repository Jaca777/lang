package pl.jaca.lang.compiler.frontend.tree.expression

import pl.jaca.lang.compiler.frontend.tree.{Context, Node, Visitor}

/**
  * @author Jaca777
  *         Created 2016-03-28 at 21
  */
case class If(cond: Expression, expr: Expression, override val context: Context = Context.EmptyContext)
  extends Expression(expr.`type`, context) {

  override def accept[T](visitor: Visitor[T]): T = {
    visitor.visitIf(this)
  }
}

