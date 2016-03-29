package pl.jaca.lang.compiler.frontend.tree.expression

import pl.jaca.lang.compiler.frontend.tree.Visitor
import pl.jaca.lang.compiler.frontend.tree.typesystem.LangTypeSystem

/**
  * @author Jaca777
  *         Created 2016-03-28 at 21
  */
case class IntLiteral(value: Int) extends Expression(LangTypeSystem.IntType) {
  override def accept[T](visitor: Visitor[T]): T = {
    visitor.visitIntLiteral(this)
  }
}

