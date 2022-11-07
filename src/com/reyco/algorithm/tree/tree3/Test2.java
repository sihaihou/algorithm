package com.reyco.algorithm.tree.tree3;

import java.util.ArrayList;

/**
 * 返回二叉树从根节点到叶子节点的每一条路径
 * @author reyco
 *
 */
public class Test1 {

	public static void main(String[] args) {
		//			 	1
		//		2  		 		3
		//	4  	  	5  		6		7 		
		//8	  9	 10   11
			
			
		TreeNode tree11 = new TreeNode(11);
		TreeNode tree10 = new TreeNode(10);
		TreeNode tree9 = new TreeNode(9);
		TreeNode tree8 = new TreeNode(8);
		TreeNode tree7 = new TreeNode(7);
		TreeNode tree6 = new TreeNode(6);
		TreeNode tree5 = new TreeNode(5,tree10,tree11);
		TreeNode tree4 = new TreeNode(4,tree8,tree9);
		TreeNode tree3 = new TreeNode(3,tree6,tree7);
		TreeNode tree2 = new TreeNode(2,tree4,tree5);
		TreeNode root = new TreeNode(1,tree2,tree3);
		int sumRootToLeaf = sumRootToLeaf(root);
		System.out.println(sumRootToLeaf);
	}
	public static int sumRootToLeaf(TreeNode root) {
		ArrayList<String> paths = new ArrayList<>();
		process(root.left, paths, root.val+"");
		process(root.right, paths, root.val+"");
		System.out.println(paths);
		return 1;
    }
	public static void process(TreeNode root,ArrayList<String> paths,String path) {
		if(root!=null) {
			path = path+"->"+root.val;
			if(root.left==null && root.right==null) {
				paths.add(path);
			}
			process(root.left, paths, path);
			process(root.right, paths, path);
		}
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
}
