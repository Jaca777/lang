package pl.jaca.lang.compiler.frontend.tree

import pl.jaca.lang.compiler.frontend.tree.statement.Statement
import pl.jaca.lang.compiler.frontend.tree.typesystem.Type

/**
  * @author Jaca777
  *         Created 2016-03-28 at 22
  */
case class FormalArg(name: String, `type`: Type)
