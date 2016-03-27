package pl.jaca.lang.compiler.bytecode

import pl.jaca.lang.compiler.`type`.Type
import pl.jaca.lang.recognizer.LangParser.FunctionDeclarationContext

/**
  * @author Jaca777
  *         Created 2016-03-25 at 21
  */
case class FunctionDeclaration(name: String, scope: Scope, t: Type, context: FunctionDeclarationContext)
