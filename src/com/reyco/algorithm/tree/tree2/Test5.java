package com.reyco.algorithm.tree.tree2;

import com.reyco.algorithm.tree.TreeNode;

/**
 * 搜索二叉树转双向链表
 * 答：左树的last连向头节点的first，头节点的first连向左节点last;右树的first连向头节点的last，头节点的last连向右节点first;
 * @author reyco
 *
 */
public class Test5 {
	
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
		//
		LinkNode treeToLink = TreeToLink(root);
		TreeNode curr = treeToLink.first;
		while(curr!=null) {
			System.out.println(curr.val);
			curr = curr.right;
		}
	}
	
	
	public static LinkNode TreeToLink(TreeNode root) {
		if(root==null) {
			return new LinkNode(null,null);
		}
		LinkNode left = TreeToLink(root.left);
		LinkNode right = TreeToLink(root.right);
		if(left.last!=null) {
			left.last.right = root;
		}
		root.left = left.last;
		root.right = right.first;
		if(right.first!=null) {
			right.first.left=root;
		}
		return new LinkNode(left.first!=null ? left.first : root, 
				right.last!=null ? right.last : root);
	}
	/**
	 * 双向链表
	 * @author reyco
	 *
	 */
	public static class LinkNode{
		public TreeNode first;
		public TreeNode last;
		public LinkNode(TreeNode first, TreeNode last) {
			super();
			this.first = first;
			this.last = last;
		}
	}
}
