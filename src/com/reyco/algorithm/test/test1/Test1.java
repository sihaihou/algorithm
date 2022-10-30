package com.reyco.lgorithm.test.test1;

import java.util.Arrays;

/**
 * <pre>
 * [0,2,8]:  0表示这里石头没有颜色,如果变红代价是2,如果变蓝代价是8;
 * [1,x,x]:  1表示这里石头已经红色,而且不能变色,所以后两个数无意义;
 * [2,x,x]:  1表示这里石头已经蓝色,而且不能变色,所以后两个数无意义;
 * 要求:
 * 给你一批这样的数据,要求最后所有石头都有颜色,且红色和蓝色的石头数据必须相同,求最小代价?
 * 如果不能做到所有石头都有颜色并且红色和蓝色的石头数据必须相,返回-1;
 * 
 * </pre>
 * @author reyco
 *
 */
public class Test1 {
	public static void main(String[] args) {
		int[][] stones = createRandomArray();
		int cost = minCost(stones);
		System.out.println(cost);
	}

	private static int minCost(int[][] stones) {
		int length = stones.length;
		
		if((length&1)!=0) {
			return -1;
		}
		Arrays.sort(stones, (a, b) -> a[0] == 0 && b[0] == 0 ? (b[1] - b[2] - a[1] + a[2]) : (a[0] - b[0]));
		
		//多少个无色的      3  
		int zero = 0; 
		//多少个红色的      1
		int red = 0;  
		//多少个蓝色的      2
		int blue = 0; 
		//全部变成红色代价 
		int cost = 0;   
		for (int i=0;i<length;i++) {
			if(stones[i][0]==0) {
				zero++;
				cost += stones[i][1];
			}
			if(stones[i][0]==1) {
				 red++;
			}
			if(stones[i][0]==2) {
				blue++;
			}
		}
		//红色、蓝色有一个大于数据一半以上的直接返回-1;
		if (red > (length >> 1) || blue > (length >> 1)) {
			return -1;
		}
		//需要变成蓝色的数量
		blue = zero - ((length >> 1) - red); 
		for (int i = 0; i < blue; i++) {
			cost += stones[i][2] - stones[i][1];
		}
		return cost;
	}

	private static int[][] createRandomArray() {
		int[][] arr = new int[6][3];
		int[] arr0 = { 0, 8, 3 };
		arr[0]=arr0;
		int[] arr1 = { 1, 4, 2 };
		arr[1]=arr1;
		int[] arr2 = { 0, 7, 7 };
		arr[2]=arr2;
		int[] arr3 = { 0, 22, 1 };
		arr[3]=arr3;
		int[] arr4 = { 0, 5, 8 };
		arr[4]=arr4;
		int[] arr5 = { 1, 9, 4 };
		arr[5]=arr5;
		return arr;
	}
}
