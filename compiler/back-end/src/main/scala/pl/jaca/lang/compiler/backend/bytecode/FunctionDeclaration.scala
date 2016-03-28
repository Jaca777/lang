package pl.jaca.lang.compiler.backend.bytecode

import pl.jaca.lang.compiler.backend.`type`.Type
import pl.jaca.lang.compiler.frontend.antlr.LangParser
import LangParser.FunctionDeclarationContext

/**
  * @author Jaca777
  *         Created 2016-03-25 at 21
  */
case class FunctionDeclaration(name: String, scope: Scope, t: Type, context: FunctionDeclarationContext)
