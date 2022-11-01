package com.reyco.lgorithm.string.array1;

/**
 * 给定一个字符串str，返回把str全部切成回文子串的最小分割数。
 *  例:1）str="aba" 本身是回文，不需要切割，返回1；
 *    2）str="ACDCDCDAD",最少需要切两次变成回文子串，A、CDCDC、DAD，所有返回3.
 * @author reyco
 *
 */
public class Test9 {
	
	public static void main(String[] args) {
		//String str = "ABA";
		//String str = "ACDCDCDAD"; //3
		String str = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAB"; //3
		int strCut = minCut1(str);
		System.out.println(strCut);
	}
	public static int minCut1(String str) {
		if(str==null) {
			return 0;
		}
		if(str.length()==1) {
			return 1;
		}
		boolean[][] record = record(str);
		int[] dp = new int[str.length()+1];
		dp[str.length()] = 0;
		dp[str.length()-1] = 1;
		for (int i = str.length()-2; i >=0; i--) {
			dp[i] = str.length()-i;
			for (int j = i; j < str.length(); j++) {
				if(record[i][j]) {
					dp[i] = Math.min(dp[i], dp[j+1]+1);
				}
			}
		}
		return dp[0];
	}
	private static boolean[][] record(String str){
		boolean[][] record = new boolean[str.length()][str.length()];
		record[str.length()-1][str.length()-1] = true;
		for (int i = 0; i < record.length-1; i++) {
			record[i][i]=true;
			record[i][i+1] = str.charAt(i)==str.charAt(i+1);
		}
		for (int row = str.length()-3; row>=0; row--) {
			for (int col = row+2; col < str.length(); col++) {
				record[row][col] = str.charAt(row)==str.charAt(col) && record[row+1][col-1];
			}
		}
		return record;
	}
	
	
	
	public static int minCut(String str) {
		if(str==null) {
			return 0;
		}
		if(str.length()==1) {
			return 1;
		}
		return process(str, 0);
	}
	private static int process(String str,int i) {
		if(i==str.length()) {
			return 0;
		}
		int min = Integer.MAX_VALUE;
		//尝试每一个end，如果str[i...end]这个部分是回文，就去尝试这个部分作为回文的第一块。
		for (int end = i; end < str.length(); end++) {
			if(valid(str, i, end)) {
				//str[i...]拆成： 第一块为str[i..end]  后续的str[end+1]怎么拆最省的问题
				min = Math.min(min, 1+process(str, end+1));
			}
		}
		return min;
	}
	private static boolean valid(String str,int L,int R) {
		while(L<=R) {
			if(str.charAt(L++)!=str.charAt(R--)) {
				return false;
			}
		}
		return true;
	}
	
}
