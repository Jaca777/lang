package pl.jaca.lang.compiler.bytecode

import jdk.internal.org.objectweb.asm.ClassVisitor
import pl.jaca.lang.interpreter.visitor.Scope
import pl.jaca.lang.recognizer.LangParser.{FunctionDeclarationContext, FormalArgumentContext}

/**
  * @author Jaca777
  *         Created 2016-03-24 at 14
  */
class ScopeContext(val scope: Scope = new Scope(),
                   functions: Set[FunctionDeclaration] = Set.empty[FunctionDeclaration],
                   vars: Set[JavaVariable] = Set.empty) {

  def declareFunctions(fs: Set[FunctionDeclaration]): ScopeContext =
    new ScopeContext(scope, functions ++ fs, vars)

  def defineVar(v: JavaVariable): ScopeContext =
    new ScopeContext(scope, functions, vars + v)

  val visibleFunctions = functions.filter(f => this.scope contains f.scope)

  val visibleVars = vars.filter(v => this.scope contains v.scope)

  def functionsDiff(context: ScopeContext): Set[FunctionDeclaration] = functions diff context.functions


}
