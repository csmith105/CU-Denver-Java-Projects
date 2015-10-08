package com.advanced.cody;

public class TreeNode {
	
	int value;
	
	TreeNode leftChild, rightChild;

	// Constructor
	public TreeNode(int value) { this.value = value; }
	
	// Getters
	public int getValue() { return value; }
	public TreeNode getLeftChild() { return leftChild; }
	public TreeNode getRightChild() { return rightChild; }
	
	// Setters
	public void setLeftChild(TreeNode leftChild) { this.leftChild = leftChild; }
	public void setRightChild(TreeNode rightChild) { this.rightChild = rightChild; }
	
	public TreeNode findNode(int value) {
		
		TreeNode left = null, right = null;
		
		if(this.value == value)
			return this;
		
		if(leftChild != null)
			left = leftChild.findNode(value);
		
		if(left != null)
			return left;
		
		if(rightChild != null)
			right = rightChild.findNode(value);
		
		if(right != null)
			return right;
		
		return null;
		
	}
	
	// @override toString
	public String toString() {
		
		if(leftChild != null && rightChild != null)
			return value + " " + leftChild.toString() + " " + rightChild.toString();
		
		if(leftChild != null)
			return value + " " + leftChild.toString() + " ";
		
		if(rightChild != null)
			return value + " " + rightChild.toString() + " ";
		
		return Integer.toString(value);
	}

}
