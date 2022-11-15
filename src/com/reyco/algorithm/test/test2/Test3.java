package com.reyco.algorithm.test.test2;

/**
 * 52
 * 给定 n个非负整数表示每个宽度为 1的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 例如：[0,1,0,2,1,0,1,3,2,1,2,1] 输出：6
 * 答：双指针从最左和最右开始，左右两边谁的最大值谁小谁先结算。arr[i] = Math.max(0,Math.min(leftMax,rightMax)-arr[i])
 * @author reyco
 *
 */
public class Test3 {
	
	public static void main(String[] args) {
		//int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};//6
		//int[] height = {4,2,0,3,2,5};//9
		int[] height = {2,0,2};//2
		int maxWater = maxWater(height);
		System.out.println(maxWater);
	}
	/**
	 * 双指针从最左和最右开始，左右两边谁的最大值最小谁先结算。arr[i] = Math.max(0,Math.min(leftMax,rightMax)-arr[i])
	 * @param height
	 * @return
	 */
	public static int maxWater(int[] height) {
		int length = height.length;
		//返回值
		int maxWater = 0;
		//左边最大值
		int leftMax = height[0];
		//右边最大值
		int rightMax = height[length-1];
		//左右指针
		int L = 1;
		int R = height.length-2;
		while(L<=R) {
			if(height[L]>=leftMax) {
				leftMax = height[L];
				L++;
			}else if(height[R]>=rightMax) {
				rightMax = height[R];
				R--;
			}else if(leftMax>rightMax) {
				maxWater += rightMax-height[R];
				R--;
			}else if(leftMax<rightMax) {
				maxWater += leftMax-height[L];
				L++;
			}else {
				if(L==R) {
					maxWater += rightMax-height[R];
					break;
				}else {
					maxWater += leftMax-height[L];
					maxWater += rightMax-height[R];
					L++;
					R--;
				}
			}
		}
		return maxWater;
	}
	
}
