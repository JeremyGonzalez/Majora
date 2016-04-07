package com.nevzingtonavenue.knock;

import java.io.*;
import java.net.*;

//for the server side, there will be jokes.java(containing all the jokes and message handling to the client),
//socket_conn.java(containing the code to receive connections from clients and start a new socket for said connection),
//a connected class that will take the received connection and basically drive the jokes.java class...

public class Socket_Conn implements Runnable{

	ServerSocket ss = null;
	private final int PORT = 10404;
	
	public void run(){
		
		try(
			
			ServerSocket ss = new ServerSocket(PORT);
			
		){
			
			//we want to have a runloop which will create new threads that run a new class object to
			//handle the connection once received...
			System.out.println("Server running...");
			while(true){
				Socket socket = ss.accept();
				new Thread(new Driver(socket)).start();
			}
			
		}
		catch(Exception e){}
		finally{
			
			try {
				ss.close();
			}
			catch(IOException e){
				e.printStackTrace();
			}
			
		}
		
	}
	
	
	public static void main(String[] args){
		new Socket_Conn().run();
	}
	
}