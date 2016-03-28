package pl.jaca.lang.compiler.frontend

import org.objectweb.asm.Opcodes._
import pl.jaca.lang.compiler.frontend.bytecode.Opcode._
import pl.jaca.lang.compiler.frontend.bytecode.Opcode

/**
  * @author Jaca777
  *         Created 2016-03-27 at 15
  */
object IntType extends Type("int") {
  override def asJava: String = "I"

  override def isConvertableTo(t: Type): Boolean = t match {
    case IntType => true
    case _ => false
  }

  override def opcode: Opcode = IntOpcode
}

object IntOpcode extends Opcode{
  val Load = ILOAD
  val StackSize = 1
  val Pop = POP

  def operator(op: Operator) = Some(op match {
    case Sum => IADD
    case Sub => ISUB
    case Mul => IMUL
    case Div => IDIV
  })
}
