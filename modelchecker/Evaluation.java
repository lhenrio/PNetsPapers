package fr.inria.oasis.vercors.vce.openpnets.modelchecker;

import fr.inria.oasis.vercors.vce.xtext.model.vceX.Expression;
import fr.inria.oasis.vercors.vce.xtext.model.vceX.Variable;

public interface Evaluation {
	/**
	 * The purpose of emptyEvaluation is to get the initial value
	 */
	public void emptyEvaluation();
	
	/**
	 * update the value of the variable, like rho(x-->v)
	 * @param evaluation
	 * @param variable
	 * @param expression
	 */
	public void update(Evaluation evaluation, Variable variable, Expression expression);
	
	/**
	 * parallel update the value of variable, like rho(x-->rho(e))
	 * @param evaluationAssignment
	 * @param variable
	 * @param evaluationExpression
	 * @param expression
	 */
	public void parallelUpdate(Evaluation evaluationAssignment, Variable variable, Evaluation evaluationExpression, Expression expression);
	
	/**
	 * apply expression, like rho(e)
	 * @param expression
	 * @return
	 */
	public Evaluation applyEvaluation(Expression expression);
}
