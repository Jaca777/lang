package pl.jaca.lang.interpreter

import pl.jaca.lang.recognizer.LangParser.{CallContext, ExprContext}
import pl.jaca.lang.recognizer.{LangBaseVisitor, LangParser}

import scala.collection.JavaConverters._
import pl.jaca.lang.interpreter.Interpreter._

/**
  * @author Jaca777
  *         Created 2016-03-23 at 16
  */
class CallInterpreter(scope: Scope) extends LangBaseVisitor[Value] {

  override def visitCall(ctx: CallContext): Value = {
    val args = arguments(ctx)
    val argValues = eval(args)
    val name = functionName(ctx)
    if (name == "print") {
      println(argValues.head.value)
      null
    } else {
      val function = findFunction(name)
      if (function.isEmpty) throw new InterpreterException(s"Function $name not found.", lineOf(ctx))
      else function.get._2.apply(argValues, ctx)
    }
  }

  def findFunction(name: String): Option[(String, Function)] =
    scope.functions.find(_._1 == name)


  def eval(args: List[ExprContext]): List[Value] = args.map {
    val exprInterpreter = new ExpressionInterpreter(scope)
    exprInterpreter.visit(_)
  }

  def arguments(ctx: CallContext): List[LangParser.ExprContext] =
    ctx.actualArguments().expr().asScala.toList

  def functionName(ctx: CallContext): String = {
    ctx.name.getText
  }
}
