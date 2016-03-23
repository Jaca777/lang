package pl.jaca.lang.interpreter

import pl.jaca.lang.interpreter.value.Value
import pl.jaca.lang.recognizer.LangBaseVisitor
import pl.jaca.lang.recognizer.LangParser._

/**
  * @author Jaca777
  *         Created 2016-03-23 at 14
  */
class ExpressionInterpreter(scope: Scope) extends LangBaseVisitor[Value] with Interpreter {
  override def visitCall(ctx: CallContext): Value = {
    val callIntepreter = new CallInterpreter(scope)
    callIntepreter.visitCall(ctx)
  }

  override def visitOpExpr(ctx: OpExprContext): Value = {
    val left = visit(ctx.left)
    val right = visit(ctx.right)
    val op = ctx.op.getText
    applyOperator(op, left, right)
  }

  private def applyOperator(op: String, left: Value, right: Value): Value = op match {
    case "+" => Value(left.asInt + right.asInt, "int")
  }

  override def visitRefExpr(ctx: RefExprContext): Value = {
    val name = ctx.ref.getText
    val value = scope.references.get(name)
    if(value.isDefined) value.get
    else
  }

  override def visitAtomExpr(ctx: AtomExprContext): Value = super.visitAtomExpr(ctx)

  override def visitParenExpr(ctx: ParenExprContext): Value = super.visitParenExpr(ctx)
}
