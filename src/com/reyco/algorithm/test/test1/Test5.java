package com.reyco.algorithm.test.test1;

import java.util.Stack;

/**
 * 62
 * 给定一个字符串str,str表示一个公式，公式里有整数、加减乘除、左括号、右括号符号，返回公式的计数结果！
 * @author reyco
 *
 */
public class Test5 {
	
	public static void main(String[] args) {
		//String str= "33+((12*9+42/2)+6/3)";
		String str= "22-19-18";
		int resulut = getValue(str);
		System.out.println(resulut);
	}
	public static int getValue(String str) {
		return value(str, 0).sum;
	}
	public static Response value(String str,int i) {
		LinkedList<String> linkedList = new LinkedList<String>();
		int num = 0;
		char ati;
		while(i<str.length() && (ati=str.charAt(i++))!=')') {
			if(ati>='0' && ati<='9') {
				num = num*10 + ati-'0';
			}else if(ati != '(') {
				addNum(linkedList, num);
				num = 0;
				linkedList.addLast(String.valueOf(ati));
			}else {
				Response response = value(str, i);
				num = response.sum;
				i = response.index;
			}
		}
		addNum(linkedList, num);
		return new Response(getSum(linkedList),i);
	}
	private static void addNum(LinkedList<String> linkedList,int num) {
		if(!linkedList.isEmpty()) {
			String symbol = linkedList.pollLast();
			if(symbol.equals("+") || symbol.equals("-")) {
				linkedList.addLast(symbol);
			}else {
				int left = Integer.valueOf(linkedList.pollLast());
				num = symbol.equals("*") ? (left*num) : (left/num);
			}
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
		int sum = 0;
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
				sum += add ? num :(-num);
			}
		}
		return sum;
	}
	public static class Response{
		int sum;
		int index;
		public Response(int sum, int index) {
			super();
			this.sum = sum;
			this.index = index;
		}
	}
	
}
