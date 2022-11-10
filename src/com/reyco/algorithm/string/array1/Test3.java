package com.reyco.lgorithm.string.array1;

/**
 * 66
 * 给定字符串str1和str2，求str1的子串中包含str2所有字符的最小子串长度。
 * 例：
 * 	 str1="abcde" str2="ac" 'abc'包含str2的所有字符，长度3.
 * 	 str1="12345" str2="344" 最小包含子串不存在，长度0
 * 答：从左到右，滑动窗口 + 词频 + 总的欠的字符数 
 * @author reyco
 *
 */
public class Test3 {
    /**
	 * 给定字符串str1和str2，求str1的子串中包含str2所有字符的最小子串长度。
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static int minLenth(String s1,String s2) {
		if(s1==null || s1.equals("") || s2==null || s2.equals("") || s1.length()<s2.length()) {
			return 0;
		}
		Map<Character,Integer> timesMap = new HashMap<>();
		for (int i = 0; i < s2.length(); i++) {
			char charAt = s2.charAt(i);
			if(!timesMap.containsKey(charAt)) {
				timesMap.put(charAt, 0);
			}
			timesMap.put(charAt, timesMap.get(charAt)+1);
		}
		//总欠的词频
		int deficientWord  = s2.length();
		int minLen = Integer.MAX_VALUE;
		int left=0;
		int right=left;
		while(right<s1.length()) {
			char charAt = s1.charAt(right);
			if(timesMap.containsKey(charAt)) {
				timesMap.put(charAt, timesMap.get(charAt)-1);
				if(timesMap.get(charAt)>=0) {
					deficientWord -= 1;
				}
			}
			if(deficientWord==0) {
				//当不欠词频时，看left可以往右移动多少，然后计算长度
				while(timesMap.get(s1.charAt(left))==null || timesMap.get(s1.charAt(left))<0) {
					//还多给的词频
					if(timesMap.get(s1.charAt(left))!=null && timesMap.get(s1.charAt(left))<0) {
						timesMap.put(s1.charAt(left),timesMap.get(s1.charAt(left))+1);
					}
					left++;
				}
				minLen = Math.min(minLen, right-left+1);
				//把不能往右移动的加到词频中，left向右移动
				deficientWord++;
				timesMap.put(s1.charAt(left), timesMap.get(s1.charAt(left))+1);
				left++;
			}
			right++;
		}
		return minLen==Integer.MAX_VALUE ? 0 : minLen;
	}
}
