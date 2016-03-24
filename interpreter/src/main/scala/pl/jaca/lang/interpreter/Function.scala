package pl.jaca.lang.interpreter

import pl.jaca.lang.interpreter.Interpreter._
import pl.jaca.lang.recognizer.LangParser.{CallContext, FunctionDeclarationContext}

import scala.collection.JavaConverters._
import scala.collection.mutable

/**
  * @author Jaca777
  *         Created 2016-03-23 at 14
  */
class Function(tree: FunctionDeclarationContext, declaringScope: Scope) {
  /**
    * Names and types of formal arguments.
    */
  val arguments: mutable.Buffer[(String, String)] = {
    val desc = tree.functionDescriptor()
    val args = desc.formalArguments().formalArgument().asScala
    args.map(arg => (arg.name.getText, arg.`type`.getText))
  }

  def apply(args: List[Value], callingContext: CallContext): Value = {
    val actualArguments = this.arguments.zip(args).map {
      case ((name, t), Value(value, givenType)) =>
        if (typesMatch(t, givenType)) name -> Value(value, t)
        else throw new InterpreterException(s"Unable to pass $givenType as $t", lineOf(callingContext))
    }.toMap
    applyArguments(actualArguments)
  }

  private def applyArguments(actualArguments: Map[String, Value]): Value = {
    val functionInterpreter = new BlockInterpreter(declaringScope.extendRefs(actualArguments))
    functionInterpreter.visitBlock(tree.block())
  }

  def typesMatch(given: String, expected: String): Boolean = given == expected
}
