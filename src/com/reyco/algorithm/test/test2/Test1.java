package com.reyco.algorithm.test.test2;

/**
 * 给定一个有序数组arr，代表数轴上从左到右右n个点arr[0]、arr[1]...arr[n-1],
 * 给定一个整数L，代表一根长度为L的绳子，求绳子最多能覆盖其中的几个点.
 * 答： 以arr[left]开始的最多能覆盖几个点,当right不能再往右移动了，就计算长度，left右移一格，继续看right最多能覆盖几个点；中间出现的最大值就是结果。
 * @author reyco
 *
 */
public class Test1 {

	public static void main(String[] args) {
		int[] arr = {1,3,4,6,7,9,10,13,14,17,19,21,22,23,24,25,26,27,28,29,30};
		int maxPoint = maxPoint(arr, 10);
		System.out.println(maxPoint);
	}
	public static int maxPoint(int[] arr,int L) {
		int max = 0 ;
		int count = 0 ;
		int left = 0;
		int right = 0;
		while(left<=right && right<arr.length) {
			if(arr[right]-arr[left]<=L) {
				count++;
				right++;
			}else {
				max = Math.max(max, count);
				left++;
				count = (right-1)-left+1;
			}
		}
		return max;
	}
	
}
