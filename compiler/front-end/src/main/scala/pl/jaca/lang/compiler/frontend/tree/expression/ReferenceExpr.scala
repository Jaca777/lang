package pl.jaca.lang.compiler.frontend.tree.expression

import pl.jaca.lang.compiler.frontend.tree.{Context, Visitor}
import pl.jaca.lang.compiler.frontend.tree.typesystem.Type

/**
  * @author Jaca777
  *         Created 2016-03-28 at 21
  */
case class ReferenceExpr(name: String, override val `type`: Type, override val context: Context = Context.EmptyContext)
  extends Expression(`type`, context)  {
  override def accept[T](visitor: Visitor[T]): T = {
    visitor.visitReference(this)
  }
}

