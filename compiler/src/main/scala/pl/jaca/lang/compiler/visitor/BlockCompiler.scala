package pl.jaca.lang.compiler.visitor


import org.objectweb.asm.tree.{InsnList, MethodNode}
import org.objectweb.asm.{ClassVisitor, MethodVisitor}
import pl.jaca.lang.compiler.bytecode.{Stack, JavaBlockContext, ScopeContext}
import pl.jaca.lang.recognizer.LangBaseVisitor
import pl.jaca.lang.recognizer.LangParser.{StatementContext, BlockContext, FunctionDeclarationContext, FunctionDeclarationStatementContext}
import scala.collection.JavaConverters._

/**
  * @author Jaca777
  *         Created 2016-03-24 at 20
  */
class BlockCompiler(scope: ScopeContext, methodVisitor: MethodVisitor)
  extends LangBaseVisitor[ScopeContext] {


  override def visitBlock(ctx: BlockContext): ScopeContext = {
    val statements = ctx.statement().asScala.toList
    val declarations = functionDeclarations(statements)
    val scopeWithFunctions = scope.declareFunctions(declarations)
    val (instructions, newScopeCtx) = compileStatements(statements, scopeWithFunctions)
    visitInstructions(instructions)
    newScopeCtx
  }

  private def functionDeclarations(statements: List[StatementContext]) = {
    val declResolver = new FunctionDeclarationsResolver(scope.scope)
    for (statement <- statements)
      declResolver.visit(statement)
    declResolver.getDeclarations
  }

  private def compileStatements(statements: List[StatementContext], scopeContext: ScopeContext): (InsnList, ScopeContext) = {
    val instructions = new InsnList()
    val javaBlock = new JavaBlockContext(Set.empty, new Stack())
    def compileStatementsAcc(statements: List[StatementContext], scopeContext: ScopeContext, javaBlockContext: JavaBlockContext): ScopeContext =
      if (statements.isEmpty) scopeContext
      else {
        val statement = statements.head
        val compiler = new StatementCompiler(instructions, scopeContext, javaBlockContext)
        val (newScopeCtx, newBlockContext) = compiler.visit(statement)
        compileStatementsAcc(statements.tail, newScopeCtx, javaBlockContext)
      }
    (instructions, compileStatementsAcc(statements, scopeContext, javaBlock))
  }


  private def visitInstructions(instructions: InsnList) = {
    val method = new MethodNode()
    method.instructions = instructions
    method.accept(methodVisitor)
  }
}
