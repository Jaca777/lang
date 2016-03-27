package pl.jaca.lang.compiler.visitor


import org.objectweb.asm.tree.InsnList
import pl.jaca.lang.compiler.bytecode.{JavaBlockContext, JavaVariable, ScopeContext}
import pl.jaca.lang.recognizer.LangBaseVisitor
import pl.jaca.lang.recognizer.LangParser._

/**
  * @author Jaca777
  *         Created 2016-03-24 at 22
  */
class StatementCompiler(insnList: InsnList, scopeContext: ScopeContext, javaBlockContext: JavaBlockContext)
  extends LangBaseVisitor[(ScopeContext, JavaBlockContext)] {

  override def visitInitializationStatement(ctx: InitializationStatementContext): (ScopeContext, JavaBlockContext) = {
    val init = ctx.initialization()
    val declaration = new JavaVariable(scopeContext.scope, init.`type`.getText)
    val newContext = scopeContext.defineVar(declaration)
    createVar(init)

    (newContext, javaBlockContext)
  }

  private def createVar(init: InitializationContext): JavaVariable = {
    val varType = init.`type`.getText
    val value: ExprContext = init.value
    val exprCompiler = new ExpressionCompiler(insnList, varType, scopeContext, javaBlockContext)
    exprCompiler.visit(value)
    val varId = javaBlockContext.newVarIndex
  }

  private def putTopStackValueInVar(varId: Int) {

  }

  override def visitAssignmentStatement(ctx: AssignmentStatementContext): (ScopeContext, JavaBlockContext) = {

  }

  override def visitExprStatement(ctx: ExprStatementContext): (ScopeContext, JavaBlockContext) = {

  }

  override def visitFunctionDeclarationStatement(ctx: FunctionDeclarationStatementContext): (ScopeContext, JavaBlockContext) = {

  }
}
