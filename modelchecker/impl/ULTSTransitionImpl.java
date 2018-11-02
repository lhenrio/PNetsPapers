package fr.inria.oasis.vercors.vce.openpnets.modelchecker.impl;

import java.util.ArrayList;
import java.util.List;

import fr.inria.oasis.vercors.vce.openpnets.modelchecker.ULTSState;
import fr.inria.oasis.vercors.vce.openpnets.modelchecker.ULTSTransition;
import fr.inria.oasis.vercors.vce.pnetsmodel.ParamAction;
import fr.inria.oasis.vercors.vce.xtext.model.vceX.Assignment;
import fr.inria.oasis.vercors.vce.xtext.model.vceX.Expression;


public class ULTSTransitionImpl implements ULTSTransition{
	protected ULTSState targetULTSState;	  //The successor state of the transition
	
	protected Expression booleanExpression;				//The guard of the transition
	protected List<Assignment> assignment;		//the assignment
	protected Expression operator;		//the parameterized action
	
	public ULTSTransitionImpl() {
		super();
		assignment = new ArrayList<Assignment>();
	}
	
	public ULTSTransitionImpl(Expression operator, ULTSState targetULTSState) {
		super();
		this.assignment = new ArrayList<Assignment>();
		this.targetULTSState = targetULTSState;
		this.operator = operator;
	}

	@Override
	public ULTSState getTargetULTSState() {
		if (this.targetULTSState == null) {
			this.targetULTSState = new ULTSStateImpl();
		}
		return targetULTSState;
	}

	@Override
	public void setTargetULTSState(ULTSState tarULTSState) {
		this.targetULTSState = tarULTSState;
	}

	@Override
	public Expression getGuard() {
		return booleanExpression;
	}

	@Override
	public void setGuard(Expression expr) {
		booleanExpression = expr;
	}

	@Override
	public Expression getAction() {
		return operator;
	}

	@Override
	public void setAction(Expression operator) {
		this.operator = operator;
	}

	@Override
	public List<Assignment> getAssignment() {
		return assignment;
	}

	@Override
	public void setAssignment(List<Assignment> assignList) {
		this.assignment = new ArrayList<Assignment>();
		this.assignment.addAll(assignList);
	}
}
