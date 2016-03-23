// Generated from C:/Users/Szymon/Desktop/Programming/lang/interpreter/src/main/resources/pl/jaca/lang\Lang.g4 by ANTLR 4.5.1
package pl.jaca.lang;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LangParser}.
 */
public interface LangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LangParser#module}.
	 * @param ctx the parse tree
	 */
	void enterModule(LangParser.ModuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#module}.
	 * @param ctx the parse tree
	 */
	void exitModule(LangParser.ModuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(LangParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(LangParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(LangParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(LangParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#functionDescriptor}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDescriptor(LangParser.FunctionDescriptorContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#functionDescriptor}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDescriptor(LangParser.FunctionDescriptorContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#funtionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFuntionDeclaration(LangParser.FuntionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#funtionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFuntionDeclaration(LangParser.FuntionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#initialization}.
	 * @param ctx the parse tree
	 */
	void enterInitialization(LangParser.InitializationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#initialization}.
	 * @param ctx the parse tree
	 */
	void exitInitialization(LangParser.InitializationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(LangParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(LangParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code condExpr}
	 * labeled alternative in {@link LangParser#conditional}.
	 * @param ctx the parse tree
	 */
	void enterCondExpr(LangParser.CondExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code condExpr}
	 * labeled alternative in {@link LangParser#conditional}.
	 * @param ctx the parse tree
	 */
	void exitCondExpr(LangParser.CondExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code call}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCall(LangParser.CallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code call}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCall(LangParser.CallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code opExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterOpExpr(LangParser.OpExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code opExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitOpExpr(LangParser.OpExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code refExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterRefExpr(LangParser.RefExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code refExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitRefExpr(LangParser.RefExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAtomExpr(LangParser.AtomExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAtomExpr(LangParser.AtomExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParenExpr(LangParser.ParenExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParenExpr(LangParser.ParenExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#actualArguments}.
	 * @param ctx the parse tree
	 */
	void enterActualArguments(LangParser.ActualArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#actualArguments}.
	 * @param ctx the parse tree
	 */
	void exitActualArguments(LangParser.ActualArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#formalArguments}.
	 * @param ctx the parse tree
	 */
	void enterFormalArguments(LangParser.FormalArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#formalArguments}.
	 * @param ctx the parse tree
	 */
	void exitFormalArguments(LangParser.FormalArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#formalArgument}.
	 * @param ctx the parse tree
	 */
	void enterFormalArgument(LangParser.FormalArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#formalArgument}.
	 * @param ctx the parse tree
	 */
	void exitFormalArgument(LangParser.FormalArgumentContext ctx);
}