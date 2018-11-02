package fr.inria.oasis.vercors.vce.openpnets.modelchecker;

import java.util.List;

import fr.inria.oasis.vercors.vce.pnetsmodel.ParamAction;
import fr.inria.oasis.vercors.vce.xtext.model.vceX.Assignment;
import fr.inria.oasis.vercors.vce.xtext.model.vceX.Expression;

public interface ULTSTransition {

	/**
	 * get the target ULTS state
	 * @return
	 */
	public ULTSState getTargetULTSState();
	
	/**
	 * set the target state
	 * @param ultsState
	 */
	public void setTargetULTSState(ULTSState tarUltsState);
	
	/**
	 * get the guard in the transition
	 * @return
	 */
	public Expression getGuard();
	
	/**
	 * set a guard by the expr
	 * @param expr
	 */
	public void setGuard(Expression expr);
	
	/**
	 * get action in the ults transition
	 * @return
	 */
	public Expression getAction();
	
	/**
	 * set the parameterized action
	 * @param pAction
	 */
	public void setAction(Expression pAction);
	
	/**
	 * get a list of assignments
	 * @return
	 */
	public List<Assignment> getAssignment();
	
	/**
	 * set a list of assignments from assignList
	 * @param assignList
	 */
	public void setAssignment(List<Assignment> assignList);
	
}
