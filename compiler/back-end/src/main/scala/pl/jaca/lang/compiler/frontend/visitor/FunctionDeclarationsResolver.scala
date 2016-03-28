package pl.jaca.lang.compiler.frontend.visitor

import pl.jaca.lang.compiler.frontend.Type
import pl.jaca.lang.compiler.frontend.TypeResolver
import pl.jaca.lang.compiler.frontend.bytecode.{Scope, FunctionDeclaration}
import pl.jaca.lang.compiler.backend.antlr.LangBaseVisitor
import pl.jaca.lang.compiler.backend.antlr.LangParser.{FunctionDeclarationStatementContext, FunctionDeclarationContext}

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
