package com.reyco.algorithm.sort;

//9,6,1,3,5
//第一轮
//第1次
//6,9,1,3,5

//第二轮
//第1次
//6,1,9,3,5
//第2次
//1,6,9,3,5

//第三轮
//第1次
//1,6,3,9,5
//第2次
//1,3,6,9,5
//第3次
//1,3,6,9,5

//第四轮
//第1次
//1,3,6,5,9
//第2次
//1,3,5,6,9
//第3次
//1,3,5,6,9
//第4次
//1,3,5,6,9
/**
 * 插入排序---------保证arr[0...i]上有序
 * 时间复杂度： O(N²)
 * 空间复杂度： O(1)
 * 稳定性：     有
 * @author reyco
 *
 */
public class InsertSort {

	public static void main(String[] args) {
		int[] arr = {9,6,11,3,5,12,8,7,10,15,14,4,1,13,2};
		sort(arr);
		print(arr);
	}
	public static void sort(int[] arr) {
		//保证arr[0...i]上有序,所以i从1开始,j<=i
		for (int i=1;i<arr.length;i++) {
			//要保证j<=i
			for (int j=i;j>0;j--) {
				if(arr[j]<arr[j-1]) {
					swap(arr, j, j-1);
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
