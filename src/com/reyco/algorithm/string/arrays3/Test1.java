package com.reyco.algorithm.string.array3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 48
 * 给定一个整数数组arr,求差值为k的去重数字对.
 * arr=[2,3,5,7,0,1]  k=2
 * 答： 1,用Map记录数组中所有的值,遍历数组arr[i]到map中查询有没有差值为2的数，有就是我们要的结果；
 *    2,arr[i]遍历后直接移除；
 * @author reyco
 *
 */
public class Test1 {
	
	public static void main(String[] args) {
		int[] arr = {2,3,5,7,0,1};
		List<int[]> list = get(arr, 2);
		for (int[] is : list) {
			System.out.println("["+is[0]+","+is[1]+"]");
		}
	}
	public static List<int[]> get(int[] arr,int k){
		List<int[]> result = new ArrayList<int[]>();
		Map<Integer,Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], arr[i]);
		}
		for (int i = 0; i < arr.length; i++) {
			if(map.containsKey(arr[i]+k)) {
				int[] temp = {arr[i],arr[i]+k};
				result.add(temp);
			}
			if(map.containsKey(arr[i]-k)) {
				int[] temp = {arr[i]-k,arr[i]};
				result.add(temp);
			}
			map.remove(arr[i]);
		}
		return result;
	}
}
