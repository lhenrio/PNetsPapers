package fr.inria.oasis.vercors.vce.openpnets.modelchecker.impl;

import java.util.ArrayList;
import java.util.List;

import fr.inria.oasis.vercors.vce.openpnets.modelchecker.ULTSState;
import fr.inria.oasis.vercors.vce.openpnets.modelchecker.ULTSTransition;
import fr.inria.oasis.vercors.vce.xtext.model.vceX.Variable;

public class ULTSStateImpl implements ULTSState{
	
	protected List<Variable> varList;  //The variable of a state in ULTS
	protected List<ULTSTransition> ultsTransitions;
	protected ULTSState ultsState;
	
	public ULTSStateImpl() {
		super();
	}
	
	public ULTSStateImpl(List<Variable> varList) {
		this.varList = varList;
	}
	
	public ULTSStateImpl(List<Variable> varList, List<ULTSTransition> ultsTransitions) {
		this.varList = varList;
		this.ultsTransitions = ultsTransitions;
	}

	@Override
	public List<ULTSTransition> getULTransitions() {
//		if (ultsTransitions == null) {
//			ultsTransitions = new ArrayList<ULTSTransition>();
//		}
		return ultsTransitions;
	}

	@Override
	public void addULTSTransition(ULTSTransition ultsTransition) {
		if (this.ultsTransitions == null) {
			this.ultsTransitions = new ArrayList<ULTSTransition>();
		}
		this.ultsTransitions.add(ultsTransition);
	}

	@Override
	public void setULTSTransitions(List<ULTSTransition> ultsTransitions) {
		this.ultsTransitions = ultsTransitions;
	}

	@Override
	public List<Variable> getULTSStateVariables() {
		return varList;
	}

	@Override
	public void setULTSStateVariables(List<Variable> varList) {
		this.varList = varList;
	}

	@Override
	public ULTSState getULTSStateName() {
		return ultsState;
	}

	@Override
	public void setULTSStateName(ULTSState ultsState) {
		this.ultsState = ultsState;
	}
	
}
