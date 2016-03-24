package pl.jaca.lang.interpreter

import pl.jaca.lang.interpreter.Interpreter._
import pl.jaca.lang.recognizer.LangBaseVisitor
import pl.jaca.lang.recognizer.LangParser._
/**
  * @author Jaca777
  *         Created 2016-03-23 at 14
  */
class StatementInterpreter(scope: Scope) extends LangBaseVisitor[Scope] {

  override def visitStatement(ctx: StatementContext): Scope = {
    if (isExpr(ctx)) evalExpr(ctx.expr())
    else if (isFunctionDeclaration(ctx)) visit(ctx.functionDeclaration())
    else if (isInitialization(ctx)) visit(ctx.initialization())
    else if (isAssignment(ctx)) visit(ctx.assignment())
    else throw new InterpreterException("Unknown statement.", lineOf(ctx))
  }

  override def visitFunctionDeclaration(ctx: FunctionDeclarationContext): Scope = {
    val desc = ctx.functionDescriptor()
    val name = desc.name.getText
    val args = desc.args.arguments
    scope.extendsFun(name, new Function(ctx, scope))
  }

  private def isFunctionDeclaration(ctx: StatementContext) =
    ctx.functionDeclaration() != null

  override def visitInitialization(ctx: InitializationContext): Scope = {
    val name = ctx.name.getText
    val t = ctx.`type`.getText
    val expr = ctx.value
    val exprIntepreter = new ExpressionInterpreter(scope)
    val value = exprIntepreter.visit(expr)
    scope.extendRef(name, value)
  }

  private def isInitialization(ctx: StatementContext) =
    ctx.initialization() != null


  override def visitAssignment(ctx: AssignmentContext): Scope = {
    val name = ctx.name.getText
    val expr = ctx.value
    val exprIntepreter = new ExpressionInterpreter(scope)
    val value = exprIntepreter.visit(expr)
    scope.extendRef(name, value)
  }

  private def isAssignment(ctx: StatementContext) =
    ctx.assignment() != null



  private def evalExpr(ctx: ExprContext): Scope = {
    val exprIntepreter = new ExpressionInterpreter(scope)
    exprIntepreter.visit(ctx)
    this.scope
  }

  def isExpr(ctx: StatementContext): Boolean =
    ctx.expr() != null

}
