package com.reyco.lgorithm.manacher;

/**
 * 42
 * 返回字符串str的最长回文子串？代码错的
 * @author reyco
 *
 */
public class Test1 {
	
	public static void main(String[] args) {
		String s= "abcdefgfe";
		System.out.println(maxLength(s));;
	}
	public static int maxLength(String s) {
		if(s==null || s.length()==0) {
			return 0;
		}
		char[] sChar = manacherString(s);//#a#b#c#d#e#f#g#
		int[] cache = new int[s.length()];
		//最长回文右边界的中心点的位置
		int C = -1;
		//最长回文右边界
		int R = -1;
		int max = Integer.MIN_VALUE;
		for(int i=0;i!=s.length();i++) {
			cache[i] = R > i ? Math.min(cache[2*C-i], R-i) : 1;
			while(i+cache[i]<s.length() && i-cache[i]>-1) {
				if(sChar[i+cache[i]]==sChar[i-cache[i]]) {
					cache[i]++;
				}else {
					break;
				}
			}
			if(i+cache[i]>R) {
				R = i+ cache[i];
				C = i;
			}
			max = Math.max(max, cache[i]);
		}
		return max-1;
	}
	private static char[] manacherString(String s) {
		char[] sChar = new char[(s.length()<<1)+1];
		sChar[0] = '#';
		int k = 1;
		for(int i=0;i<s.length();i++) {
			sChar[k] = s.charAt(i);
			sChar[k+1] = '#';
			k += 2;
		}
		return sChar;
	}
}
