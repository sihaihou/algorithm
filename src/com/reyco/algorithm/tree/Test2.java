package com.reyco.algorithm.tree1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 1.按照二叉树的宽度优先遍历
 * 2.求一棵二叉树的宽度
 * 2.求一棵二叉树的深度
 * @author reyco
 *
 */
public class Test2 {
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
		
		widthTraversal(tree);
		//获取一个二叉树的最大宽度
		int maxWidth = getMaxWidth(tree);
		System.out.println();
		System.out.print("二叉树的最大宽度：");
		System.out.println(maxWidth);
		
		//获取二叉树的最大深度
		int maxheight = getMaxHeight(tree);
		System.out.println("二叉树的最大深度："+maxheight);
		
	}
	/**
	 * 获取一个二叉树的最大宽度
	 * 思路:按照二叉树的宽度优先遍历
	 * @param tree
	 * @return
	 */
	public static int getMaxWidth(TreeNode root) {
		if(root==null) {
			return 0;
		}
		if(root.left==null && root.right==null) {
			return 1;
		}
		Queue<TreeNode> treeQueue = new LinkedList<>(); 
		treeQueue.add(root);
		TreeNode currEnd = root; //当前层最右节点
		TreeNode nextEnd = null; //下一层，最右节点
		//当前层有多少个节点
		int currLevelNotes = 0;
		//最大节点数
		int maxLevelNotes = 0;
		while(!treeQueue.isEmpty()) {
			TreeNode curr = treeQueue.poll();
			if(curr.left!=null) {
				treeQueue.add(curr.left);
				nextEnd = curr.left;
			}
			if(curr.right!=null) {
				treeQueue.add(curr.right);
				nextEnd = curr.right;
			}
			currLevelNotes++;
			if(curr==currEnd) {
				maxLevelNotes = Math.max(currLevelNotes, maxLevelNotes);
				currLevelNotes = 0;
				currEnd = nextEnd;
			}
		}
		return maxLevelNotes;
	}
	/**
	 * 获取一个二叉树的最大宽度
	 * 思路:按照二叉树的宽度优先遍历+hash表
	 * @param tree
	 * @return
	 */
	public static int getMaxWidth1(TreeNode tree) {
		if(tree==null) {
			return 0;
		}
		if(tree.left==null && tree.right==null) {
			return 1;
		}
		Map<TreeNode,Integer> levelMap = new HashMap<>();
		levelMap.put(tree, 1);
		Queue<TreeNode> treeQueue = new LinkedList<>(); 
		treeQueue.add(tree);
		//第几层
		int currlevel = 1;
		//当前层有多少个节点
		int levelNotes = 0;
		//最大节点数
		int maxLevelNotes = Integer.MIN_VALUE;
		while(!treeQueue.isEmpty()) {
			TreeNode t = treeQueue.poll();
			int level = levelMap.get(t);
			if(currlevel==level) {
				levelNotes++;
			}else {
				maxLevelNotes = Math.max(maxLevelNotes, levelNotes);
				currlevel=level;
				levelNotes=1;
			}
			if(t.left!=null) {
				treeQueue.add(t.left);
				levelMap.put(t.left, currlevel+1);
			}
			if(t.right!=null) {
				treeQueue.add(t.right);
				levelMap.put(t.right, currlevel+1);
			}
		}
		return levelNotes;
	}
	/**
	 * 获取二叉树的最大深度
	 * @param tree
	 * @return
	 */
	public static int getMaxHeight(TreeNode tree) {
		if(tree==null) {
			return 0;
		}
		int leftheight = getMaxHeight(tree.left);
		int rightHeight = getMaxHeight(tree.right);
		return Math.max(leftheight, rightHeight)+1;
	}
	/**
	 * 按照二叉树的宽度优先遍历
	 * @param tree
	 * @return
	 */
	public static void widthTraversal(TreeNode tree) {
		if(tree==null) {
			return;
		}
		Queue<TreeNode> treeQueue = new LinkedList<>(); 
		treeQueue.add(tree);
		while(!treeQueue.isEmpty()) {
			TreeNode t = treeQueue.poll();
			System.out.print(t.val+" ");
			if(t.left!=null) {
				treeQueue.add(t.left);
			}
			if(t.right!=null) {
				treeQueue.add(t.right);
			}
		}
	}
}
