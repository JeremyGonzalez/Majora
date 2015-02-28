package com.nevzington.LinkedList;

public class LinkedList {
	// reference to the head node.
	private Node head;
	private int listCount;
		
	// LinkedList constructor
	public LinkedList(){
		// this is an empty list, so the reference to the head node
		// is set to a new node with no data
		head = new Node(null);
		listCount = 0;
	}
		
	// post: appends the specified element to the end of this list.
	public void add(Object data){
		Node temp = new Node(data);
		Node current = head;
	
		// starting at the head node, crawl to the end of the list
		while(current.getNext() != null){
			current = current.getNext();
		}
		
		// the last node's "next" reference set to our new node
		current.setNext(temp);
		listCount++;// increment the number of elements variable
	}
		
	// post: inserts the specified element at the specified position in this list.
	public void add(Object data, int index){
		Node temp = new Node(data);
		Node current = head.getNext();
		// crawl to the requested index or the last element in the list,
		// whichever comes first
		for(int i = 1; i < index && current.getNext() != null; i++){
			current = current.getNext();
		}
	
		// set the new node's next-node reference to this node's next-node reference
		temp.setNext(current.getNext());
		
		// now set this node's next-node reference to the new node
		current.setNext(temp);
		listCount++;// increment the number of elements variable
	}
		
	// post: returns the element at the specified position in this list.
	public Object get(int index){
		// index must be 1 or higher
		if(index <= 0)
			return null;
			
		Node current = head.getNext();
		for(int i = 1; i < index; i++){
			if(current.getNext() == null)
				return null;
				
			current = current.getNext();
		}
		return current.getData();
	}
		
	// post: removes the element at the specified position in this list.
	public boolean remove(int index){
		// if the index is out of range, exit
		if(index < 1 || index > size())
			return false;
			
		Node prev = head;
		Node current = head.getNext();
		for(int i = 1; i < index; i++){
			if(current.getNext() == null)
				return false;
				
			prev = current;
			current = current.getNext();
		}
		
		if(current == head){
			head = current.getNext();
			return true;
		}
		
		//current.setNext(current.getNext().getNext());
		prev.setNext(current.getNext());
		listCount--; // decrement the number of elements variable
		return true;
	}
	
	public boolean setData(Object data, int index){
		if(index <= 0)
			return false;
			
		Node current = head.getNext();
		for(int i = 1; i < index && current.getNext() != null; i++){
			current = current.getNext();
		}
		
		current.setData(data);
		return true;
	}
		
	// post: returns the number of elements in this list.
	public int size(){
		return listCount;
	}
		
	public String toString(){
		Node current = head.getNext();
		String output = "";
		while(current != null){
			output += "[" + current.getData().toString() + "]";
			current = current.getNext();
		}
		
		return output;
	}
		
	private class Node{
		// reference to the next node in the chain,
		// or null if there isn't one.
		Node next;
	
		// data carried by this node.
		// could be of any type you need.
		Object data;
			

		// Node constructor
		public Node(Object _data){
			next = null;
			data = _data;
		}
		
		/*
		// another Node constructor if we want to
		// specify the node to point to.
		public Node(Object _data, Node _next){
			next = _next;
			data = _data;
		}
		*/
			
		// these methods should be self-explanatory
		public Object getData(){
			return data;
		}
		
		public void setData(Object _data){
			data = _data;
		}
					
		public Node getNext(){
			return next;
		}
		
		public void setNext(Node _next){
			next = _next;
		}
	}
}