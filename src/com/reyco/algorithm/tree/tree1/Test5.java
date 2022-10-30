package com.reyco.algorithm.tree.tree1;

/**
 * 判断一个二叉树是否平衡二叉树
 * 思路:
 * 		1.左孩子是平衡二叉树，并且右孩子是平衡二叉树 
 *      2.左右平衡二叉树的高度差不超过1
 * @author reyco
 *
 */
public class Test5 {
	public static void main(String[] args) {
		/**
		 *       1
		 *    2       3  
		 *  4   5   6   7
		 */
		TreeNode tree6 = new TreeNode(6);
		TreeNode tree7 = new TreeNode(7);
		TreeNode tree3 = new TreeNode(3,tree6,tree7);
		TreeNode tree4 = new TreeNode(4);
		TreeNode tree5 = new TreeNode(5);
		TreeNode tree2 = new TreeNode(2,tree4,tree5);
		TreeNode tree = new TreeNode(1,tree2,tree3);
		boolean balanceTree = isBalanceTree(tree).balanceTree;
		System.out.println(balanceTree);
	}
	public static class Response{
		int height;
		boolean balanceTree;
		public Response() {
		}
		public Response(int height, boolean balanceTree) {
			super();
			this.height = height;
			this.balanceTree = balanceTree;
		}
	}
	public static Response isBalanceTree(TreeNode tree) {
		if(tree==null) {
			return new Response(0,true);
		}
		Response leftResponse = isBalanceTree(tree.left);
		Response rightResponse = isBalanceTree(tree.right);
		int height = Math.max(leftResponse.height, rightResponse.height)+1;
		boolean balanceTree = leftResponse.balanceTree && rightResponse.balanceTree 
				&& Math.abs(leftResponse.height-rightResponse.height)<2;
		return new Response(height,balanceTree);
	}
	public static class TreeNode{
		int value;
		TreeNode left;
		TreeNode right;
		public TreeNode() {
		}
		public TreeNode(int value) {
			super();
			this.value = value;
		}
		public TreeNode(int value, TreeNode left, TreeNode right) {
			super();
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}
}
