package pl.jaca.lang.compiler.backend.bytecode

import org.objectweb.asm.Opcodes
import org.objectweb.asm.tree.{IntInsnNode, AbstractInsnNode}
import pl.jaca.lang.compiler.backend.CompilationException
import pl.jaca.lang.compiler.backend.`type`.{ IntType, Type}
import pl.jaca.lang.compiler.frontend.antlr.LangParser
import LangParser.{LiteralContext, LiteralExprContext}

/**
  * @author Jaca777
  *         Created 2016-03-27 at 14
  */
object Literal {

  def apply(literal: LiteralContext): Literal = {
    if (literal.INT() != null) new IntLiteral(literal.INT().getText.toInt)
    else unknownLiteralType(literal)
  }

  def unknownLiteralType(lit: LiteralContext): Nothing = throw new CompilationException("Unknown literal type: " + lit.getText, lit.start.getLine)
}

abstract class Literal(val `type`: Type) {
  def pushInsn: AbstractInsnNode
}

class IntLiteral(value: Int) extends Literal(IntType) {
  override def pushInsn = new IntInsnNode(Opcodes.BIPUSH, value)
}