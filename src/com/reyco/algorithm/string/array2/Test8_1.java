package com.reyco.algorithm.string.array2;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 38
 * 一个字符串数组有很多字符串，把所有字符串都拼接起来，问如何拼接使整体字典序最小，并返回这个字典序最小的字符串？
 * 答：如果： a+b>b+a ? b+a : a+b
 * @author reyco
 *
 */
public class Test8_1 {

	public static void main(String[] args) {
		String[] strs = {"a","dc","c"};
		String lowestString = lowestString(strs);
		System.out.println(lowestString);
	}
	
	public static String lowestString(String[] strs) {
		if(strs==null || strs.length==0) {
			return "";
		}
		Arrays.sort(strs,new StringComparator());
		String ans = "";
		for (int i = 0; i < strs.length; i++) {
			ans += strs[i];
		}
		return ans;
	}
	public static class StringComparator implements Comparator<String>{
		@Override
		public int compare(String o1, String o2) {
			return (o1+o2).compareTo(o2+o1);
		}
	}
}
