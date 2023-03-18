package com.reyco.algorithm.test.test3;

/**
 *  81
 * 给定两个长度为N的正数数组weight和values，
 * weight[i]和values[i]分别代表货物的重量和价值。
 * 给定一个正数bag,表示一个载重bag的袋子，
 * 你装的物品不能超过这个重量。
 * 返回你能装下最多的价值是多少？
 * @author reyco
 *
 */
public class Test6 {
	public static void main(String[] args) {
		int[] weight = RandomArrayFactory.createRandomArray(5,10);
		int[] values = RandomArrayFactory.createRandomArray(5,10);
		RandomArrayFactory.print(weight);
		RandomArrayFactory.print(values);
		int bag = 10;
		int max = max1(weight, values, bag);
		System.out.println(max);
		int max1 = max2(weight, values, bag);
		System.out.println(max1);
		int max2 = max3(weight, values, bag);
		System.out.println(max2);
	}
	/**
	 * 暴力递归
	 * @param weight
	 * @param values
	 * @param bag
	 * @return
	 */
	public static int max1(int[] weight,int[] values,int bag) {
		return process1(weight, values, 0, bag);
	}
	/**
	 * @param weight
	 * @param values
	 * @param index 当前来到的位置
	 * @param rest	包裹剩余载重
	 * @return
	 */
	public static int process1(int[] weight,int[] values,int index,int rest) {
		if(rest<=0) {
			return 0;
		}
		if(index==weight.length) {
			return 0;
		}
		//不要
		int p1 = process1(weight, values, index+1, rest);
		//要
		int p2 = Integer.MIN_VALUE;
		if(rest>=weight[index]) {
			p2 = values[index]+process1(weight, values, index+1, rest-weight[index]);
		}
		//取最好的
		return Math.max(p1, p2);
	}
	/**
	 * 暴力递归+记忆搜索法
	 * @param weight
	 * @param values
	 * @param bag
	 * @return
	 */
	public static int max2(int[] weight,int[] values,int bag) {
		int[][] dp = new int[weight.length][bag+1];
		for (int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				dp[i][j] = -1;
			}
		}
		return process2(weight, values, 0, bag,dp);
	}
	public static int process2(int[] weight,int[] values,int index,int rest,int[][] dp) {
		if(rest<=0 || index==weight.length) {
			return 0;
		}
		if(dp[index][rest]!=-1) {
			return dp[index][rest];
		}
		int p1 = process2(weight, values, index+1, rest,dp);
		int p2 = Integer.MIN_VALUE;
		if(rest>=weight[index]) {
			p2 = values[index]+process2(weight, values, index+1, rest-weight[index],dp);
		}
		dp[index][rest] = Math.max(p1, p2);
		return dp[index][rest];
	}
	/**
	 * 动态规划
	 * @param weight
	 * @param values
	 * @param bag
	 * @return
	 */
	public static int max3(int[] weight,int[] values,int bag) {
		int[][] dp = new int[weight.length+1][bag+1];
		for(int index=weight.length-1;index>=0;index--) {
			for(int rest=0;rest<dp[0].length;rest++) {
				int p1 = dp[index+1][rest];
				int p2 = Integer.MIN_VALUE; 
				if(rest-weight[index]>=0) {
					p2 = values[index]+dp[index+1][rest-weight[index]];
				}
				dp[index][rest] = Math.max(p1, p2);
			}
		}
		return dp[0][bag];
	}
}
