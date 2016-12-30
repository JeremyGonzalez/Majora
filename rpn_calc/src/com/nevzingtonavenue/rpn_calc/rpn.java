package com.nevzingtonavenue.rpn_calc;

public class rpn {
	
	private int counter; // counter to determine what index within the stack we currently are.
	private int[] stk0;
	private char[] stk1;
	
	private void pushop(char op){
		stk1[counter] = op;
		counter++;
	}
	
	private void push(int val){
		stk0[counter] = val;
		counter++;
	}
	
	private int pop(){
		counter--;
		return stk0[counter+1];
	}
	
	private char popop(){
		counter--;
		return stk1[counter+1];
	}
	
	public void operation(String a){
		
		for(int x = 0; x < a.length(); x+=2){
			if(a.charAt(x) == '+' || a.charAt(x) == '-' || a.charAt(x) == '*' || a.charAt(x) == '/'){
				pushop(a.charAt(x));
			}else{
				push(Character.getNumericValue(a.charAt(x)));
			}
		}
		
		for(int x = counter; x > 0; x--){
			char op = popop();
			if(op == '+'){
				add();
			}else if(op == '-'){
				minus();
			}else if(op == '*'){
				multi();
			}else if(op == '/'){
				divide();
			}
		}
		System.out.println();
		System.out.println(pop());
		
	}
	
	// operation() shall invoke appropriate method listed below.
	// These methods shall merely perform the maths op required.
	private void add(){
		int a,b;
		b = pop();
		a = pop();
		
		push(a+b);
	}
	
	private void minus(){
		int a,b;
		b = pop();
		a = pop();
		
		push(a-b);
	}
	
	private void multi(){
		int a,b;
		b = pop();
		a = pop();
		
		push(a*b);
	}
	private void divide(){
		int a,b;
		b = pop();
		a = pop();
		
		push(a/b);
	}
	
	
	public rpn(){
		counter = 0;
		stk0 = new int[15];
		stk1 = new char[15];
	}

}
