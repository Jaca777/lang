package pl.jaca.lang.interpreter

import pl.jaca.lang.recognizer.LangBaseVisitor
import pl.jaca.lang.recognizer.LangParser.{BlockContext, ExprContext, StatementContext}

import scala.collection.JavaConverters._

/**
  * @author Jaca777
  *         Created 2016-03-23 at 15
  */
class BlockInterpreter(scope: Scope) extends LangBaseVisitor[Value] {

  override def visitBlock(ctx: BlockContext): Value = {
    val statements = ctx.statement.asScala.toList
    if (statements.nonEmpty)
      evalBlock(statements)
    else Value.Unit
  }

  private def evalBlock(statements: List[StatementContext]): Value = {
    var _scope = this.scope
    for (statement <- statements.init)
      _scope = interpretStatement(statement, _scope)
    evalStatement(statements.last, _scope)
  }

  def interpretStatement(statement: StatementContext, currScope: Scope): Scope = {
    val intepreter: StatementInterpreter = new StatementInterpreter(scope)
    intepreter.visit(statement)
  }

  private def evalStatement(statement: StatementContext, scope: Scope): Value = {
    if (statement.expr() == null) {
      interpretStatement(statement, scope)
      Value.Unit
    } else evalExpr(statement.expr(), scope)
  }

  private def evalExpr(expr: ExprContext, scope: Scope): Value = {
    val exprIntepreter = new ExpressionInterpreter(scope)
    exprIntepreter.visit(expr)
  }
}
