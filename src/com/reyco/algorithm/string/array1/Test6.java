package com.reyco.lgorithm.string.array1;

/**
 * 55
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *   分析: ends[i]有效区内，表示所有长度为i+1的最长递增子序列的最小结尾是多少？
 * 答： 方法1： N^2的方法： 生成dp数组，dp[i]表示以arr[i]结尾最长递增子序列长度是多少？
                   生成dp[i]时，在dp[0~i-1]中找到小于等于arr[i]的最大值+1.
               
       方法2:  ends[i]表示长度为i+1的最长子序列的最小结尾是多少？
              在ends有效区中二分查找大于nums[i]最左的位置，更新ends这个位置上的数;dp[i]等于在ends数组中连通自己有几个数；
	      如果没有找到大于nums[i]的数，就扩充有效区，dp[i]等于在ends数组中连通自己有几个数；
	      
             第一步：数组ends[endIndex]大于nums[i],那么dp[i] = (endIndex+1)+1;
 *	 	    数组ends[endIndex]<=于nums[i],找到大于等于nums[i]的最小索引，dp[i] = 最小索引+1,同时更新ends的最小索引位置的value=nums[i]；
 *	     第二部：查找dp[i]的最大值
 *     方法2(用TreeMap替换ends数组): map.key最小结尾的值，value是最小结尾的长度，
 		TreeMap中找大于nums[i]的key，如果没有添加到TreeMap中，value等于TreeMap的大小加1；如果有先移除，在添加，value等于老的值，dp[i]的值等于当前TreeMap的大小。
 * @author reyco
 *
 */
public class Test6 {
	
	public static void main(String[] args) {
		int[] nums = {7,7,7,7,7,7,7};
		int maxLength = maxLenght(nums);
		System.out.println(maxLength);
	}
	/**
	 *   分析: ends[i]有效区内，表示所有长度为i+1的最长递增子序列的最小结尾是多少？
	 * 第一步：数组ends[endIndex]大于nums[i],那么dp[i] = (endIndex+1)+1;
	 * 		数组ends[endIndex]<=于nums[i],找到大于等于nums[i]的最小索引，dp[i] = 最小索引+1,同时更新ends的最小索引位置的value=nums[i]；
	 * 第二部：查找dp[i]的最大值
	 * @param nums
	 * @return
	 */
	public static int maxLenght(int[] nums) {
		int[] ends = new int[nums.length];
		int[] dp = new int[nums.length];
		ends[0] = nums[0];
		dp[0]=1;
		int endIndex = 0;
		for (int i=1;i<nums.length;i++) {
			if(nums[i]>ends[endIndex]) {
				dp[i] = (endIndex+1)+1;
				ends[++endIndex] = nums[i];
			}else {
				int f = findLength(ends, endIndex, nums[i]);
				dp[i] = f;
				ends[f-1] = nums[i];
			}
		}
		int maxLength = 0;
		for (int i : dp) {
			maxLength = Math.max(maxLength, i);
		}
		return maxLength;
	}
	/**
	 * 在ends数组中找到大于等于target的最小的前缀长度
	 * ends=[1,2,3,4,5,7,8,9] target=6
	 *   输出：6。   大于等于target的最小的数为7,索引为5.
	 * @param ends
	 * @param endIndex
	 * @param num
	 * @return
	 */
	private static int findLength(int[] ends,int endIndex,int target) {
		if(endIndex<0) {
			return 0;
		}
		int L = 0;
		int R = endIndex;
		while(L<=R) {
			int mid = ((R-L)>>1)+L;
			if(ends[mid]==target) {
				return mid+1;
			}else if(((mid-1)>=0 && ends[mid-1]<target && ends[mid]>target)
					 || (mid-1)<0 && ends[mid]>target){
				return mid+1;
			}else if(ends[mid]>target) {
				R = mid-1;
			}else {
				L = mid+1;
			}
		}
		return 0;
	}
}
