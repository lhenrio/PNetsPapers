package fr.inria.oasis.vercors.vce.openpnets.modelchecker.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

import fr.inria.oasis.vercors.vce.xtext.model.vceX.AssignRight;
import fr.inria.oasis.vercors.vce.xtext.model.vceX.BinaryOperator;
import fr.inria.oasis.vercors.vce.xtext.model.vceX.Expression;
import fr.inria.oasis.vercors.vce.xtext.model.vceX.Variable;

public class OpExpressionImpl implements Expression{

	BinaryOperator binaryOperator;
	
	
	public BinaryOperator getBinaryOperator() {
		return binaryOperator;
	}

	public void setBinaryOperator(BinaryOperator binaryOperator) {
		this.binaryOperator = binaryOperator;
	}

	public OpExpressionImpl(BinaryOperator binaryOperator) {
		// TODO Auto-generated constructor stub
		this.binaryOperator = binaryOperator;
	}
	
	public OpExpressionImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return binaryOperator.getName();
	}
	
	@Override
	public EList<Variable> getVariables() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EClass eClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resource eResource() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EObject eContainer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EStructuralFeature eContainingFeature() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EReference eContainmentFeature() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EList<EObject> eContents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TreeIterator<EObject> eAllContents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eIsProxy() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public EList<EObject> eCrossReferences() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object eGet(EStructuralFeature feature) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object eGet(EStructuralFeature feature, boolean resolve) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eSet(EStructuralFeature feature, Object newValue) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean eIsSet(EStructuralFeature feature) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void eUnset(EStructuralFeature feature) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object eInvoke(EOperation operation, EList<?> arguments) throws InvocationTargetException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EList<Adapter> eAdapters() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eDeliver() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void eSetDeliver(boolean deliver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eNotify(Notification notification) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AssignRight getNewEReference1() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setNewEReference1(AssignRight value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Expression clone(String prefix, int counter, StringBuilder treeIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isSynchronized() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEqual(Expression expr) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getOpName() {
		// TODO Auto-generated method stub
		return null;
	}

}
