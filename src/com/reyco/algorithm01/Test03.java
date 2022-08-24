package com.reyco.algorithm01;

import java.util.Arrays;

/** 
 * <pre>
 * 给定一个正数数组代表每一个人的体重;
 * 给定一个正数limit代表船的重载量；
 * 要求：
 * 	1,可以一个人坐一条船;
 *  2,最多只能两个人坐一条船,且总重量不能超过船的载重。
 *  3,两个人的总重量必须是偶数.
 *  问：同时坐船，最少需要多少条船？
 * </pre>
 * @author  reyco
 * @date    2022.08.23
 * @version v1.0.1 
 */
public class Test03 {
	
	public static void main(String[] args) {
		//int[] arr = {2,2,3,4,9,5,8,9,5,6,8,3};  
		int[] arr = {2,3,9};  
		//int[] arr = {2,2,3,3,6,6,7,8,8,9,9}; 
		int minShip = minShip(arr, 10);
		System.out.println(minShip);
		int minShipEven = minShipEven(arr, 10);
		System.out.println(minShipEven);
	}
	/**
	 * 最少的船数量
	 * @author  reyco
	 * @date    2022年8月23日
	 * @version v1.0.1 
	 * @return
	 */
	public static int minShipEven(int[] arr ,int limit) {
		Arrays.sort(arr);
		//
		int odd = 0;
		int even = 0;
		for (int i : arr) {
			if((i&1)==0) {
				even++;
			}else {
				odd++;
			}
		}
		int[] odds = new int[odd];
		int[] evens = new int[even];
		for (int i = arr.length-1; i >=0 ; i--) {
			if ((arr[i] & 1) == 0) {
				evens[--even] = arr[i];
			} else {
				odds[--odd] = arr[i];
			}
		}
		return minShip(odds, limit) + minShip(evens, limit);
	}
	/**
	 * 计数最少的船
	 * @author  reyco
	 * @date    2022年8月23日
	 * @version v1.0.1 
	 * @param arr
	 * @param limit
	 * @return
	 */
	public static int minShip(int[] arr ,int limit) {
		if(arr==null || arr.length==0) {
			return 0;
		}
		if(arr.length==1) {
			return 1;
		}
		//
		if(arr[arr.length-1]>limit) {
			return -1;
		}
		int length = arr.length;
		//倒数第一个小于等于limit/2
		int ltMid = -1;
		for (int i = length-1; i>=0; i--) {
			if(arr[i] <= limit>>1) {
				ltMid = i;
				break;
			}
		}
		//没有小于等于limit/2
		if(ltMid==-1) {
			//返回总长度
			return length;
		}
		//左
		int left = ltMid;
		//右
		int right = left+1;
		//没有使用的
		int noUsed = 0;
		while(left>=0) {
			//匹配数
			int match = 0;
			while(right<length && arr[left]+arr[right]<= limit) {
				right++;
				match++;
			}
			if(match==0) {
				//左边没有匹配的,那么未使用的+1;
				noUsed++;
				left--;
			}else {
				//left减去匹配数等于未匹配数
				left = Math.max(-1,left-match);
			}
		}
		//length=11 ; all=7; noUsed=5 ; used=2
		//所有小于等于limit/2的
		int all = ltMid+1;
		//已使用(匹配的)
		int used = all - noUsed; 
		//(length-all)是大于limit/2;(也是右边的)
		//右边的减去匹配的等于右边未匹配的
		int gtNoUsed = (length-all) -used;
		int minShip = used + ((noUsed+1)>>1) + gtNoUsed;
		return minShip;
	}
}
