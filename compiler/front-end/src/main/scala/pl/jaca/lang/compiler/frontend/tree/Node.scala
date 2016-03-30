package pl.jaca.lang.compiler.frontend.tree

/**
  * @author Jaca777
  *         Created 2016-03-28 at 21
  */
abstract class Node(val context: Context) {
  def accept[T](visitor: Visitor[T]): T
}

