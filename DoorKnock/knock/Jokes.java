package com.nevzingtonavenue.knock;

import java.util.Random;

public class Jokes {

	private static final int PREQUESTION = 0,
							 POSTQUESTION = 1,
							 JOKE = 2;
	
	public int state = PREQUESTION; //keeps track of which part of the joke to feed the user next
	public int question_num = 0; //determines which question of the set to use
	Random rand = new Random();
	
	private String[] question = {"Canoe", 
								 "Merry",
								 "Orange"};
	private String[] ans = {"Canoe help me with my homework? Contine? (y/n)",
							"Merry Christmas! Contine? (y/n)",
							"Orange you going to let me in? Contine? (y/n)"};
							 
	
	public void rng(){
		question_num = rand.nextInt(3);
	}
	
	
	public void reset(){
		state = PREQUESTION;
		rng();
	}
	
	
	public void setQuestonNum(int num){
		question_num = num;		
	}
	
	
	public String output(){
		
		if(state == PREQUESTION){
			state = POSTQUESTION;
			return "Knock Knock mutherfucka";
		}
		
		if(state == POSTQUESTION){
			state = JOKE;
			return question[question_num];
		}
		
		if(state == JOKE){
			return ans[question_num];
		}
		
		return "Error!!!";
		
	}
	
}