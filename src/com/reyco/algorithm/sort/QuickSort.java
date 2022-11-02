package com.reyco.algorithm.sort;

//9, 6, 11, 3, 5, 12, 2, 7, 10, 15, 14, 4, 1, 13, 8 
//随机找一个数当轴,小于等于这个轴的放左边，大于轴的放右边。
//                    8
//6,3,5,2,7,4,1              9,11,12,10,15,14,13 
/**
 * 快速排序-----先找到一个轴，小于轴的放左边，大于轴的放右边
 * 时间复杂度： O(N*logN)
 * 空间复杂度： O(N)
 * 稳定性：     无
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
	/**
	 * 快排v3.0版本
	 * @param arr
	 * @param leftBound
	 * @param rightBound
	 * @return
	 */
	public static int[] sort(int[] arr, int leftBound, int rightBound) {
		if (leftBound >= rightBound) {
			return arr;
		}
		swap(arr, leftBound+(int)Math.random()*(rightBound-leftBound+1), rightBound);
		int[] equalArea = partition3(arr, leftBound, rightBound);
		sort(arr, leftBound, equalArea[0]-1);
		sort(arr, equalArea[1]+1, rightBound);
		return arr;
	}
	private static int[] partition3(int[] arr, int leftBound, int rightBound) {
		if(leftBound > rightBound) {
			return new int[]{-1,-1};
		}
		if(leftBound==rightBound) {
			return new int[] {leftBound,rightBound};
		}
		int lessIndex = leftBound-1;
		int moreIndex = rightBound;
		int index = leftBound;
		while(index<moreIndex) {
			if(arr[index]==arr[rightBound]) {
				index++;
			}else if(arr[index]<arr[rightBound]){
				swap(arr, index++, ++lessIndex);
			}else {
				swap(arr, index, --moreIndex);
			}
		}
		swap(arr, moreIndex, rightBound);
		return new int[] {lessIndex+1,moreIndex};
	}
	/**
	 * 快排v2.0版本
	 * @param arr
	 * @param leftBound
	 * @param rightBound
	 * @return
	 */
	public static int[] sort2(int[] arr, int leftBound, int rightBound) {
		if (leftBound >= rightBound) {
			return arr;
		}
		int[] equalArea = partition2(arr, leftBound, rightBound);
		sort2(arr, leftBound, equalArea[0]-1);
		sort2(arr, equalArea[1]+1, rightBound);
		return arr;
	}
	private static int[] partition2(int[] arr, int leftBound, int rightBound) {
		if(leftBound > rightBound) {
			return new int[]{-1,-1};
		}
		if(leftBound==rightBound) {
			return new int[] {leftBound,rightBound};
		}
		int lessIndex = leftBound-1;
		int moreIndex = rightBound;
		int index = leftBound;
		while(index<moreIndex) {
			if(arr[index]==arr[rightBound]) {
				index++;
			}else if(arr[index]<arr[rightBound]){
				swap(arr, index++, ++lessIndex);
			}else {
				swap(arr, index, --moreIndex);
			}
		}
		swap(arr, moreIndex, rightBound);
		return new int[] {lessIndex+1,moreIndex};
	}
	/**
	 * 快排v1.0版本
	 * @param arr
	 * @param leftBound
	 * @param rightBound
	 * @return
	 */
	public static int[] sort1(int[] arr, int leftBound, int rightBound) {
		if (leftBound >= rightBound) {
			return arr;
		}
		int mid = partition1(arr, leftBound, rightBound);
		sort1(arr, leftBound, mid-1);
		sort1(arr, mid+1, rightBound);
		return arr;
	}
	/**
	 * 
	 * @param arr
	 * @param leftBound
	 * @param rightBound
	 * @return
	 */
	private static int partition1(int[] arr, int leftBound, int rightBound) {
		int pivot = arr[rightBound];
		int li = leftBound;
		int ri = rightBound-1;
		while(li <= ri) {
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
