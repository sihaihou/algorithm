package com.reyco.algorithm.bit;

/**
 * 位运算基本操作
 * @author reyco
 *
 */
public class Test3 {
	public static void main(String[] args) {
		int num = 5;
		System.out.println(num+"最右的1:"+getMostRightOne(num));
		forEachMostRightOne(num);
		System.out.println(num+"个1:"+getNOne(num));
		int[] nums = {1,2,3};
		System.out.println("nums中1的并集:"+getUnionOne(nums));
		System.out.println(num+"第"+2+"位的状态:"+getIndexStatus(num,2));
		
		System.out.println("nums数组第"+32+"位的状态:"+getIndexStatue(nums,32));
		setIndexStatueOne(nums, 32);
		System.out.println("nums数组第"+32+"位的状态:"+getIndexStatue(nums,32));
		setIndexStatueZero(nums, 32);
		System.out.println("nums数组第"+32+"位的状态:"+getIndexStatue(nums,32));
	}
	
	/**
	 * 获取最右的1
	 */
	public static int getMostRightOne(int num) {
		return num & (~num+1);
	}
	/**
	 * 循环最右的1
	 * @param num
	 * @return
	 */
	public static void forEachMostRightOne(int num) {
		int pos = num;
		int mostRightOne = 0;
		while(pos!=0) {
			mostRightOne = pos & (~pos+1);
			System.out.println(pos+"最右的1:"+mostRightOne);
			pos ^= mostRightOne;
		}
	}
	/**
	 * 获取N个1
	 * @param n
	 * @return
	 */
	public static int getNOne(int N) {
		return N==32 ? -1 : (1<<N)-1;
	}
	/**
	 * 获取num中1的并集
	 * @return
	 */
	public static int getUnionOne(int[] nums) {
		int res = 0;
		for (int i : nums) {
			res |= i;
		}
		return res;
	} 
	/**
	 * 获取1的数量
	 * @param n
	 * @return
	 */
	public static int hammingWeight(int n) {
        int times = 0;
        int i = 0;
        while(i<32) {
        	if((n&(1<<i))!=0) {
        		times++;
        	}
        	i++;
        }
        return times;
    }
	/**
	 * 返回num第index位的状态（0：false，1：true）
	 * @param num
	 * @param index
	 * @return
	 */
	public static int getIndexStatus(int num,int index) {
		return (num>>(index-1))&1;
	}
	/**
	 * nums数组第index位的状态
	 * @param nums
	 * @param index
	 * @return
	 */
	public static int getIndexStatue(int[] nums,int index) {
		int numIndedx = index/32;
		int bitIndedx = index%32;
		return (nums[numIndedx]>>bitIndedx)&1;
	}
	/**
	 * nums数组第index位的设置1
	 * @param nums
	 * @param index
	 * @return
	 */
	public static void setIndexStatueOne(int[] nums,int index) {
		int numIndedx = index/32;
		int bitIndedx = index%32;
		//第index位的设置1
		nums[numIndedx] = nums[numIndedx] | (1<<bitIndedx);
	}
	/**
	 * nums数组第index位的设置0
	 * @param nums
	 * @param index
	 * @return
	 */
	public static void setIndexStatueZero(int[] nums,int index) {
		int numIndedx = index/32;
		int bitIndedx = index%32;
		//第index位的设置0
		nums[numIndedx] = nums[numIndedx] & (~(1<<bitIndedx));
	}
}
