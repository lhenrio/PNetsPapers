package fr.inria.oasis.vercors.vce.openpnets.modelchecker.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import fr.inria.oasis.vercors.vce.openpnets.modelchecker.Evaluation;
import fr.inria.oasis.vercors.vce.openpnets.modelchecker.MCGState;
import fr.inria.oasis.vercors.vce.openpnets.modelchecker.MCGTransition;
import fr.inria.oasis.vercors.vce.openpnets.modelchecker.ModalGraph;
import fr.inria.oasis.vercors.vce.openpnets.modelchecker.ULTSState;

public class MCGStateImpl implements MCGState{
		
	protected ULTSState ultsState;
	protected Evaluation rhoULTS;
	protected ModalGraph modalGraphState;
	protected Evaluation rhoMG;

	protected List<MCGState> mcgStateList;
	protected List<MCGTransition> mcgTrList;
	
	protected int depth;
	protected boolean status;
	protected boolean sigma;
	public Stack<MCGState> statesD;
	protected boolean instack;
	
	public MCGStateImpl() {
		super();
		mcgStateList = null;
	}
	
	public MCGStateImpl(ULTSState ultsState, Evaluation rhoULTS, ModalGraph modalGraphState, Evaluation rhoMG) {
		this.ultsState = ultsState;
		this.rhoULTS = rhoULTS;
		this.modalGraphState = modalGraphState;
		this.rhoMG = rhoMG;
	}

	@Override
	public void createMCGStateList(int MCGNum) {
		 this.mcgStateList = new ArrayList<MCGState>(MCGNum);
	}

	@Override
	public boolean equals(MCGState mcgState) {
		for (int i = 0; i < this.mcgStateList.size(); i++) {
			if (!this.getMCGStates().get(i).toString().equals(mcgState.getMCGStates().get(i).toString())) {
				return false;
			}
		}
		return true;
	}

	@Override
	public List<MCGState> getMCGStates() {
		if (this.mcgStateList == null) {
			this.mcgStateList = new ArrayList<MCGState>();
		}
		return this.mcgStateList;
	}

	@Override
	public List<MCGTransition> getMCGTransition() {
		if (this.mcgTrList == null) {
			this.mcgTrList = new ArrayList<MCGTransition>();
		}
		return mcgTrList;
	}

	@Override
	public void setMCGTransition(List<MCGTransition> mcgTransitions) {
		this.mcgTrList = mcgTransitions;
	}

	@Override
	public int getDepth() {
		return depth;
	}

	@Override
	public void setDepth(int depth) {
		this.depth = depth;
	}

	@Override
	public boolean getStatus() {
		return status;
	}

	@Override
	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public boolean getSigma() {
		return sigma;
	}

	@Override
	public void setSigma(boolean sigma) {
		this.sigma = sigma;
	}

	@Override
	public Stack<MCGState> getStatesD() {
		return statesD;
	}

	@Override
	public void setStatedD(Stack<MCGState> statesD) {
		this.statesD = statesD;
		
	}

	@Override
	public boolean getInstack() {
		return instack;
	}

	@Override
	public void setInstack(boolean instack) {
		this.instack = instack;
	}
	
}
