package com.reyco.algorithm01;

import java.util.HashMap;
import java.util.Map;

/** 
 * <pre>
 * 给定一个数组;
 * 要求：
 * 	 返回累加和等于sum的子数组有多少个？
 * </pre>
 * @author  reyco
 * @date    2022.08.23
 * @version v1.0.1 
 */
public class Test04 {
	/**                             1     1
	 * int[] arr = {2, 2, -3, 3, 4, 2, 7, 3, 4, 5, 2};  10
	 *              2  4   1  4  8  10 17 20 24 29 31
	 *  10-8=9          
	 *  17-4=13            
	 * @author  reyco
	 * @date    2022年8月23日
	 * @version v1.0.1 
	 * @param args
	 */
	public static void main(String[] args) {
		//int[] arr = {2, 2, -3, 3, 4, 2, 7, 3, 4, 5, 2};
		int[] arr = {10, -10, 10, 10};
 		int minShip = matchSubArr(arr, 20);
 		System.out.println(minShip);
 		int subarraySum = subarraySum(arr, 20);
		System.out.println(subarraySum);
	}
	public static int subarraySum(int[] nums, int sum) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		// key : 某一个前缀和！
		// value : 这个前缀和，出现了几次！
		Map<Integer, Integer> preSumTimesMap = new HashMap<>();
		preSumTimesMap.put(0, 1);
		// 每一步的整体和, 当你遍历到i位置，0~i整体的累加和！
		int all = 0;
		int ans = 0;
		for (int i = 0; i < nums.length; i++) {
			// 0...i的整体累加和了！1000   200   1000 - 200 = 800
			all += nums[i];
			if (preSumTimesMap.containsKey(all - sum)) {
				ans += preSumTimesMap.get(all - sum);
			}
			// 0....i 这个前缀和，一定要去！更新map！
			if (!preSumTimesMap.containsKey(all)) {
				preSumTimesMap.put(all, 1);
			} else {
				preSumTimesMap.put(all, preSumTimesMap.get(all) + 1);
			}
		}
		return ans;
	}
	/**
	 * @author  reyco
	 * @date    2022年8月23日
	 * @version v1.0.1 
	 * @return
	 */
	public static int matchSubArr(int[] arr,int sum) {
		print(arr);
		int length = arr.length;
		int[] temp = new int[length];
		for(int i=0;i<length;i++) {
			if(i==0) {
				temp[i]= arr[i];
			}else {
				temp[i] = arr[i]+temp[i-1];
			}
		}
		print(temp);
		int match = 0;
		for(int i=length-1;i>=0;i--) {
			if(i==0) {
				if(temp[i]==sum) {
					match++;
				}
			}else {
				if(temp[i]==sum) {
					match++;
				}
				int j = i-1;
				while(j>=0) {
					if(temp[i]-temp[j--]==sum) {
						match++;
					}
				}
			}
		}
		return match;
	}
	
	
	private static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
