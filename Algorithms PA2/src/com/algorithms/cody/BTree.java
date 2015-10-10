package com.algorithms.cody;

public class BTree {
	
	public Node root;
	private int size = 0;
	
	public BTree() {
		
		this.root = null;
		
	}
	
	public int size() {
		return size;
	}
	
	public Word find(Word data){
		
		Node current = root;
		
		while(current != null) {
			
			if(current.data.compareTo(data) == 0) {
				
				return current.data;
				
				
			} else if(current.data.compareTo(data) > 0) {
				
				current = current.left;
				
			} else {
				
				current = current.right;
				
			}
			
		}
		
		return null;
		
	}

	public void insert(Word data) {
		
		Node newNode = new Node(data);
		
		if(root == null) {
			
			root = newNode;
			++size;
			return;
		}
		
		Node current = root;
		
		Node parent = null;
		
		while(true) {
			
			parent = current;
			
			if(data.compareTo(current.data) < 0) {
				
				current = current.left;
				
				if(current == null) {
					
					parent.left = newNode;
					++size;
					return;
					
				}
				
			} else {
				
				current = current.right;
				
				if(current == null) {
					
					parent.right = newNode;
					++size;
					return;
					
				}
				
			}
			
		}
		
	}
	
}

class Node{
	
	Word data;
	Node left;
	Node right;
	
	public Node(Word data) {
		this.data = data;
		left = null;
		right = null;
	}
	
}