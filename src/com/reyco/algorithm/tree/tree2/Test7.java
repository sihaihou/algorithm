package com.reyco.algorithm.tree.tree2;

import com.reyco.algorithm.tree.TreeNode;

/**
 * 55
 * 求完全二叉树的节点个数。
 * @author reyco
 *
 */
public class Test7 {

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
		int treeNodeNum = treeNodeNum(root);
		System.out.println(treeNodeNum);
	}
	/**
	 * 求完全二叉树的节点个数。
	 * @param root
	 * @return
	 */
	public static int treeNodeNum(TreeNode root) {
		if(root==null) {
			return 0;
		}
		return f(root,1,level(root, 1));
	}
	/**
	 * 
	 * @param root		根节点
	 * @param level		第几层
	 * @param height    高度
	 * @return
	 */
	private static int f(TreeNode root, int level, int height) {
		if(level==height) {
			return 1;
		}
		if(level(root.right, level+1)==height) {
			//左树和当前节点个数  + 右树节点个数
			return (1<<(height-level)) + f(root.right, level+1, height);
		}else {
			//右树和当前节点个数 + 左树节点个数
			return (1<<(height-level-1)) + f(root.left, level+1, height);
		}
	}
	/**
	 * root节点当前层级
	 * @param root		
	 * @param level
	 * @return
	 */
	private static int level(TreeNode root,int level) {
		TreeNode curr = root;
		while(curr!=null) {
			level++;
			curr = curr.left;
		}
		return level-1;
	}
	
}
