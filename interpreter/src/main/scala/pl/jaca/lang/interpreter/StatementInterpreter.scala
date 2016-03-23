package pl.jaca.lang.interpreter

import pl.jaca.lang.recognizer.LangBaseVisitor
import pl.jaca.lang.recognizer.LangParser._

/**
  * @author Jaca777
  *         Created 2016-03-23 at 14
  */
class StatementInterpreter(scope: Scope) extends LangBaseVisitor[Scope] with Interpreter {

  override def visitFunctionDeclaration(ctx: FunctionDeclarationContext) = {
    val desc = ctx.functionDescriptor()
    val name = desc.name.getText
    val args = desc.args.arguments

  }

  override def visitInitialization(ctx: InitializationContext): Scope = {

  }

  override def visitAssignment(ctx: AssignmentContext): Scope = {

  }

  override def visitConditional(ctx: ConditionalContext): Scope = {

  }

  override def visitCall(ctx: CallContext): Scope = {

  }

}
