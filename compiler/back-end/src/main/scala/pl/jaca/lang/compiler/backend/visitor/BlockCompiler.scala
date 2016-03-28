package pl.jaca.lang.compiler.backend.visitor


import org.objectweb.asm.tree.{InsnList, MethodNode}
import org.objectweb.asm.{ClassVisitor, MethodVisitor}
import pl.jaca.lang.compiler.backend.bytecode._
import pl.jaca.lang.compiler.frontend.antlr.{LangBaseVisitor, LangParser}
import LangParser.{StatementContext, BlockContext, FunctionDeclarationContext, FunctionDeclarationStatementContext}
import scala.collection.JavaConverters._

/**
  * @author Jaca777
  *         Created 2016-03-24 at 20
  */
class BlockCompiler(scope: ScopeContext, methodVisitor: MethodVisitor)
  extends LangBaseVisitor[ScopeContext] {

  private val emptyBlock = new JavaBlockContext(Set.empty, new Stack())
  private val mutableBlock = new MutableBlockWrapper(emptyBlock)
  private val mutableScope = new MutableScopeWrapper(scope)

  override def visitBlock(ctx: BlockContext): ScopeContext = {
    val statements = ctx.statement().asScala.toList
    declareFunctions(statements)
    visitStatements(statements)
    mutableScope.current
  }

  def declareFunctions(statements: List[StatementContext]): Unit = {
    val declarations = functionDeclarations(statements)
    mutableScope.declareFunctions(declarations)
  }

  def visitStatements(statements: List[StatementContext]): Unit = {
    val instructions = compileStatements(statements)
    visitInstructions(instructions)
  }

  private def functionDeclarations(statements: List[StatementContext]) = {
    val declResolver = new FunctionDeclarationsResolver(mutableScope.current.scope)
    for (statement <- statements)
      declResolver.visit(statement)
    declResolver.getDeclarations
  }

  private def compileStatements(statements: List[StatementContext]): InsnList = {
    val instructions = new InsnList()
    for (statement <- statements) {
      val compiler = new StatementCompiler(instructions, mutableScope.current, mutableBlock.current)
      val (scope, block) = compiler.visit(statement)
      mutableScope.set(scope)
      mutableBlock.set(block)
    }
    instructions
  }


  private def visitInstructions(instructions: InsnList) = {
    val method = new MethodNode()
    method.instructions = instructions
    method.accept(methodVisitor)
  }
}
