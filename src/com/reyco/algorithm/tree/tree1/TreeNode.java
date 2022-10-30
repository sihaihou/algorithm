package com.reyco.algorithm.tree.tree1;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode() {
	}
	public TreeNode(int val) {
		super();
		this.val = val;
	}
	public TreeNode(int val, TreeNode left, TreeNode right) {
		super();
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
