package com.reyco.algorithm.sort;

import java.util.Arrays;
import java.util.Random;

public class SortCheck {
	
	private static Random random = new Random();
	
	public static void main(String[] args) {
		check(100);
	}
	public static void check(int count) {
		boolean flag = true;
		while(count-->0) {
			int[] array = createRandomArray(1000000);
			int[] customArr = new int[array.length];
			System.arraycopy(array, 0, customArr, 0, array.length);
			
			long start1 = System.currentTimeMillis();
			Arrays.sort(array);
			long end1 = System.currentTimeMillis();
			long time1 = end1-start1;
			
			
			long start2 = System.currentTimeMillis();
			//SelectionSort.sort(customArr);//选择排序
			//BubbleSort.sort(customArr); //冒泡排序
			//InsertSort.sort(customArr); //插入排序
			//ShellSort.sort(customArr);  //shell排序
			//MergeSort.sort(customArr, 0, customArr.length-1); //归并排序
			QuickSort.sort2(customArr, 0, customArr.length-1); //快排
			//CountSort.sort(customArr, 0, 999);
			//RadixSort.sort(customArr, 3);
			
			long end2 = System.currentTimeMillis();
			long time2 = end2-start2;
			//if(time2<=time1) {
				System.out.println("Arrays.sort():"+time1+",custom.sort():"+time2);
			//}
			for (int i=0;i<array.length;i++) {
				if(array[i] != customArr[i]) {
					flag = false;
					break;
				}
			}
			if(!flag) {
				break;
			}
		}
		System.out.println(flag?"OK":"fail");
	}
	/**
	 * 创建随机数据
	 * @param randomLenth
	 * @return
	 */
	private static int[] createRandomArray(int randomLenth) {
		int count = random.nextInt(randomLenth);
		int[] array = new int[count];
		int i=0;
		while(i < count) {
			array[i++] = random.nextInt(10000);
		}
		return array;
	}
	
}
