package com.reyco.lgorithm.string.array1;

/**
 * 数组arr,有正、有负、有零,求数组中所有元素相加和小于或等于k的最长子数组长度。
 * @author reyco
 *
 */
public class Test5 {
	
	public static void main(String[] args) {
		int[] arr = {-1,-2,4,5,7,8,10,-12,-3,7};
		int maxLength = maxLength(arr, 20);
		System.out.println(maxLength);
	}
	public static int maxLength(int[] arr,int k) {
		//最小和
		int[] minSumArr = new int[arr.length];
		//最小和的下标到达的位置
		int[] minSumArrEnd = new int[arr.length];
		minSumArr[arr.length-1] = arr[arr.length-1];
		minSumArrEnd[arr.length-1] = arr.length-1;
		for (int i=arr.length-2;i>=0;i--) {
			if(minSumArr[i+1]<0) {
				minSumArr[i] = arr[i]+minSumArr[i+1];
				minSumArrEnd[i] = minSumArrEnd[i+1];
			}else {
				minSumArr[i] = arr[i];
				minSumArrEnd[i] = i;
			}
		}
		//
		int sum = 0;
		int end = 0;
		int maxLength = 0;
		for (int i=0;i<arr.length;i++) {
			while(end < arr.length && sum + minSumArr[end] <= k) {
				sum += minSumArr[end];
				end = minSumArrEnd[end]+1;
			}
			maxLength = Math.max(end-i,maxLength);
			if(end>i) {
				sum += arr[i];
			}else {
				end = i+1;
			}
		}
		return maxLength;
	}
}
