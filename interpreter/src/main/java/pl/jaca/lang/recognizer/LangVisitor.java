// Generated from C:/Users/Szymon/Desktop/Programming/lang/interpreter/src/main/resources/pl/jaca/lang\Lang.g4 by ANTLR 4.5.1
package pl.jaca.lang.recognizer;
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
	 * Visit a parse tree produced by {@link LangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(LangParser.StatementContext ctx);
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
	 * Visit a parse tree produced by {@link LangParser#conditional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditional(LangParser.ConditionalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code call}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCall(LangParser.CallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code opExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpExpr(LangParser.OpExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code refExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRefExpr(LangParser.RefExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomExpr(LangParser.AtomExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpr(LangParser.ParenExprContext ctx);
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