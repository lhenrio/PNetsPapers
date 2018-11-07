package fr.inria.oasis.vercors.vce.openpnets.modelchecker.impl;

import java.util.ArrayList;

import fr.inria.oasis.vercors.vce.extension.StdNAryOperator;
import fr.inria.oasis.vercors.vce.extension.impl.ActionLiteralImpl;
import fr.inria.oasis.vercors.vce.extension.impl.StdNAryOpExpressionImpl;
import fr.inria.oasis.vercors.vce.xtext.model.vceX.Assignment;
import fr.inria.oasis.vercors.vce.xtext.model.vceX.BinaryOperator;
import fr.inria.oasis.vercors.vce.xtext.model.vceX.Expression;
import fr.inria.oasis.vercors.vce.xtext.model.vceX.Variable;
import fr.inria.oasis.vercors.vce.xtext.model.vceX.impl.AssignmentImpl;
import fr.inria.oasis.vercors.vce.xtext.model.vceX.impl.BinaryOpExpressionImpl;
import fr.inria.oasis.vercors.vce.xtext.model.vceX.impl.BoolLiteralImpl;
import fr.inria.oasis.vercors.vce.xtext.model.vceX.impl.VariableImpl;

public class Print {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ModalGraphImpl mGraph = new ModalGraphImpl();
		ArrayList<ModalGraphState> aState= new ArrayList<ModalGraphState>();
		
		Variable emptyVariable = new VariableImpl(null);
		Variable t = new VariableImpl("t");
		Variable M = new VariableImpl("M");
		Expression start = new ActionLiteralImpl("start", 0);
		Expression and  = new OpExpressionImpl(BinaryOperator.AND);

		
		Expression disjunction = new BinaryOpExpressionImpl(emptyVariable, emptyVariable, BinaryOperator.AND);
		Expression start_t = new StdNAryOpExpressionImpl(StdNAryOperator.FUN, start, t);
		Expression m_equation_t = new BinaryOpExpressionImpl(M, t, BinaryOperator.EQUAL);
		Expression captial_Y = new BinaryOpExpressionImpl(t, emptyVariable, BinaryOperator.EQUAL);
		//Expression exists_start_t = new StdUnaryOpExpressionImpl(start_t, StdUnaryOperator);
		
		ModalGraphState v0 = mGraph.new ModalGraphStateImpl(emptyVariable, and, 0, "nu");
		ModalGraphState v1 = mGraph.new ModalGraphStateImpl(emptyVariable, captial_Y, 0, "nu");
		ModalGraphState v2 = mGraph.new ModalGraphStateImpl(t, m_equation_t, 1, "mu");
		ModalGraphState v3 = mGraph.new ModalGraphStateImpl(t, disjunction, 1, "mu");
		
		aState.add(v0);
		aState.add(v1);
		aState.add(v2);
		aState.add(v3);
//		for (int i = 0; i < aState.size(); i++) {
//			System.out.println("s" + i + ": " + aState.get(i).variable + ", "+aState.get(i).fixPointType);
//		}
//		
		
		ULTSImpl ults = new ULTSImpl();
		Variable emptyVariable1 = new VariableImpl("");
		//Variable t1 = new VariableImpl("t");
		
		//start(t)
		//Expression start = new ActionLiteralImpl("start", 0);
		//Expression start_t = new StdNAryOpExpressionImpl(StdNAryOperator.FUN, start, t);
		
		//tick
		Expression tick = new ActionLiteralImpl("tick", 0);
		
		//timeout
		Expression timeout = new ActionLiteralImpl("timeout", 0);
		
		//boolean expression
		Expression booleanExpression = new BoolLiteralImpl(false);
		
		//Assignment:
		Expression expression = new StdNAryOpExpressionImpl(StdNAryOperator.FUN);
		Assignment assignment = new AssignmentImpl(t, expression);
		
		//The state variables:   0,a,M
		Variable v_0 = new VariableImpl("0");
		Variable v_a = new VariableImpl("a");
		Variable v_M = new VariableImpl("M");
		
		//The states
		ULTSState us0 = ults.new ULTSStateImpl(emptyVariable);
		ULTSState us10 = ults.new ULTSStateImpl(v_0);
		ULTSState us1a = ults.new ULTSStateImpl(v_a);
		ULTSState us1M = ults.new ULTSStateImpl(v_M);
		
		//transitions
		ULTSTransition t0_10 = ults.new ULTSTransitionImpl(us0, booleanExpression, null, start_t, us10);
		ULTSTransition t0_1a = ults.new ULTSTransitionImpl(us0, booleanExpression, null, start_t, us1a);
		ULTSTransition t0_1M = ults.new ULTSTransitionImpl(us0, booleanExpression, null, start_t, us1M);
		ULTSTransition t1M_1a = ults.new ULTSTransitionImpl(us1M, booleanExpression, assignment, tick, us1a);
		ULTSTransition t1a_1a = ults.new ULTSTransitionImpl(us1a, booleanExpression, assignment, tick, us1a);
		ULTSTransition t1a_10 = ults.new ULTSTransitionImpl(us1a, booleanExpression, assignment, tick, us10);
		ULTSTransition t10_0 = ults.new ULTSTransitionImpl(us10, booleanExpression, null, timeout, us0);
		
		ArrayList<ULTSState> uList = new ArrayList<ULTSState>();
		uList.add(us0);
		uList.add(us10);
		uList.add(us1a);
		uList.add(us1M);
		
//		for (int i = 0; i < uList.size(); i++) {
//			System.out.println(uList.get(i).expression);
//		}
		
		Expression and0 = new OpExpressionImpl(BinaryOperator.AND);
		
		ModelCheckingGraphImpl modelCheckingGraph = new ModelCheckingGraphImpl();
		boolean rho = false;
		MCGStateImpl state = modelCheckingGraph.new MCGStateImpl(us0, v0, rho);
		
		if (state.modalGraphState.operator.toString().equals(start_t.toString())) {
			System.out.println("start_t");
		}else if(state.modalGraphState.operator.toString().equals(and0.toString())){
			System.out.println("and");
		}
		
		//System.out.println(state.modalGraphState.operator+", "+state.depth+", "+state.instack);
		
		
	}

}
