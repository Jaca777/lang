package pl.jaca.lang.compiler.frontend.tree

import jdk.nashorn.internal.ir.Block
import pl.jaca.lang.compiler.frontend.tree.expression._
import pl.jaca.lang.compiler.frontend.tree.statement._

/**
  * @author Jaca777
  *         Created 2016-03-28 at 21
  */
class Visitor[T] {

  def visit(node: Node): T =
    node.accept(this)


  def visitModule(module: Module): T = {
    throw new UnsupportedOperationException("visitModule is not implemented.")
  }

  def visitBlock(block: Block): T = {
    throw new UnsupportedOperationException("visitBlock is not implemented.")
  }

  def visitInitialization(block: Initialization): T = {
    throw new UnsupportedOperationException("visitInitialization is not implemented.")
  }

  def visitAssignment(block: Assignment): T = {
    throw new UnsupportedOperationException("visitAssignment is not implemented.")
  }

  def visitFunctionDeclaration(decl: FunctionDeclaration): T = {
    throw new UnsupportedOperationException("visitFunctionDeclaration is not implemented.")
  }

  def visitFunctionDescriptor(desc: FunctionDescriptor): T = {
    throw new UnsupportedOperationException("visitFunctionDescriptor is not implemented.")
  }

  def visitReference(ref: ReferenceExpr): T = {
    throw new UnsupportedOperationException("visitReference is not implemented.")
  }

  def visitLiteral(literal: LiteralExpr): T = {
    throw new UnsupportedOperationException("visitLiteral is not implemented.")
  }

  def visitBlock(block: BlockExpr): T = {
    throw new UnsupportedOperationException("visitBlock is not implemented.")
  }

  def visitCall(call: CallExpr): T = {
    throw new UnsupportedOperationException("visitCall is not implemented.")
  }

  def visitConditional(cond: ConditionalExpr): T = {
    throw new UnsupportedOperationException("visitConditional is not implemented.")
  }

  def visitIf(ifCond: If): T = {
    throw new UnsupportedOperationException("visitIf is not implemented.")
  }

  def visitElse(ifCond: Else): T = {
    throw new UnsupportedOperationException("visitElse is not implemented.")
  }

  def visitElseIf(elseifCond: ElseIf): T = {
    throw new UnsupportedOperationException("visitElseIf is not implemented.")
  }

  def visitFormalArg(formalArg: FormalArg): T = {
    throw new UnsupportedOperationException("visitFormalArg is not implemented.")
  }

  def visitSumExpr(sumExpr: OperatorExpr.Sum): T = {
    throw new UnsupportedOperationException("visitSumExpr is not implemented.")
  }

  def visitDiffExpr(sumExpr: OperatorExpr.Diff): T = {
    throw new UnsupportedOperationException("visitDiffExpr is not implemented.")
  }

  def visitMulExpr(sumExpr: OperatorExpr.Mul): T = {
    throw new UnsupportedOperationException("visitMulExpr is not implemented.")
  }

  def visitDivExpr(sumExpr: OperatorExpr.Div): T = {
    throw new UnsupportedOperationException("visitDivExpr is not implemented.")
  }

}
