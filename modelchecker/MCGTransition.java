package fr.inria.oasis.vercors.vce.openpnets.modelchecker;

import java.util.List;

public interface MCGTransition {

	/**
	 * get the target modal graph state
	 * @return
	 */
	public MCGState getTargetMCGState();
	
	/**
	 * set the target state
	 * @param tarMGState
	 */
	public void setTargetMCGState(MCGState tarMCGState);
	
	/**
	 * get the start Modal Graph state
	 * @return
	 */
	public MCGState getStartMCGState();
	
	/**
	 * set the start state from strMGState
	 * @param strMGState
	 */
	public void setStartMCGSStart(MCGState strMCGState);
	
	/**
	 * get a list of modal graph transition
	 * @return
	 */
	public List<MCGTransition> getMCGTransition();
	
	/**
	 * add a list of ults transition from newMGSTr
	 * @param newMGSTr
	 */
	public void addMCGTransition(MCGTransition mcgTransition);
	
	
}
