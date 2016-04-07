package com.nevzingtonavenue.knockclient;

import java.io.*;
import java.net.*;

public class Knock_Client implements Runnable{

	private String str = null;
	
	public void run(){
		
		try{
			InetAddress addr = InetAddress.getByName("127.0.0.1");
			Socket s = new Socket(addr, 10404);
			PrintWriter out = new PrintWriter(s.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
			
			while((str = in.readLine()) != null){
				if(str.equalsIgnoreCase("bye")){
					System.out.println("Server says: bye");
					break;
				}
				
				System.out.println(str);
				
				while((str = stdin.readLine()) != null){
					if(str == null || str.isEmpty())
						continue;
					out.println(str);
					break;
				}
			}
			
			s.close();
			out.close();
			in.close();
			stdin.close();
		}
		catch(Exception e){
			System.err.println("Error setting up socket connection...");
		}
		
	}
	
	
	public static void main(String[] args){
		new Knock_Client().run();
	}
	
}