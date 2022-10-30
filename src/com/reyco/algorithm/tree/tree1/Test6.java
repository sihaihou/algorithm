package com.reyco.algorithm.tree.tree1;

/**
 * 判断一棵二叉树是否是满二叉树
 * @author reyco
 *
 */
public class Test6 {
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
		boolean balanceTree = isFullTree(tree);
		System.out.println(balanceTree);
	}
	public static boolean isFullTree(TreeNode tree) {
		Response response = getResponse(tree);
		return response.nodes == response.height*2+1;
	}
	private static Response getResponse(TreeNode tree) {
		if(tree==null) {
			return new Response(0,0);
		}
		Response leftResponse = getResponse(tree.left);
		Response rightResponse = getResponse(tree.right);
		int height = Math.max(leftResponse.height, rightResponse.height)+1;
		int nodes = leftResponse.nodes+rightResponse.nodes+1;
		return new Response(height, nodes);
	}
	
	public static class Response{
		int height;
		int nodes;
		public Response() {
		}
		public Response(int height, int nodes) {
			super();
			this.height = height;
			this.nodes = nodes;
		}
	}
}
