package pl.jaca.lang.compiler.bytecode

import pl.jaca.lang.compiler.`type`.Type

/**
  * @author Jaca777
  *         Created 2016-03-25 at 21
  */
class JavaBlockContext(variables: Set[JavaVariable], stack: Stack) {

  def pushStack(`type`: Type): JavaBlockContext = new JavaBlockContext(variables, stack.push(`type`))

  def popStack(`type`: Type): JavaBlockContext = new JavaBlockContext(variables, stack.pop(`type`))

  def topStackType = stack.topType

  def newVarIndex = variables.size

  def defineVariable(variable: JavaVariable) = new JavaBlockContext(variables + variable, stack)

  def varType(name: String) = findVar(name).t

  def findVar(name: String): JavaVariable = {
    variables.find(_.name == name).get
  }
}
