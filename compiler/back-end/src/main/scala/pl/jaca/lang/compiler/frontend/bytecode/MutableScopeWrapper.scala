package pl.jaca.lang.compiler.frontend.bytecode

/**
  * @author Jaca777
  *         Created 2016-03-27 at 19
  */
class MutableScopeWrapper(initial: ScopeContext) {
  private var _current = initial
  def declareFunctions(fs: Set[FunctionDeclaration]) =
    _current = _current.declareFunctions(fs)

  def defineVar(v: JavaVariable) =
    _current = _current.defineVar(v)

  def set(scope: ScopeContext) =
    _current = scope

  def scope = _current.scope

  def current = _current
}
