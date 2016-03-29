package pl.jaca.lang.compiler.frontend.tree.expression

import pl.jaca.lang.compiler.frontend.tree.Visitor
import pl.jaca.lang.compiler.frontend.tree.typesystem.Type

/**
  * @author Jaca777
  *         Created 2016-03-28 at 21
  */
case class ConditionalExpr(`if`: If, elseIf: List[ElseIf], `else`: Else, override val `type`: Type) extends Expression(`type`) {
  override def accept[T](visitor: Visitor[T]): T = {
    visitor.visitConditional(this)
  }
}
