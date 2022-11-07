package com.reyco.algorithm.tree.tree3;

import java.util.LinkedList;
import java.util.Queue;

import com.reyco.algorithm.tree.TreeNode;

/**
 * 二叉树的序列化与反序列化
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
		TreeNode root = new TreeNode(1,tree2,tree3);
		preOrder(root);
		System.out.println();
		String serialByPre = encodTreeNodePre(root);
		System.out.println("序列化："+serialByPre);
		TreeNode treeNode = decodeTreeNodePre(serialByPre);
		preOrder(treeNode);
	}
	/**
	 * 先序
	 * @param node
	 * @return
	 */
	public static void preOrder(TreeNode tree) {
		if(tree==null) {
			return;
		}
		System.out.print(tree.val+" ");
		if(tree.left!=null) {
			preOrder(tree.left);
		}
		if(tree.right!=null) {
			preOrder(tree.right);
		}
	}
	/**
	 * 先序序列化
	 * @param root
	 * @return
	 */
	public static String encodTreeNodePre(TreeNode root) {
		if(root==null) {
			return "#,";
		}
		String res = root.val+",";
		res += encodTreeNodePre(root.left);
		res += encodTreeNodePre(root.right);
		return res;
	}
	/**
	 * 先序反序列化
	 * @param root
	 * @return
	 */
	public static TreeNode decodeTreeNodePre(String s) {
		String[] treeNodeArray = s.split(",");
		Queue<String> queue = new LinkedList<String>();
		for (int i = 0; i < treeNodeArray.length; i++) {
			queue.add(treeNodeArray[i]);
		}
		return decodeTreeNodePre(queue);
	}
	private static TreeNode decodeTreeNodePre(Queue<String> queue) {
		String node = queue.poll();
		if(node.equals("#")) {
			return null;
		}
		TreeNode root = new TreeNode(Integer.parseInt(node));
		root.left = decodeTreeNodePre(queue);
		root.right = decodeTreeNodePre(queue);
		return root;
	}
}
