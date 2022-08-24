package com.reyco.sort;

//9, 6, 11, 3, 5, 12, 2, 7, 10, 15, 14, 4, 1, 13, 8 
//随机找一个数当轴,小于等于这个轴的放左边，大于轴的放右边。
//                    8
//6,3,5,2,7,4,1              9,11,12,10,15,14,13 
/**
 * 快速排序
 * @author reyco
 *
 */
public class QuickSort {

	public static void main(String[] args) {
		int[] arr = { 9, 6, 11, 3, 5, 12, 2, 7, 10, 15, 14, 4, 1, 13, 8 };
		//int[] arr = { 7,3,2,8,1,9,5,4,6,10};
		sort(arr,0,arr.length-1);
		print(arr);
	}

	public static int[] sort(int[] arr, int leftBound, int rightBound) {
		if (leftBound >= rightBound) {
			return arr;
		}
		int mid = partition(arr, leftBound, rightBound);
		sort(arr, leftBound, mid-1);
		sort(arr, mid+1, rightBound);
		return arr;
	}
	private static int partition(int[] arr, int leftBound, int rightBound) {
		int pivot = arr[rightBound];
		int li = leftBound;
		int ri = rightBound-1;
		while(li <= ri) {
			System.out.println("---");
			while(li <= ri && arr[li]<=pivot) {
				li++;
			}
			while(li <= ri && arr[ri]>pivot) {
				ri--;
			}
			if(li<ri) {
				swap(arr, li, ri);
			}
		}
		swap(arr, li, rightBound);
		return li;
	}
	/**
	 * 打印数组
	 * 
	 * @param arr
	 */
	private static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	/**
	 * 数组索引交换位置
	 * 
	 * @param arr
	 * @param i
	 * @param j
	 */
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
