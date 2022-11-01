package com.reyco.algorithm.test.test2;

/**
 * 通配符
 * @author reyco
 *
 */
public class Test6 {
	
	public static void main(String[] args) {
		String s = "aaac";
		String e = "a*c";
		boolean process = process(s, e, 0, 0);
		System.out.println(process);
	}
	public static boolean process(String s,String e,int si,int ei) {
		if(ei==e.length()) {
			return si == s.length();
		}
		if(ei+1==e.length() || e.charAt(ei+1)!='*') {
			return si != s.length() && (e.charAt(ei)==s.charAt(si) || e.charAt(ei)=='.')
					    && process(s, e, si+1, ei+1);
		}
		while(si!=s.length() && (e.charAt(ei)==s.charAt(si) || e.charAt(ei)=='.')) {
			if(process(s, e, si, ei+2)) {
				return true;
			}
			si++;
		}
		return process(s, e, si, ei+2);
	}
	
}
