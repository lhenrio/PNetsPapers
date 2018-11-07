package fr.inria.oasis.vercors.vce.openpnets.modelchecker.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import fr.inria.oasis.vercors.vce.openpnets.modelchecker.ModalGraph;
import fr.inria.oasis.vercors.vce.openpnets.modelchecker.ModalGraphState;
import fr.inria.oasis.vercors.vce.xtext.model.vceX.Expression;
import fr.inria.oasis.vercors.vce.xtext.model.vceX.Variable;

/**
 * @author tengfeili
 * comment: The data structure of Modal Graph 
 */
public class ModalGraphImpl implements ModalGraph{
	
	//field
	protected List<Variable> varList;
	protected List<ModalGraphState> mgStatesList;
	protected ModalGraphState initialMGState;
	protected HashMap<Variable, ModalGraphState> mgStateVar;
	protected HashMap<Variable, List<Expression>> variableAssignment;
	protected HashMap<Variable, Expression> variableInitAssignment;

	public ModalGraphImpl() {
		super();
	}
	
	public ModalGraphImpl(List<ModalGraphState> mgStatesList, ModalGraphState initialMGState, List<Variable> varList) {
		super();
		this.mgStatesList = mgStatesList;
		this.initialMGState = initialMGState;
		this.varList = varList;
	}


	@Override
	public List<ModalGraphState> getModalGraphState() {
		if (this.mgStatesList == null) {
			this.mgStatesList = new ArrayList<ModalGraphState>();
		}
		return this.mgStatesList;
	}


	@Override
	public void addModalGraphState(ModalGraphState mgState) {
		if (this.mgStatesList == null) {
			this.mgStatesList = new ArrayList<ModalGraphState>();
		}
		this.mgStatesList.add(mgState);
	}


	@Override
	public ModalGraphState getInitialModalGraphState() {
		return initialMGState;
	}


	@Override
	public void setInitialModalGraphState(ModalGraphState mgState) {
		initialMGState = mgState;
	}


	@Override
	public HashMap<Variable, ModalGraphState> getMGStateVariableList() {
		return mgStateVar;
	}


	@Override
	public void setVariables(List<Variable> variables) {
		varList = variables;
	}


	@Override
	public void setMGStateVariable(HashMap<Variable, ModalGraphState> mgStateVar, List<Expression> defaultExprList) {
		this.mgStateVar = new HashMap<Variable, ModalGraphState>();
		this.variableAssignment = new HashMap<Variable, List<Expression>>();
		this.variableInitAssignment = new HashMap<Variable, Expression>();
		this.mgStateVar.putAll(mgStateVar);
		Iterator<Variable> iteVar = this.mgStateVar.keySet().iterator();
		int i = 0;
		int size = defaultExprList.size();
		while (iteVar.hasNext() && i< size) {
			Variable variable = iteVar.next();
			List<Expression> exprList = new ArrayList<Expression>();
			exprList.add(defaultExprList.get(i));
			this.variableAssignment.put(variable, exprList);
			if (!exprList.isEmpty() && null != exprList.get(0)) {
				this.variableInitAssignment.put(variable, exprList.get(0));
			}else {
				this.variableInitAssignment.put(variable, null);
			}
		}
		
	}


	@Override
	public void setMGStateVariable(List<Variable> varList, List<ModalGraphState> stateList, List<Expression> defaultExprList) {
		this.mgStateVar = new HashMap<Variable, ModalGraphState>();
		this.variableAssignment = new HashMap<Variable, List<Expression>>();
		this.variableInitAssignment = new HashMap<Variable, Expression>();
		
		Iterator<Variable> iteVar = varList.iterator();
		Iterator<ModalGraphState> iteState = stateList.iterator();
		Iterator<Expression> iteExpr = defaultExprList.iterator();
		
		while (iteExpr.hasNext() && iteVar.hasNext() && iteState.hasNext()) {
			Variable var = iteVar.next();
			ModalGraphState mgState = iteState.next();
			Expression expr = iteExpr.next();
			this.mgStateVar.put(var, mgState);
			
			List<Expression> exprList = new ArrayList<Expression>();
			if (null != expr) {
				exprList.add(expr);
				this.variableInitAssignment.put(var, expr);
			}else {
				this.variableInitAssignment.put(var, null);
			}
			this.variableAssignment.put(var, exprList);
		}
		
	}

	
	@Override
	public void addMGStateVariable(Variable var, ModalGraphState mgState, Expression expr) {
		if (null == this.mgStateVar) {
			this.mgStateVar = new HashMap<Variable, ModalGraphState>();
		}
		this.mgStateVar.put(var, mgState);
		if (null == this.variableAssignment) {
			this.variableAssignment = new HashMap<Variable, List<Expression>>();
		}
		if (null != var) {
			List<Expression> exprList = this.variableAssignment.get(var);
			if (null == exprList) {
				exprList = new ArrayList<Expression>();
			}
			if (!exprList.contains(expr) && null != expr) {
				exprList.add(expr);
			}
			this.variableAssignment.put(var, exprList);
		}
	}
	

}

