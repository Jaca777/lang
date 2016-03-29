package pl.jaca.lang.compiler.frontend.tree.expression

import pl.jaca.lang.compiler.frontend.tree.Node
import pl.jaca.lang.compiler.frontend.tree.statement.Statement
import pl.jaca.lang.compiler.frontend.tree.typesystem.Type

/**
  * @author Jaca777
  *         Created 2016-03-28 at 21
  */
abstract class Expression(val `type`: Type) extends Statement
