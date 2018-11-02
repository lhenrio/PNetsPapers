package fr.inria.oasis.vercors.vce.openpnets.modelchecker;

import java.util.HashMap;
import java.util.List;

import fr.inria.oasis.vercors.vce.xtext.model.vceX.Expression;
import fr.inria.oasis.vercors.vce.xtext.model.vceX.Variable;

public interface ULTS {
	
	/**
	 * get a list of states
	 * @return
	 */
	public List<ULTSState> getULTSStates();
	
	/**
	 * get the initial state
	 * @return
	 */
	public ULTSState getInitialULTSState();
	
	/**
	 * Set the ultsState as the initial state
	 * @param ultsState
	 */
	public void setInitialULTSState(ULTSState ultsState);
	
	/**
	 * add a ULTS state
	 * @param ultsState
	 */
	public void addULTSState(ULTSState ultsState);
	
	/**
	 * set a set of the variables for the ULTS state
	 * @param uLTSStateVar
	 * @param exprList
	 */
	public void setStateVariables(HashMap<Variable, ULTSState> uLTSStateVar, List<Expression> exprList);
	
	/**
	 * set a list of the ULTS state variables
	 * @param varList
	 * @param ulStateList
	 * @param exprList
	 */
	public void setStateVariables(List<Variable> varList, List<ULTSState> ulStateList, List<Expression> exprList);
	
	/**
	 * add a ULTS state variable
	 * @param variable
	 * @param ultsState
	 * @param expr
	 */
	public void addStateVariable(Variable var, ULTSState ultsState, Expression expr);
	
	/**
	 * get a list of variable in the ULTS state 
	 * @return
	 */
	public HashMap<Variable, ULTSState> getStateVariableList();
	
	/**
	 * rewrite toString()
	 * @return
	 */
	public String toString();
	
}
