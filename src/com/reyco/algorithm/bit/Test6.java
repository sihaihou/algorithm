package com.reyco.lgorithm.bit;
/**
 * 一个正数数组，只有一种数出现了奇数次，其它数出现了偶数次,找出这个出现了奇数次的数？
 * 一个正数数组，只有两种数出现了奇数次，其它数出现了偶数次，找出这两个出现了奇数次的数？
 * 
 * @author reyco
 *
 */
public class Test6{
	public static void main(String[] args) {	
		int[] oddArr = { 5, 5, 2, 3, 4, 3, 4, 2, 9 };
		System.out.println(odd(oddArr));
		int[] evenArr = { 1,1, 2, 3, 4,4, 5,5, 9, 9 };
		System.out.println(even(evenArr));
	}

	public static int odd(int[] arr) {
		int a = 0;
		for (int i = 0; i < arr.length; i++) {
			a = a ^ arr[i];
		}
		return a;
	}
	/**
	 * 加入a和b出现奇数次
	 * @param nums
	 * @return
	 */
	public static int even(int[] nums) {
		int eor = 0;
		for (int num : nums) {
			eor ^= num;
		}
		//eor = a^b;
		//eor必然有一位是1
		int rirhtOne = eor & (~eor + 1);// 找到最右边为1的数
		int eor1 = 0;
		for (int cur : nums) {
			if ((cur & rirhtOne) != 0) { // 筛选出那一位上为1或者0的数
				eor1 ^= cur;
			}
		}
		System.out.println("第一个数：" + eor1 + ",第二个数：" + (eor ^ eor1));
		return eor ^ eor1;
	}
}
