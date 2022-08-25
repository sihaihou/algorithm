package com.reyco.sort;


/**
 * 堆排序---把数组看成一个完全二叉树
 * 每一个索引的左孩子等于 index*2+1
 * 每一个索引的右孩子等于 index*2+2
 * 每一个索引的父节点等于 (index-1)/2
 * @author reyco
 * @date 2022.08.22
 * @version v1.0.1
 */
public class HeapSort {
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,9,5,8,9,5,6,8,1};
		sort(arr);
		print(arr);
	}
	public static void sort(int[] arr) {
		if(arr==null || arr.length<2) {
			return;
		}
		for(int i=0;i<arr.length;i++) {
			heapInsert(arr, i);
		}
		int heapSize = arr.length;
		while(heapSize>1) {
			swap(arr, 0,--heapSize);
			heapify(arr, 0, heapSize);
		}
	}
	public static void heapInsert(int[] arr,int index) {
		while(arr[index] > arr[(index-1)/2]) {
			swap(arr, index, (index-1)/2);
			index = (index-1)/2;
		}
	}
	public static void heapify(int[] arr,int index,int heapSize) {
		int left = index*2+1;
		while(left < heapSize) {
			 int largest = left+1 < heapSize && arr[left+1]>arr[left] ? left+1 : left;
			 largest = arr[largest] > arr[index] ? largest : index;
			 if(largest==index) {
				 break;
			 }
			 swap(arr, largest, index);
			 index = largest;
			 left = index*2+1;
		}
	}
	private static void swap(int[] arr,int i,int j) {
		arr[j] = arr[j] ^ arr[i];
		arr[i] = arr[j] ^ arr[i];
		arr[j] = arr[j] ^ arr[i];
	}
	private static void print(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}
