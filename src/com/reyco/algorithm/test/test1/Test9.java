package com.reyco.algorithm.test.test1;

/**
 * 一个字符串只包含左括号和右括号，
 * 求最长的有效括号。
 * @author reyco
 *
 */
public class Test9 {

	public static void main(String[] args) {
		String s = "()()()()((())))(((())))";	
		int maxLength = maxLength(s);
		System.out.println(maxLength);
	}
	public static int maxLength(String s) {
		if(s==null || s.equals("")) {
			return 0;
		}
		int[] dp = new int[s.length()];
		int maxLength = 0;
		int pre = 0;
		for (int i=1;i<s.length();i++) {
			if(s.charAt(i)==')') {
				pre = i-dp[i-1]-1;
				if(pre >= 0 && s.charAt(pre)=='(') {
					dp[i] = dp[i-1]+2+(pre>0 ? dp[pre-1] : 0);
				}
			}
			maxLength = Math.max(maxLength, dp[i]);
		}
		return maxLength;
	}
	
}
