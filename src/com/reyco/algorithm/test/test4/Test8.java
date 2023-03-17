package com.reyco.algorithm.test.test4;

import com.reyco.algorithm.test.test3.RandomArrayFactory;

/**
 * 46
 * 给定正整数数组arr，arr[i]代表货币金额，arr[i]可以使用任意张，求搞定target钱有多少种方法？
 * @author reyco
 *
 */
public class Test7 {

	public static void main(String[] args) {
		int[] arr = RandomArrayFactory.createRandomArray(10, 10);
		RandomArrayFactory.print(arr);
		long start = System.currentTimeMillis();
		System.out.println(ways(arr,50));
		long end = System.currentTimeMillis();
		System.out.println("end-start:"+(end-start));
		
		long start1 = System.currentTimeMillis();
		System.out.println(ways1(arr,50));
		long end1 = System.currentTimeMillis();
		System.out.println("end1-start1:"+(end1-start1));
		
		long start2 = System.currentTimeMillis();
		System.out.println(ways2(arr,50));
		long end2 = System.currentTimeMillis();
		System.out.println("end2-start2:"+(end2-start2));
		
		long start3 = System.currentTimeMillis();
		System.out.println(ways3(arr,50));
		long end3 = System.currentTimeMillis();
		System.out.println("end3-start3:"+(end3-start3));
	}
	/**
	 * 暴力递归
	 * @param arr
	 * @param target
	 * @return
	 */
	public static int ways(int[] arr,int target) {
		return process(arr, 0, target);
	}
	/**
	 * 暴力递归
	 * @param arr
	 * @param index	索引位置
	 * @param rest	剩余钱数
	 * @return
	 */
	private static int process(int[] arr,int index,int rest) {
		if(rest<0) {
			return 0;
		}
		if(index==arr.length) {
			return rest==0 ? 1 : 0;
		}
		int ans = 0;
		for(int z=0;arr[index]*z<=rest;z++) {
			ans += process(arr, index+1, rest-arr[index]*z);
		}
		return ans;
	}
	/**
	 * 暴力递归+记忆化搜索
	 * @param arr
	 * @param target
	 * @return
	 */
	public static int ways1(int[] arr,int target) {
		int[][] dp = new int[arr.length+1][target+1];
		for (int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				dp[i][j] = -1;
			}
		}
		return process1(arr, 0, target,dp);
	}
	/**
	 * 暴力递归+记忆化搜索
	 * @param arr
	 * @param index	索引位置
	 * @param rest	剩余钱数
	 * @return
	 */
	private static int process1(int[] arr,int index,int rest,int[][] dp) {
		if(dp[index][rest]!=-1) {
			return dp[index][rest];
		}
		if(rest<0) {
			dp[index][rest] = 0;
		}else if(index==arr.length) {
			dp[index][rest] = rest==0 ? 1 : 0;
		}else {
			int ans = 0;
			for(int z=0;arr[index]*z<=rest;z++) {
				ans += process1(arr, index+1, rest-arr[index]*z,dp);
			}
			dp[index][rest] = ans;
		}
		return dp[index][rest];
	}
	/**
	 * 动态规划
	 * @param arr
	 * @param target
	 * @return
	 */
	public static int ways2(int[] arr,int target) {
		int[][] dp = new int[arr.length+1][target+1];
		dp[arr.length][0] = 1;
		for(int index=arr.length-1;index>=0;index--) {
			for (int rest=0;rest<=target;rest++) {
				int ans = 0;
				for(int z=0;arr[index]*z<=rest;z++) {
					ans += dp[index+1][rest-arr[index]*z];
				}
				dp[index][rest] = ans;
			}
		}
		return dp[0][target];
	}
	/**
	 * 动态规划
	 * @param arr
	 * @param target
	 * @return
	 */
	public static int ways3(int[] arr,int target) {
		int[][] dp = new int[arr.length+1][target+1];
		dp[arr.length][0] = 1;
		for(int index=arr.length-1;index>=0;index--) {
			for (int rest=0;rest<=target;rest++) {
				dp[index][rest] = dp[index+1][rest];
				if(rest-arr[index]>=0) {
					dp[index][rest] += dp[index][rest-arr[index]];
				}
			}
		}
		return dp[0][target];
	}
}
