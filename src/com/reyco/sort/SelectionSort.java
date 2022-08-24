package com.reyco.sort;


/** 
 *	排序第一种：选择排序
 *	时间复杂度  big O(N²)
 * @author  reyco
 * @date    2022.08.24
 * @version v1.0.1 
 */
public class SelectionSort {
	public static void main(String[] args) {
		int[] arr = {5,3,4,8,2,9};
		sort(arr);
	}
	public static void sort(int[] arr) {
		for(int i=0;i<arr.length-1;i++) {
			int minIndex = i;
			for(int j=i+1;j<arr.length;j++) {
				if(arr[j]<arr[minIndex]) {
					minIndex =j;
				}
			}
			if(minIndex!=i) {
				swap(arr, i, minIndex);
				print(arr);
			}
		}
	}
	private static void swap(int[] arr, int i,int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	private static void print(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}
