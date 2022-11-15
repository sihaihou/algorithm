package com.reyco.algorithm.tree.tree1;

import com.reyco.algorithm.tree.TreeNode;

/**
 * 43
 * 求二叉树的最大距离
 * @author reyco
 *
 */
public class Test9 {
	public static void main(String[] args) {
		/**
		 *        1
		 *    2       3  
		 *  4   5   6   7
		 */
		TreeNode tree6 = new TreeNode(6);
		TreeNode tree7 = new TreeNode(7);
		TreeNode tree3 = new TreeNode(3,tree6,tree7);
		TreeNode tree4 = new TreeNode(4);
		TreeNode tree5 = new TreeNode(5);
		TreeNode tree2 = new TreeNode(2,tree4,tree5);
		TreeNode root = new TreeNode(1,tree2,tree3);
		int maxDistance = maxDistance(root);
		System.out.println(maxDistance);
	}
	public static int maxDistance(TreeNode root) {
		int maxDistance = process(root).maxDistance;
		return maxDistance;
	}
	public static Response process(TreeNode root) {
		if(root==null) {
			return new Response(0,0);
		}
		Response left = process(root.left);
		Response right = process(root.right);
		int maxDistanceLeft = left.maxDistance;
		int maxDistanceRight = right.maxDistance;
		int maxHeight = left.maxHeight+1+right.maxHeight;
		int maxDistance = Math.max(maxHeight, Math.max(maxDistanceLeft, maxDistanceRight));
		int height = Math.max(left.maxHeight, right.maxHeight)+1;
		return new Response(maxDistance,height);
	}
	public static class Response{
		//最大距离
		int maxDistance;
		//最大高度
		int maxHeight;
		public Response() {
		}
		public Response(int maxDistance, int maxHeight) {
			super();
			this.maxDistance = maxDistance;
			this.maxHeight = maxHeight;
		}
	}
}
