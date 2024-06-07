package com.reyco.algorithm.sort;

/**
 * 33
 * 堆排
 * 
 * @author reyco
 *
 */
public class HeapSort {

	public static void main(String[] args) {
		int[] arr = {9,6,11,3,5,12,8,7,10,15,14,4,1,13,2};
		sort(arr);
		print(arr);
	}

	public static void sort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		/*for (int i = 0; i < arr.length; i++) {
			heapInsert(arr, i);
		}*/
		for(int i=arr.length-1;i>=0;i--) {
			heapify(arr, i, arr.length);
		}
		print(arr);
		int heapSize = arr.length;
		while (heapSize > 1) {
			swap(arr, 0, --heapSize);
			heapify(arr, 0, heapSize);
		}
	}
	/**
	 * heapInsert
	 * 
	 * @param arr
	 * @param index
	 */
	public static void heapInsert(int[] arr, int index) {
		while (arr[index] > arr[(index - 1) / 2]) {
			swap(arr, index, (index - 1) / 2);
			index = (index-1)/2;
		}
	}

	/**
	 * 是否需要
	 * 
	 * @param arr
	 * @param index
	 * @param heapSize
	 */
	public static void heapify(int[] arr, int index, int heapSize) {
		// left孩子
		int left = index * 2 + 1;
		while (left < heapSize) {
			// 左右稍大的孩子
			int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
			// 左右稍大的孩子 和 父比较
			largest = arr[largest] > arr[index] ? largest : index;
			// 是自己
			if (largest == index) {
				break;
			}
			//
			swap(arr, largest, index);
			// index回到稍大的
			index = largest;
			// 重新算left孩子
			left = index * 2 + 1;
		}
	}

	/**
	 * 数组索引交换位置
	 * 
	 * @param arr
	 * @param i
	 * @param j
	 */
	private static void swap(int[] arr, int i, int j) {
		arr[i] = arr[i] ^ arr[j];
		arr[j] = arr[i] ^ arr[j];
		arr[i] = arr[i] ^ arr[j];
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
