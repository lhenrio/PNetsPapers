package fr.inria.oasis.vercors.vce.openpnets.modelchecker;

import java.util.List;

import fr.inria.oasis.vercors.vce.xtext.model.vceX.Variable;

public interface ULTSState {
	
	/**
	 * get a list of transitions from the ULTS States
	 * @return
	 */
	public List<ULTSTransition> getULTransitions();
	
	/**
	 * add a transition to the list of ULTS Transition
	 * @param ultsTransition
	 */
	public void addULTSTransition(ULTSTransition ultsTransition);
	
	/**
	 * set each transition for the current state
	 * @param ultsTransitions
	 */
	public void setULTSTransitions(List<ULTSTransition> ultsTransitions);
	
	/**
	 * get a list of state variables
	 * @return
	 */
	public List<Variable> getULTSStateVariables();
	
	/**
	 * set the varList to state variables
	 * @param varList
	 */
	public void setULTSStateVariables(List<Variable> varList);
	
	/**
	 * get the name of state
	 * @return
	 */
	public ULTSState getULTSStateName();
	
	/**
	 * set the name of the state
	 * @param ultsState
	 */
	public void setULTSStateName(ULTSState ultsState);
}
