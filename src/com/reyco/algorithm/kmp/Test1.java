package com.reyco.lgorithm.kpm;

/**
 * 41
 * KMP
 * 字符串str1和str2，str1是否包含str2，如果包含，返回str2在str1中开始的位置.否则返回-1
 * 答： 第一步：计算str2[0...i-1]每一个位置之前的字符串最长前缀长度与最长后缀长度数组，
 *         next[i]: 
 *                  如果str2[i]==next[cn],next[i]=cn;
 *         			如果cn大于0，cn往前跳，cn=next[cn];
 *                  否则，next[i]=0。
 *    第二步： str1[i]与str2[j]相等都往后移动；不等，j往前跳，j等于j位置的最长前缀与最长后缀长度的value(j=next[j])。
 * @author reyco
 *
 */
public class Test1 {
	public static void main(String[] args) {
		String str1 = "123abcdefgitoy";
		String str2 = "abcdefg";
		int index = getIndex(str1, str2);
		System.out.println(index);
	}
	public static int getIndex(String str1,String str2) {
		if(str1==null || str2==null || str1.length()<str2.length()) {
			return -1;
		}
		//
		int[] next =  getNextArray(str2);
		
		int i=0;
		int j=0;
		//O(N)
		while(i<str1.length() && j<str2.length()) {
			if(str1.charAt(i)==str2.charAt(j)) {
				i++;
				j++;
			}else if(next[j]==-1){   //j来到了-1位置。表示0...i都无法匹配，i往后移动
				i++;
			}else {
				j=next[j];
			}
		}
		return j==str2.length() ? i-j : -1;
	}
	private static int[] getNextArray(String str) {
		int[] next = new int[str.length()];
		next[0] = -1;
		next[1] = 0;
		int index = 2;
		int cn = 0;
		while(index<str.length()) {
			if(str.charAt(index-1)==next[cn]) {
				next[index++] = ++cn;
			}else if(cn>0) {
				cn = next[cn];
			}else {
				next[index++] = 0;
			}
		}
		return next;
	}
}
