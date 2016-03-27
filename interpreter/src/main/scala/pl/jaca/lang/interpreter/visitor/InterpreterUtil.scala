package pl.jaca.lang.interpreter.visitor

import org.antlr.v4.runtime.ParserRuleContext

/**
  * @author Jaca777
  *         Created 2016-03-23 at 13
  */
object InterpreterUtil {
  def lineOf(context: ParserRuleContext) = context.getStart.getLine
}
