package com.nevzingtonavenue.rpn_calc;

import java.util.Scanner;

public class Driver {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		System.out.println("Please entre the entire maths equation seperated each by a space.");
		rpn cal = new rpn();
		cal.operation(in.nextLine());
		
		cal = null;
		in.close();
		
	}

}
