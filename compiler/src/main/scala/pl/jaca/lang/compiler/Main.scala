package pl.jaca.lang.compiler

import java.io.{File, FileReader}

import org.antlr.v4.runtime.{ANTLRInputStream, CharStream, CommonTokenStream, TokenStream}
import pl.jaca.lang.compiler.visitor.ModuleVisitor
import pl.jaca.lang.recognizer.{LangParser, LangLexer}

/**
  * @author Jaca777
  *         Created 2016-03-23 at 13
  */
object Main {
  def main(args: Array[String]) {
    val input: CharStream = new ANTLRInputStream(new FileReader(
      new File(Main.getClass.getClassLoader.getResource("pl/jaca/lang/script.xr").toURI)))
    val tokens: TokenStream = new CommonTokenStream(new LangLexer(input))
    val parser: LangParser = new LangParser(tokens)
    val module: LangParser.ModuleContext = parser.module
    val compiler = new ModuleVisitor
    compiler.visit(module)
  }
}
