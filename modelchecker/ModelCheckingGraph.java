package fr.inria.oasis.vercors.vce.openpnets.modelchecker;

import java.util.List;

public interface ModelCheckingGraph {

	/**
	 * get the initial state
	 * @return
	 */
	public MCGState getInitState();
	
	/**
	 * set an initial state
	 * @param mcgState
	 */
	public void setInitState(MCGState mcgState);
	
	/**
	 * get a global model checking graph state
	 * @return
	 */
	public List<MCGState> getGlobalMCGState();
	
	/**
	 * get model checking graph transition
	 * @return
	 */
	public List<MCGTransition> getMCGTransition();
	
	
}
