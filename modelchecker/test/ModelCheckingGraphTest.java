package fr.inria.oasis.vercors.vce.openpnets.modelchecker.test;

import java.util.ArrayList;
import java.util.List;

import fr.inria.oasis.vercors.vce.extension.StdNAryOperator;
import fr.inria.oasis.vercors.vce.extension.impl.ActionLiteralImpl;
import fr.inria.oasis.vercors.vce.extension.impl.StdNAryOpExpressionImpl;
import fr.inria.oasis.vercors.vce.openpnets.modelchecker.ModalGraphState;
import fr.inria.oasis.vercors.vce.openpnets.modelchecker.ULTSState;
import fr.inria.oasis.vercors.vce.openpnets.modelchecker.ULTSTransition;
import fr.inria.oasis.vercors.vce.openpnets.modelchecker.impl.ModalGraphImpl;
import fr.inria.oasis.vercors.vce.openpnets.modelchecker.impl.ModalGraphStateImpl;
import fr.inria.oasis.vercors.vce.openpnets.modelchecker.impl.ULTSImpl;
import fr.inria.oasis.vercors.vce.openpnets.modelchecker.impl.ULTSStateImpl;
import fr.inria.oasis.vercors.vce.openpnets.modelchecker.impl.ULTSTransitionImpl;
import fr.inria.oasis.vercors.vce.xtext.model.vceX.Assignment;
import fr.inria.oasis.vercors.vce.xtext.model.vceX.BinaryOperator;
import fr.inria.oasis.vercors.vce.xtext.model.vceX.Expression;
import fr.inria.oasis.vercors.vce.xtext.model.vceX.Variable;
import fr.inria.oasis.vercors.vce.xtext.model.vceX.impl.AssignmentImpl;
import fr.inria.oasis.vercors.vce.xtext.model.vceX.impl.BinaryOpExpressionImpl;
import fr.inria.oasis.vercors.vce.xtext.model.vceX.impl.BoolLiteralImpl;
import fr.inria.oasis.vercors.vce.xtext.model.vceX.impl.VariableImpl;

public class ModelCheckingGraphTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ModalGraphImpl mGraph = new ModalGraphImpl();
		List<ModalGraphState> mgStateList = new ArrayList<ModalGraphState>();
		
		Variable emptyVariable = new VariableImpl(null);
		Variable zero = new VariableImpl("0");
		Variable t = new VariableImpl("t");
		Variable M = new VariableImpl("M");
		Expression start = new ActionLiteralImpl("start", 0);
		
		
		Expression disjunction = new BinaryOpExpressionImpl(emptyVariable, emptyVariable, BinaryOperator.AND);
		Expression start_t = new StdNAryOpExpressionImpl(StdNAryOperator.FUN, start, t);
		Expression m_equation_t = new BinaryOpExpressionImpl(M, t, BinaryOperator.EQUAL);
		Expression captial_Y = new BinaryOpExpressionImpl(t, emptyVariable, BinaryOperator.EQUAL);
		
		List<Variable> varList0 = new ArrayList<>();
		List<Variable> varList1 = new ArrayList<>();
		List<Variable> varList2 = new ArrayList<>();
		List<Variable> varList3 = new ArrayList<>();

		varList0.add(emptyVariable);
		varList1.add(t);
		varList2.add(t);
		varList3.add(M);
		
		ModalGraphState s0 = new ModalGraphStateImpl(varList0, start_t, 0, "nu");
		ModalGraphState s1 = new ModalGraphStateImpl(varList0, captial_Y, 0, "nu");
		ModalGraphState s2 = new ModalGraphStateImpl(varList1, m_equation_t, 1, "mu");
		ModalGraphState s3 = new ModalGraphStateImpl(varList1, disjunction, 1, "mu");
		
		mgStateList.add(s0);
		mgStateList.add(s1);
		mgStateList.add(s2);
		mgStateList.add(s3);
		for (int i = 0; i < mgStateList.size(); i++) {
			System.out.println("s" + i + ": " + mgStateList.get(i).getDepth() + ", "+ mgStateList.get(i).getFixPointType());
		}
		
		
		ULTSImpl ults = new ULTSImpl();
		Variable emptyVariable1 = new VariableImpl("");
		//Variable t1 = new VariableImpl("t");
		
		//start(t)
		//Expression start = new ActionLiteralImpl("start", 0);
		//Expression start_t = new StdNAryOpExpressionImpl(StdNAryOperator.FUN, start, t);
		
		//tick, timeout
		Expression tick = new ActionLiteralImpl("tick", 0);
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
		
		
		varList0.add(emptyVariable);
		varList1.add(v_0);
		varList2.add(v_a);
		varList3.add(v_M);
		
		//The states
		ULTSState s00 = new ULTSStateImpl(varList0);
		ULTSState s10 = new ULTSStateImpl(varList1);
		ULTSState s1a = new ULTSStateImpl(varList2);
		ULTSState s1M = new ULTSStateImpl(varList3);
		
		//transitions
		ULTSTransition t0_10 = new ULTSTransitionImpl(start_t, s10);
		ULTSTransition t0_1a = new ULTSTransitionImpl(start_t, s1a);
		ULTSTransition t0_1M = new ULTSTransitionImpl(start_t, s1M);
		ULTSTransition t1M_1a = new ULTSTransitionImpl(tick, s1a);
		ULTSTransition t1a_1a = new ULTSTransitionImpl(tick, s1a);
		ULTSTransition t1a_10 = new ULTSTransitionImpl(tick, s10);
		ULTSTransition t10_0 = new ULTSTransitionImpl(timeout, s00);
		
		s00.addULTSTransition(t0_10);
		s00.addULTSTransition(t0_1a);
		s00.addULTSTransition(t0_1M);
		s1M.addULTSTransition(t1M_1a);
		s1a.addULTSTransition(t1a_1a);
		s1a.addULTSTransition(t1a_10);
		s10.addULTSTransition(t10_0);
		
		List<ULTSState> ultsStateList = new ArrayList<ULTSState>();
		ultsStateList.add(s00);
		ultsStateList.add(s1M);
		ultsStateList.add(s1a);
		ultsStateList.add(s10);
		
		for (int i = 0; i < ultsStateList.size(); i++) {
			System.out.println(ultsStateList.get(i).getULTSStateVariables());
		}
		
		
	}

}
