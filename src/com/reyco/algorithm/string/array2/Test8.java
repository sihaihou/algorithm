package com.reyco.algorithm.string.array2;

/**
 * 56
 * 在s字符串中，每个字母都要保留一个，让最后的结果字典序最小，并返回。
 * 答：第一步：统计词频；s=adcbadb[a=2,d=2,c=1,b=2]
 *    1)字符串s=adcbadb从0开始，ad cbadb,保留0位置的a，a前面的都删除掉,a后面的a都删除掉，第一部分a,第二部分dcbdb(递归)，a+?(第二部分递归)
 *    2)继续s=dcbdb从0开始，d cbdb,保留0位置的d，d前面的都删除掉,d后面的d都删除掉，第一部分d,第二部分cbb(递归)，d+?(第二部分递归)
 *    3)继续s=cbb从0开始，c bb,保留0位置的c，c前面的都删除掉,c后面的c都删除掉,第一部分c,第二部分bb(递归)，c+?(第二部分递归)
 *    4)继续s=bb从0开始，b b,保留0位置的b，b前面的都删除掉，b后面的b都删除掉，第一部分b，没有第二部分，结束,答案ans= a+d+c+b
 * @author reyco
 *
 */
public class Test8 {
	
	public static void main(String[] args) {
		String s = "adcbadb";
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
