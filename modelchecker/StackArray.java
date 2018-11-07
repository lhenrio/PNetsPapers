package fr.inria.oasis.vercors.vce.openpnets.modelchecker;

public interface StackArray {

	/**
	 * push a mcgState into stack
	 * @param mcgState
	 */
	public void push(MCGState mcgState);
	
	/**
	 * pop the current state of the stack
	 * @return
	 */
	public MCGState pop();
	
	/**
	 * get the top state of the stack
	 * @return
	 */
	public MCGState top();
	
	/**
	 * check if the stack is empty.
	 * @return
	 */
	public boolean empty();
	
	/**
	 * get a state with index in stack
	 * @param index
	 * @return
	 */
	public MCGState element(int index);
	
	/**
	 * get the size of the stack
	 * @return
	 */
	public int size();
	
}
