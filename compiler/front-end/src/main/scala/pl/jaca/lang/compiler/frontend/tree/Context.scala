package pl.jaca.lang.compiler.frontend.tree

import org.antlr.v4.runtime.ParserRuleContext
import pl.jaca.lang.compiler.CompilationException
import pl.jaca.lang.compiler.frontend.antlr.LangParser
import pl.jaca.lang.compiler.frontend.antlr.LangParser.{ModuleContext, BlockContext}
import pl.jaca.lang.compiler.frontend.tree.statement.Module

/**
  * @author Jaca777
  *         Created 2016-03-30 at 18
  */

sealed abstract class Context

object Context {

  object EmptyContext extends Context {
    override def toString = "empty context"
  }

  case class ProgramContext(line: Int) extends Context {
    override def toString = s"line: $line"
  }

  case class ModuleContext(moduleName: String, line: Int) extends Context {
    override def toString = s"Module name: $moduleName; line: $line"
  }

  def fromANTLR(ctx: ParserRuleContext): Context = {
    val moduleOption = resolveModule(ctx.getParent)
    if (moduleOption.isEmpty) outsideModule(ctx)
    else fromANTLR(moduleOption.get)
  }

  def outsideModule(ctx: ParserRuleContext): Nothing = {
    val line = ctx.start.getLine
    val text: String = ctx.getText
    throw new CompilationException(s"Statement $text is outside of a module", ProgramContext(line))
  }

  private def fromANTLR(module: LangParser.ModuleContext): ModuleContext = {
    val name = module.name.getText
    val line = module.start.getLine
    ModuleContext(name, line)
  }

  private def resolveModule(ctx: ParserRuleContext): Option[LangParser.ModuleContext] = ctx match {
    case null => None
    case m: LangParser.ModuleContext => Some(m)
    case any: ParserRuleContext => resolveModule(any.getParent)
  }
}
