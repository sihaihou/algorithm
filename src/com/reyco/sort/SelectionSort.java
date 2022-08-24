package com.reyco.sort;


//9,6,11,3,5,12,8,7,10,15,14,4,1,13,2
//第1轮
//1,6,11,3,5,12,8,7,10,15,14,4,9,13,2
//第2轮
//1,2,11,3,5,12,8,7,10,15,14,4,9,13,6
//第3轮
//1,2,3,11,5,12,8,7,10,15,14,4,9,13,6
//第4轮
//1,2,3,4,5,12,8,7,10,15,14,11,9,13,6
//第5轮
//1,2,3,4,5,12,8,7,10,15,14,11,9,13,6
//第6轮
//1,2,3,4,5,6,8,7,10,15,14,11,9,13,12
//第7轮
//1,2,3,4,5,6,7,8,10,15,14,11,9,13,12
//第8轮
//1,2,3,4,5,6,7,8,10,15,14,11,9,13,12
//第9轮
//1,2,3,4,5,6,7,8,9,15,14,11,10,13,12
//第10轮
//1,2,3,4,5,6,7,8,9,10,14,11,15,13,12
//第11轮
//1,2,3,4,5,6,7,8,9,10,11,14,15,13,12
//第12轮
//1,2,3,4,5,6,7,8,9,10,11,12,15,13,14
//第13轮
//1,2,3,4,5,6,7,8,9,10,11,12,13,15,14
//第14轮
//1,2,3,4,5,6,7,8,9,10,11,12,13,14,15
/**
 * 选择排序
 * 时间复杂度  big O(N²)
 * @author reyco
 *
 */
public class SelectionSort {
	
	public static void main(String[] args) {
		int[] arr = {9,6,11,3,5,12,8,7,10,15,14,4,1,13,2};
		sort(arr);
		print(arr);
	}
	public static void sort(int[] arr) {
		for (int i=0;i<arr.length;i++) {
			int min = i;
			boolean flag = true;
			for (int j=i+1;j<arr.length;j++) {
				if(arr[min]>arr[j]) {
					min = j;
					flag=false;
				}
			}
			if(!flag) {
				swap(arr, min, i);
			}
		}
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
	/**
	 * 数组索引交换位置
	 * @param arr
	 * @param i
	 * @param j
	 */
	private static void swap(int[] arr,int i,int j) {
		int temp = arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
}
