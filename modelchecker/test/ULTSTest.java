package fr.inria.oasis.vercors.vce.openpnets.modelchecker.test;

import java.util.ArrayList;
import java.util.List;

import fr.inria.oasis.vercors.vce.extension.StdNAryOperator;
import fr.inria.oasis.vercors.vce.extension.impl.ActionLiteralImpl;
import fr.inria.oasis.vercors.vce.extension.impl.StdNAryOpExpressionImpl;
import fr.inria.oasis.vercors.vce.openpnets.modelchecker.ULTS;
import fr.inria.oasis.vercors.vce.openpnets.modelchecker.ULTSState;
import fr.inria.oasis.vercors.vce.openpnets.modelchecker.ULTSTransition;
import fr.inria.oasis.vercors.vce.openpnets.modelchecker.impl.ULTSImpl;
import fr.inria.oasis.vercors.vce.openpnets.modelchecker.impl.ULTSStateImpl;
import fr.inria.oasis.vercors.vce.openpnets.modelchecker.impl.ULTSTransitionImpl;
import fr.inria.oasis.vercors.vce.xtext.model.vceX.BinaryOperator;
import fr.inria.oasis.vercors.vce.xtext.model.vceX.Expression;
import fr.inria.oasis.vercors.vce.xtext.model.vceX.Variable;
import fr.inria.oasis.vercors.vce.xtext.model.vceX.impl.BinaryOpExpressionImpl;
import fr.inria.oasis.vercors.vce.xtext.model.vceX.impl.VariableImpl;

public class ULTSTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Variable> varList0 = new ArrayList<Variable>();
		List<Variable> varList1 = new ArrayList<Variable>();
		List<Variable> varList2 = new ArrayList<Variable>();
		List<Variable> varList3 = new ArrayList<Variable>();
		
		Variable emptyVariable = new VariableImpl(null);
		Variable t = new VariableImpl("t");
		
		//The actions: start(t), tick, timeout
		Expression start = new ActionLiteralImpl("start", 0);
		Expression start_t = new StdNAryOpExpressionImpl(StdNAryOperator.FUN, start, t);
		Expression tick = new ActionLiteralImpl("tick", 0);
		Expression timeout = new ActionLiteralImpl("timeout", 0);
		
		//The state variables:   0,a,M
		Variable v_0 = new VariableImpl("0");
		Variable v_a = new VariableImpl("a");
		Variable v_M = new VariableImpl("M");
		
		varList0.add(emptyVariable);
		varList1.add(v_0);
		varList2.add(v_a);
		varList3.add(v_M);
		
		//The states
		ULTSState s0 = new ULTSStateImpl(varList0);
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
		ULTSTransition t10_0 = new ULTSTransitionImpl(timeout, s0);
		
		s0.addULTSTransition(t0_10);
		s0.addULTSTransition(t0_1a);
		s0.addULTSTransition(t0_1M);
		s1M.addULTSTransition(t1M_1a);
		s1a.addULTSTransition(t1a_1a);
		s1a.addULTSTransition(t1a_10);
		s10.addULTSTransition(t10_0);
		
		List<ULTSState> ultsStateList = new ArrayList<ULTSState>();
		ultsStateList.add(s0);
		ultsStateList.add(s1M);
		ultsStateList.add(s1a);
		ultsStateList.add(s10);

		System.out.println("Print each state variable and transitions");
		for (int i = 0; i < ultsStateList.size(); i++) {
			System.out.print(ultsStateList.get(i).getULTSStateVariables()+", ");
			for (int j = 0; j < ultsStateList.get(i).getULTransitions().size(); j++) {
				System.out.print(ultsStateList.get(i).getULTransitions().get(j).getAction()+", ");
			}
			System.out.println();
		}
		
		ULTS ults = new ULTSImpl(ultsStateList, s0, varList0);
		
		System.out.println("Printing each state variavle with ULTS object:");
		
		for (int i = 0; i < ults.getULTSStates().size(); i++) {
			System.out.println(ults.getULTSStates().get(i).getULTSStateVariables());
		}
		
		
		Variable tr = new VariableImpl("tru");
		Variable fal = new VariableImpl("true");
		Expression expre = new BinaryOpExpressionImpl(tr, fal, BinaryOperator.OR);
		System.out.println(expre.getOpName().equals("OR"));
		System.out.println(expre.getVariables().get(1).toString());
		System.out.println(Boolean.getBoolean(expre.getVariables().get(1).toString()));
		System.out.println(Boolean.parseBoolean("true"));
	}

}
