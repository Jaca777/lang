package pl.jaca.lang.interpreter.value

import pl.jaca.lang.interpreter.InterpreterException

/**
  * @author Jaca777
  *         Created 2016-03-23 at 14
  */
case class Value(val value: Any, val `type`: String) {

  def asInt: Int = {
    if (`type` != "int") throw new InterpreterException(s"Type mismatch. Expected int, got $`type`.")
    value.asInstanceOf[Int]
  }

}
