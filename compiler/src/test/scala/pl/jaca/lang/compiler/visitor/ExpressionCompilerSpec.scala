package pl.jaca.lang.compiler.visitor

import java.io.{File, FileReader}

import org.antlr.v4.runtime.{CommonTokenStream, TokenStream, ANTLRInputStream, CharStream}
import org.objectweb.asm.tree.InsnList
import org.scalatest.{Matchers, WordSpecLike}
import pl.jaca.lang.compiler.`type`.IntType
import pl.jaca.lang.compiler.bytecode._
import pl.jaca.lang.recognizer.{LangParser, LangLexer}
import pl.jaca.lang.recognizer.LangParser.ExprContext

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
      val scopeCtx = new ScopeContext(vars = Set(variable))
      val insns = new InsnList
      val block = new JavaBlockContext(Set.empty, new Stack)
      val compiler = new ExpressionCompiler(insns, scopeCtx, block, true)
      compiler.visit(reference)
    }
  }

}
