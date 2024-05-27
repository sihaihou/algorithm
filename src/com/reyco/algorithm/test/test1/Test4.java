package com.reyco.algorithm.test.test1;

import java.util.Stack;

/**
 * 62
 * 给定一个字符串str,str表示一个公式，公式里有整数、加减乘除符符号，返回公式的计数结果！
 * @author reyco
 *
 */
public class Test4 {
	
	public static void main(String[] args) {
		String str= "33+12*9+42/2+6/3";
		//String str= "22-19-18";
		int resulut = getValue(str);
		System.out.println(resulut);
	}
	public static int getValue(String str) {
		LinkedList<String> linkedList = new LinkedList<String>();
		int num = 0;
		for(int i=0;i<str.length();i++) {
			char ati;
			if((ati=str.charAt(i))>='0' && ati<='9') {
				num = num*10 + (ati-'0');
			}else {
				addNum(linkedList, num);
				linkedList.addLast(String.valueOf(str.charAt(i)));
				num = 0;
			}
		}
		addNum(linkedList, num);
		return getSum(linkedList);
	}
	private static void addNum(LinkedList<String> linkedList,Integer num) {
		String peek;
		if(!linkedList.isEmpty() && ((peek=linkedList.peekLast()).equals("*") || peek.equals("/"))) {
			String symbol = linkedList.pollLast();
			int curr = Integer.parseInt(linkedList.pollLast());
			num = symbol.equals("*") ? (curr*num) : (curr/num);
		}
		linkedList.addLast(String.valueOf(num));
	}
	/**
	 * 求和
	 * @param stack
	 * @param num
	 * @return
	 */
	public static int getSum(LinkedList<String> linkedList) {
		int ans = 0;
		boolean add = true;
		String curr = null;
		int num = 0;
		while(!linkedList.isEmpty()) {
			curr = linkedList.pollFirst();
			if(curr.equals("+")) {
				add = true;
			}else if(curr.equals("-")) {
				add = false;
			}else {
				num = Integer.valueOf(curr);
				ans += add ? num :(-num);
			}
		}
		return ans;
	}
}
