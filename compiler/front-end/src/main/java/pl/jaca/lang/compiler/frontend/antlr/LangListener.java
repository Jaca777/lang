// Generated from C:/Users/Szymon/Desktop/Programming/lang/compiler/front-end/src/main/resources/pl/jaca/lang\Lang.g4 by ANTLR 4.5.1
package pl.jaca.lang.compiler.frontend.antlr;
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
	 * Enter a parse tree produced by the {@code initializationStatement}
	 * labeled alternative in {@link LangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterInitializationStatement(LangParser.InitializationStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code initializationStatement}
	 * labeled alternative in {@link LangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitInitializationStatement(LangParser.InitializationStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignmentStatement}
	 * labeled alternative in {@link LangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentStatement(LangParser.AssignmentStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignmentStatement}
	 * labeled alternative in {@link LangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentStatement(LangParser.AssignmentStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprStatement}
	 * labeled alternative in {@link LangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterExprStatement(LangParser.ExprStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprStatement}
	 * labeled alternative in {@link LangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitExprStatement(LangParser.ExprStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code functionDeclarationStatement}
	 * labeled alternative in {@link LangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclarationStatement(LangParser.FunctionDeclarationStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functionDeclarationStatement}
	 * labeled alternative in {@link LangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclarationStatement(LangParser.FunctionDeclarationStatementContext ctx);
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
	 * Enter a parse tree produced by {@link LangParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclaration(LangParser.FunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclaration(LangParser.FunctionDeclarationContext ctx);
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
	 * Enter a parse tree produced by the {@code referenceExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterReferenceExpr(LangParser.ReferenceExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code referenceExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitReferenceExpr(LangParser.ReferenceExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code literalExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLiteralExpr(LangParser.LiteralExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code literalExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLiteralExpr(LangParser.LiteralExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code operatorExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterOperatorExpr(LangParser.OperatorExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code operatorExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitOperatorExpr(LangParser.OperatorExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code blockExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBlockExpr(LangParser.BlockExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code blockExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBlockExpr(LangParser.BlockExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code callExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCallExpr(LangParser.CallExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code callExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCallExpr(LangParser.CallExprContext ctx);
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
	 * Enter a parse tree produced by the {@code conditionalExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterConditionalExpr(LangParser.ConditionalExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code conditionalExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitConditionalExpr(LangParser.ConditionalExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#paren}.
	 * @param ctx the parse tree
	 */
	void enterParen(LangParser.ParenContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#paren}.
	 * @param ctx the parse tree
	 */
	void exitParen(LangParser.ParenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intLiteral}
	 * labeled alternative in {@link LangParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterIntLiteral(LangParser.IntLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intLiteral}
	 * labeled alternative in {@link LangParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitIntLiteral(LangParser.IntLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#reference}.
	 * @param ctx the parse tree
	 */
	void enterReference(LangParser.ReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#reference}.
	 * @param ctx the parse tree
	 */
	void exitReference(LangParser.ReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#call}.
	 * @param ctx the parse tree
	 */
	void enterCall(LangParser.CallContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#call}.
	 * @param ctx the parse tree
	 */
	void exitCall(LangParser.CallContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#conditional}.
	 * @param ctx the parse tree
	 */
	void enterConditional(LangParser.ConditionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#conditional}.
	 * @param ctx the parse tree
	 */
	void exitConditional(LangParser.ConditionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#c_if}.
	 * @param ctx the parse tree
	 */
	void enterC_if(LangParser.C_ifContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#c_if}.
	 * @param ctx the parse tree
	 */
	void exitC_if(LangParser.C_ifContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#c_elseif}.
	 * @param ctx the parse tree
	 */
	void enterC_elseif(LangParser.C_elseifContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#c_elseif}.
	 * @param ctx the parse tree
	 */
	void exitC_elseif(LangParser.C_elseifContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#c_else}.
	 * @param ctx the parse tree
	 */
	void enterC_else(LangParser.C_elseContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#c_else}.
	 * @param ctx the parse tree
	 */
	void exitC_else(LangParser.C_elseContext ctx);
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