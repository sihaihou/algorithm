package com.reyco.algorithm.sort;

//间隔==4
//第一个
//9, 6,11,3, 5, 12,8,7, 10, 15,14,4, 1 ,13,2  
//1, 6,11,3, 5, 12,8,7, 9, 15,14,4, 10 ,13,2  
//第二个
//1, 6, 11,3,5, 12, 8,7,9, 15, 14,4,10 ,13, 2 
//1, 6, 11,3,5, 12, 8,7,9, 13, 14,4,10 ,15, 2
//第三个
//1,6, 11, 3,5,12, 8, 7,9,13, 14, 4,10,15, 2
//1,6, 2, 3,5,12, 8, 7,9,13, 11, 4,10,15, 14
//第四个
//1,6,2, 3, 5,12,8, 7, 9,13,11, 4, 10,15,14
//1,6,2, 3, 5,12,8, 4, 9,13,11, 7, 10,15,14

//间隔==2
//第一个
//1,6,2,3,5,12,8,4,9,13,11,7,10,15,14
//1,6,2,3,5,12,8,4,9,13,10,7,11,15,14
//第二个
//1,6,2,3,5,12,8,4,9,13,10,7,11,15,14
//1,3,2,4,5,6,8,7,9,12,10,13,11,15,14

//间隔==1
//1,3,2,4,5,6,8,7,9,12,10,13,11,15,14
//1,2,3,4,5,6,7,8,9,10,11,12,13,14,15
/**
 * shell排序(插入排序优化版)------先分组,分组遍历有序；组的大小除于2,组的大小等于1排序后就整体有序了
 * 时间复杂度： O(N²)
 * 空间复杂度： O(1)
 * 稳定性： 	无
 * @author reyco
 *
 */
public class ShellSort {

	public static void main(String[] args) {
		int[] arr = {9,6,11,3,5,12,8,7,10,15,14,4,1,13,2};
		sort(arr);
		print(arr);
	}
	public static void sort(int[] arr) {
		int gapSize=4;
		while(gapSize<=arr.length/3) {
			gapSize = gapSize*3+1;
		}
		for (int gap=gapSize;gap>0;gap=(gap-1)/3) {
			for (int i=gap;i<arr.length;i++) {
				for (int j=i;j>gap-1;j-=gap) {
					if(arr[j]<arr[j-gap]) {
						swap(arr, j, j-gap);
					}
				}
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
