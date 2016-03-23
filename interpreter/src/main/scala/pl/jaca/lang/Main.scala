package pl.jaca.lang

import java.io.{File, FileReader}

import org.antlr.v4.runtime.{CommonTokenStream, TokenStream, ANTLRInputStream, CharStream}
import pl.jaca.lang.interpreter.{Interpreter, ModuleInterpreter}
import pl.jaca.lang.recognizer.{LangParser, LangLexer}

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
    val moduleInterpreter: ModuleInterpreter = new ModuleInterpreter with Interpreter
    moduleInterpreter.visitModule(module)
  }
}
