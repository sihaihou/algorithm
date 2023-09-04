package com.reyco.algorithm.test.test1;
/**
 * 48 
 * ()()()一个字符串只包含左括号和右括号，至少添加多少个字符，使整体是一个完整的括号序列。
 * @author reyco
 *
 */
public class Test10 {
	public static void main(String[] args) {
		String str = "()()()()((())))(((())))";
		Integer ans = needParenthreses(str);
		System.out.println(ans);
	}
	public static Integer needParenthreses(String str) {
		int ans = 0;
		int count = 0;
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i) == '(') {
				count++;
			}else {
				if(count==0) {
					ans++;
				}else {
					count--;
				}
			}
		}
		return ans+count;
	}
}
