package com.reyco.lgorithm.string.array2;

import java.util.HashMap;
import java.util.Map;
/**
 * 28
 * 给定一个数组arr，和正数sum;
 * 返回累加和等于sum的子数组有多少个?
 * 答:累加和必须以i结尾的情况下有多个累加和等sum的子数组;求以每一个结尾的情况下的相加有多少个？
 * @author reyco
 *
 */
public class Test2 {
	public static void main(String[] args) {
		int[] arr = {2,1,5,4,6,8,2};
		int ans = subArraySum(arr, 10);
		System.out.println(ans);
	}
	
	public static int subArraySum(int[] arr,int sum) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		// key : 某一个前缀和！
		// value : 这个前缀和，出现了几次！
		Map<Integer, Integer> preSumTimesMap = new HashMap<>();
		preSumTimesMap.put(0, 1);
		// 每一步的整体和, 当你遍历到i位置，0~i整体的累加和！
		int all = 0;
		int ans = 0;
		for (int i = 0; i < arr.length; i++) {
			// 0...i的整体累加和了！1000   200   1000 - 200 = 800
			all += arr[i];
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
}
