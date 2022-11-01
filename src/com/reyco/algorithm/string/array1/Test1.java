package com.reyco.lgorithm.string.array1;

/**
 * 给定两个字符串str1、str2,求str1和str2的最长公共子串。
 * 答:方法1： 必须以str1[i]和str2[j]结尾，它只依赖左上角的值+1: dp[i-1][j-1]+1
 *   方法2：
 * @author reyco
 *
 */
public class Test1 {
	
	public static void main(String[] args) {
		String str1 = "abcdefg";
		String str2 = "aaaabcdefg";
		String maxLenth = maxLenth(str1, str2);
		System.out.println(maxLenth);
	}
	/**
	 * 最长公共子串：从右上往左上，再有左上往左下(整体从左上往右下)
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static String maxLenth(String str1,String str2) {
		int row = 0;
		int col = str2.length()-1;
		int max = 0;
		int end = 0;
		while(row < str1.length()) {
			int i = row;
			int j = col;
			int len = 0;
			while(i<str1.length() && j<str2.length()) {
				if(str1.charAt(i)!=str2.charAt(j)) {
					len = 0;
				}else {
					len++;
				}
				if(len>max) {
					end = i;
					max = len;
				}
				i++;
				j++;
			}
			if(col>0) {
				col--;
			}else{
				row++;
			}
		}
		return str1.substring(end-max+1,end+1);
	}
}
