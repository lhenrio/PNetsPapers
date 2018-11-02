package fr.inria.oasis.vercors.vce.openpnets.modelchecker.impl;


import java.util.List;

import fr.inria.oasis.vercors.vce.openpnets.modelchecker.MCGState;
import fr.inria.oasis.vercors.vce.openpnets.modelchecker.MCGTransition;
import fr.inria.oasis.vercors.vce.openpnets.modelchecker.ModelCheckingGraph;

public class ModelCheckingGraphImpl implements ModelCheckingGraph{

	//fields
	protected List<MCGState> mcgStateList;
	protected boolean stateB;
	protected MCGStateImpl[] stateD;
	protected MCGState initialMCGState;
	protected List<MCGTransition> mcgTrList;
	
	public ModelCheckingGraphImpl() {
		mcgStateList = null;
	}

	@Override
	public MCGState getInitState() {
		return initialMCGState;
	}

	@Override
	public void setInitState(MCGState initialMCGState) {
		this.initialMCGState = initialMCGState;
	}

	@Override
	public List<MCGState> getGlobalMCGState() {
		return mcgStateList;
	}

	@Override
	public List<MCGTransition> getMCGTransition() {
		return mcgTrList;
	}
	
}
