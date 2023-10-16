package com.reyco.algorithm.string.array1;

/**
 * 63
 * 给定一个字符串str，返回最长的回文子序列。
 * 答：范围上的尝试模型：左下半区无效
 *	   str[i..j]上最长回文子序列。dp[i][j]表示str[i~j]上最长回文子序列长度。
 *     求的点就是dp[0][str.length-1]
 *     
 *     1)不i，不j：dp[i+1][j-1]
 *     2)以i，不j：dp[i][j-1]
 *     3)不i，以j：dp[i+1][j]
 *     4)str[i]==str[j] 以i，以j：dp[i+1][j-1]+2 
 *     四种情况求最大值
 * @author reyco
 *
 */
public class Test8 {
	public static void main(String[] args) {
		String s = "abcc";
		int length = longestPalindrome(s);
		System.out.println(length);	
	}
	public static int longestPalindrome(String s) {
		int length = s.length();
		int[][] dp = new int[length][length];
		for (int i = 0; i < length; i++) {
			dp[i][i] = 1;
		}
		int max = 1;
		for (int i = length - 2; i >= 0; i--) {
			for (int j = i + 1; j < length; j++) {
				dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
				dp[i][j] = Math.max(dp[i][j], dp[i + 1][j - 1]);
				if (s.charAt(i) == s.charAt(j)) {
					dp[i][j] = Math.max(dp[i][j], dp[i + 1][j - 1] + 2);
				}
				max = Math.max(max, dp[i][j]);
			}
		}
		return max;
	}
}
