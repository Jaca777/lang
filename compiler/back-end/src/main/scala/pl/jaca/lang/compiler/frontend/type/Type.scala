package pl.jaca.lang.compiler.frontend

import pl.jaca.lang.compiler.frontend.bytecode.Opcode

/**
  * @author Jaca777
  *         Created 2016-03-27 at 15
  */
abstract class Type(val name: String) {
  def asJava: String
  def isConvertableTo(t: Type): Boolean
  def opcode: Opcode
}

