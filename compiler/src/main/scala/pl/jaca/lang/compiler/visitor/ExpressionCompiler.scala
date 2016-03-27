package pl.jaca.lang.compiler.visitor

import org.antlr.v4.runtime.ParserRuleContext
import org.objectweb.asm.tree.{InsnList, VarInsnNode}
import pl.jaca.lang.compiler.CompilationException
import pl.jaca.lang.compiler.bytecode._
import pl.jaca.lang.recognizer.LangBaseVisitor
import pl.jaca.lang.recognizer.LangParser._

/**
  * @author Jaca777
  *         Created 2016-03-24 at 22
  */
class ExpressionCompiler(insnList: InsnList, scopeContext: ScopeContext, javaBlockContext: JavaBlockContext, leaveOnStack: Boolean = true) extends LangBaseVisitor[(ScopeContext, JavaBlockContext)] {

  override def visitReferenceExpr(ctx: ReferenceExprContext): (ScopeContext, JavaBlockContext) = {
    val ref = ctx.reference()
    val name = getName(ref)
    val variable = javaBlockContext.findVar(name)
    val blockAfterExpr = {
      val block = pushVar(variable)
      if (!leaveOnStack) popVar(variable)
      else block
    }
    (scopeContext, blockAfterExpr)
  }

  private def pushVar(variable: JavaVariable): JavaBlockContext = {
    insnList.add(variable.pushInsn)
    javaBlockContext.pushStack(variable.t)
  }

  private def popVar(variable: JavaVariable): JavaBlockContext = {
    insnList.add(variable.popInsn)
    javaBlockContext.popStack(variable.t)
  }

  private def getName(ref: ReferenceContext): String =
    ref.QUALIFIED_NAME().getText

  override def visitLiteralExpr(ctx: LiteralExprContext): (ScopeContext, JavaBlockContext) = if (leaveOnStack) {
    val literalCtx = ctx.literal()
    val literal = Literal(literalCtx)
    val blockAfterExpr = pushLiteral(literal)
    (scopeContext, blockAfterExpr)
  } else (scopeContext, javaBlockContext)

  private def pushLiteral(literal: Literal) = {
    insnList.add(literal.pushInsn)
    javaBlockContext.pushStack(literal.`type`)
  }

  override def visitOperatorExpr(ctx: OperatorExprContext): (ScopeContext, JavaBlockContext) = {
    val (scopeContext1, javaBlockContext1) = compileExpr(ctx.left, scopeContext, javaBlockContext)
    val (scopeContext2, javaBlockContext2) = compileExpr(ctx.right, scopeContext1, javaBlockContext1)

  }

  private def compileExpr(exprContext: ExprContext, scopeContext: ScopeContext, javaBlockContext: JavaBlockContext): (ScopeContext, JavaBlockContext) = {
    val compiler = new ExpressionCompiler(insnList, scopeContext, javaBlockContext)
    compiler.visit(exprContext)
  }

  override def visitBlockExpr(ctx: BlockExprContext): (ScopeContext, JavaBlockContext) = {

  }

  override def visitCallExpr(ctx: CallExprContext): (ScopeContext, JavaBlockContext) = {

  }

  override def visitParenExpr(ctx: ParenExprContext): (ScopeContext, JavaBlockContext) = {

  }

  override def visitConditionalExpr(ctx: ConditionalExprContext): (ScopeContext, JavaBlockContext) = {

  }

  private def lineOf(ctx: ParserRuleContext) = ctx.start.getLine

}
