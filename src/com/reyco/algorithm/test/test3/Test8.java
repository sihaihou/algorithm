package com.reyco.algorithm.test.test3;

/**
 *  65
 * 有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
 * 现在要求你戳破所有的气球。戳破第 i 个气球，你可以获得 nums[i - 1] * nums[i] * nums[i + 1] 枚硬币。 
 * 这里的 i - 1 和 i + 1 代表和 i 相邻的两个气球的序号。如果 i - 1或 i + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。
 *	 求所能获得硬币的最大数量。
 *	示例 1：
 *	输入：nums = [3,1,5,8]
 *	输出：167
 *	解释：
 *	nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
 *	coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167
 *
 * 答：arr[L~R]范围上尝试：都尝试最后打爆
 *
 *
 * @author reyco
 *
 */
public class Test8 {
	
	public static void main(String[] args) {
		int[] nums = {1,5};
		//int[] nums = {3,1,5,8};
		int max = max(nums);
		System.out.println(max);
	}
	public static int max(int[] nums) {
		if(nums==null || nums.length==0) {
			return 0;
		}
		if(nums.length==1) {
			return nums[0];
		}
		//3,1,5,8--->1,3,1,5,8,1
		int[] newNums = new int[nums.length+2];
		newNums[0] = 1;
		newNums[nums.length+1] = 1;
		for (int i = 0; i < nums.length; i++) {
			newNums[i+1] = nums[i];
		}
		//处理arr[L~R上范围]
		return process(newNums, 1, nums.length);
	}
	/**
	 * 保证L和 R一定没有被打爆
	 * @param nums
	 * @param L
	 * @param R
	 * @return
	 */
	private static int process(int[] nums,int L,int R) {
		if(L==R) { //如果L~R上只有一个气球
			return nums[L-1] * nums[L] * nums[L+1];
		}
		//最后打爆nums[L]的方案，和最后打爆nums[R]的方案，先比较一下。
		int max = Math.max(
				nums[L-1]*nums[L]*nums[R+1]+process(nums, L+1, R), //最后打爆L
				nums[L-1]*nums[R]*nums[R+1]+process(nums, L, R-1));//最后打爆R
		//尝试中间位置的气球被打爆的每一种方案。
		for (int i = L+1; i < R; i++) {
			// nums[L-1]*nums[i]*nums[R+1]: 中间
			// process(nums, L, i-1)前一部分  
			// process(nums, i+1, R)后一部分
			max = Math.max(max, nums[L-1]*nums[i]*nums[R+1]+process(nums, L, i-1)+process(nums, i+1, R));
		}
		return max;
	}
}
