package com.reyco.algorithm.huffman;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 38
 * 给定一个正整数数组arr,arr[i]表示这个人要分的金条数，arr数组的和就是整个金条的大小，求分割的最小代价？
 * 例: arr[10,20,30] 最优分割，60的金条先分割成[30,30],分割代价是60,再把30的金条分割[10,20],分割代价是30，总的分割代价是90.
 * 答：哈夫曼编码问题
 * @author reyco
 *
 */
public class Test1 {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9};
		int minMoney = minMoney(arr);
		System.out.println(minMoney);
	}
	public static int minMoney(int[] arr) {
		PriorityQueue<Integer> heap = new PriorityQueue<>(new MinHeapComparator());
		for (int i = 0; i < arr.length; i++) {
			heap.add(arr[i]);
		}
		int sum = 0;
		while(heap.size()>1) {
			int curr = heap.poll()+heap.poll();
			sum += curr;
			heap.add(curr);
		}
		return sum;
	}
	public static class MinHeapComparator implements Comparator<Integer>{
		@Override
		public int compare(Integer o1, Integer o2) {
			return 01-o2;
		}
	}
}
