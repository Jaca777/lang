package pl.jaca.lang.compiler.visitor

import pl.jaca.lang.compiler.bytecode.{Scope, FunctionDeclaration}
import pl.jaca.lang.recognizer.LangBaseVisitor
import pl.jaca.lang.recognizer.LangParser.{FunctionDeclarationStatementContext, FunctionDeclarationContext}

/**
  * @author Jaca777
  *         Created 2016-03-24 at 21
  */
class FunctionDeclarationsResolver(scope: Scope) extends LangBaseVisitor[Unit] {
  private var declarations = Set.empty[FunctionDeclaration]

  override def visitFunctionDeclarationStatement(ctx: FunctionDeclarationStatementContext) {
    val declContext = ctx.functionDeclaration
    val desc = declContext.functionDescriptor
    val block = declContext.block
    val declaration = new FunctionDeclaration(desc.name.getText, scope, desc.`type`.getText, declContext)
    this.declarations += declaration
  }

  def getDeclarations: Set[FunctionDeclaration] = declarations
}
