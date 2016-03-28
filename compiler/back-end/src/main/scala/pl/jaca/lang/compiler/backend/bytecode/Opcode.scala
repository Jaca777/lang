package pl.jaca.lang.compiler.backend.bytecode

import org.objectweb.asm.Opcodes._
import pl.jaca.lang.compiler.backend.CompilationException
import pl.jaca.lang.compiler.backend.bytecode.Opcode.Operator

/**
  * @author Jaca777
  *         Created 2016-03-25 at 22
  */
trait Opcode {
  def Load: Int

  def StackSize: Int

  def Pop: Int

  def operator(op: Operator): Option[Int]

}

object Opcode {

  abstract sealed class Operator
  object Sum extends Operator
  object Sub extends Operator
  object Mul extends Operator
  object Div extends Operator



}


