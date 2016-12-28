package com.nevzingtonavenue.rpn_calc;

public class rpn {
	
	private int[] stk; // stack used to hold operands.
	
	public void push(int val){} // pushes an int onto the stack.
	
	public int pop(){return 0;} // pops off an int for various uses.
	
	public void operation(String a){
		// Determine what op will be performed via the string input.
		// Pop off the previous 2 int and perform specified op.
		// Push result back on stk.
	}
	
	// operation() shall invoke appropriate method listed below.
	// These methods shall merely perform the maths op required.
	private void add(){}
	private void minus(){}
	private void multi(){}
	private void divide(){}

}
