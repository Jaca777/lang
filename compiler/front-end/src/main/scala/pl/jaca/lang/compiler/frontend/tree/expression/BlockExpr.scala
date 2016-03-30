package pl.jaca.lang.compiler.frontend.tree.expression

import pl.jaca.lang.compiler.frontend.tree.{Context, Visitor, Function}
import pl.jaca.lang.compiler.frontend.tree.statement.Statement
import pl.jaca.lang.compiler.frontend.tree.typesystem.Type

/**
  * @author Jaca777
  *         Created 2016-03-28 at 21
  */
case class BlockExpr(statements: List[Statement], declaredFunctions: Set[Function], override val context: Context = Context.EmptyContext)
  extends Expression(statements.last.returnType, context) {

  override def accept[T](visitor: Visitor[T]): T = {
    visitor.visitBlock(this)
  }

}
