package pl.jaca.lang.compiler.frontend.tree.expression

import pl.jaca.lang.compiler.frontend.tree.{Context, Visitor}
import pl.jaca.lang.compiler.frontend.tree.typesystem.LangTypeSystem

/**
  * @author Jaca777
  *         Created 2016-03-28 at 21
  */
case class IntLiteral(value: Int, override val context: Context = Context.EmptyContext) extends Expression(LangTypeSystem.IntType, context) {
  override def accept[T](visitor: Visitor[T]): T = {
    visitor.visitIntLiteral(this)
  }
}

