package com.reyco.algorithm.window;

import java.util.LinkedList;

/**
 * 有一个整数的数组arr和一个大小为w的窗口从数组的最左端滑动到最右端，窗口每次向右滑动一个位置。
 * 求每种窗口状态下窗口中的最大值，并以最大值的数组
 * <pre>
 * 	例如: arr{4,3,5,4,3,3,6,7}  结果：{5,5,5,4,6,7}
 * 	[4,3,5],4,3,3,6,7  	最大值 5
 * 	4,[3,5,4],3,3,6,7	最大值 5
 * 	4,3,[5,4,3],3,6,7	最大值 5
 * 	4,3,5,[4,3,3],6,7	最大值 4
 * 	4,3,5,4,[3,3,6],7	最大值 6
 * 	4,3,5,4,3,[3,6,7]	最大值 7
 * </pre>
 *  思路:
 *  	1,双端队列，大头小尾
 *  	2,先去掉过期的，在添加新加入的
 *      3,获取first最大的
 * @author reyco
 *
 */
public class Test1 {
	
	public static void main(String[] args) {
		int[] nums = {4,3,5,4,3,3,6,7};
		//int[] nums = {1,-1};
		int[] maxArr = maxArr(nums, 3);
		print(maxArr);
	}
	
	public static int[] maxArr(int[] nums,int k) {
		if(nums==null) {
			return nums;
		}
		int[] result = null;
		if(nums.length<k) {
			result = new int[1];
			int max = Integer.MIN_VALUE;
			for(int i=0;i<nums.length;i++) {
				max = Math.max(nums[i], max);
			}
			result[0] = max;
			return result;
		}
		LinkedList<Integer> queue = new LinkedList<>();
		result = new int[nums.length-k+1];
		for(int i=0;i<k;i++) {
			if(queue.isEmpty()) {
				queue.add(i);
			}else {
				while(true) {
					if(!queue.isEmpty() && nums[i]>=nums[queue.peekLast()]) {
						queue.pollLast();
					}else {
						queue.addLast(i);
						break;
					}
				}
			}
		}
		result[0] = nums[queue.peekFirst()];
		int i = 0;
		int right = k;
		int left = 0;
		while(right<nums.length && left<right) {
			if(!queue.isEmpty() && left==queue.peekFirst()) {
				queue.pollFirst();
			}
			while(true) {
				if(!queue.isEmpty() && nums[right]>=nums[queue.peekLast()]) {
					queue.pollLast();
				}else {
					queue.addLast(right);
					break;
				}
			}
			result[++i] = nums[queue.peekFirst()];
			right++;
			left++;
		}
		return result;
	}
	/**
	 * 打印数组
	 * @param arr
	 */
	private static void print(int[] arr){
		for (int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}
