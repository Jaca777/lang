package pl.jaca.lang.compiler.frontend

import pl.jaca.lang.compiler.frontend.CompilationException
import pl.jaca.lang.compiler.frontend.bytecode.Opcode
import org.objectweb.asm.Opcodes._
import pl.jaca.lang.compiler.frontend.bytecode.Opcode._

/**
  * @author Jaca777
  *         Created 2016-03-27 at 15
  */
class ObjectType(name: String) extends Type(name) {
  override def asJava: String = ???

  override def isConvertableTo(t: Type): Boolean = ???

  override def opcode: Opcode = ObjectOpcode
}

object ObjectOpcode extends Opcode {
  val Load = ALOAD
  val StackSize = 1
  val Pop = POP

  def operator(op: Operator) = None
}
