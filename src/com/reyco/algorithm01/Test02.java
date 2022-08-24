package com.reyco.algorithm01;

import java.util.HashMap;
import java.util.Map;

//给定一个正数数组arr，表示每个小朋友的得分
//任何两个相邻的小朋友，如果得分一样，怎么分糖果无所谓，但如果得分不一样，分数大的一定要比分数少的多拿一些糖果
//假设所有的小朋友坐成一个环形，返回在不破坏上一条规则的情况下，需要的最少糖果数
/**
 * 
 * @author  reyco
 * @date    2022.08.24
 * @version v1.0.1
 */
@SuppressWarnings("all")
public class Test02 {

	public static void main(String[] args) {
		int[] arr = createRandomArray();
		int count = minCandyRing(arr);
		System.out.println(count);
	}
	/**
	 * 环形坐法
	 * @author  reyco
	 * @date    2022年8月23日
	 * @version v1.0.1 
	 * @param arr
	 * @return
	 */
	public static int minCandyRing(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		if (arr.length == 1) {
			return 1;
		}
		int length = arr.length;
		//计数中间小的数
		int minIndex = -1;
		for (int i =0 ; i < length; i++) {
			if(i==0 && arr[i]<=arr[length-1] && arr[i]<=arr[i+1]) {
				minIndex = i;
				break;
			}else if(i==length-1 && arr[i]<=arr[0] && arr[i]<=arr[i-1]) {
				minIndex = i;
				break;
			}else if(i!=0 && i!=length-1 && arr[i]<=arr[i-1] && arr[i]<=arr[i+1]) {
				minIndex = i;
				break;
			}
		}
		int[] temp = new int[length+1];
		for(int i = 0; i <= length; i++,minIndex=nextIndex(minIndex, length)) {
			temp[i] = arr[minIndex];
		}
		print(temp);
		System.out.println();
		//左
		int[] left = new int[length+1];
		left[0] = 1;
		for (int i = 1; i <= length; i++) {
			left[i] = temp[i] > temp[i-1] ? left[i-1] + 1 : 1;
		}
		print(left);
		System.out.println();
		//右
		int[] right = new int[length+1];
		right[length] = 1;
		for (int i=length-1; i >= 0; i--) {
			right[i] = temp[i]>temp[i+1] ? right[i+1]+1 : 1;
		}
		print(right);
		//计数
		int minCandy= 0;
		for(int i = 0; i < length; i++) {
			minCandy += Math.max(left[i], right[i]);
		}
		System.out.println();
		return minCandy;
	}
	/**
	 * 列型坐法
	 * @author  reyco
	 * @date    2022年8月23日
	 * @version v1.0.1 
	 * @param arr
	 * @return
	 */
	public static int minCandyArray(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		if (arr.length == 1) {
			return 1;
		}
		int length = arr.length;
		int[] left = new int[length];
		left[0] = 1;
		for (int i = 1; i < length; i++) {
			if (arr[i] > arr[i-1]) {
				left[i] = left[i-1] + 1;
			} else {
				left[i] = 1;
			}
		}
		print(left);
		System.out.println();
		int[] right = new int[length];
		right[length-1] = 1;
		for (int i=arr.length-2; i >= 0; i--) {
			if (arr[i] > arr[i + 1]) {
				right[i] = right[i + 1] + 1;
			}else {
				right[i] = 1;
			}
		}
		print(right);
		int minCandy= 0;
		for(int i = 0; i < length; i++) {
			minCandy+=left[i]>right[i]?left[i]:right[i];
		}
		System.out.println();
		return minCandy;
	}

	private static int[] createRandomArray() {
		int[] arr = {5,3,4,8,2,9};
		return arr;
	}
	public static int nextIndex(int i, int n) {
		return i == n - 1 ? 0 : (i + 1);
	}
	private static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
