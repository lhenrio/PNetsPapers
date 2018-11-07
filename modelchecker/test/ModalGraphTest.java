package fr.inria.oasis.vercors.vce.openpnets.modelchecker.test;

import java.util.ArrayList;
import java.util.List;

import fr.inria.oasis.vercors.vce.extension.StdNAryOperator;
import fr.inria.oasis.vercors.vce.extension.impl.ActionLiteralImpl;
import fr.inria.oasis.vercors.vce.extension.impl.StdNAryOpExpressionImpl;
import fr.inria.oasis.vercors.vce.openpnets.modelchecker.ModalGraphState;
import fr.inria.oasis.vercors.vce.openpnets.modelchecker.ModalGraphTransition;
import fr.inria.oasis.vercors.vce.openpnets.modelchecker.impl.ModalGraphStateImpl;
import fr.inria.oasis.vercors.vce.openpnets.modelchecker.impl.ModalGraphTransitionImpl;
import fr.inria.oasis.vercors.vce.xtext.model.vceX.BinaryOperator;
import fr.inria.oasis.vercors.vce.xtext.model.vceX.Expression;
import fr.inria.oasis.vercors.vce.xtext.model.vceX.Variable;
import fr.inria.oasis.vercors.vce.xtext.model.vceX.impl.BinaryOpExpressionImpl;
import fr.inria.oasis.vercors.vce.xtext.model.vceX.impl.VariableImpl;

public class ModalGraphTest {

	public static void main(String[] args) {
		List<ModalGraphState> mgStateList= new ArrayList<ModalGraphState>();
		
		Variable emptyVariable = new VariableImpl();
		Variable t = new VariableImpl("t");
		Variable M = new VariableImpl("M");
		Expression start = new ActionLiteralImpl("start", 0);
		
		Expression disjunction = new BinaryOpExpressionImpl(emptyVariable, emptyVariable, BinaryOperator.AND);
		Expression start_t = new StdNAryOpExpressionImpl(StdNAryOperator.FUN, start, t);
		Expression m_equation_t = new BinaryOpExpressionImpl(M, t, BinaryOperator.EQUAL);
		Expression captial_Y = new BinaryOpExpressionImpl(t, emptyVariable, BinaryOperator.EQUAL);
		
		ModalGraphState v0 = new ModalGraphStateImpl(start_t, 0, "nu");
		ModalGraphState v1 = new ModalGraphStateImpl(captial_Y, 0, "nu");
		ModalGraphState v2 = new ModalGraphStateImpl(m_equation_t, 1, "mu");
		ModalGraphState v3 = new ModalGraphStateImpl(disjunction, 1, "mu");
		
		mgStateList.add(v0);
		mgStateList.add(v1);
		mgStateList.add(v2);
		mgStateList.add(v3);
		
		
		ModalGraphTransition mgTr0_1 = new ModalGraphTransitionImpl(v0, v1);
		ModalGraphTransition mgTr0_2 = new ModalGraphTransitionImpl(v0, v2);
		ModalGraphTransition mgTr0_3 = new ModalGraphTransitionImpl(v0, v3);
		ModalGraphTransition mgTr3_2 = new ModalGraphTransitionImpl(v3, v2);
		ModalGraphTransition mgTr2_2 = new ModalGraphTransitionImpl(v2, v2);
		ModalGraphTransition mgTr2_1 = new ModalGraphTransitionImpl(v2, v1);
		ModalGraphTransition mgTr1_0 = new ModalGraphTransitionImpl(v1, v0);
		
		for (int i = 0; i < mgStateList.size(); i++) {
			System.out.println("s" + i + ": " + mgStateList.get(i).getOperator()+"," + mgStateList.get(i).getDepth() + ", "+mgStateList.get(i).getFixPointType());
			System.out.println(mgStateList.get(i).getModalGraphTransition());
		}
	}

}
