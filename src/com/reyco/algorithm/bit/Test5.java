package com.reyco.algorithm.bit;

/**
 * 判断一个数是不是2、4的幂次方
 * @author reyco
 *
 */
public class Test5 {
	
	public static void main(String[] args) {
		for(int i=0;i<1000000;i++) {
			if(f2_1(i) && f2_2(i)) {
				System.out.println("2的幂次方"+i);
			}
			if(f4_1(i)) {
				System.out.println("4的幂次方"+i);
			}
		}
	}
	/**
	 * 2的幂次方
	 * @param num
	 * @return
	 */
	public static boolean f2_1(int num) {
		int mostRightOne = 0;
		int times = 0;
		while(num!=0) {
			mostRightOne = num & (~num+1);
			num = num-mostRightOne;
			times++;
		}
		return times==1;
	}
	/**
	 * 2的幂次方
	 * @param num
	 * @return
	 */
	public static boolean f2_2(int num) {
		if(num<1) {
			return false;
		}
		while(num!=1 && num!=0) {
			if(num%2!=0) {
				return false;
			}
			num = num/2;
		}
		return true;
	}
	/**
	 * 2的幂次方
	 * @param num
	 * @return
	 */
	public static boolean f4_1(int num) {
		if(num<1) {
			return false;
		}
		while(num!=1 && num!=0) {
			if(num%4!=0) {
				return false;
			}
			num = num/4;
		}
		return true;
	}
}
