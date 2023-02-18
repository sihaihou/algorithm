package com.reyco.algorithm.string.array1;

/**
 * 62
 * 给定两个字符串str1、str2,求str1和str2的最长公共子串。
 * 答: str1必须以i结尾,str2必须以j结尾情况下，最长公共子串有多长。它只依赖左上角的值+1, dp[i-1][j-1]+1
 *            如果:str1[i]==str2[j]，len=dp[i-1][j-1]+1;
 *            如果:str1[i]!=str2[j],len=0
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
		int row = 0;//斜线开始位置的行
		int col = str2.length()-1;//斜线开始位置的列
		int max = 0;//全局最大的公共子串长度
		int end = 0;//
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
