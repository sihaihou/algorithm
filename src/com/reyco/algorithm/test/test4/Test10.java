package com.reyco.algorithm.test.test4;

/**
 * 64
 *	给你一个数num,返回可以有多少种裂开方法
 *	1   （1）
 *  2 （1 1） （2）  
 *  3 （1 1 1） （1 2）  （3）
 *  4 （1 1 1 1） （1 1 2） （1 3） （2 2） （4）
 * @author reyco
 *
 */
public class Test9 {
	
	public static void main(String[] args) {
		int ways = ways(4);
		System.out.println(ways);
	}
	
	public static int ways(int num) {
		if(num<1) {
			return 0;
		}
		return process(1, num);
	}
	
	public static int process(int prev,int num) {
		if(num==0) {
			return 1;
		}
		if(prev>num) {
			return 0;
		}
		int ways = 0;
		for (int i=prev;i<=num;i++) {
			ways += process(i, num-i);
		}
		return ways;
	}
}
