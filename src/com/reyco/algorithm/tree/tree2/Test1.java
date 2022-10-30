package com.reyco.algorithm.tree.tree2;

import com.reyco.algorithm.tree.TreeNode;

/**
 * 求二叉树的最大搜索子树？
 * 
 * @author reyco
 *
 */
public class Test1 {
	
	public static void main(String[] args) {
		/**
		 *       1
		 *    4       3  
		 *  2   5   6   7
		 */
		TreeNode tree6 = new TreeNode(6);
		TreeNode tree7 = new TreeNode(7);
		TreeNode tree3 = new TreeNode(3,tree6,tree7);
		TreeNode tree2 = new TreeNode(2);
		TreeNode tree5 = new TreeNode(5);
		TreeNode tree4 = new TreeNode(4,tree2,tree5);
		TreeNode root = new TreeNode(1,tree4,tree3);
		int maxSearchTree = maxSearchTree(root);
		System.out.println(maxSearchTree);
	}
	public static int maxSearchTree(TreeNode root) {
		return process(root).maxSubSearchTreeSize;
	}
	/**
	 * 
	 * @param root
	 * @return
	 */
	public static Response process(TreeNode root) {
		if(root==null) {
			return null;
		}
		Response left = process(root.left);
		Response right = process(root.right);
		
		int maxSubSearchTreeSize = 0;
		int max = root.val;
		int min = root.val;
		if(left!=null) {
			maxSubSearchTreeSize = left.maxSubSearchTreeSize;
			max = Math.max(max,left.max);
			min = Math.min(min,left.min);
		}
		if(right!=null) {
			maxSubSearchTreeSize = Math.max(maxSubSearchTreeSize, right.maxSubSearchTreeSize);
			max = Math.max(max,right.max);
			min = Math.min(min,right.min);
		}
		boolean isAllSearchTree = false;
		if((left==null ? true : left.isAllSearchTree)//左树是搜索二叉树
				&& (right==null ? true : right.isAllSearchTree)//右树是搜索二叉树
				&& (left==null ? true : root.val > left.max)//左树最大值小于等于当前节点的值
				&& (right==null ? true : root.val < right.min)//右树最小值大于等于当前节点的值
				) {
			maxSubSearchTreeSize = 
					(left==null ? 0 : left.maxSubSearchTreeSize)
					+
					(left==null ? 0 : right.maxSubSearchTreeSize)
					+
					1;
			isAllSearchTree = true;
		}
		return new Response(maxSubSearchTreeSize, isAllSearchTree, max, min);
	}

	public static class Response {
		// 最大搜索二叉树的大小
		int maxSubSearchTreeSize;
		// 是否是搜索二叉树
		boolean isAllSearchTree;
		// 左树的最大值；
		int max;
		// 右树的最小值
		int min;

		public Response(int maxSubSearchTreeSize, boolean isAllSearchTree, int max, int min) {
			super();
			this.maxSubSearchTreeSize = maxSubSearchTreeSize;
			this.isAllSearchTree = isAllSearchTree;
			this.max = max;
			this.min = min;
		}
	}
}
