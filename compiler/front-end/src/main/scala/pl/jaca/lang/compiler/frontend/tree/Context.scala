package pl.jaca.lang.compiler.frontend.tree

/**
  * @author Jaca777
  *         Created 2016-03-30 at 18
  */
abstract class Context

object Context {
  object EmptyContext extends Context {
    override def toString = "empty context"
  }
  case class ProgramContext(line: Int, moduleName: String) {
    override def toString = s"Module name: $moduleName; line: $line"
  }
}
