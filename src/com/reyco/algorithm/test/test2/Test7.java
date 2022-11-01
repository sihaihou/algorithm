package com.reyco.algorithm.test.test2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * 给你两个整数元素的集合a、b,从一个集合中取出一个数放入另外一个集合中，使两个集合的平均数都增加，我们定义这个操作为magic。
 * 问最多可以进行多少种magic操作？
 * @author reyco
 *
 */
public class Test7 {

	public static void main(String[] args) {
		int[] a = createRandomArray(20);
		int[] b = createRandomArray(20);
		print(a);
		print(b);
		int maxOps = maxOps(a, b);
		System.out.println(maxOps);
	}
	public static int maxOps(int[] a,int[] b) {
		double aSum = 0;
		for (int i : a) {
			aSum += i;
		}
		double bSum = 0;
		for (int i : b) {
			bSum += i;
		}
		if(avg(aSum, a.length) == avg(bSum, b.length)) {
			return 0;
		}
		//稍大的、稍小的
		int[] more;
		int[] less;
		double moreSum;
		double lessSum;
		if(avg(aSum, a.length) > avg(bSum, b.length)) {
			more = a;
			less = b;
			moreSum = aSum;
			lessSum = bSum;
		}else {
			more = b;
			less = a;
			moreSum = bSum;
			lessSum = aSum;
		}
		//
		Arrays.sort(more);
		//去重
		Set<Integer> lessSet = new HashSet<>();
		for (Integer num : less) {
			lessSet.add(num);
		}
		int moreSize = more.length;
		int lessSize = less.length;
		int ops = 0;
		for (int i=0;i<more.length;i++) {
			double curr = more[i];
			if(curr > avg(moreSum, moreSize)
					&& curr > avg(lessSum, lessSize)
					&& lessSet.add(more[i])) {
				ops++;
				moreSize--;
				moreSum -= curr;
				lessSize++;
				lessSum += curr;
			}
		}
		return ops;
	}
	
	private static double avg(double bSum,int length) {
		return bSum/length;
	}
	/**
	 * 创建随机数据
	 * @param randomLenth
	 * @return
	 */
	private static int[] createRandomArray(int randomLenth) {
		int count = new Random().nextInt(randomLenth);
		int[] array = new int[count];
		int i=0;
		while(i < count) {
			array[i++] = new Random().nextInt(100);
		}
		return array;
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
