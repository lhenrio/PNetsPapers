package fr.inria.oasis.vercors.vce.openpnets.modelchecker.impl;

import java.util.ArrayList;
import java.util.List;

import fr.inria.oasis.vercors.vce.openpnets.modelchecker.ModalGraphState;
import fr.inria.oasis.vercors.vce.openpnets.modelchecker.ModalGraphTransition;
import fr.inria.oasis.vercors.vce.xtext.model.vceX.Expression;
import fr.inria.oasis.vercors.vce.xtext.model.vceX.Variable;

/**
 * comment: The structure of the label of State
 * There are four parameters: variable, operator, depth and fixPointType
 */
public class ModalGraphStateImpl implements ModalGraphState{
	protected List<Variable> varList;// The variables of the state
	protected List<ModalGraphTransition> mgTrList;
	
	protected Expression operator; //The operators
	protected int depth;				//depth
	protected String fixPointType;	//fix point type
	
	public ModalGraphStateImpl(List<Variable> varList, Expression operator, int depth, String fixPointType) {
		this.varList = varList;
		this.operator = operator;
		this.depth = depth;
		this.fixPointType = fixPointType;
	}
	
	public ModalGraphStateImpl(Expression operator, int depth, String fixPointType) {
		this.operator = operator;
		this.depth = depth;
		this.fixPointType = fixPointType;
	}


	@Override
	public void addModalGraphTransition(ModalGraphTransition mgTransition) {
		if (mgTrList == null) {
			this.mgTrList = new ArrayList<ModalGraphTransition>();
		}
		mgTrList.add(mgTransition);
	}


	@Override
	public List<ModalGraphTransition> getModalGraphTransition() {
		if (this.mgTrList == null) {
			this.mgTrList = new ArrayList<ModalGraphTransition>();
		}
		return mgTrList;
	}


	@Override
	public void setModalGraphTransition(List<ModalGraphTransition> modalGraphTransitions) {
		this.mgTrList = modalGraphTransitions;
		
	}

	@Override
	public void setFixPointType(String fixPointtype) {
		this.fixPointType = fixPointtype;
	}

	@Override
	public String getFixPointType() {
		return fixPointType;
	}

	@Override
	public void setDepth(int depth) {
		this.depth = depth;
	}

	@Override
	public int getDepth() {
		return depth;
	}

	@Override
	public void setOperator(Expression operator) {
		this.operator = operator;
	}

	@Override
	public Expression getOperator() {
		return this.operator;
	}
}
