package com.reyco.algorithm.test.test3;

/**
 * 给定一个只有0、1、&、|、^ 五种字符组成的字符串express，再给定一个布尔值desired。返回express有多少种组合方式，可以达到desired的结果。
 * 如：
 * 	express = "1^0|0|1",desired=false,只有“1^((0|0)|1)”和"1^(0|(0|1))"的组合可以得到false，返回2.
 * @author reyco
 *
 */
public class Test9 {

	public static void main(String[] args) {
		String express = "1^0|0|1";
		boolean desired=false;
		int ways = ways(express, desired);
		System.out.println(ways);
	}
	
	public static int ways(String express,boolean desired) {
		if(express==null || express.equals("")) {
			return 0;
		}
		if(!isValid(express)) {
			return 0;
		}
		return process(express, desired, 0, express.length()-1);
	}
	/**
	 * L、R不要是逻辑符号
	 * @param express
	 * @param desired
	 * @param L
	 * @param R
	 * @return
	 */
	private static int process(String express,boolean desired,int L,int R) {
		if(L==R) {
			if(express.charAt(L)=='1') {
				return desired ? 1 : 0;
			}else {
				return desired ? 0 : 1;
			}
		}
		int ans = 0;
		if(desired) {
			for (int i = L+1; i < R; i += 2) {
				switch (express.charAt(i)) {
				case '&':
					ans += process(express, true, L, i-1)*process(express, true, i+1, R);
					break;
				case '|':
					ans += process(express, true, L, i-1)*process(express, false, i+1, R);
					ans += process(express, false, L, i-1)*process(express, true, i+1, R);
					ans += process(express, true, L, i-1)*process(express, true, i+1, R);
					break;
				case '^':
					ans += process(express, true, L, i-1)*process(express, false, i+1, R);
					ans += process(express, false, L, i-1)*process(express, true, i+1, R);
					break;
				}
			}
		}else {
			for (int i = L+1; i < R; i += 2) {
				switch (express.charAt(i)) {
				case '&':
					ans += process(express, true, L, i-1)*process(express, false, i+1, R);
					ans += process(express, false, L, i-1)*process(express, true, i+1, R);
					ans += process(express, false, L, i-1)*process(express, false, i+1, R);
					break;
				case '|':
					ans += process(express, false, L, i-1)*process(express, false, i+1, R);
					break;
				case '^':
					ans += process(express, true, L, i-1)*process(express, true, i+1, R);
					ans += process(express, false, L, i-1)*process(express, false, i+1, R);
					break;
				}
			}
		}
		return ans;
	}
	private static boolean isValid(String express) {
		if(express==null || express.equals("")) {
			return false;
		}
		if((express.length()&1)==0) {
			return false;
		}
		for (int i = 0; i < express.length(); i++) {
			if((i&1)==0 && express.charAt(i)!='0' && express.charAt(i)!='1') {
				return false;
			}
			if((i&1)==1 && express.charAt(i)!='&' && express.charAt(i)!='|' && express.charAt(i)!='^') {
				return false;
			}
		}
		return true;
	}
}
