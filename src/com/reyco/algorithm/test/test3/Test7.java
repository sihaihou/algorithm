package com.reyco.algorithm.test.test3;

import java.util.Arrays;

/**
 * 52
 * 给定一个正整数数组drinks，drinks[i]代表每个人喝完咖啡准备刷刷杯子的时间。
 * 只有一个咖啡机，一次只能洗一个杯子，时间耗费A,洗完才能洗下一个杯子；
 * 每个杯子也可以自己挥发干净，时间耗费B,咖啡被可以并行挥发。
 * 返回让所有咖啡被变干净的最早完成时间？
 * @author reyco
 *
 */
public class Test7 {
	public static void main(String[] args) {
		int[] drinks = RandomArrayFactory.createRandomArray(10, 20);
		Arrays.sort(drinks);
		RandomArrayFactory.print(drinks);
		int A = 2;
		int B = 5;
		System.out.println(min(drinks, A, B));
		System.out.println(min1(drinks, A, B));
	}
	public static int min(int[] drinks,int A,int B) {
		Arrays.sort(drinks);
		return process(drinks, A, B, 0, 0);
	}
	/**
	 * 暴力递归
	 * @param drinks	需要洗干净的杯子
	 * @param A			洗一个杯子时间
	 * @param B			挥发时间
	 * @param index		当前来到的杯子，（0-index-1）已经搞定了
	 * @param washLine  洗咖啡机来到的时间点，表示这个时间之后才有时间
	 * @return
	 */
	private static int process(int[] drinks,int A,int B,int index,int washLine) {
		int N = drinks.length;
		//只有一杯
		if(index == N-1) {
			return Math.min(Math.max(washLine,drinks[index])+A,drinks[index]+B);
		}
		//index决定洗
		int wash = Math.max(washLine,drinks[index])+A;
		int nextWash1 = process(drinks, A, B, index+1, wash);
		int p1 = Math.max(wash, nextWash1);
		//index决定挥发
		int dry = drinks[index]+B;
		int nextWash2 = process(drinks, A, B, index+1, washLine);
		int p2 = Math.max(dry, nextWash2);
		
		//洗和挥发取最小值
		return Math.min(p1, p2);
	}
	/**
	 * 
	 * @param drinks
	 * @param A
	 * @param B
	 * @return
	 */
	public static int min1(int[] drinks,int A,int B) {
		Arrays.sort(drinks);
		int N = drinks.length;
		if(A>=B) {
			return drinks[N-1]+B;
		}
		//washLine的                      可能最大值
		int limit = 0;
		for (int i=0;i<N;i++) {
			limit = Math.max(limit, drinks[i])+A;
		}
		int[][] dp = new int[N][limit+1];
		//
		for(int washLine=0;washLine<=limit;washLine++) {
			dp[N-1][washLine] = Math.min(
					Math.max(washLine,drinks[N-1])+A,
					drinks[N-1]+B);
		}
		for(int index=N-2;index>=0;index--) {
			for(int washLine=0;washLine<=limit;washLine++) {
				//index决定洗
				int p1 = Integer.MAX_VALUE;
				int wash = Math.max(washLine,drinks[index])+A;
				if(wash<=limit) {
					p1 = Math.max(wash, dp[index+1][wash]);
				}
				//index决定挥发
				int dry = drinks[index]+B;
				int p2 = Math.max(dry, dp[index+1][washLine]);
				
				//洗和挥发取最小值
				dp[index][washLine] = Math.min(p1, p2);
			}
		}
		return dp[0][0];
	}
}
