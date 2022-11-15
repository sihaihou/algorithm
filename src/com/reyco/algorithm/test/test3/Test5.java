package com.reyco.algorithm.test.test3;

/**
 * 51
 * 有n个打包机器从左到右一次排开，每个打包机器上有一堆物品，只能相邻位置移动，物品太大，一次只能移动一个，最少移动多少轮，可以使每个机器上的物品数量一样，如果不能做到返回-1；
 *  答： 求每一个位置至少移动多少轮。所有位置最大的就是结果。
            1) 以arr[i]为中心，左右都为正，左右最大的就是至少移动多少轮；
	    2）以arr[i]为中心，左右都为负，左右相加的和就是至少移动多少轮；
	    3）以arr[i]为中心，左右一正一负，左右绝对值最大的就是至少移动多少轮；
 * @author reyco
 *
 */
public class Test5 {
	
	public static void main(String[] args) {
		int[] arr = {18,7,6,9,8,8,14};
		int minOps = minOps(arr);
		System.out.println(minOps);
	}
	
	public static int minOps(int[] arr) {
		if(arr==null || arr.length==1) {
			return 0;
		}
		int length = arr.length;
		int sum = 0 ;
		for (int i : arr) {
			sum += i;
		}
		if(sum%length!=0) {
			return -1;
		}
		int avg = sum/length;
		int minOps = 0;
		int leftSum = 0;
		for(int i=0;i<arr.length;i++) {
			int leftRest = leftSum-i*avg;
			int rightRest = (sum-leftSum-arr[i])-(length-i-1)*avg;
			if(leftRest<0 && rightRest<0) {
				minOps = Math.max(minOps, Math.abs(leftRest)+Math.abs(rightRest));
			}else {
				minOps = Math.max(minOps, Math.max(leftRest, rightRest));
			}
			leftSum += arr[i];
		}
		return minOps;
		
	}
}
