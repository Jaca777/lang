package pl.jaca.lang.interpreter

import pl.jaca.lang.interpreter.value.Value
import pl.jaca.lang.recognizer.LangBaseVisitor
import pl.jaca.lang.recognizer.LangParser.CallContext

/**
  * @author Jaca777
  *         Created 2016-03-23 at 16
  */
class CallInterpreter(scope: Scope) extends LangBaseVisitor[Value] {
  override def visitCall(ctx: CallContext): Value = {
    val args = ctx.actualArguments().expr()
  }
}
