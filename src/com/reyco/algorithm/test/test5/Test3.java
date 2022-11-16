package com.reyco.algorithm.test.test5;

/**
 * 39-50
 * 规定1和A对应，2和B对应、3和C对应...
 * 那么一个数字字符串比如111就可以转化为AAA、AK、KA，
 * 给定一个只有数字组成的字符串str,返回有多少种转化结果？
 * @author reyco
 *
 */
public class Test3 {
	public static void main(String[] args) {
		String str = "1123";
		int changeNum = getChangeNum(str);
		System.out.println(changeNum);
		int changeNum1 = getChangeNum1(str);
		System.out.println(changeNum1);
	}
	public static int getChangeNum(String str) {
		return process(str, 0);
	}
	/**
	 * 
	 * @param str
	 * @param index
	 * @return
	 */
	public static int process(String str,int index) {
		if(index==str.length()) {
			return 1;
		}
		if(str.charAt(index)=='0') {
			return 0;
		}
		int res = process(str, index+1);
		if(str.charAt(index)=='1') {
			if(index+1<str.length()) {
				res += process(str, index+2);
			}
		}
		if(str.charAt(index)=='2') {
			if(index+1<str.length() && str.charAt(index+1)>='0' && str.charAt(index+1)<='6') {
				res += process(str, index+2);
			}
		}
		return res;
	}
	/**
	 * 动态规划
	 * @param str
	 * @return
	 */
	public static int getChangeNum1(String str) {
		int[] dp = new int[str.length()+1];
		dp[str.length()] = 1;
		for(int index=str.length()-1;index>=0;index--) {
			if(str.charAt(index)=='0') {
				dp[index]=0;
			}
			dp[index] = dp[index+1];
			if(str.charAt(index)=='1') {
				if(index+1<str.length()) {
					dp[index] += dp[index+2];
				}
			}
			if(str.charAt(index)=='2') {
				if(index+1<str.length() && str.charAt(index+1)>='0' && str.charAt(index+1)<='6') {
					dp[index] += dp[index+2];
				}
			}

		}
		return process(str, 0);
	}

	
}
