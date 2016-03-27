package pl.jaca.lang.interpreter.visitor

import pl.jaca.lang.recognizer.LangBaseVisitor
import pl.jaca.lang.recognizer.LangParser._

/**
  * @author Jaca777
  *         Created 2016-03-23 at 14
  */
class StatementInterpreter(scope: Scope) extends LangBaseVisitor[Scope] {

  override def visitFunctionDeclarationStatement(ctx: FunctionDeclarationStatementContext): Scope = {
    val func = ctx.functionDeclaration()
    val desc = func.functionDescriptor()
    val name = desc.name.getText
    val args = desc.args.arguments
    scope.extendsFun(name, new Function(func, scope))
  }

  override def visitExprStatement(ctx: ExprStatementContext): Scope = {
    val expr = ctx.expr()
    evalExpr(expr)
    this.scope
  }

  override def visitInitializationStatement(ctx: InitializationStatementContext): Scope = {
    val init = ctx.initialization()
    val name = init.name.getText
    val t = init.`type`.getText
    val expr = init.value
    val value = evalExpr(expr)
    scope.extendRef(name, value)
  }


  override def visitAssignmentStatement(ctx: AssignmentStatementContext): Scope = {
    val assign = ctx.assignment()
    val name = assign.name.getText
    val expr = assign.value
    val value = evalExpr(expr)
    scope.extendRef(name, value)
  }

  private def evalExpr(ctx: ExprContext): Value = {
    val exprIntepreter = new ExpressionInterpreter(scope)
    exprIntepreter.visit(ctx)
  }


}
