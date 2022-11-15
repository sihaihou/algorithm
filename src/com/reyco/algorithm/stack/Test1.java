package com.reyco.lgorithm.stack;

import com.reyco.algorithm.test.test3.RandomArrayFactory;

/**
 * 42
 * 整数数据nums,求左边比nums[i]大的，右边比nums[i]大的
 * 单调栈: 1，往栈放入链表，比栈顶小的放入之间放入，比栈顶大的，先弹出pop，获取弹出的右边比pop大的就是当前要放入的，左边比pop大的，就是栈顶链表的最后一个元素，
 * 		 2,栈中剩下的依次弹出，获取结果
 * @author reyco
 *
 */
public class Test1 {
	public static void main(String[] args) {
		int[] nums = RandomArrayFactory.createRandomArray(10, 10);
	}
}
