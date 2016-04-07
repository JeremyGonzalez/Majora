package com.nevzingtonavenue.knock;

import java.io.*;
import java.net.*;

public class Driver implements Runnable{

	Socket s = null;
	String line = null;
	Jokes pikachu = null;
	
	Driver(Socket s){
		this.s = s;
	}
	
	public void run(){
		
		try(
			
			PrintWriter out = new PrintWriter(s.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		){
			
			pikachu = new Jokes();
			System.err.println("Resources opened correctly.");
			out.println("Welcome! Are you ready to begin? (y/n)");
			while((line = in.readLine()) != null){
				if(line == null){
					out.println("You are supposed to respond silly");
					continue;
				}
				
				if(line.equalsIgnoreCase("n")){
					out.println("bye");
					break;
				}
				
				if(line.equalsIgnoreCase("y")){
					out.println(pikachu.output());
					continue;
				}
				
				if(pikachu.state == 1){
					if(line.equalsIgnoreCase("who is there?") || line.equalsIgnoreCase("who is there") || line.equalsIgnoreCase("whos there?") || line.equalsIgnoreCase("whos there")){
						out.println(pikachu.output());
						continue;
					}
					out.println("You are supposed to ask \"who is there?\" silly panda");
					continue;
				}
				
				if(pikachu.state == 2){
					if(line.equalsIgnoreCase("who") || line.equalsIgnoreCase("who?")){
						out.println(pikachu.output());
						pikachu.reset();
						continue;
					}
					out.println("You are supposed to ask \"who?\" silly mexican jew pirate");
				}
			}
			
			out.close();
			in.close();
			
		}
		catch(Exception e){
			System.err.println(e.getCause());
		}
		finally{
			try{ s.close(); }
			catch(Exception e){
				System.err.println(e.getMessage());
			}
		}
		
	}
	
}