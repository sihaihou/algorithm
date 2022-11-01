package com.reyco.lgorithm.string.array1;

/**
 * 无重复最长字串
 * 最长子串、子数组问题： 以i结尾怎么怎么样？
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
