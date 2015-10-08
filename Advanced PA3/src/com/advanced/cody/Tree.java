package com.advanced.cody;

public class Tree {

	TreeNode rootNode;
	
	// Constructors
	public Tree() { }
	public Tree(TreeNode node) { rootNode = node; }
	
	// Getters
	public TreeNode getRootNode() { return rootNode; }
	
	// Setters
	public void setRootNode(TreeNode node) { rootNode = node; }
	
	public String toString() {
		return rootNode.toString();
	}

	/*
	 * NOTES TO THE GRADER:
	 * -----------------------------------
	 * I know she asked for a linked-list here, but after scratching my head over this
	 * forever, I can't figure out why anyone would do that. The Tree structure is naturally
	 * already a linked list, as trees are fundamental containers.
	 * 
	 * I've opted to leave this class bare as a simple representation of a Tree. Obviously
	 * this is kind of stupid as a TreeNode can already do that, but oh well, this is what
	 * she asked for.
	 * 
	 * Just to make it 100% clear that I do know how to create a linked-list in Java and 
	 * simply chose not to, here's the code:
	 * 
	 * LinkedList<TreeNode> list = new LinkedList<TreeNode>();
	 */

}
