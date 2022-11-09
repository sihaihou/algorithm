package com.reyco.algorithm.test.test2;

import java.util.ArrayList;
import java.util.List;

/**
 * 56、57
 * 给定一个整数数据arr,长度为n，有1<=arr[i]<=n,其中部分整数会重复出现而部分不会重复出现。找出所有未出现的数。
 * 答： 位置怼的方法
 * @author reyco
 *
 */
public class Test8 {
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,5,8,6};
		List<Integer> list = find(arr);
		System.out.println(list);
	}

	public static List<Integer> find(int[] arr) {
		if(arr==null || arr.length==0) {
			return new ArrayList<Integer>();
		}
		for (int i=0;i<arr.length;i++) {
			modify(arr,arr[i]);
		}
		List<Integer> list = new ArrayList<>();
		for (int i=0;i<arr.length;i++) {
			if(arr[i]!=i+1) {
				list.add(i+1);
			}
		}
		return list;
	}
	private static void modify(int[] arr, int value) {
		while(arr[value-1]!=value) {
			int temp = arr[value-1];
			arr[value-1] = value;
			value = temp;
		}
	}
}
