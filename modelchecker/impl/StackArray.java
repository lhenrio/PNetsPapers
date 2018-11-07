package fr.inria.oasis.vercors.vce.openpnets.modelchecker.impl;


public class StackArray{

	private MCGStateImpl[] statesArray;
	private int stackSize = 0;
	public StackArray() {
		statesArray = new MCGStateImpl[50];
		stackSize = 0;
	}
	
	public StackArray(int size) {
		statesArray = new MCGStateImpl[size];
		stackSize = 0;
	}
	
	public void push(MCGStateImpl stateElemet) {
		statesArray[stackSize++] = stateElemet;
	}
	
	public MCGStateImpl pop() {
		if (stackSize <= 0) {
			return null;
		}
		return statesArray[--stackSize];
	}
	
	public MCGStateImpl top() {
		return statesArray[stackSize-1];
	}
	
	public boolean empty() {
		if (stackSize == 0) 
			return true;
		else
			return false;
	}
	
	public MCGStateImpl element(int index) {
		if (stackSize <= 0) 
			return null;
		else
			return statesArray[index];
	}
	
	public void clear() {
		stackSize = 0;
	}
	
	public int size() {
		return stackSize;
	}
	

}
