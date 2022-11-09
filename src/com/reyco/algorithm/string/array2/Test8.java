package com.reyco.lgorithm.string.array2;

/**
 * 56
 * 在s字符串中，每个字母都要保留一个，让最后的结果字典序最小，并返回。
 * @author reyco
 *
 */
public class Test8 {
	
	public static void main(String[] args) {
		String s = "adcbadbgaasf";
		System.out.println(remove(s));
	}
	public static String remove(String s) {
		if(s==null || s.length()<2) {
			return s;
		}
		int[] dp = new int[26];
		for (int i = 0; i < s.length(); i++) {
			dp[s.charAt(i)-'a']++;
		}
		int minACSIndex = 0;
		for (int i = 0; i < s.length(); i++) {
			if(--dp[s.charAt(i)-'a'] == 0) {
				break;
			}else {
				minACSIndex = s.charAt(minACSIndex)>s.charAt(i) ? i : minACSIndex;
			}
		}
		//s.charAt(minACSIndex) + s.charAt(minACSIndex+1...).replaceAll(s.charAt(minACSIndex)
		return String.valueOf((s.charAt(minACSIndex))
				+ remove(
						s
						.substring(minACSIndex+1)
						.replaceAll(String.valueOf(s.charAt(minACSIndex)), "")
						)
				);
	}
}
