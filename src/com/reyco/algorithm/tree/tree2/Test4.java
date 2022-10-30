package com.reyco.algorithm.tree.tree2;

import com.reyco.algorithm.tree.TreeNode;

/**
 * 二叉树每个节点都有一个int类型的权值，从根节点到叶节点的所有路径中，权值和最大的值为多少？
 * @author reyco
 *
 */
public class Test4 {
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
		TreeNode root = new TreeNode(1,tree2,tree3);
		int max1 = max1(root);
		int max2 = max2(root);
		if(max1!=max2) {
			System.out.println("fail");
		}
		System.out.println("max1:"+max1+",max2:"+max2);
	}
	public static int max1(TreeNode root) {
		return process1(root, 0, 0);
	}
	private static int process1(TreeNode root,int max,int pre) {
		if(root==null) {
			return pre;
		}
		int p1 = process1(root.left,max, pre+root.val);
		int p2 = process1(root.right,max,pre+root.val);
		return Math.max(p1, p2);
	}
	public static int max2(TreeNode root) {
		return process2(root);
	}
	private static int process2(TreeNode root) {
		if(root.left==null && root.right==null) {
			return root.val;
		}
		int p1 = Integer.MIN_VALUE;
		int p2 = Integer.MIN_VALUE;
		if(root.left!=null) {
			p1 = process2(root.left);
		}
		if(root.right!=null) {
			p2 = process2(root.right);
		}
		return Math.max(p1, p2)+root.val;
	}
	
}
