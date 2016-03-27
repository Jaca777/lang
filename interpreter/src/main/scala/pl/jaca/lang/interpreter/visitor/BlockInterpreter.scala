package pl.jaca.lang.interpreter.visitor

import pl.jaca.lang.recognizer.LangBaseVisitor
import pl.jaca.lang.recognizer.LangParser.{BlockContext, ExprContext, ExprStatementContext, StatementContext}
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
    val intepreter: StatementInterpreter = new StatementInterpreter(currScope)
    intepreter.visit(statement)
  }

  private def evalStatement(statement: StatementContext, currScope: Scope): Value = statement match {
    case context: ExprStatementContext =>
      evalExpr(context.expr(), currScope)
    case _ =>
      interpretStatement(statement, currScope)
      Value.Unit
  }

  private def evalExpr(expr: ExprContext, currScope: Scope): Value = {
    val exprIntepreter = new ExpressionInterpreter(currScope)
    exprIntepreter.visit(expr)
  }
}
