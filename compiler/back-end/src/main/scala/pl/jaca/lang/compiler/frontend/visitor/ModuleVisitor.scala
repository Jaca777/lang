package pl.jaca.lang.compiler.frontend.visitor

import com.typesafe.scalalogging.Logger
import org.slf4j.LoggerFactory
import pl.jaca.lang.compiler.backend.antlr.LangBaseVisitor
import pl.jaca.lang.compiler.backend.antlr.LangParser.ModuleContext
import pl.jaca.lang.compiler.frontend.bytecode.ScopeContext

//pl.jaca.lang.compiler.backend.antlr -> pl.jaca.lang.compiler.backend.antlr
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
