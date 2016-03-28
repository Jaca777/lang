package pl.jaca.lang.compiler.backend.visitor


import org.objectweb.asm.tree.InsnList
import pl.jaca.lang.compiler.backend.`type`.TypeResolver
import pl.jaca.lang.compiler.backend.bytecode._
import pl.jaca.lang.compiler.frontend.antlr.{LangBaseVisitor, LangParser}
import LangParser._

/**
  * @author Jaca777
  *         Created 2016-03-24 at 22
  */
class StatementCompiler(insnList: InsnList, scopeContext: ScopeContext, javaBlockContext: JavaBlockContext)
  extends LangBaseVisitor[(ScopeContext, JavaBlockContext)] {

  val mutableScope = new MutableScopeWrapper(scopeContext)
  val mutableBlock = new MutableBlockWrapper(javaBlockContext)

  override def visitInitializationStatement(ctx: InitializationStatementContext): (ScopeContext, JavaBlockContext) = {
    val init = ctx.initialization()
    val t = TypeResolver.forName(init.`type`.getText)
    val name = init.name.getText
    val declaration = new JavaVariable(name, mutableBlock.newVarIndex, mutableScope.scope, t)
    val newContext = scopeContext.defineVar(declaration)
    createVar(init)
    (mutableScope.current, mutableBlock.current)
  }

  private def createVar(init: InitializationContext): JavaVariable = {
    val varType = init.`type`.getText
    val value: ExprContext = init.value
    val exprCompiler = new ExpressionCompiler(insnList, scopeContext, javaBlockContext)
    exprCompiler.visit(value)
    val varId = javaBlockContext.newVarIndex
    ???
  }

  private def putTopStackValueInVar(varId: Int) {
    (mutableScope.current, mutableBlock.current)
  }

  override def visitAssignmentStatement(ctx: AssignmentStatementContext): (ScopeContext, JavaBlockContext) = {
    (mutableScope.current, mutableBlock.current)
  }

  override def visitExprStatement(ctx: ExprStatementContext): (ScopeContext, JavaBlockContext) = {
    (mutableScope.current, mutableBlock.current)
  }

  override def visitFunctionDeclarationStatement(ctx: FunctionDeclarationStatementContext): (ScopeContext, JavaBlockContext) = {
    (mutableScope.current, mutableBlock.current)
  }
}
