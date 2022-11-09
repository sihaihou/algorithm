package com.reyco.algorithm.trie;

import java.util.TreeMap;

/**
 * 54
 * 给定一个字符串类型的数组arr，String[] arr = {"b\\cst","d\\","a\\d\\e","a\\b\\c"};
 * 把这些路径蕴含的目录结构绘画出来，子目录直接列在父目录下面,并比父目录向右进两格，同一级别的需按字母顺序排列，不能乱。就像这样：
 * 	 a
 * 	   b
 *       c
 *     d 
 *     	 c
 *   b 
 *     cst
 *   d  
 *   
 *   答： 先生成前缀树，在使用深度优先遍历。
 * @author reyco
 *
 */
public class Test1 {
	
	public static void main(String[] args) {
		String[] arr = {"b\\cst","d\\","a\\d\\e","a\\b\\c"};
		printTree(arr);
	}
	public static void printTree(String[] arr) {
		Node head = createNode(arr);
		printProcess(head, 0);
	}
	private static void printProcess(Node head,int level) {
		if(level!=0) {
			System.out.println(getSpace(level)+head.name);
		}
		for (Node node : head.nextMap.values()) {
			printProcess(node, level+1);
		}
	}
	/**
	 * 生成前缀树
	 * @param arr
	 * @return
	 */
	private static Node createNode(String[] arr) {
		Node head = new Node("");
		for (String s : arr) {
			String[] paths = s.split("\\\\");
			Node curr = head;
			for (String path : paths) {
				if(!curr.nextMap.containsKey(path)) {
					curr.nextMap.put(path, new Node(path));
				}
				curr = curr.nextMap.get(path);
			}
		}
		return head;
	}
	private static String getSpace(int count) {
		String res = "";
		for(int i=1;i<count;i++) {
			res += "  ";
		}
		return res;
	}
	public static class Node{
		public String name;
		public TreeMap<String,Node> nextMap;
		public Node(String name) {
			super();
			this.name = name;
			this.nextMap = new TreeMap<>();
		}
		
	}
}
