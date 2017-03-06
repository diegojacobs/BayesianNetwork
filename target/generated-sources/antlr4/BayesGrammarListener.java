// Generated from BayesGrammar.g4 by ANTLR 4.4
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link BayesGrammarParser}.
 */
public interface BayesGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link BayesGrammarParser#op2}.
	 * @param ctx the parse tree
	 */
	void enterOp2(@NotNull BayesGrammarParser.Op2Context ctx);
	/**
	 * Exit a parse tree produced by {@link BayesGrammarParser#op2}.
	 * @param ctx the parse tree
	 */
	void exitOp2(@NotNull BayesGrammarParser.Op2Context ctx);
	/**
	 * Enter a parse tree produced by {@link BayesGrammarParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(@NotNull BayesGrammarParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link BayesGrammarParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(@NotNull BayesGrammarParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link BayesGrammarParser#op}.
	 * @param ctx the parse tree
	 */
	void enterOp(@NotNull BayesGrammarParser.OpContext ctx);
	/**
	 * Exit a parse tree produced by {@link BayesGrammarParser#op}.
	 * @param ctx the parse tree
	 */
	void exitOp(@NotNull BayesGrammarParser.OpContext ctx);
	/**
	 * Enter a parse tree produced by {@link BayesGrammarParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(@NotNull BayesGrammarParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BayesGrammarParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(@NotNull BayesGrammarParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link BayesGrammarParser#negation}.
	 * @param ctx the parse tree
	 */
	void enterNegation(@NotNull BayesGrammarParser.NegationContext ctx);
	/**
	 * Exit a parse tree produced by {@link BayesGrammarParser#negation}.
	 * @param ctx the parse tree
	 */
	void exitNegation(@NotNull BayesGrammarParser.NegationContext ctx);
	/**
	 * Enter a parse tree produced by {@link BayesGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(@NotNull BayesGrammarParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BayesGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(@NotNull BayesGrammarParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link BayesGrammarParser#operator2}.
	 * @param ctx the parse tree
	 */
	void enterOperator2(@NotNull BayesGrammarParser.Operator2Context ctx);
	/**
	 * Exit a parse tree produced by {@link BayesGrammarParser#operator2}.
	 * @param ctx the parse tree
	 */
	void exitOperator2(@NotNull BayesGrammarParser.Operator2Context ctx);
	/**
	 * Enter a parse tree produced by {@link BayesGrammarParser#probability}.
	 * @param ctx the parse tree
	 */
	void enterProbability(@NotNull BayesGrammarParser.ProbabilityContext ctx);
	/**
	 * Exit a parse tree produced by {@link BayesGrammarParser#probability}.
	 * @param ctx the parse tree
	 */
	void exitProbability(@NotNull BayesGrammarParser.ProbabilityContext ctx);
	/**
	 * Enter a parse tree produced by {@link BayesGrammarParser#cliBayes}.
	 * @param ctx the parse tree
	 */
	void enterCliBayes(@NotNull BayesGrammarParser.CliBayesContext ctx);
	/**
	 * Exit a parse tree produced by {@link BayesGrammarParser#cliBayes}.
	 * @param ctx the parse tree
	 */
	void exitCliBayes(@NotNull BayesGrammarParser.CliBayesContext ctx);
	/**
	 * Enter a parse tree produced by {@link BayesGrammarParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(@NotNull BayesGrammarParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link BayesGrammarParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(@NotNull BayesGrammarParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link BayesGrammarParser#operator}.
	 * @param ctx the parse tree
	 */
	void enterOperator(@NotNull BayesGrammarParser.OperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link BayesGrammarParser#operator}.
	 * @param ctx the parse tree
	 */
	void exitOperator(@NotNull BayesGrammarParser.OperatorContext ctx);
}