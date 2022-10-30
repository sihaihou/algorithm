package com.reyco.algorithm.trie;

import java.util.Random;

public class Test {
	
	public static void main(String[] args) {
		TrieTree2 trieTree = new TrieTree2();
		int count = 0;
		for (int i=0;i<10;i++) {
			String s = createRandomStringNotNumber(10);
			if(s.charAt(0)=='a') {
				count++;
			}
			System.out.println(s);
			trieTree.insert(s);
		}
		System.out.println("count:"+count+",time:"+trieTree.prefixNumber("a"));
	}
	
	private static String createRandomStringNotNumber(int length) {
		Random random = new Random();
		char[] charArray = new char[length];
		String template = "abcdefghigklmnopqrstwvuxyz";
		int i=0;
		while(i<length) {
			charArray[i++] = template.charAt(random.nextInt(template.length()));
		}
		return new String(charArray);
	}
}
