package com.reyco.algorithm.tree;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * 搜索二叉树--AVL
 * 
 * @author reyco
 * @param <E>
 *
 */
public class SearchBinaryTree<E> {
	
	public static void main(String[] args) {
		SearchBinaryTree<Object> searchBinaryTree = new SearchBinaryTree<>();
		Set<Integer> set = new HashSet<>();
		for(int i=0;i<100;i++) {
			int curr = 0;
			while(!set.add(curr)) {
				curr = new Random().nextInt(100);
			}
			try {
				searchBinaryTree.add(curr);
			} catch (Exception e) {
				System.out.println(curr);
				e.printStackTrace();
			}
		}
		process(searchBinaryTree.root);
	}
	public static void process(TreeNode root) {
		if(root==null) {
			return;
		}
		System.out.println(root.value);
		process(root.left);
		process(root.right);
	}
	
	
	
	private TreeNode root;
	public SearchBinaryTree() {
		// TODO Auto-generated constructor stub
	}
	public SearchBinaryTree(int value) {
		root = new TreeNode(value);
	}
	
	public SearchBinaryTree(TreeNode root) {
		super();
		this.root = root;
	}
	/**
	 * 查询
	 * 
	 * @param root
	 * @param value
	 * @return
	 */
	public TreeNode search(int value) {
		return processSearch(root, value);
	}
	private static TreeNode processSearch(TreeNode root, int value) {
		if (root == null) {
			return null;
		}
		if (root.value==value) {
			return root;
		}
		if (value > root.value) {
			return processSearch(root.right, value);
		}
		return processSearch(root.left, value);
	}

	/**
	 * 新增
	 * @param root
	 * @param value
	 */
	public void add(int value) {
		processInsert(root, value);
	}

	private void processInsert(TreeNode root, int value) {
		TreeNode newTreeNode = new TreeNode(value);
		if (root == null) {
			root = newTreeNode;
			this.root =root;
		} else {
			TreeNode curr = root;
			TreeNode parent = root;
			while (curr != null) {
				parent = curr;
				if (value > curr.value) {
					curr = curr.right;
				} else{
					curr = curr.left;
				}
			}
			if (parent.value > value) {
				parent.left = newTreeNode;
			} else {
				parent.right = newTreeNode;
			}
		}
		if(!isBalanceTree(root).balanceTree) {
			rotateLeft(root);
		}
	}
	public static class Response{
		int height;
		boolean balanceTree;
		public Response() {
		}
		public Response(int height, boolean balanceTree) {
			super();
			this.height = height;
			this.balanceTree = balanceTree;
		}
	}
	public static Response isBalanceTree(TreeNode tree) {
		if(tree==null) {
			return new Response(0,true);
		}
		Response leftResponse = isBalanceTree(tree.left);
		Response rightResponse = isBalanceTree(tree.right);
		int height = Math.max(leftResponse.height, rightResponse.height)+1;
		boolean balanceTree = leftResponse.balanceTree && rightResponse.balanceTree 
				&& Math.abs(leftResponse.height-rightResponse.height)<2;
		return new Response(height,balanceTree);
	}
	/**
	 * 删除节点
	 * @param value
	 * @return
	 */
	public TreeNode remove(int value) {
		return processRemove(root, value);
	}
	private TreeNode processRemove(TreeNode root, int value) {
		if (root == null) {
			return null;
		}
		TreeNode curr = root;
		TreeNode parent = root;
		while (curr != null) {
			if (value > curr.value) {
				parent = curr;
				curr = curr.right;
			} else if (value < curr.value) {
				parent = curr;
				curr = curr.left;
			} else {
				break;
			}
		}
		if (curr.left == null) {
			if (curr == root) {
				root = curr.right;
			} else if (curr == parent.left) {
				parent.left = curr.right;
			} else {
				parent.right = curr.right;
			}
		} else if (curr.right == null) {
			if (curr == root) {
				root = curr.left;
			} else if (curr == parent.right) {
				parent.right = curr.left;
			} else {
				parent.left = curr.left;
			}
		}else if(curr.left != null && curr.right == null){
			TreeNode target = curr.right;
            TreeNode targetParent = curr;
            while(target.left != null){
                targetParent = target;
                target = target.left;
            }
            curr.value = target.value;
            if(targetParent.left == target){
                targetParent.left = target.right;
            }else {
                targetParent.right = target.right;
            }
		}
		this.root = root;
		return curr;
	}
	/**
	 * 左旋
	 * @param root
	 * @return
	 */
	public TreeNode rotateLeft(TreeNode root){
		TreeNode oldRoot = root;
		TreeNode newRoot = root.right;
		TreeNode temp = newRoot.left;
		newRoot.left = oldRoot;
		oldRoot.right = temp;
		this.root = newRoot;
		return newRoot;
	}
	/**
	 * 右旋
	 * @param root
	 * @return
	 */
	public TreeNode rotateRight(TreeNode root){
		TreeNode oldRoot = root;
		TreeNode newRoot = root.left;
		TreeNode temp = newRoot.right;
		newRoot.right = oldRoot;
		oldRoot.left = temp;
		this.root = newRoot;
		return newRoot;
	}
	/**
	 * 二叉树
	 * 
	 * @author reyco
	 *
	 * @param <K>
	 * @param <V>
	 */
	static class TreeNode extends Node {

		TreeNode left;

		TreeNode right;

		TreeNode(Integer value) {
			super(value, null, value);
		}
	}

	/**
	 * 节点
	 * 
	 * @author reyco
	 *
	 * @param <K>
	 * @param <V>
	 */
	static class Node {
		int hash;
		String key;
		int value;

		public Node(int hash, String key, int value2) {
			super();
			this.hash = hash;
			this.key = key;
			this.value = value2;
		}
	}
}
