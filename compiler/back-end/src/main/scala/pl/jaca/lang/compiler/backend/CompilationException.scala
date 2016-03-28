package pl.jaca.lang.compiler.backend

/**
  * @author Jaca777
  *         Created 2016-03-25 at 22
  */
class CompilationException(msg: String, line: Int) extends RuntimeException(s"$msg[$line]"){

}
