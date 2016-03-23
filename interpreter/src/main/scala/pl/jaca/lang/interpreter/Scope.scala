package pl.jaca.lang.interpreter

import pl.jaca.lang.interpreter.value.Value

/**
  * @author Jaca777
  *         Created 2016-03-23 at 15
  */
class Scope(val references: Map[String, Value], val functions: Map[String, Function] ) {
  def extendRef(name: String, value: Value): Scope =
    new Scope(references + (name -> value), functions)
  def extendsFunc(name: String, func: Function) =
    new Scope(references, functions + (name -> func))
}
