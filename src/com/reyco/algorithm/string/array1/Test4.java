package com.reyco.lgorithm.string.array1;

/**
 * 61
 * 正数数组arr,求数组中所有元素相加和等于k的最长子数组长度。
 * @author reyco
 *
 */
public class Test4 {
	public static void main(String[] args) {
		int[] arr = {6,2,3,1,1,1,1};
		int maxLength = maxLength(arr,6);
		System.out.println(maxLength);
	}
	public static int maxLength(int[] arr,int k) {
		if(arr==null || arr.length==0 || k<0) {
			return 0;
		}
		int maxLength = 0;
		int left = 0;
		int right = 1;
		int sum = arr[0];
		while(right<arr.length && left<=right) {
			if(sum==k) {
				maxLength = Math.max(right-left, maxLength);
				if(right==arr.length-1) {
					break;
				}
				sum += arr[right];
				right++;
			}else if(sum>k) {
				sum -= arr[left];
				left++;
			}else if(sum<k){
				sum += arr[right];
				right++;
			}
		}
		return maxLength;
	}
}
