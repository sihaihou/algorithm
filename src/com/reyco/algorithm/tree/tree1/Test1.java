package com.reyco.algorithm.tree.tree1;

import java.util.Stack;

import com.reyco.algorithm.tree.TreeNode;

/**
 * 二叉树的前中后遍历
 * @author reyco
 *
 */
public class Test1 {
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
		//先序
		System.out.print("preOrder:");
		preOrder(root);
		System.out.println();
		System.out.print("preOrderStack:");
		preOrderStack(root);
		
		System.out.println();
		
		//中序
		System.out.print("middleOrder:");
		middleOrder(root);
		System.out.println();
		System.out.print("middleOrderStack:");
		middleOrderStack(root);
		
		System.out.println();
		
		//后续
		System.out.print("posOrder:");
		posOrder(root);
		System.out.println();
		System.out.print("posOrderStack:");
		posOrderStack(root);
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
	 * 先序
	 * @param node
	 * @return
	 */
	public static void preOrderStack(TreeNode tree) {
		if(tree!=null) {
			Stack<TreeNode> stock = new Stack<>();
			stock.push(tree);
			while(!stock.isEmpty()) {
				TreeNode t = stock.pop();
				System.out.print(t.val+" ");
				if(t.right!=null) {
					stock.push(t.right);
				}
				if(t.left!=null) {
					stock.push(t.left);
				}
			}
		}
	}
	/**
	 * 中序
	 * @param tree
	 * @return
	 */
	public static void middleOrder(TreeNode tree) {
		if(tree==null) {
			return;
		}
		if(tree.left!=null) {
			middleOrder(tree.left);
		}
		System.out.print(tree.val+" ");
		if(tree.right!=null) {
			middleOrder(tree.right);
		}
	}
	/**
	 * 中序
	 * @param tree
	 * @return
	 */
	public static void middleOrderStack(TreeNode tree) {
		if(tree!=null) {
			Stack<TreeNode> stock = new Stack<>();
			while(!stock.isEmpty() || tree!=null) {
				if(tree!=null) {
					stock.push(tree);
					tree = tree.left;
				}else {
					TreeNode t = stock.pop();
					System.out.print(t.val+" ");
					tree = t.right;
				}
			}
		}
	}
	/**
	 * 后序
	 * @param tree
	 * @return
	 */
	public static void posOrder(TreeNode tree) {
		if(tree==null) {
			return;
		}
		if(tree.left!=null) {
			posOrder(tree.left);
		}
		if(tree.right!=null) {
			posOrder(tree.right);
		}
		System.out.print(tree.val+" ");
	}
	/**
	 * 后序
	 * @param tree
	 * @return
	 */
	public static void posOrderStack(TreeNode tree) {
		if(tree!=null) {
			Stack<TreeNode> stock1 = new Stack<>();
			Stack<TreeNode> stock2 = new Stack<>();
			stock1.push(tree);
			while(!stock1.isEmpty()) {
				TreeNode t = stock1.pop();
				stock2.push(t);
				if(t.left!=null) {
					stock1.push(t.left);
				}
				if(t.right!=null) {
					stock1.push(t.right);
				}
			}
			while(!stock2.isEmpty()) {
				TreeNode t = stock2.pop();
				System.out.print(t.val+" ");
			}
		}
	}
}
