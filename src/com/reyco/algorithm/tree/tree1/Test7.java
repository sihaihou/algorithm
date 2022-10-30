package com.reyco.algorithm.tree.tree1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.reyco.algorithm.tree.TreeNode;

/**
 * 找到node1和node2在Tree中的最低公共祖先
 * 思路：先组装Tree中所有节点的父节点 
 * @author reyco
 */
public class Test7 {
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
		TreeNode caNode = getCANode(tree, tree4, tree6);
		System.out.println(caNode.val);
	}
	/**
	 * 获取最低公共祖先
	 * @param tree
	 * @param tree1
	 * @param tree2
	 * @return
	 */
	public static TreeNode getCANode(TreeNode tree,TreeNode tree1,TreeNode tree2) {
		Map<TreeNode,TreeNode> caMap = new HashMap<TreeNode,TreeNode>();
		caMap.put(tree,tree);
		process(tree, caMap);
		Set<TreeNode> tree1Set = new HashSet<TreeNode>();
		TreeNode curr = tree1;
		while(curr!=caMap.get(curr)) {
			tree1Set.add(curr);
			curr = caMap.get(curr);
		}
		tree1Set.add(tree);
		curr = tree2;
		while(curr!=null) {
			if(tree1Set.contains(curr)) {
				return curr;
			}
			curr = caMap.get(curr);
		}
		return tree;
		
	}
	public static void process(TreeNode tree,Map<TreeNode,TreeNode> caMap) {
		if(tree==null) {
			return;
		}
		caMap.put(tree.left, tree);
		caMap.put(tree.right, tree);
		process(tree.left, caMap);
		process(tree.right, caMap);
	}
}
