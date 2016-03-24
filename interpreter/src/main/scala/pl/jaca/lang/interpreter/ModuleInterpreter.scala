package pl.jaca.lang.interpreter

import com.typesafe.scalalogging.Logger
import org.slf4j.LoggerFactory
import pl.jaca.lang.recognizer.LangBaseVisitor
import pl.jaca.lang.recognizer.LangParser.ModuleContext

/**
  * @author Jaca777
  *         Created 2016-03-23 at 13
  */
class ModuleInterpreter extends LangBaseVisitor[Unit] {

  private val log = Logger(LoggerFactory.getLogger("ModuleInterpreter"))

  override def visitModule(ctx: ModuleContext) {
    val name: String = ctx.name.getText
    log.debug("Executing module: " + name)
    val block = ctx.block()
    val blockInterpreter = new BlockInterpreter(new Scope)
    blockInterpreter.visitBlock(block)
  }

}
