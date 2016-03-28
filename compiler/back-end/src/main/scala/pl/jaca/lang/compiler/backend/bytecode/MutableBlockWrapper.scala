package pl.jaca.lang.compiler.backend.bytecode

import pl.jaca.lang.compiler.backend.`type`.Type

/**
  * @author Jaca777
  *         Created 2016-03-27 at 19
  */
class MutableBlockWrapper(initial: JavaBlockContext) extends Mutable{
  private var _current = initial

  def pushStack(`type`: Type) =
    _current = _current.pushStack(`type`)

  def popStack(`type`: Type) =
    _current = _current.popStack(`type`)

  def defineVariable(variable: JavaVariable) =
    _current = _current.defineVariable(variable)

  def topStackType = _current.topStackType

  def newVarIndex = _current.newVarIndex

  def varType(name: String) =
    _current.varType(name)

  def findVar(name: String): JavaVariable =
    _current.findVar(name)

  def set(block: JavaBlockContext) =
    _current = block

  def current = _current
}
