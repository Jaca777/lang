package pl.jaca.lang.compiler.frontend.tree.expression

import pl.jaca.lang.compiler.frontend.tree.typesystem.Type
import pl.jaca.lang.compiler.frontend.tree.{Node, Visitor}

/**
  * @author Jaca777
  *         Created 2016-03-28 at 21
  */
case class CallExpr(name: String, args: List[Expression], override val `type`: Type) extends Expression(`type`) {
  override def accept[T](visitor: Visitor[T]): T = {
    visitor.visitCall(this)
  }
}
