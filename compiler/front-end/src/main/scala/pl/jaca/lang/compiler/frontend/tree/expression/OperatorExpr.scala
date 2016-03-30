package pl.jaca.lang.compiler.frontend.tree.expression

import com.sun.org.apache.xalan.internal.xsltc.compiler.CompilerException
import pl.jaca.lang.compiler.CompilationException
import pl.jaca.lang.compiler.frontend.tree.{Context, Visitor}
import pl.jaca.lang.compiler.frontend.tree.typesystem.{LangTypeSystem, Type}

/**
  * @author Jaca777
  *         Created 2016-03-28 at 21
  */
abstract class OperatorExpr(left: Expression, right: Expression, context: Context)
  extends Expression(OperatorExpr.resultType(left, right), context)

object OperatorExpr {

  /**
    * Allowed types to be used with operator.
    * Ordered by type-influence.
    */
  val AllowedTypes: List[Type] = List {
    LangTypeSystem.IntType
  }

  private[OperatorExpr] def resultType(left: Expression, right: Expression): Type = {
    checkTypes(left, right)
    val type1 = left.`type`
    val type2 = right.`type`
    if (type1 == type2) type1
    else AllowedTypes.find(e => e == type1 || e == type2).get
  }

  private def checkTypes(left: Expression, right: Expression) =
    if (AllowedTypes.contains(left.`type`) && AllowedTypes.contains(right.`type`))
      throw new CompilationException("Combination of " + left.`type` + " and " + right.`type` + " is not applicable to operators.", left.context)


  case class Sum(left: Expression, right: Expression, override val context: Context = Context.EmptyContext)
    extends OperatorExpr(left, right, context) {

    override def accept[T](visitor: Visitor[T]): T = {
      visitor.visitSumExpr(this)
    }

  }

  case class Diff(left: Expression, right: Expression, override val context: Context = Context.EmptyContext)
    extends OperatorExpr(left, right, context) {

    override def accept[T](visitor: Visitor[T]): T = {
      visitor.visitDiffExpr(this)
    }

  }

  case class Div(left: Expression, right: Expression, override val context: Context = Context.EmptyContext)
    extends OperatorExpr(left, right, context) {

    override def accept[T](visitor: Visitor[T]): T = {
      visitor.visitDivExpr(this)
    }

  }

  case class Mul(left: Expression, right: Expression, override val context: Context = Context.EmptyContext)
    extends OperatorExpr(left, right, context) {

    override def accept[T](visitor: Visitor[T]): T = {
      visitor.visitMulExpr(this)
    }

  }

}
