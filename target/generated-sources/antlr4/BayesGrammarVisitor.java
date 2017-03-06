// Generated from BayesGrammar.g4 by ANTLR 4.4
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link BayesGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface BayesGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link BayesGrammarParser#op2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp2(@NotNull BayesGrammarParser.Op2Context ctx);
	/**
	 * Visit a parse tree produced by {@link BayesGrammarParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(@NotNull BayesGrammarParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link BayesGrammarParser#op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp(@NotNull BayesGrammarParser.OpContext ctx);
	/**
	 * Visit a parse tree produced by {@link BayesGrammarParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(@NotNull BayesGrammarParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link BayesGrammarParser#negation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegation(@NotNull BayesGrammarParser.NegationContext ctx);
	/**
	 * Visit a parse tree produced by {@link BayesGrammarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(@NotNull BayesGrammarParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link BayesGrammarParser#operator2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperator2(@NotNull BayesGrammarParser.Operator2Context ctx);
	/**
	 * Visit a parse tree produced by {@link BayesGrammarParser#probability}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProbability(@NotNull BayesGrammarParser.ProbabilityContext ctx);
	/**
	 * Visit a parse tree produced by {@link BayesGrammarParser#cliBayes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCliBayes(@NotNull BayesGrammarParser.CliBayesContext ctx);
	/**
	 * Visit a parse tree produced by {@link BayesGrammarParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(@NotNull BayesGrammarParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link BayesGrammarParser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperator(@NotNull BayesGrammarParser.OperatorContext ctx);
}