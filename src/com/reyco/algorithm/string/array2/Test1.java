package com.reyco.lgorithm.string.array2;

/**
 * 54
 * 返回子数组的最大累加和
 * @author reyco
 *
 */
public class Test1 {

	public static void main(String[] args) {
		int[] nums = {1,2,-1,-2,4,-5,8,9,-1,3};
		int maxSum = maxSum(nums);
		System.out.println(maxSum);
	}
	public static int maxSum(int[] nums) {
		int curr = 0;
		int max = Integer.MIN_VALUE;
		for (int i : nums) {
			curr += i;
			max = Math.max(max, curr);
			curr = curr<0 ? 0 : curr;
		}
		return max;
	}
}
