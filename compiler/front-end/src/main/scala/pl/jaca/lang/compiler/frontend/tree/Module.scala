package pl.jaca.lang.compiler.frontend.tree

import pl.jaca.lang.compiler.frontend.tree.statement.Statement

/**
  * @author Jaca777
  *         Created 2016-03-28 at 21
  */
case class Module() extends Statement {
  override def accept[T](visitor: Visitor[T]): T = {
    visitor.visitModule(this)
  }
}

