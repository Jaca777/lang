package pl.jaca.lang.compiler.visitor

import org.antlr.v4.runtime.ParserRuleContext
import org.objectweb.asm.tree.{InsnList, VarInsnNode}
import pl.jaca.lang.compiler.CompilationException
import pl.jaca.lang.compiler.`type`.TypeResolver
import pl.jaca.lang.compiler.bytecode._
import pl.jaca.lang.recognizer.LangBaseVisitor
import pl.jaca.lang.recognizer.LangParser._

/**
  * @author Jaca777
  *         Created 2016-03-24 at 22
  */
class ExpressionCompiler(insnList: InsnList, scopeContext: ScopeContext, javaBlockContext: JavaBlockContext, leaveOnStack: Boolean = true) extends LangBaseVisitor[(ScopeContext, JavaBlockContext)] {

  val mutableScope = new MutableScopeWrapper(scopeContext)
  val mutableBlock = new MutableBlockWrapper(javaBlockContext)

  override def visitReferenceExpr(ctx: ReferenceExprContext): (ScopeContext, JavaBlockContext) = {
    if (leaveOnStack) pushRef(ctx)
    (mutableScope.current, mutableBlock.current)
  }

  def pushRef(ctx: ReferenceExprContext): Unit = {
    val ref = ctx.reference()
    val name = getName(ref)
    val variable = mutableBlock.findVar(name)
    pushVar(variable)
  }

  private def pushVar(variable: JavaVariable) {
    insnList.add(variable.pushInsn)
    mutableBlock.pushStack(variable.t)
  }

  private def popVar(variable: JavaVariable) {
    insnList.add(variable.popInsn)
    mutableBlock.popStack(variable.t)
  }

  private def getName(ref: ReferenceContext): String =
    ref.QUALIFIED_NAME().getText

  override def visitLiteralExpr(ctx: LiteralExprContext): (ScopeContext, JavaBlockContext) = {
    if (leaveOnStack) pushLiteral(ctx)
    (mutableScope.current, mutableBlock.current)
  }

  def pushLiteral(ctx: LiteralExprContext): Unit = {
    val literalCtx = ctx.literal()
    val literal = Literal(literalCtx)
    insnList.add(literal.pushInsn)
    mutableBlock.pushStack(literal.`type`)
  }

  override def visitOperatorExpr(ctx: OperatorExprContext): (ScopeContext, JavaBlockContext) = {
    pushExpr(ctx.left)
    pushExpr(ctx.right)
    (mutableScope.current, mutableBlock.current)
  }

  private def pushExpr(exprContext: ExprContext) {
    val compiler = new ExpressionCompiler(insnList, mutableScope.current, mutableBlock.current)
    val (scope, block) = compiler.visit(exprContext)
    mutableScope.set(scope)
    mutableBlock.set(block)
  }

  override def visitBlockExpr(ctx: BlockExprContext): (ScopeContext, JavaBlockContext) = {
    (mutableScope.current, mutableBlock.current)
  }

  override def visitCallExpr(ctx: CallExprContext): (ScopeContext, JavaBlockContext) = {
    (mutableScope.current, mutableBlock.current)
  }

  override def visitParenExpr(ctx: ParenExprContext): (ScopeContext, JavaBlockContext) = {
    (mutableScope.current, mutableBlock.current)
  }

  override def visitConditionalExpr(ctx: ConditionalExprContext): (ScopeContext, JavaBlockContext) = {
    (mutableScope.current, mutableBlock.current)
  }

  private def lineOf(ctx: ParserRuleContext) = ctx.start.getLine

}
