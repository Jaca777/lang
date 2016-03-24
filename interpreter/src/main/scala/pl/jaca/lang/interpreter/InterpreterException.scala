package pl.jaca.lang.interpreter

/**
  * @author Jaca777
  *         Created 2016-03-23 at 16
  */
class InterpreterException(msg: String, line: Int) extends RuntimeException(msg + s" (line=$line)")
