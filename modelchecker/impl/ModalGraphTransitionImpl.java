package fr.inria.oasis.vercors.vce.openpnets.modelchecker.impl;

import java.util.List;

import fr.inria.oasis.vercors.vce.openpnets.modelchecker.ModalGraphState;
import fr.inria.oasis.vercors.vce.openpnets.modelchecker.ModalGraphTransition;
import fr.inria.oasis.vercors.vce.xtext.model.vceX.Variable;

/**
 * Comment: This is the structure of transition in modal graph
 *
 */
public class ModalGraphTransitionImpl implements ModalGraphTransition{
	
	protected ModalGraphState startMGState;
	protected ModalGraphState targetMGState;
	
	public ModalGraphTransitionImpl() {
		super();
		startMGState = null;
		targetMGState = null;
	}
	
	public ModalGraphTransitionImpl(ModalGraphState startMGState, ModalGraphState targetMGState) {
		this.startMGState = startMGState;
		this.targetMGState = targetMGState;
	}

	@Override
	public ModalGraphState getTargetMGState() {
		return targetMGState;
	}

	@Override
	public void setTargetMGState(ModalGraphState targetMGState) {
		this.targetMGState = targetMGState;
	}

	@Override
	public ModalGraphState getStartMGState() {
		return startMGState;
	}

	@Override
	public void setStartMGState(ModalGraphState startMGState) {
		this.startMGState = startMGState;
	}

	@Override
	public List<Variable> computeVariables() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
