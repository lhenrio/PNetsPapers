package fr.inria.oasis.vercors.vce.openpnets.modelchecker;

import java.util.List;

import fr.inria.oasis.vercors.vce.xtext.model.vceX.Expression;

public interface ModalGraphState {
	
	
	/**
	 * set the fix point type
	 * @param fixPointtype
	 */
	public void setFixPointType(String fixPointtype);
	
	/**
	 * get fix point type
	 * @return
	 */
	public String getFixPointType();
	
	/**
	 * set the depth 
	 * @param depth
	 */
	public void setDepth(int depth);
	
	/**
	 * get depth
	 * @return
	 */
	public int getDepth();
	
	/**
	 * set operator from operator
	 * @param operator
	 */
	public void setOperator(Expression operator);
	
	/**
	 * get operator expression
	 * @return
	 */
	public Expression getOperator();
	
	
	/**
	 * add a modal graph transition to the list of modal graph transition.
	 * @param modalGraphTransition
	 */
	public void addModalGraphTransition(ModalGraphTransition modalGraphTransition);
	
	/**
	 * get a list of transition from the current modal graph state
	 * @return
	 */
	public List<ModalGraphTransition> getModalGraphTransition();
	
	/**
	 * set a list of transitions for the current state. 
	 * @param modalGraphTransitions
	 */
	public void setModalGraphTransition(List<ModalGraphTransition> modalGraphTransitions);
	
}
