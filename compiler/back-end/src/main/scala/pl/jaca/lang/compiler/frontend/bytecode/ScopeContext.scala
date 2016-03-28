package pl.jaca.lang.compiler.frontend.bytecode

import jdk.internal.org.objectweb.asm.ClassVisitor
import pl.jaca.lang.compiler.backend.antlr.LangParser.{FunctionDeclarationContext, FormalArgumentContext}

/**
  * @author Jaca777
  *         Created 2016-03-24 at 14
  */
class ScopeContext(val scope: Scope = new Scope(),
                   private val functions: Set[FunctionDeclaration] = Set.empty[FunctionDeclaration],
                   references: Set[JavaVariable] = Set.empty) {

  def declareFunctions(fs: Set[FunctionDeclaration]): ScopeContext =
    new ScopeContext(scope, functions ++ fs, references)

  def defineVar(v: JavaVariable): ScopeContext =
    new ScopeContext(scope, functions, references + v)

  val visibleFunctions = functions.filter(f => this.scope contains f.scope)

  val visibleVars = references.filter(v => this.scope contains v.scope)

  def functionsDiff(context: ScopeContext): Set[FunctionDeclaration] = functions diff context.functions


}
