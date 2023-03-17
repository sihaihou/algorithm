package com.reyco.algorithm.test.test4;

/**
 * 45
 * 正整数数组arr代表每一枚硬币,求硬币加起来等于目标值target的最少硬币数？
 * @author reyco
 *
 */
public class Test6 {
	public static void main(String[] args) {
		int[] arr = {2,3,7,9,2};
		int minCoins1 = minCoins1(arr, 10);
		System.out.println(minCoins1);
		int minCoins2 = minCoins2(arr, 10);
		System.out.println(minCoins2);
		int minCoins3 = minCoins3(arr, 10);
		System.out.println(minCoins3);
	}
	public static int minCoins1(int[] arr,int target) {
		return process1(arr, 0,target);
	}
	public static int process1(int[] arr,int index,int target) {
		if(target<0) {
			return -1;
		}
		if(target==0) {
			return 0;
		}
		if(index==arr.length) {
			return -1;
		}
		int p1 = process1(arr, index+1, target);
		int p2 = process1(arr, index+1, target-arr[index]);
		if(p1==-1 && p2==-1) {
			return -1;
		}else {
			if(p1==-1) {
				return p2 + 1;
			}
			if(p2==-1) {
				return p1;
			}
			return Math.min(p1, p2);
		}
	}
	public static int minCoins2(int[] arr,int target) {
		int[][] dp = new int[arr.length+1][target+1];
		for(int i=0;i<=arr.length;i++) {
			for(int j=0;j<=target;j++) {
				dp[i][j] = -2;
			}
		}
		return process2(arr, 0,target,dp);
	}
	public static int process2(int[] arr,int index,int target,int[][] dp) {
		if(target<0) {
			return -1;
		}
		if(dp[index][target]!=-2) {
			return dp[index][target];
		}
		if(target==0) {
			dp[index][target] = 0;
		}else if(index==arr.length) {
			dp[index][target] = -1;
		}else {
			int p1 = process2(arr, index+1, target,dp);
			int p2 = process2(arr, index+1, target-arr[index],dp);
			if(p1==-1 && p2==-1) {
				dp[index][target] = -1;
			}else {
				if(p1==-1) {
					dp[index][target] = p2 + 1;
				}else if(p2==-1) {
					dp[index][target] = p1;
				}else {
					dp[index][target] = Math.min(p1, p2);
				}
			}
		}
		return dp[index][target];
	}
	public static int minCoins3(int[] arr,int target) {
		int N = arr.length;
		int[][] dp = new int[N+1][target+1];
		for(int index=0;index<=N;index++) {
			dp[index][0] = 0;
		}
		for(int rest=1;rest<=target;rest++) {
			dp[N][rest] = -1;
		}
		for(int index=N-1;index>=0;index--) {
			for(int rest=1;rest<=target;rest++) {
				int p1 = dp[index+1][rest];
				int p2 = -1;
				if(rest-arr[index]>=0) {
					p2 = dp[index+1][rest-arr[index]];
				}
				if(p1==-1 && p2==-1) {
					dp[index][rest] = -1;
				}else {
					if(p1==-1) {
						dp[index][rest] =  p2 + 1;
					}else if(p2==-1) {
						dp[index][rest] =  p1;
					}else {
						dp[index][rest] = Math.min(p1, p2+1);
					}
				}
			}
		}
		return dp[0][target];
	}
}
