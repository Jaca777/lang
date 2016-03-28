package pl.jaca.lang.compiler.frontend.bytecode

import pl.jaca.lang.compiler.frontend.Type
import pl.jaca.lang.compiler.backend.antlr.LangParser.FunctionDeclarationContext

/**
  * @author Jaca777
  *         Created 2016-03-25 at 21
  */
case class FunctionDeclaration(name: String, scope: Scope, t: Type, context: FunctionDeclarationContext)
