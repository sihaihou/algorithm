package com.reyco.algorithm.tree1;

import java.util.Stack;

/**
 * 搜索二叉树(left>parent && parent<right)
 * 判断一棵二叉树是搜索二叉树
 * 思路：使用中序优先遍历
 * @author reyco
 *
 */
public class Test3 {
	private static int preTreeValue =  Integer.MIN_VALUE;
	public static void main(String[] args) {
		/**
		 *        4
		 *    2       6  
		 *  1   3   5   7
		 */
		TreeNode tree1 = new TreeNode(1);
		TreeNode tree3 = new TreeNode(3);
		TreeNode tree5 = new TreeNode(5);
		TreeNode tree7 = new TreeNode(7);
		TreeNode tree2 = new TreeNode(2,tree1,tree3);
		TreeNode tree6 = new TreeNode(6,tree5,tree7);
		TreeNode root = new TreeNode(4,tree2,tree6);
		//中序
		System.out.print("isBST:");
		Boolean isBST = isBST(root);
		System.out.println(isBST);
		
		System.out.println();
		preTreeValue = Integer.MIN_VALUE;
		
		System.out.print("isBSTStack:");
		Boolean bstStack = isBSTStack(root);
		System.out.println(bstStack);
		
		System.out.println();
	}
	/**
	 * 中序
	 * @param tree
	 * @return
	 */
	public static Boolean isBST(TreeNode tree) {
		if(tree==null) {
			return true;
		}
		Boolean left = isBST(tree.left);
		if(!left) {
			return false;
		}
		if(tree.val<preTreeValue) {
			return false;
		}
		Boolean right = isBST(tree.right);
		if(!right) {
			return false;
		}
		preTreeValue = tree.val;
		return true;
	}
	/**
	 * 中序
	 * @param tree
	 * @return
	 */
	public static Boolean isBSTStack(TreeNode tree) {
		if(tree!=null) {
			Stack<TreeNode> stock = new Stack<>();
			while(!stock.isEmpty() || tree!=null) {
				if(tree!=null) {
					stock.push(tree);
					tree = tree.left;
				}else {
					TreeNode t = stock.pop();
					if(t.val<preTreeValue) {
						return false;
					}
					preTreeValue = t.val;
					tree = t.right;
				}
			}
		}
		return true;
	}
}
