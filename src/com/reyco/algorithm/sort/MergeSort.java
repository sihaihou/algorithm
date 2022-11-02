package com.reyco.algorithm.sort;

//两部分有序,变量两边，谁小谁先放入

//1,4,6,7,10,  2,3,5,8,9
//新数组第1个放进入的1,
//新数组第2个放进入的2,
//新数组第3个放进入的3,
//新数组第4个放进入的4,
//新数组第5个放进入的5,
//新数组第6个放进入的6,
//新数组第7个放进入的7,
//新数组第8个放进入的8,
//新数组第9个放进入的9,
//新数组第10个放进入的10,
/**
 * 归并排序-------两部分有序,变量两边，谁小谁先放入
 * 时间复杂度： O(N*logN)
 * 空间复杂度： O(N)
 * 稳定性：     有
 * @author reyco
 *
 */
public class MergeSort {

	public static void main(String[] args) {
		int[] arr = {1,4,7,8,3,6,9};
		sort(arr, 0, arr.length-1);
		print(arr);
	}
	public static void sort(int[] arr,int left,int right) {
		if(left==right) {
			return ;
		}
		int mid = left + (right-left)/2;
		sort(arr, left, mid);
		sort(arr, mid+1, right);
		merge(arr, left, mid+1, right);
	}
	/**
	 *
	 * {1,4,7,8,3,6,9}
	 * 1,4,7,8,3,6
	 * leftIndex = 0
	 * rightIndex = 4
	 * rightBoundIndex = 6;
	 * @param arr
	 * @param leftIndex
	 * @param rightIndex
	 * @param rightBoundIndex
	 * @return
	 */
	private static void merge(int[] arr,int leftIndex,int rightIndex,int rightBoundIndex) {
		int[] temp = new int[rightBoundIndex - leftIndex + 1];
		int mid = rightIndex-1;
		int i=leftIndex;
		int j=rightIndex;
		int index=0;
		while(i<=mid && j<=rightBoundIndex) {
			temp[index++] = arr[i]<=arr[j] ? arr[i++] : arr[j++];
		}
		while(i<=mid) {
			temp[index++] = arr[i++];
		}
		while(j<=rightBoundIndex) {
			temp[index++] = arr[j++];
		}
		for (int m=0;m<temp.length;m++) {
			arr[leftIndex+m] = temp[m];
		}
	}
	private static int[] merge1(int[] arr) {
		int[] temp = new int[arr.length];
		int mid = arr.length/2;
		int i=0;
		int j=mid+1;
		int index=0;
		while(i<=mid && j<arr.length) {
			temp[index++] = arr[i]<=arr[j] ? arr[i++] : arr[j++];
		}
		while(i<mid) {
			temp[index++] = arr[i++];
		}
		while(j<arr.length) {
			temp[index++] = arr[j++];
		}
		System.arraycopy(temp, 0, arr, 0, temp.length);
		return arr;
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
