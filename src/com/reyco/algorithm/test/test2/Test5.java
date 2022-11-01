package com.reyco.algorithm.test.test2;

/**
 * 给定一个数组arr，如果通过调整可以做到任意两个相邻的数字相乘是4的倍数，返回true,否则返回false.
 * 答：
 * 1: 只是2的倍数==0,   
 * 		(1)奇数==1,4的倍数>=1
 * 		(2)奇数>1,4的倍数>=奇数-1
 * 2: 只是2的倍数!=0, 4的倍数>=奇数
 * @author reyco
 *
 */
public class Test5 {
	
	public static void main(String[] args) {
		int[] arr = {2,4,6,7,8,9,10,11,12};
		boolean process = process(arr);
		System.out.println(process);
	}
	
	/**
	 * 1: 只是2的倍数==0,   
	 * 		(1)奇数==1,4的倍数>=1
	 * 		(2)奇数>1,4的倍数>=奇数-1
	 * 2: 只是2的倍数!=0, 4的倍数>=奇数
	 * @param arr
	 * @return
	 */
	public static boolean process(int[] arr) {
		//奇数数量
		int oddCount = 0;
		//只有一个2的因子
		int onlyFactor2Count = 0;
		//4的倍数
		int factor4Count = 0;
		for (int i : arr) {
			if((i&1)==1) {
				oddCount++;
			}else {
				if((i%4)==0) {
					factor4Count++;
				}else {
					onlyFactor2Count++;
				}
			}
		}
		if(onlyFactor2Count==0) {
			if(oddCount==1) {
				return factor4Count>=1;
			}else {
				return factor4Count>=oddCount-1;
			}
		}else {
			return factor4Count>=oddCount;
		}
	}
	
}
