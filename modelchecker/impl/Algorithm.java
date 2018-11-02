package fr.inria.oasis.vercors.vce.openpnets.modelchecker.impl;

import java.util.ArrayList;

import fr.inria.oasis.vercors.vce.extension.StdNAryOperator;
import fr.inria.oasis.vercors.vce.extension.impl.ActionLiteralImpl;
import fr.inria.oasis.vercors.vce.extension.impl.StdNAryOpExpressionImpl;
import fr.inria.oasis.vercors.vce.openpnets.modelchecker.impl.ModalGraphImpl.ModalGraphStateImpl;
import fr.inria.oasis.vercors.vce.openpnets.modelchecker.impl.ModelCheckingGraphImpl.MCGStateImpl;
import fr.inria.oasis.vercors.vce.openpnets.modelchecker.impl.ULTSImpl.ULTSStateImpl;
import fr.inria.oasis.vercors.vce.xtext.model.vceX.AssignLeft;
import fr.inria.oasis.vercors.vce.xtext.model.vceX.AssignRight;
import fr.inria.oasis.vercors.vce.xtext.model.vceX.Assignment;
import fr.inria.oasis.vercors.vce.xtext.model.vceX.BinaryOperator;
import fr.inria.oasis.vercors.vce.xtext.model.vceX.Expression;
import fr.inria.oasis.vercors.vce.xtext.model.vceX.Variable;
import fr.inria.oasis.vercors.vce.xtext.model.vceX.impl.BinaryOpExpressionImpl;
import fr.inria.oasis.vercors.vce.xtext.model.vceX.impl.BoolLiteralImpl;
import fr.inria.oasis.vercors.vce.xtext.model.vceX.impl.VariableImpl;

public class Algorithm {
	//global variables
	protected MCGStateImpl state;
	protected ULTSStateImpl uState;
	protected ModalGraphStateImpl modalGraphState;
	protected boolean stateB;
	protected MCGStateImpl[] stateD;
	protected StackArray stackArray;
	ModelCheckingGraphImpl modelCheckingGraph = new ModelCheckingGraphImpl();
	
	Expression be = new BoolLiteralImpl();
	boolean B;
	
	/**
	 * boolean modelCheck(State state)
	 * @param state
	 * @return state.status
	 */
	public boolean modelCheck(MCGStateImpl state) {
		state.status = visited(state.sigma);
		stackArray.push(state);
		while (!stackArray.empty()) {
			close(stackArray.top());
		}
		return state.status;
	}

	boolean bPre = false;
	boolean bPost = false;
	//State[] stateW;

	/**
	 * void close(State top)
	 * @param top
	 * @return
	 */
	public void close(MCGStateImpl top) {
		//ULTSState ultsState = top.ultsState;
		//ModalGraphState modalGraphState = top.modalGraphState;
		
		
		ArrayList<MCGStateImpl> stateW = null;
		
		Expression x = new ActionLiteralImpl("x", 0);
		Variable emptyVariable = new VariableImpl(null);
		//Variable t = new VariableImpl("t");
		Expression c = new ActionLiteralImpl("c", 0);
		//Expression expr = new StdNAryOpExpressionImpl(StdNAryOperator.FUN,  x);
		
		//Operators of the state
		Expression conjunction  = new OpExpressionImpl(BinaryOperator.AND);
		Expression disjunction = new OpExpressionImpl(BinaryOperator.OR);
		Expression c_x = new StdNAryOpExpressionImpl(StdNAryOperator.FUN, c, x);
		Expression forall_x = new StdNAryOpExpressionImpl(StdNAryOperator.FUN, x);
		Expression exist_x = new StdNAryOpExpressionImpl(StdNAryOperator.FUN, x);
		Expression x_assignedBy_e = new BinaryOpExpressionImpl(x, emptyVariable, BinaryOperator.EQUAL);

		
		if (top.modalGraphState.operator.toString().equals(x_assignedBy_e.toString())) {
			B = checkAnd(stateW);
		}else if(top.modalGraphState.operator.toString().equals(conjunction.toString())){
			B = checkAnd(stateW);
			System.out.println("and");
		}else if(top.modalGraphState.operator.toString().equals(disjunction.toString())) {
			B = checkAnd(stateW);
		}else if(top.modalGraphState.operator.toString().equals(forall_x.toString())) {
			B = checkAnd(stateW);
		}else if(top.modalGraphState.operator.toString().equals(exist_x.toString())) {
			B = checkOr(stateW);
		}else if(top.modalGraphState.operator.toString().equals(c_x.toString())) {
			B = checkOr(stateW);
		}else {
			B = rhoBoolean(be);
		}
		
		if (B == bPre) {
			stackArray.pop();
			if ((state.status == visited(bPost))&&(bPost != bPre)) {
				state.status = visited(bPre);
				restore(state.statesD, bPre);
			}
		}
	}
	
