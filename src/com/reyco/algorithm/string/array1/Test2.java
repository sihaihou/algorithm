package com.reyco.lgorithm.string.array1;

/**
 * 62
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0
 * 
 * @author reyco
 *
 */
public class Test2 {
	public static void main(String[] args) {
		/*String text1 = "abcbaa";
		String text2 = "abcbcba";*/
		/*String text1 = "hofubmnylkra";
		String text2 = "pqhgxgdofcvmr";*/
		String text1 = "bsbininm";
		String text2 = "jmjkbkjkv";
		// int longestCommonSubsequence =
		// longestCommonSubsequence("hofubmnylkra","pqhgxgdofcvmr");
		// int longestCommonSubsequence =
		// longestCommonSubsequence("bsbininm","jmjkbkjkv");
		System.out.println(longestCommonSubsequence(text1, text2));

	}
	/**
	 * text1[0][i]
	 * text2[0][j]
	 * 1)不以text1的i结尾，不以text2的j结尾：dp[i-1][j-1]
	 * 		dp[i][j] = max(max(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])
	 * 2)不以text1的i结尾，以text2的j结尾：dp[i-1][j]
	 * 		dp[i][j] = max(max(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])
	 * 3)以text1的i结尾，不以text2的j结尾：dp[i][j-1]
	 *      dp[i][j] = max(max(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])
	 * 4)以text1的i结尾，以text2的j结尾(text1[i]==text2[j])：dp[i-1][j-1]+1 :取四种可能性最大值 
	 * 		dp[i][j] = max(max(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]+1)
	 * 
	 * @param text1
	 * @param text2
	 * @return
	 */
	public static int longestCommonSubsequence(String text1, String text2) {
		int[][] dp = new int[text1.length()][text2.length()];
		dp[0][0] = text1.charAt(0)==text2.charAt(0) ? 1 : 0;
		//0列
		for(int i=1;i<text1.length();i++) {
			dp[i][0] = Math.max(dp[i-1][0],text1.charAt(i)==text2.charAt(0) ? 1 : 0);
		}
		//0行
		for(int j=1;j<text2.length();j++) {
			dp[0][j] = Math.max(dp[0][j-1],text1.charAt(0)==text2.charAt(j) ? 1 : 0);
		}
		//
		for (int i = 1; i < text1.length(); i++) {
			for (int j = 1; j < text2.length(); j++) {
				dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				if (text1.charAt(i) == text2.charAt(j)) {
					dp[i][j] = Math.max(dp[i][j], dp[i-1][j - 1]+1);
				}
			}
		}
		return dp[text1.length()-1][text2.length()-1];
	}
}
