package com.reyco.lgorithm.string.array2;

/**
 * 56
 * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
 * 你可以对一个单词进行如下三种操作：
 * 		(1)插入一个字符
 * 		(2)删除一个字符
 * 		(3)替换一个字符
 * 
 * str1[i]-->str2[j]  表示str1长度为（0~i-1）编辑到str2长度为（0~j-1）最低代价是多少？
 * 
 * 答： 第一种情况：dp[i-1][j]   del
 * 			例：
 * 			str1: abcde
 *                      str2: abcd
 *          		str1只需要删除e
 *    第二种情况：dp[i][j-1]   add 
 *    			例：
 *         		str1: abcd————>abcde
 *          		str2: abcde
 *         	 	str1只需要插入e
 *    第三种情况：dp[i-1][j-1] replace
 *   		 	例：
 *    			str1: abcdf
 *          		str2: abcde
 *          		str1只需要替换f成e
 *    第四种情况：i-1==j-1,dp[i-1][j-1] copy
 *    		 	例：
 *    			str1: abcde
 *          		str2: abcde
 * @author reyco
 *
 */
public class Test10 {

	public static void main(String[] args) {
		String word1 = "abce";
		String word2 = "abcd";
		System.out.println(minCost(word1, word2, 1, 1, 1));
	}
	/**
	 * 
	 * @param word1
	 * @param word2
	 * @param ic	插入
	 * @param dc	删除
	 * @param rc	替换
	 * @return
	 */
	public static int minCost(String word1,String word2,int ic,int dc,int rc) {
		if(word1==null || word2==null) {
			return 0;
		}
		int[][] dp = new int[word1.length()+1][word2.length()+1];
		for (int i = 1; i < dp[0].length; i++) {
			dp[0][i] = ic*i; 
		}
		for (int i = 1; i < dp.length; i++) {
			dp[i][0] = dc*i; 
		}
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if(word1.charAt(i-1)==word2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1];
				}else {
					dp[i][j] = dp[i-1][j-1]+rc;
				}
				dp[i][j] = Math.min(dp[i][j], dp[i][j-1]+ic);
				dp[i][j] = Math.min(dp[i][j], dp[i-1][j]+dc);
			}
		}
		return dp[word1.length()][word2.length()];
	}
	
	
}
