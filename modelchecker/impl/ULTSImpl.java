package fr.inria.oasis.vercors.vce.openpnets.modelchecker.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


import fr.inria.oasis.vercors.vce.openpnets.modelchecker.ULTS;
import fr.inria.oasis.vercors.vce.openpnets.modelchecker.ULTSState;
import fr.inria.oasis.vercors.vce.xtext.model.vceX.Expression;
import fr.inria.oasis.vercors.vce.xtext.model.vceX.Variable;

public class ULTSImpl implements ULTS{
	
	//field
	protected List<Variable> varList;
	protected List<ULTSState> uLtsStates;
	protected ULTSState initialState;
	protected HashMap<Variable, ULTSState> ultsStateVar;
	protected HashMap<Variable, List<Expression>> variableAssignment;
	protected HashMap<Variable, Expression> variableInitAssignment;
	
	
	public ULTSImpl() {
		super();
	}
	
	public ULTSImpl(List<ULTSState> ultsStates, ULTSState initialState, List<Variable> varList) {
		this.uLtsStates = ultsStates;
		this.initialState = initialState;
		this.varList = varList;
	}

	@Override
	public ULTSState getInitialULTSState() {
		return initialState;
	}

	@Override
	public void setInitialULTSState(ULTSState initUltsState) {
		this.initialState = initUltsState;
	}

	@Override
	public void addULTSState(ULTSState ultsState) {
		if (this.uLtsStates == null) {
			this.uLtsStates = new ArrayList<ULTSState>();
		}
		this.uLtsStates.add(ultsState);
	}

	@Override
	public void setStateVariables(HashMap<Variable, ULTSState> uLTSStateVar, List<Expression> defaultExprList) {
		this.ultsStateVar = new HashMap<Variable, ULTSState>();
		this.variableAssignment = new HashMap<Variable, List<Expression>>();
		this.variableInitAssignment = new HashMap<Variable, Expression>();
		this.ultsStateVar.putAll(uLTSStateVar);
		Iterator<Variable> iteVar = this.ultsStateVar.keySet().iterator();
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
	public void setStateVariables(List<Variable> varList, List<ULTSState> ulStateList, List<Expression> defaultExprList) {
		this.ultsStateVar = new HashMap<Variable, ULTSState>();
		this.variableAssignment = new HashMap<Variable, List<Expression>>();
		this.variableInitAssignment = new HashMap<Variable, Expression>();
		
		Iterator<Variable> iteVar = varList.iterator();
		Iterator<ULTSState> iteState = ulStateList.iterator();
		Iterator<Expression> iteExpr = defaultExprList.iterator();
		
		while (iteExpr.hasNext() && iteVar.hasNext() && iteState.hasNext()) {
			Variable var = iteVar.next();
			ULTSState ultsSt = iteState.next();
			Expression expr = iteExpr.next();
			this.ultsStateVar.put(var, ultsSt);
			
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
	public void addStateVariable(Variable var, ULTSState ultsState, Expression expr) {
		if (null == this.ultsStateVar) {
			this.ultsStateVar = new HashMap<Variable, ULTSState>();
		}
		this.ultsStateVar.put(var, ultsState);
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

	@Override
	public HashMap<Variable, ULTSState> getStateVariableList() {
		if (null == this.ultsStateVar) {
			this.ultsStateVar = new HashMap<Variable, ULTSState>();
		}
		return ultsStateVar;
	}

	@Override
	public List<ULTSState> getULTSStates() {
		if (this.uLtsStates == null) {
			this.uLtsStates = new ArrayList<ULTSState>();
		}
		return uLtsStates;
	}
	

}
