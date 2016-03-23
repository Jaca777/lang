package pl.jaca.lang.interpreter.function

import pl.jaca.lang.interpreter.value.Value
import pl.jaca.lang.recognizer.LangParser.FunctionDeclarationContext

import scala.collection.JavaConverters._
/**
  * @author Jaca777
  *         Created 2016-03-23 at 14
  */
class Function(tree: FunctionDeclarationContext)  {
  val argTypes = {
    val desc = tree.functionDescriptor()
    val args = desc.formalArguments().formalArgument().asScala
    args.map(_.`type`.getText)
  }
  def apply(vAny: Value*): Value = {
    val functionInterpreter = new FunctionIntepreter
  }
}
