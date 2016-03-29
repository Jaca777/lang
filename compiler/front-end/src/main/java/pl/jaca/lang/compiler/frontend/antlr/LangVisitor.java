// Generated from C:/Users/Szymon/Desktop/Programming/lang/compiler/front-end/src/main/resources/pl/jaca/lang\Lang.g4 by ANTLR 4.5.1
package pl.jaca.lang.compiler.frontend.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LangVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LangParser#module}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModule(LangParser.ModuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(LangParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code initializationStatement}
	 * labeled alternative in {@link LangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitializationStatement(LangParser.InitializationStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignmentStatement}
	 * labeled alternative in {@link LangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentStatement(LangParser.AssignmentStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprStatement}
	 * labeled alternative in {@link LangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprStatement(LangParser.ExprStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functionDeclarationStatement}
	 * labeled alternative in {@link LangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclarationStatement(LangParser.FunctionDeclarationStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#functionDescriptor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDescriptor(LangParser.FunctionDescriptorContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#functionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(LangParser.FunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#initialization}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitialization(LangParser.InitializationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(LangParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code referenceExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReferenceExpr(LangParser.ReferenceExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code literalExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralExpr(LangParser.LiteralExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code operatorExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperatorExpr(LangParser.OperatorExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code blockExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockExpr(LangParser.BlockExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code callExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallExpr(LangParser.CallExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpr(LangParser.ParenExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code conditionalExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalExpr(LangParser.ConditionalExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#paren}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParen(LangParser.ParenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intLiteral}
	 * labeled alternative in {@link LangParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntLiteral(LangParser.IntLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#reference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReference(LangParser.ReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCall(LangParser.CallContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#conditional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditional(LangParser.ConditionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#c_if}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitC_if(LangParser.C_ifContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#c_elseif}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitC_elseif(LangParser.C_elseifContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#c_else}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitC_else(LangParser.C_elseContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#actualArguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitActualArguments(LangParser.ActualArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#formalArguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalArguments(LangParser.FormalArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#formalArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalArgument(LangParser.FormalArgumentContext ctx);
}