	/**
	 * restore(State[] statesD, boolean bPre)
	 * @param (stateD, bPre)
	 */

	protected void restore(StackArray statesD, boolean bPre) {
		MCGStateImpl state;
		for (int i = 0; i < statesD.size(); i++) {
			state = statesD.element(i);
			if ((state.status == visited(bPost))&&(bPost!=bPre)) {
				state.status = visited(state.sigma);
				if (!state.instack) {
					stackArray.push(state);
					restore(statesD, bPre);
					state.statesD = null;
				}
			}
		}
	}

	/**
	 * boolean visited(boolean bPost)
	 * @param bPost
	 * @return 
	 */
	protected boolean visited(boolean bPost) {
		if (bPost == false) 
			return false;
		else
			return true;
	}
	
/////////////////////////////////////////// Submit it to z3 for checking
	/**
	 * boolean rho(Expression booleanExpression)
	 * @param be
	 * @return 
	 * This method assigns the variable
	 */
	protected boolean rhoBoolean(Expression booleanExpression) {
		String left = booleanExpression.getVariables().get(0).toString();//Get the boolean value of the left variable in the boolean expression
		String right = booleanExpression.getVariables().get(1).toString();//Get the boolean value of the right variable in the boolean expression
		boolean result = false;			//the execution result with a boolean value
		
		if (booleanExpression.getOpName().equals("AND")) { 
			result = Boolean.parseBoolean(left) && Boolean.parseBoolean(right);
		}else if(booleanExpression.getOpName().equals("OR")) { 
			result = Boolean.parseBoolean(left) || Boolean.parseBoolean(right);
		}
		
		return result;
	}
	
	protected int rhoInt(Expression intExpression) {
		String left = intExpression.getVariables().get(0).toString();//Get the value of the left variable 
		String right = intExpression.getVariables().get(1).toString();//Get the value of the right variable
		int result = 0;			//the execution result
		
		if (intExpression.getOpName().equals("PLUS")) { 
			result =  Integer.parseInt(left) + Integer.parseInt(right);
		}else if(intExpression.getOpName().equals("MINUS")) { 
			result = Integer.parseInt(left) - Integer.parseInt(right);
		}
		
		return result;
	}
	
	protected void rho(Assignment assignment) {
		AssignLeft assignmentLeft = assignment.getLeft();
		AssignRight assignRight = assignment.getRight();
		
		Variable variableLeft = (Variable) assignmentLeft;
		//int valueRight = assignRight;
		
		
	}
	
/////////////////////////////////////////	
	
	protected boolean checkAnd(ArrayList<MCGStateImpl> stateW) {
		//CheckState checkState = modelCheckingGraph.new CheckState(stateB, stateD);
		boolean tempBool = false;
		for (int i = 0; i < stateW.size(); i++) {
			state = stateW.get(i);
			if (stateB == B.DEFERRED) {
				tempBool =  B.DEFERRED;
			}else if (stateB == B.FALSE) {
				//state.addState(state);
				tempBool = B.FALSE;
			}else {
				tempBool = B.TRUE;
			}
		}
		return tempBool;
	}
	
	/**
	 * boolean checkOr(Vertex vert, Node nod, STGAEdge stgaEdge, ModalEdge modalEdge)
	 * @param stateW
	 * @return tempBool
	 * comment 1: add s to Di
	 * comment 2: Next state is a set of states. 
	 */
	protected boolean checkOr(ArrayList<MCGStateImpl> stateW) {
		//CheckState checkState = modelCheckingGraph.new CheckState(stateB, stateD);
		
		boolean tempBool = false;
		
		for (int i = 0; i < stateW.size(); i++) {
			state = stateW.get(i);
			if (stateB == B.DEFERRED) {
				tempBool = B.DEFERRED;
			}else if (stateB == B.FALSE) {
				tempBool = B.FALSE;
			}else {
				tempBool = B.TRUE;
			}
		}
		return tempBool;
	}


	/**
	 * protected CheckState check(State state)
	 * @param state
	 * @return a pair: (stateB, stateD) with type CheckState
	 */
	protected CheckState check(MCGStateImpl state) {
		CheckState checkState = null;
	    boolean fresh = state.status;
	    if (state.status == fresh) {
			state.status = visited(state.sigma);
			stackArray.push(state);
			checkState = modelCheckingGraph.new CheckState(B.DEFERRED, stateD);
		} else if (state.status == visited(bPre)) {
			checkState = modelCheckingGraph.new CheckState(bPre, stateD);
		}
		return checkState;
	}
	
	
}
