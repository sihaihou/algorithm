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
		String str = "1323212123";
		int changeNum = getChangeNum1(str);
		System.out.println(changeNum);
		int changeNum1 = getChangeNum2(str);
		System.out.println(changeNum1);
	}
	public static int getChangeNum1(String str) {
		return process1(str, 0);
	}
	/**
	 * 
	 * @param str
	 * @param index
	 * @return
	 */
	public static int process1(String str,int index) {
		if(index==str.length()) {
			return 1;
		}
		if(str.charAt(index)=='0') {
			return 0;
		}
		if(str.charAt(index)=='1') {
			int res = process1(str, index+1);
			if(index+1<str.length()) {
				res += process1(str, index+2);
			}
			return res;
		}
		if(str.charAt(index)=='2') {
			int res = process1(str, index+1);
			if(index+1<str.length() && str.charAt(index+1)>='0' && str.charAt(index+1)<='6') {
				res += process1(str, index+2);
			}
			return res;
		}
		//3<=str[index]<=9
		return process1(str, index+1);
	}
	/**
	 * 动态规划
	 * @param str
	 * @return
	 */
	public static int getChangeNum2(String str) {
		int[] dp = new int[str.length()+1];
		dp[str.length()] = 1;
		for(int index=str.length()-1;index>=0;index--) {
			if(str.charAt(index)=='0') {
				dp[index]=0;
			}
			if(str.charAt(index)=='1') {
				dp[index] = dp[index+1];
				if(index+1<str.length()) {
					dp[index] += dp[index+2];
				}
			}
			if(str.charAt(index)=='2') {
				dp[index] = dp[index+1];
				if(index+1<str.length() && str.charAt(index+1)>='0' && str.charAt(index+1)<='6') {
					dp[index] += dp[index+2];
				}
			}
			if(str.charAt(index)>='3' && str.charAt(index)<='9') {
				dp[index] = dp[index+1];
			}
		}
		return dp[0];
	}
}
