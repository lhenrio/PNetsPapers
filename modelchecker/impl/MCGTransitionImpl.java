package fr.inria.oasis.vercors.vce.openpnets.modelchecker.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import fr.inria.oasis.vercors.vce.openpnets.modelchecker.MCGState;
import fr.inria.oasis.vercors.vce.openpnets.modelchecker.MCGTransition;
import fr.inria.oasis.vercors.vce.openpnets.modelchecker.ModalGraphState;
import fr.inria.oasis.vercors.vce.openpnets.modelchecker.ULTSState;
import fr.inria.oasis.vercors.vce.openpnets.modelchecker.ULTSTransition;

public class MCGTransitionImpl implements MCGTransition{
	/**
	 * class Transition of the model checking graph
	 * @author tengfeili
	 */
	protected List<ULTSTransition> ultsTrList;
	protected List<MCGTransition> mcgTrList;
	protected MCGState tarMCGState;
	protected MCGState startMCGState;
	protected HashMap<ULTSState, ModalGraphState> mcgState;
	
	public MCGTransitionImpl(List<ULTSTransition> ultsTrList, List<MCGTransition> mcgTrList) {
		this.ultsTrList = ultsTrList;
		this.mcgTrList = mcgTrList;
	}

	@Override
	public MCGState getTargetMCGState() {
		return tarMCGState;
	}

	@Override
	public void setTargetMCGState(MCGState tarMCGState) {
		this.tarMCGState = tarMCGState;
	}

	@Override
	public MCGState getStartMCGState() {
		return startMCGState;
	}

	@Override
	public void setStartMCGSStart(MCGState startMCGState) {
		this.startMCGState = startMCGState;
	}

	@Override
	public List<MCGTransition> getMCGTransition() {
		return mcgTrList;
	}

	@Override
	public void addMCGTransition(MCGTransition mcgTransition) {
		if (mcgTrList == null) {
			mcgTrList = new ArrayList<MCGTransition>();
		}
		this.mcgTrList.add(mcgTransition);
	}
	

}
