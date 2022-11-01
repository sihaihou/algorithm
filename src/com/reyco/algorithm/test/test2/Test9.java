package com.reyco.algorithm.test.test2;

/**
 * 给定一个整数数组arr,求如果排序之后，相邻两数的最大差值，要求时间复杂的O(N),且要求不能使用非基于比较的排序。
 * @author reyco
 *
 */
public class Test9 {

	public static void main(String[] args) {
		int[] arr = {1,5,9,7,8,14,6,6,3};
		int maxDifference = maxDifference(arr);
		System.out.println(maxDifference);
	}
	public static int maxDifference(int[] arr) {
		if(arr==null || arr.length<2) {
			return 0;
		}
		int length = arr.length;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			int num = arr[i];
			max = Math.max(max,num);
			min = Math.min(min, num);
		}
		if(max == min) {
			return 0;
		}
		boolean[] hasNum = new boolean[length+1];
		int[] maxs = new int[length+1];
		int[] mins = new int[length+1];
		int bid = 0;
		for (int i = 0; i < length; i++) {
			bid = bucket(arr[i],length,min,max);
			mins[bid] = hasNum[bid] ? Math.min(mins[bid], arr[i]) : arr[i];
			maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], arr[i]) : arr[i];
			hasNum[bid] = true;
		}
		int res = 0;
		int lastMax = maxs[0];
		for (int i = 0; i <= length; i++) {
			if(hasNum[i]) {
				res = Math.max(res, mins[i]-lastMax);
				lastMax = maxs[i];
			}
		}
		return res;
	}
	private static int bucket(int num, int length, int min, int max) {
		return (int)((num-min)*length/(max-min));
	}
	
}
