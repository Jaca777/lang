package pl.jaca.lang.compiler.frontend.bytecode

/**
  * @author Jaca777
  *         Created 2016-03-25 at 21
  */
class Scope(private val scope: List[String] = List.empty) {

  def enter(scope: String): Scope = new Scope(scope :: this.scope)

  def exit() = new Scope(scope.tail)

  def contains(scope: Scope) = {
    this.scope.zip(scope.scope).forall(p => p._1 == p._2)
  }

}
