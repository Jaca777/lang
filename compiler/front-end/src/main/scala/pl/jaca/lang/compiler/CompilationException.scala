package pl.jaca.lang.compiler

import pl.jaca.lang.compiler.frontend.tree.Context

/**
  * @author Jaca777
  *         Created 2016-03-25 at 22
  */
class CompilationException(msg: String, context: Context) extends RuntimeException(s"$msg [$context]"){

}
