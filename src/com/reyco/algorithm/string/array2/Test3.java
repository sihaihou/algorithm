package com.reyco.algorithm.string.array2;

import java.util.ArrayList;
import java.util.List;

/**
 * 39
 * 字符串全排列
 * 答：   str[i...]范围上，所有的字符，都可以在i位置上，后续都去尝试，
 *    str[0...i-1]范围上，是之前做的选择。
 *    请把所有的字符串形成的全排列加入到ans中去。
 * @author reyco
 *
 */
public class Test3 {
	
	public static void main(String[] args) {
		String str = "abca";
		List<String> ans = new ArrayList<String>();
		f(str.toCharArray(), 0, ans);
		System.out.println(ans);
		ans = new ArrayList<String>();
		f2(str.toCharArray(), 0, ans);
		System.out.println(ans);
	}
	/**
	 * 字符串全排列
	 * str[i...]范围上，所有的字符，都可以在i位置上，后续都去尝试，
	 * str[0...i-1]范围上，是之前做的选择。
	 * 请把所有的字符串形成的全排列加入到ans中去。
	 * @param str
	 * @param index
	 * @param ans
	 */
	public static void f(char[] str, int index, List<String> ans) {
		if (index == str.length) {
			ans.add(String.valueOf(str));
		} else {
			for (int i = index; i < str.length; i++) {
				swap(str, index, i);
				f(str, index + 1, ans);
				swap(str, index, i);
			}
		}
	}
	/**
	 * 字符串全排列-去重
	 * str[i...]范围上，所有的字符，都可以在i位置上，后续都去尝试，
	 * str[0...i-1]范围上，是之前做的选择。
	 * 请把所有的字符串形成的全排列加入到ans中去。
	 * @param str
	 * @param index
	 * @param ans
	 */
	public static void f2(char[] str, int index, List<String> ans) {
		if (index == str.length) {
			ans.add(String.valueOf(str));
		} else {
			boolean[] visited = new boolean[256];
			for (int i = index; i < str.length; i++) {
				if (!visited[str[i]]) {
					visited[str[i]] = true;
					swap(str, index, i);
					f2(str, index + 1, ans);
					swap(str, index, i);
				}
			}
		}
	}
	
	public static void swap(char[] chs, int i, int j) {
		char tmp = chs[i];
		chs[i] = chs[j];
		chs[j] = tmp;
	}
	
}
