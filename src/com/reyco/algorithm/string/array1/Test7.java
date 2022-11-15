package com.reyco.lgorithm.string.array1;

/**
 * 56-57
 * 无重复最长子串
 * 答：记录每个字符出现的位置，用pre记录s[i]上一次出现的位置，用当前位置i减去pre上次出现位置，等于以i结尾最长无重复最长子串长度，
       和之前最长长度比较，最后更新当前字符出现的索引位置。
 * @author reyco
 *
 */
public class Test7 {

	public static void main(String[] args) {
		String s = "abcdfefgadfwga";
		int maxLength = maxLength(s);
		System.out.println(maxLength);
	}
	public static int maxLength(String s) {
		int[] dp = new int[256];
		for (int i = 0; i < dp.length; i++) {
			dp[i] = -1;
		}
		int len = 0;
		int pre = -1;
		int curr = 0;
		for (int i = 0; i < s.length(); i++) {
			pre = Math.max(pre, dp[s.charAt(i)]);
			curr = i-pre;
			len = Math.max(len, curr);
			dp[s.charAt(i)] = i;
		}
		return len;
	}
	
}
