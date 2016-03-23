package pl.jaca.lang.interpreter

import pl.jaca.lang.recognizer.LangBaseVisitor
import pl.jaca.lang.recognizer.LangParser.BlockContext

/**
  * @author Jaca777
  *         Created 2016-03-23 at 15
  */
class BlockInterpreter(scope: Scope) extends LangBaseVisitor[Unit] with Interpreter{

  override def visitBlock(ctx: BlockContext): Unit = {
    if(hasSucceeded(ctx)) {
      var _scope = this.scope
      for (statement <- ctx.statement) {
        val statementInterpreter = new StatementInterpreter(_scope)
        _scope = statementInterpreter.visit(ctx)
      }
    } else fail(ctx)
  }
}
