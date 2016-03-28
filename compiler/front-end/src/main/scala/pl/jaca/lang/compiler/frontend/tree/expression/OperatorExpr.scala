package pl.jaca.lang.compiler.frontend.tree.expression

import pl.jaca.lang.compiler.frontend.tree.Visitor

/**
  * @author Jaca777
  *         Created 2016-03-28 at 21
  */
abstract class OperatorExpr(left: Expression, right: Expression) extends Expression

object OperatorExpr {

  case class Sum(left: Expression, right: Expression) extends OperatorExpr(left, right) {
    override def accept[T](visitor: Visitor[T]): T = {
      visitor.visitSumExpr(this)
    }
  }

  case class Diff(left: Expression, right: Expression) extends OperatorExpr(left, right) {
    override def accept[T](visitor: Visitor[T]): T = {
      visitor.visitDiffExpr(this)
    }
  }

  case class Div(left: Expression, right: Expression) extends OperatorExpr(left, right) {
    override def accept[T](visitor: Visitor[T]): T = {
      visitor.visitDivExpr(this)
    }
  }

  case class Mul(left: Expression, right: Expression) extends OperatorExpr(left, right) {
    override def accept[T](visitor: Visitor[T]): T = {
      visitor.visitMulExpr(this)
    }
  }

}
