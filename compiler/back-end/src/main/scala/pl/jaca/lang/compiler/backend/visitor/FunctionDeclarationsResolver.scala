package pl.jaca.lang.compiler.backend.visitor

import pl.jaca.lang.compiler.backend.`type`.Type
import pl.jaca.lang.compiler.backend.`type`.TypeResolver
import pl.jaca.lang.compiler.backend.bytecode.{Scope, FunctionDeclaration}
import pl.jaca.lang.compiler.frontend.antlr.{LangBaseVisitor, LangParser}
import LangParser.{FunctionDeclarationStatementContext, FunctionDeclarationContext}

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
    val typeName = desc.`type`.getText
    val t = TypeResolver.forName(typeName)
    val declaration = new FunctionDeclaration(desc.name.getText, scope, t, declContext)
    this.declarations += declaration
  }

  def getDeclarations: Set[FunctionDeclaration] = declarations
}
