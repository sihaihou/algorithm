package com.reyco.algorithm.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * 前缀树1.0
 * @author reyco
 *
 */
public class TrieTree2 {
	
	private Node root;
	
	public TrieTree2() {
		root = new Node();
	}
	/**
	 * 添加一个字符串
	 * @param word
	 */
	public void insert(String word) {
		if(word==null || word.equals("")) {
			return;
		}
		Node curr = root;
		int i=0;
		while(i<word.length()) {
			if(!curr.nexts.containsKey(word.charAt(i))) {
				curr.nexts.put(word.charAt(i), new Node());
			}
			curr = curr.nexts.get(word.charAt(i));
			curr.pass++;
			i++;
		}
		curr.end++;
	}
	public void delete(String word) {
		if(search(word)!=0) {
			Node curr = root;
			int i=0;
			while(i<word.length()) {
				if(--curr.nexts.get(word.charAt(i)).pass==0) {
					curr.nexts.remove(word.charAt(i));
					return;
				}
				curr = curr.nexts.get(word.charAt(i));
				i++;
			}
			curr.end--;
		}
	}
	/**
	 * 这个字符串被加入过几次
	 * @param word
	 * @return
	 */
	public int search(String word) {
		if(word==null || word.equals("")) {
			return 0;
		}
		Node curr = root;
		int i=0;
		while(i<word.length()) {
			if(!curr.nexts.containsKey(word.charAt(i))) {
				return 0;
			}
			curr = curr.nexts.get(word.charAt(i));
			i++;
		}
		return curr.end;
	}
	/**
	 * 有多少个字符串是以pre开头的
	 * @param pre
	 * @return
	 */
	public int prefixNumber(String pre) {
		if(pre==null || pre.equals("")) {
			return 0;
		}
		Node curr = root;
		int i=0;
		while(i<pre.length()) {
			if(!curr.nexts.containsKey(pre.charAt(i))) {
				return 0;
			}
			curr = curr.nexts.get(pre.charAt(i));
			i++;
		}
		return curr.pass;
	}
	
	public static class Node{
		//通过我的节点有多少个
		int pass;
		//以我结尾的有多少个
		int end;
		//表示我下级的路
		Map<Character,Node> nexts;
		public Node() {
			this.pass = 0;
			this.end = 0;
			this.nexts = new HashMap<>();
		}
	}
}
