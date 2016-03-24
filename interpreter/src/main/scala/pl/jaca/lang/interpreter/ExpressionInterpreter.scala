package pl.jaca.lang.interpreter

import pl.jaca.lang.interpreter.Interpreter._
import pl.jaca.lang.recognizer.LangBaseVisitor
import pl.jaca.lang.recognizer.LangParser._

/**
  * @author Jaca777
  *         Created 2016-03-23 at 14
  */
class ExpressionInterpreter(scope: Scope) extends LangBaseVisitor[Value]{

  override def visitCallExpr(ctx: CallExprContext): Value = {
    val callInterpreter = new CallInterpreter(scope)
    callInterpreter.visitCall(ctx.call())
  }

  override def visitOperatorExpr(ctx: OperatorExprContext): Value = {
    val left = visit(ctx.left)
    val right = visit(ctx.right)
    val op = ctx.op.getText
    applyOperator(op, left, right)
  }

  private def applyOperator(op: String, left: Value, right: Value): Value = op match {
    case "*" => Value(left.asInt * right.asInt, right.`type`)
    case "/" => Value(left.asInt / right.asInt, right.`type`)
    case "+" => Value(left.asInt + right.asInt, right.`type`)
    case "-" => Value(left.asInt - right.asInt, right.`type`)
  }

  override def visitReferenceExpr(ctx: ReferenceExprContext): Value = {
    val name = ctx.reference().QUALIFIED_NAME().getText
    val value = scope.references.get(name)
    if (value.isDefined) value.get
    else throw new InterpreterException(s"Reference $name not found.", lineOf(ctx))
  }

  override def visitLiteralExpr(ctx: LiteralExprContext): Value =
    Value(ctx.literal().INT().getSymbol.getText.toInt, "int")

  override def visitParenExpr(ctx: ParenExprContext): Value = visit(ctx.paren().expr())

  override def visitBlock(ctx: BlockContext): Value = {
    val blockInterpreter = new BlockInterpreter(scope)
    blockInterpreter.visitBlock(ctx)
  }
}
