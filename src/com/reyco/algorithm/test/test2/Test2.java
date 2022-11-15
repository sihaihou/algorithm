package com.reyco.algorithm.test.test2;

import java.util.Random;

/**
 * 给定一个函数f，可以等概率返回1~5的数字其中一个，请加工出等概率返回1~7的数字其中一个的函数。
 * 答：先生成等概率返回0和1，在等概率返回1到7: 1~7二进制位3位，先等概念生成0-6,再+1
 * @author reyco
 *
 */
public class Test2 {

	public static void main(String[] args) {
		for(int i=0;i<100;i++) {
			int ans = r07();
			System.out.println(ans);
		}
	}
	/**
	 * 概率返回0或7
	 * @return
	 */
	public static int r07() {
		int res = 0;
		do {
			res = (r01()<<2) + (r01()<<1) + r01();
		}while(res==7);
		return res+1;
	}
	
	/**
	 * 概率返回0或1
	 * @return
	 */
	public static int r01() {
		int res = 0;
		do {
			res = f();
		}while(res==3);
		return (res<3) ? 0 : 1;
	}
	
	/**
	 * 概率返回1~5
	 * @return
	 */
	public static int f() {
		return (int)(new Random().nextInt(5)+1);
	}
	
}
