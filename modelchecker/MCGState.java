package fr.inria.oasis.vercors.vce.openpnets.modelchecker;

import java.util.List;
import java.util.Stack;

public interface MCGState {

	/**
	 * create a list of model checking graph state according to the MCGNum 
	 * @param MCGNum
	 */
	public void createMCGStateList(int MCGNum);
	
	/**
	 * compare if the current state is equals to the mcgState
	 * @param mcgState
	 * @return
	 */
	public boolean equals(MCGState mcgState);
	
	/**
	 * get a list of state from the states of model checking graph (MCG)
	 * @return
	 */
	public List<MCGState> getMCGStates();
	
	/**
	 * get a list of state from the Transition of the model checking graph
	 * @return
	 */
	public List<MCGTransition> getMCGTransition(); 
	
	/**
	 * set each transition for the current state
	 * @param modelCheckingGraphTransitions
	 */
	public void setMCGTransition(List<MCGTransition> mcgTransitions);
	
	/**
	 * get depth
	 * @return
	 */
	public int getDepth();
	
	/**
	 * set the value of depth
	 * @param depth
	 */
	public void setDepth(int depth);
	
	/**
	 * get status
	 * @return
	 */
	public boolean getStatus();
	
	/**
	 * set status
	 * @param status
	 */
	public void setStatus(boolean status);
	
	/**
	 * set sigma
	 * @return
	 */
	public boolean getSigma();
	
	/**
	 * set sigma
	 * @param sigma
	 */
	public void setSigma(boolean sigma);
	
	/**
	 * get a stack array
	 * @return
	 */
	public Stack<MCGState> getStatesD();
	
	/**
	 * set a stack statesD
	 * @param statesD
	 */
	public void setStatedD(Stack<MCGState> statesD);
	
	/**
	 * get the value of instack
	 * @return
	 */
	public boolean getInstack();
	
	/**
	 * set the value of instack
	 * @param instack
	 */
	public void setInstack(boolean instack);
	
}
