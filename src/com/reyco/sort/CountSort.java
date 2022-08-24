package com.reyco.sort;

/**
 * 计数排序
 * @author reyco
 */
public class CountSort {
	public static void main(String[] args) {
		//2~9之间的数据排序
		int[] arr = {2,2,3,4,5,6,7,8,9,5};
		sort(arr,2,9);
		print(arr);
	}
	/**
	 * 稳定
	 * <pre>
	 * 		arr: 2,2,3,4,5,6,7,8,9,5
	 *           2  3  4  5  6  7  8  9           每种数类型
	 * countArr: 2, 1, 1, 2, 1, 1, 1, 1           出现的次数
	 * countArr: 2, 3, 4, 6, 7, 8, 9, 10        前数组的累加和
	 * <pre>
	 * @param arr
	 * @param minValue	最小的值   >= minValue
	 * @param maxValue  最大的值   <  maxValue
	 */
	public static void sort(int[] arr,int minValue,int maxValue) {
		int[] temp =  new int[arr.length];
		int[] countArr = new int[maxValue-minValue+1];
		for (int i=0;i<arr.length;i++) {
			countArr[arr[i]-minValue]++; 
		}
		//2, 1, 1, 2, 1, 1, 1,  1
		for(int i=1;i<countArr.length;i++) {
			countArr[i] = countArr[i] + countArr[i-1];
		}
		//2, 3, 4, 6, 7, 8, 9, 10
		for (int i=arr.length-1;i>=0;i--) {
			temp[--countArr[arr[i]-minValue]] = arr[i];
		}
		for (int i=0;i<arr.length;i++) {
			arr[i]=temp[i];
		}
		System.arraycopy(temp, 0, arr, 0, temp.length);
	}
	/**
	 * 非稳定
	 * @param arr
	 * @param minValue	最小的值   >= minValue
	 * @param maxValue  最大的值   <  maxValue
	 */
	public static void sort1(int[] arr,int minValue,int maxValue) {
		int[] temp =  new int[arr.length];
		int[] countArr = new int[maxValue-minValue+1];
		for (int i=0;i<arr.length;i++) {
			countArr[arr[i]-minValue]++; 
		}
		for (int i=0,k=0;i<countArr.length;i++) {
			while(countArr[i]-->0) {
				temp[k++] = i+minValue;
			}
		}
		for (int i=0;i<arr.length;i++) {
			arr[i]=temp[i];
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
