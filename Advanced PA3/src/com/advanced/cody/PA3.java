package com.advanced.cody;

import java.util.Scanner;

public class PA3 {

	public static void main(String[] args) {
		
		Scanner console = new Scanner(System.in);
		
		// Create tree
		Tree tree = new Tree();
		
		// Setup the root node
		tree.setRootNode(new TreeNode(5));
		tree.getRootNode().setLeftChild(new TreeNode(2));
		tree.getRootNode().setRightChild(new TreeNode(1));
		
		// First left node 
		TreeNode firstLeftNode = tree.getRootNode().getLeftChild();
		firstLeftNode.setLeftChild(new TreeNode(4));
		firstLeftNode.setRightChild(new TreeNode(6));
		
		// First right node
		TreeNode firstRightNode = tree.getRootNode().getRightChild();
		firstRightNode.setLeftChild(new TreeNode(7));
		firstRightNode.setRightChild(new TreeNode(9));
		
		// Prompt user
		System.out.print("The tree contains the following values (in pre-order traversal):\r\n" + tree.toString() + "\r\n\r\n");
		
		System.out.println("Select the first node: ");
		int aValue = console.nextInt();
		TreeNode aNode = tree.getRootNode().findNode(aValue);
		
		if(aNode == null)
			System.out.println("WARNING: " + aValue + " not found in the tree, common ancestor will not exist.");
		
		System.out.println();
		
		System.out.println("Select the second node: ");
		int bValue = console.nextInt();
		TreeNode bNode = tree.getRootNode().findNode(bValue);
		
		if(aNode == null)
			System.out.println("WARNING: " + aValue + " not found in the tree, common ancestor will not exist.");
		
		// Find the node
		TreeNode ancestor = findCommonAncestor(tree.getRootNode(), aNode, bNode);
		
		System.out.println();
		
		if(ancestor == null)
			System.out.println("No ancestor found.");
		else
			System.out.println("The common ancestor is:\r\n" + ancestor.value);
		
		console.close();
		
	}
	
	public static TreeNode findCommonAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
		
		// Guard against a null root
		if (root == null) 
			return null;
		
		// Is the root node one of our nodes, if so the common ancestor is root
		if (root == node1 || root == node2)
			return root;
		
		// Recursively call findCommonAncestor
		TreeNode left = findCommonAncestor(root.getLeftChild(), node1, node2);
		TreeNode right = findCommonAncestor(root.getRightChild(), node1, node2);
		
		// One of the nodes was not found
		if(left == null && right == null)
			return null;
		
		// Are the nodes on different sides of the tree?
		if (left != null && right != null)
			return root;
		
		// Node must be on one side of the tree or another
		if(left != null)
			return left;
		else
			return right;
		
	}
	
	
	
}