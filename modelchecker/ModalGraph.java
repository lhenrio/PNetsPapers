package fr.inria.oasis.vercors.vce.openpnets.modelchecker;

import java.util.HashMap;
import java.util.List;

import fr.inria.oasis.vercors.vce.xtext.model.vceX.Expression;
import fr.inria.oasis.vercors.vce.xtext.model.vceX.Variable;

public interface ModalGraph {
	
	/**
	 * get a list of modal graph state
	 * @return
	 */
	public List<ModalGraphState> getModalGraphState();
	
	/**
	 * add a state
	 * @param modGraphState
	 */
	public void addModalGraphState(ModalGraphState mgState);
	
	/**
	 * get the initial state
	 * @return
	 */
	public ModalGraphState getInitialModalGraphState();
	
	/**
	 * set the initial state
	 * @param mgState
	 */
	public void setInitialModalGraphState(ModalGraphState mgState);
	
	/**
	 * get a list of state variable
	 * @return
	 */
	public HashMap<Variable, ModalGraphState> getMGStateVariableList();

	
	/**
	 * set a list of variables
	 * @param variables
	 */
	public void setVariables(List<Variable> variables);
	
	/**
	 * set a state variable with type of hashmap
	 * @param mgStateVar
	 * @param exprList
	 */
	public void setMGStateVariable(HashMap<Variable, ModalGraphState> mgStateVar, List<Expression> exprList);
	
	/**
	 * set a state variable with list type
	 * @param varList
	 * @param stateVar
	 * @param exprList
	 */
	public void setMGStateVariable(List<Variable> varList, List<ModalGraphState> stateVar, List<Expression> exprList);

	/**
	 * add a state variable
	 * @param varList
	 * @param mgState
	 * @param expr
	 */
	public void addMGStateVariable(Variable varList, ModalGraphState mgState, Expression expr);
	
	
}
