package pl.jaca.lang.compiler.backend.visitor

import java.io.{File, FileReader}

import org.antlr.v4.runtime.{CommonTokenStream, TokenStream, ANTLRInputStream, CharStream}
import org.objectweb.asm.tree.InsnList
import org.scalatest.{Matchers, WordSpecLike}
import pl.jaca.lang.compiler.backend.`type`.IntType
import pl.jaca.lang.compiler.backend.bytecode._
import pl.jaca.lang.compiler.frontend.antlr.LangParser
import pl.jaca.lang.compiler.frontend.antlr.{LangLexer, LangParser}
import LangParser.{ReferenceExprContext, ExprContext}

/**
  * @author Jaca777
  *         Created 2016-03-27 at 14
  */
class ExpressionCompilerSpec extends WordSpecLike with Matchers {
  def parse(expr: String): ExprContext = {
    val input: CharStream = new ANTLRInputStream(expr)
    val tokens: TokenStream = new CommonTokenStream(new LangLexer(input))
    val parser: LangParser = new LangParser(tokens)
    parser.expr()
  }

  "ExpressionCompiler" should {
    "compile reference expression" in {
      val reference = parse("ref")
      val scope = new Scope()
      val variable = JavaVariable("ref", 1, scope, IntType)
      val scopeCtx = new ScopeContext(references = Set(variable))
      val insns = new InsnList
      val block = new JavaBlockContext(Set.empty, new Stack(1, 1))
      val compiler = new ExpressionCompiler(insns, scopeCtx, block, true)
      val (newScope, newBlock) = compiler.visit(reference)
      newBlock.topStackType should be(IntType)
      newBlock.maxStackSize should be(2)

    }
  }

}
