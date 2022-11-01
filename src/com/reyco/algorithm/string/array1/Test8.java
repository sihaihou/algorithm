package com.reyco.lgorithm.string.array1;

/**
 * 给定一个字符串str，返回最长的回文子序列。
 * 答：范围上的尝试模型：左下半区无效
 *	   str[i..j]上最长回文子序列。dp[i][j]表示str[i~j]上最长回文子序列长度。
 *     求的点就是dp[0][str.length-1]
 *     
 *     1)不i，不j：dp[i-1][j-1]
 *     2)以i，不j：dp[i][j-1]
 *     3)不i，以j：dp[i-1][j]
 *     4)str[i]==str[j] 以i，以j：dp[i][j]+2 
 *     四种情况求最大值
 * @author reyco
 *
 */
public class Test8 {
	public static void main(String[] args) {
		
	}
}
