package com.reyco.algorithm.tree;

/**
 * 43
 * Morris遍历树
 *      1,如果curr没有左子树，curr向右移动，
 *      2，如果有左子树，找到左子树上最右的节点mostRight
 *      	a.如果mostRight的右指针为空，让其指向curr,然后curr向左移动。
 *          b.如果mostRight的右指针向curr，让其指向空，然后curr向右移动。
 *      3,curr为null时遍历结束
 * @author reyco
 *
 */
public class MorrisTree {
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
		Boolean morrisSearchTree = morrisSearchTree(root);
		System.out.println(morrisSearchTree);
	}
	/**
	 * morris遍历
	 * @param root
	 */
	public static void morrisTree(TreeNode root) {
		TreeNode curr = root;
		TreeNode morrisTree = null;
		while(curr!=null) {
			morrisTree = curr.left;
			if(morrisTree!=null) {
				while(morrisTree.right!=null && morrisTree.right!=curr) {
					morrisTree = morrisTree.right;
				}
				if(morrisTree.right==null) {
					morrisTree.right = curr;
					curr = curr.left;
					continue;
				}else {
					morrisTree.right = null;
				}
			}
			curr = curr.right;
		}
	}
	/**
	 * 先序
	 * @param root
	 */
	public static void morrisTreePre(TreeNode root) {
		TreeNode curr = root;
		TreeNode morrisTree = null;
		while(curr!=null) {
			morrisTree = curr.left;
			if(morrisTree!=null) {
				while(morrisTree.right!=null && morrisTree.right!=curr) {
					morrisTree = morrisTree.right;
				}
				if(morrisTree.right==null) {
					System.out.println(curr.val);
					morrisTree.right = curr;
					curr = curr.left;
					continue;
				}else {
					morrisTree.right = null;
				}
			}else {
				System.out.println(curr.val);
			}
			curr = curr.right;
		}
	}
	/**
	 * 中序
	 * @param root
	 */
	public static void morrisTreeMid(TreeNode root) {
		TreeNode curr = root;
		TreeNode morrisTree = null;
		while(curr!=null) {
			morrisTree = curr.left;
			if(morrisTree!=null) {
				while(morrisTree.right!=null && morrisTree.right!=curr) {
					morrisTree = morrisTree.right;
				}
				if(morrisTree.right==null) {
					morrisTree.right = curr;
					curr = curr.left;
					continue;
				}else {
					morrisTree.right = null;
				}
			}
			System.out.println(curr.val);
			curr = curr.right;
		}
	}
	/**
	 * 后序
	 * @param root
	 */
	public static void morrisTreePos(TreeNode root) {
		TreeNode curr = root;
		TreeNode morrisTree = null;
		while(curr!=null) {
			morrisTree = curr.left;
			if(morrisTree!=null) {
				while(morrisTree.right!=null && morrisTree.right!=curr) {
					morrisTree = morrisTree.right;
				}
				if(morrisTree.right==null) {
					morrisTree.right = curr;
					curr = curr.left;
					continue;
				}else {
					morrisTree.right = null;
					TreeNode curr1 = reversalTree(curr.left);
					while(curr1!=null) {
						System.out.println(curr1.val);
						curr1 = curr1.right;
					}
				}
			}
			curr = curr.right;
		}
		TreeNode curr1 = reversalTree(root);
		while(curr1!=null) {
			System.out.println(curr1.val);
			curr1 = curr1.right;
		}
	}
	
	/**
	 * 是否是搜索二叉树
	 * @param root
	 */
	public static Boolean morrisSearchTree(TreeNode root) {
		TreeNode curr = root;
		TreeNode morrisTree = null;
		int prevValue = Integer.MIN_VALUE;
		while(curr!=null) {
			morrisTree = curr.left;
			if(morrisTree!=null) {
				while(morrisTree.right!=null && morrisTree.right!=curr) {
					morrisTree = morrisTree.right;
				}
				if(morrisTree.right==null) {
					morrisTree.right = curr;
					curr = curr.left;
					continue;
				}else {
					morrisTree.right = null;
				}
			}
			if(curr.val>=prevValue) {
				return false;
			}
			prevValue = curr.val;
			curr = curr.right;
		}
		return true;
	}
	
	private static TreeNode reversalTree(TreeNode root) {
		TreeNode prev = null;
		TreeNode curr = root;
		while(curr!=null) {
			TreeNode next = curr.right;
			curr.right = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}
}
