package pl.jaca.lang

import java.io.{File, FileReader}

import org.antlr.v4.runtime.{ANTLRInputStream, CharStream, CommonTokenStream, TokenStream}
import pl.jaca.lang.interpreter.ModuleInterpreter
import pl.jaca.lang.recognizer.{LangLexer, LangParser}

/**
  * @author Jaca777
  *         Created 2016-03-23 at 13
  */
object Main {
  def main(args: Array[String]) {
    val input: CharStream = new ANTLRInputStream(new FileReader(
      new File(Main.getClass.getResource("script.xr").toURI)))
    val tokens: TokenStream = new CommonTokenStream(new LangLexer(input))

    //parser generates abstract syntax tree
    val parser: LangParser = new LangParser(tokens)
    val module: LangParser.ModuleContext = parser.module
    val moduleInterpreter: ModuleInterpreter = new ModuleInterpreter
    moduleInterpreter.visitModule(module)
  }
}
