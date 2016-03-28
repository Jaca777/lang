package pl.jaca.lang.compiler.frontend.tree.statement

import pl.jaca.lang.compiler.frontend.tree.{Node, Visitor}

/**
  * @author Jaca777
  *         Created 2016-03-28 at 22
  */
case class FormalArg() extends Statement {
  override def accept[T](visitor: Visitor[T]): T = {
    visitor.visitFormalArg(this)
  }
}
