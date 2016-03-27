package pl.jaca.lang.interpreter.visitor

/**
  * @author Jaca777
  *         Created 2016-03-23 at 15
  */
class Scope(val references: Map[String, Value] = Map.empty, val functions: Map[String, Function] = Map.empty) {

  def extendRef(name: String, value: Value): Scope =
    new Scope(references + (name -> value), functions)

  def extendsFun(name: String, func: Function) =
    new Scope(references, functions + (name -> func))

  def extendRefs(refs: Map[String, Value]) =
    new Scope(references ++ refs, functions)

  def extendsFuns(funs: Map[String, Function]) =
    new Scope(references, functions ++ funs)
}
