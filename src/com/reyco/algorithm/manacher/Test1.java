package com.reyco.lgorithm.manacher;

/**
 * 42
 * 返回字符串str的最长回文子串？
 * 答：第1步: 先将s="abcdefgfe"处理成s="#a#b#c#d#e#f#g#"这个的字符串；
 * 	     第2步： 利用最大回文半径、当前最右回文边界的R、和最右回文边界的中心点‘C’来处理;
 *    第3步:  1，当i在最右回文半径外，无法优化，暴力扩；
 *           2，当i在最右回文半径内:  L最左回文边界 、R最右回文边界
 *              1）以C为中心点i的对称点i'的最长回文左边界在L内，i的最长回文长度等于i'的最长回文长度；
 *              2）以C为中心点i的对称点i'的最长回文左边界在L外，以i为中心，i的最右回文边界是R；
 *              3）以C为中心点i的对称点i'的最长回文左边界压在L上，i的最长回文长度以R向往暴力扩。
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
		int[] cache = new int[sChar.length];
		//最右回文边界的下一个位置
		int R = -1;
		//最长回文右边界的中心点的位置，随着R的变化而变化，如果R不变,C也不变。
		int C = -1;
		//当前最长回文长度
		int max = Integer.MIN_VALUE;
		for(int i=0;i!=sChar.length;i++) {
			//i至少的回文半径，先给cache[i]
			cache[i] = R > i ? Math.min(cache[2*C-i], R-i) : 1;
			while(i+cache[i]<sChar.length && i-cache[i]>-1) {
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
