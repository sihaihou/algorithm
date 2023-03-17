package com.reyco.algorithm.test.test4;

/**
 * 45
 * 有正数数组arr，arr[i]代表这个硬币的金额，求组成target有多少种方法？
 * @author reyco
 *
 */
public class Test6 {
	
	public static void main(String[] args) {
		//int[] arr = {2,3,7,8,1,9};
		int[] arr = {2,3,7,9,1};
		int ways1 = ways1(arr, 10);
		System.out.println(ways1);
		int ways2 = ways2(arr, 10);
		System.out.println(ways2);
		int ways3 = ways3(arr, 10);
		System.out.println(ways3);
	}
	/**
	 * 暴力递归
	 * @param arr
	 * @param rest
	 * @return
	 */
	public static int ways1(int[] arr,int rest) {
		return process1(arr, 0, rest);
	}
	public static int process1(int[] arr,int index,int rest) {
		if(rest<0) {
			return 0;
		}
		if(index==arr.length) {
			return rest==0 ? 1 : 0;
		}
		return process1(arr, index+1, rest-arr[index]) + process1(arr, index+1, rest);
	}
	
	/**
	 * 暴力递归+记忆搜索法
	 * @param arr
	 * @param rest
	 * @return
	 */
	public static int ways2(int[] arr,int rest) {
		int[][] dp = new int[arr.length+1][rest+1];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				dp[i][j] = -1;
			}
		}
		return process2(arr, 0, rest,dp);
	}
	public static int process2(int[] arr,int index,int rest,int[][] dp) {
		if(rest<0) {
			return 0;
		}
		if(dp[index][rest]!=-1) {
			return dp[index][rest];
		}
		if(index==arr.length) {
			dp[index][rest] = rest==0 ? 1 : 0;
			return dp[index][rest];
		}
		dp[index][rest] = process2(arr, index+1, rest-arr[index],dp) + process2(arr, index+1, rest,dp);
		return dp[index][rest];
	}

	/**
	 * 动态规划
	 * @param arr
	 * @param rest
	 * @return
	 */
	public static int ways3(int[] arr,int rest) {
		int N = arr.length;
		int[][] dp = new int[N+1][rest+1];
		/**
		 * if(index==arr.length) {
		 *		return rest==0 ? 1 : 0;
		 * }
		 * 从下往上
		 */
		for (int i = 0; i <= rest; i++) {
			dp[N][i] = 0;
			if(i==0) {
				dp[N][i] = 1;
			}
		}
		//从下往上,第N行已经弄过了，从第N-1行开始
		for (int i = N-1; i>=0; i--) {
			for (int j = 0; j<dp[i].length; j++) {
				dp[i][j] = dp[i+1][j];
				/**
				 * process1(arr, index+1, rest-arr[index]) + process1(arr, index+1, rest)
				 * dp[i][j]等于下方的值加上dp[i+1][j-arr[i]]位置的值
				 */
				//保证下标不越界
				if(j-arr[i]>=0) {
					dp[i][j] += dp[i+1][j-arr[i]];
				}
			}
		}
		return dp[0][rest];
	}
}
