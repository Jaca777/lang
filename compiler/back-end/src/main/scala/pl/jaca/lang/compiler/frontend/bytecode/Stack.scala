package pl.jaca.lang.compiler.frontend.bytecode

import pl.jaca.lang.compiler.frontend.Type

/**
  * @author Jaca777
  *         Created 2016-03-27 at 14
  */
class Stack(val maxStackSize: Int = 0, val stackSize: Int = 0, stack: List[Type] = List.empty) {

  def push(t: Type): Stack = {
    val size = t.opcode.StackSize
    new Stack(stackSize + size, calcMaxs(), t :: stack)
  }

  def pop(t: Type): Stack = {
    val size = t.opcode.StackSize
    new Stack(stackSize - size, maxStackSize, `stack`.tail)
  }

  private def calcMaxs(): Int =
    if (maxStackSize < stackSize) stackSize
    else maxStackSize

  def topType: Type = stack.head

}
