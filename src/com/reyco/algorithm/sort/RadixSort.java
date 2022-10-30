package com.reyco.algorithm.sort;

import java.util.Arrays;

//471,562,149,258,369,689,359,489
//按个位排序
//471,562,258,149,369,689,359,489
//按+位排序
//149,258,359,471,562,369,689,489
//按百位排序
//149,258,359,369,471,489,562,689,
/**
 * 基数排序
 * @author reyco
 */
public class RadixSort {
	public static void main(String[] args) {
		//2~9之间的数据排序
		int[] arr = {471,562,149,258,369,689,359,489};
		sort(arr,3);
		print(arr);
	}
	/**
	 * 稳定
	 * @param arr
	 * @param minValue	最小的值   >= minValue
	 * @param maxValue  最大的值   <  maxValue
	 */
	public static void sort(int[] arr,int maxLength) {
		int[] temp =  new int[arr.length];
		int[] countArr = new int[10];
		for(int i=0;i<maxLength;i++) {
			int division = (int)Math.pow(10, i);
			for(int j=0;j<arr.length;j++) {
				int num = arr[j]/division%10;
				countArr[num]++;
			}
			for(int j=1;j<countArr.length;j++) {
				countArr[j] = countArr[j]+countArr[j-1];
			}
			for (int j=arr.length-1;j>=0;j--) {
				int num = arr[j]/division%10;
				temp[--countArr[num]] = arr[j];
			}
			System.arraycopy(temp, 0, arr, 0, arr.length);
			Arrays.fill(countArr, 0);
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
