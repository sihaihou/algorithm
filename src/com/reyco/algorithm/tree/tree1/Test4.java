package com.reyco.algorithm.tree.tree1;

import java.util.LinkedList;
import java.util.Queue;

import com.reyco.algorithm.tree.TreeNode;

/**
 * 只有叶子节点可以不是全的,如果一个叶子节点的只能在左边.
 * 如何判断一棵二叉树是完全二叉树
 * 思路：按二叉树的宽度优先遍历
 *    条件1：任意一节点，有右无左为false
 *    条件2：在条件1满足的情况下，如果遇到了第一个左右不全，那么后续全部为叶子节点
 *     
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
		TreeNode tree = new TreeNode(1,tree2,tree3);
		Boolean completeTree = isCompleteTree(tree);
		System.out.println(completeTree);
	}
	/**
	 * 是否完全二叉树
	 * @return
	 */
	public static Boolean isCompleteTree(TreeNode tree) {
		if(tree==null) {
			return true;
		}
		Queue<TreeNode> treeQueue = new LinkedList<>(); 
		treeQueue.add(tree);
		//是否遇到过左右不爽全的节点
		Boolean leaf=false;
		TreeNode left=null;
		TreeNode right=null;
		while(!treeQueue.isEmpty()) {
			TreeNode curr = treeQueue.poll();
			System.out.print(curr.val+" ");
			left = curr.left;
			right = curr.right;
			//如果遇到了不双全的节点之后，又发现当前节点不是叶子节点
			if((leaf && (left!=null || right!=null)) 
					|| (left==null && right!=null)) {
				return false;
			}
			if(left!=null) {
				treeQueue.add(left);
			}
			if(right!=null) {
				treeQueue.add(right);
			}
			if(left==null || right==null) {
				leaf = true;
			}
		}
		return true;
	}
}
