package fr.inria.oasis.vercors.vce.openpnets.modelchecker;

import java.util.List;

import fr.inria.oasis.vercors.vce.xtext.model.vceX.Variable;

public interface ModalGraphTransition {

	/**
	 * get target state
	 * @return
	 */
	public ModalGraphState getTargetMGState();
	
	/**
	 * set the target state from mgState
	 * @param mgState
	 */
	public void setTargetMGState(ModalGraphState mgState);
	
	
	/**
	 * get the start modal graph state
	 * @return
	 */
	public ModalGraphState getStartMGState();
	
	/**
	 * set the start modal graph state
	 * @param mgState
	 */
	public void setStartMGState(ModalGraphState mgState);
	
	/**
	 * compute the variables
	 * @return
	 */
	public List<Variable> computeVariables();
}
