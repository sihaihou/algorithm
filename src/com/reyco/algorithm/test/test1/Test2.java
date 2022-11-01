package com.reyco.algorithm.test.test1;

import java.util.Random;

/**
 * 给定一个正数数组arr,表示每个小朋友的得分；
 * 任何连个相邻的小朋友如果得分一样,怎么分糖果无所谓,
 * 但如果得分不一样,分数多的一定要比分数少的多拿一些糖果,
 * 要求:
 * 假设所有的小朋友做成一个环形,返回在不破坏上一条规则的情况下,需要的最少糖果数?
 * @author reyco
 *
 */
public class Test2 {
	public static void main(String[] args) {
		//int[] arr = createRandomArray(10);
		int[] arr = {3,4,5,6,8,6,2};
		print(arr);
		//int minSugar = minCandyAnnular(arr);
		int minSugar = minCandyArr(arr);
		System.out.println(minSugar);
	}
	/**
	 * 环形坐法
	 * @param arr
	 * @return
	 */
	public static int minCandyAnnular(int[] arr) {
		if(arr==null || arr.length==0) {
			return 0;
		}
		if(arr.length==1) {
			return 1;
		}
		int length = arr.length;
		//转换数组类型
		int minIndex = 0;
		for (int i=0;i<length;i++) {
			if(i==0) {
				if(arr[i]<=arr[length-1] && arr[i]<=arr[1]) {
					minIndex=i;
					break; 
				}
			}else if(i==length-1) {
				if(arr[i]<=arr[0] && arr[i]<=arr[i-1]) {
					minIndex=i;
					break; 
				}
			}else if(arr[i]<=arr[i-1] && arr[i]<=arr[i+1]) {
				minIndex=i;
				break; 
			}
		}
		int[] temp = new int[length + 1];
		for (int i = 0; i <= length; i++, minIndex = nextIndex(minIndex, length)) {
			temp[i] = arr[minIndex];
		}
		print(temp);
		//转换好了,开始列行操作
		//左完了
		int[] left = new int[length+1];
		left[0] = 1;
		for (int i=1;i<=length;i++) {
			left[i] = temp[i]>temp[i-1] ? left[i-1]+1 : 1;
		}
		print(left);
		//右完了
		int[] right = new int[length+1];
		right[length] = 1;
		for (int i=length-1;i>=0;i--) {
			right[i] = temp[i]>temp[i+1] ? right[i+1]+1 : 1;
		}
		//计数糖果数
		int candy = 0;
		for(int i = 0; i < length; i++) {
			candy += Math.max(left[i], right[i]);
		}
		print(right);
		return candy;
	}
	/**
	 * 计数普通数组方式
	 * @param arr
	 * @return
	 */
	public static int minCandyArr(int[] arr) {
		int length = arr.length;
		int[] left = new int[length];
		left[0] = 1;
		for (int i=1;i<length;i++) {
			left[i]=arr[i]>arr[i-1]?left[i-1]+1:1;
		}
		//print(left);
		int result = 0;
		int[] right = new int[length];
		right[length-1] = 1;
		for (int i=length-2;i>=0;i--) {
			right[i]=arr[i]>arr[i+1]?right[i+1]+1:1;
		}
		int candy = 0;
		for(int i = 0; i < length; i++) {
			int max = Math.max(left[i], right[i]);
			candy += max;
		}
		//print(right);
		return candy;
	}
	public static int nextIndex(int i, int n) {
		return i == n - 1 ? 0 : (i + 1);
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
	 * 创建随机数据
	 * @param randomLenth
	 * @return
	 */
	private static int[] createRandomArray(int randomLenth) {
		Random random = new Random();
		int count = random.nextInt(randomLenth);
		int[] array = new int[count];
		int i=0;
		while(count-->0 && i < count) {
			array[i++] = random.nextInt(10);
		}
		return array;
	}
}
