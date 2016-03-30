package pl.jaca.lang.compiler.frontend.tree.statement

import pl.jaca.lang.compiler.frontend.tree.{Context, Visitor}

/**
  * @author Jaca777
  *         Created 2016-03-28 at 21
  */
case class Module(name: String, override val context: Context = Context.EmptyContext) extends Statement(context) {
  override def accept[T](visitor: Visitor[T]): T = {
    visitor.visitModule(this)
  }
}

