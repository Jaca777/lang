package pl.jaca.lang.interpreter

import org.antlr.v4.runtime.ParserRuleContext

/**
  * @author Jaca777
  *         Created 2016-03-23 at 13
  */
trait Interpreter {
  def hasSucceeded(ctx: ParserRuleContext): Boolean = ctx.exception == null
  def fail(ctx: ParserRuleContext): Nothing = throw ctx.exception
}
