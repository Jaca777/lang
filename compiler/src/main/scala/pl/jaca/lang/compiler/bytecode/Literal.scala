package pl.jaca.lang.compiler.bytecode

import org.objectweb.asm.Opcodes
import org.objectweb.asm.tree.{IntInsnNode, AbstractInsnNode}
import pl.jaca.lang.compiler.CompilationException
import pl.jaca.lang.recognizer.LangParser.{LiteralContext, LiteralExprContext}

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

abstract class Literal(val `type`: String) {
  def pushInsn: AbstractInsnNode
}

class IntLiteral(value: Int) extends Literal("int") {
  override def pushInsn = new IntInsnNode(Opcodes.BIPUSH, value)
}