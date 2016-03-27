package pl.jaca.lang.compiler.visitor

import com.typesafe.scalalogging.Logger
import org.slf4j.LoggerFactory
import pl.jaca.lang.compiler.bytecode.ScopeContext
import pl.jaca.lang.recognizer.LangBaseVisitor
import pl.jaca.lang.recognizer.LangParser.ModuleContext

/**
  * @author Jaca777
  *         Created 2016-03-24 at 14
  */
class ModuleVisitor extends LangBaseVisitor[ScopeContext] {
  private val log = Logger(LoggerFactory.getLogger("ModuleInterpreter"))

  override def visitModule(ctx: ModuleContext): ScopeContext =  {
    val name: String = ctx.name.getText
    log.debug("Compiling module: " + name)
    val classContext = new ScopeContext()
    val block = ctx.block()

    classContext
  }

}
