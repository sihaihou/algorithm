package com.reyco.algorithm.string.array1;

/**
 * 61
 * 数组arr,有正、有负、有零,求数组中所有元素相加和小于或等于k的最长子数组长度。
 *  答： 
 *     第一步：生成minSumArr,minSumArrEnd 例: arr[1,2,5,-4,3,-1], minSumArr[1,2,1,-4,2,-1], minSumArrEnd[0,1,3,3,5,5]  
 *	          minSumArr[i]表示必须从i出发到右的所有情况中，能得到的最小累加和是多少？
 *                minSumArrEnd[i]表示必须从i出发到右的所有情况中，最小累加和的右边界是多少？

 *     第二步：      
 * @author reyco
 *
 */
public class Test5 {
	
	public static void main(String[] args) {
		int[] arr = {-1,-2,4,5,7,8,10,-12,-3,7};
		int maxLength = maxLength(arr, 20);
		System.out.println(maxLength);
	}
	public static int maxLength(int[] arr,int k) {
		//最小和
		int[] minSumArr = new int[arr.length];
		//最小和的下标到达的位置
		int[] minSumArrEnd = new int[arr.length];
		minSumArr[arr.length-1] = arr[arr.length-1];
		minSumArrEnd[arr.length-1] = arr.length-1;
		for (int i=arr.length-2;i>=0;i--) {
			if(minSumArr[i+1]<0) {
				minSumArr[i] = arr[i]+minSumArr[i+1];
				minSumArrEnd[i] = minSumArrEnd[i+1];
			}else {
				minSumArr[i] = arr[i];
				minSumArrEnd[i] = i;
			}
		}
		//
		int sum = 0;
		int end = 0;
		int maxLength = 0;
		//i是窗口最左的位置，end是是窗口最右位置的下一个位置
		for (int i=0;i<arr.length;i++) {
			//以i开头的情况下，累计和<=k的最长子数组是arr[i...end-1],看看这个数组长度能不能更新maxLength
			while(end < arr.length && sum + minSumArr[end] <= k) {
				sum += minSumArr[end];
				end = minSumArrEnd[end]+1;
			}
			maxLength = Math.max(end-i,maxLength);
			if(end>i) {     //窗口还有数
				sum -= arr[i];
			}else {  //窗口没有数了，说明从i开头的所有子数组累加和都不可能<=k
				end = i+1;
			}
		}
		return maxLength;
	}
}
