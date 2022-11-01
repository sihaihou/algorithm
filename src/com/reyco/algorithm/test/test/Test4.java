package com.reyco.algorithm.test.test2;

/**
 * 给定一个长度为n的数组arr,把它分割为左右两个部分，求左右部分最大值的差的最大化？
 * 答：找出数组最大值，第一种情况：当最大值处于左边时，使右边只有1个数；第二种情况：当最大值处于右边时，使左边只有1个数；返回两种情况的最大值。
 * @author reyco
 *
 */
public class Test4 {
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,9,8,7};
		int maxDifference = maxDifference(arr);
		System.out.println(maxDifference);
	}
	public static int maxDifference(int[] arr) {
		int max = 0;
		for (int i : arr) {
			max = Math.max(max, i);
		}
		int ans = Math.max(max-arr[0], max-arr[arr.length-1]);
		return ans;
	}
}
