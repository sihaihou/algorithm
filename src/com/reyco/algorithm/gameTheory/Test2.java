package com.reyco.algorithm.gameTheory;

/**
 * 有一堆草，羊每次只能吃4的n次方份，谁最后吃完剩下的草，谁赢。
 * @author reyco
 *
 */
public class Test2 {

	public static void main(String[] args) {
		for(int i=0;i<50;i++) {
			boolean winner = winner(i);
			System.out.println("i:"+i+",winner:"+winner);
		}
	}
	
	public static boolean winner(int n) {
		if(n<5) {
			return (n==0 || n==2) ? false : true;
		}
		int base = 1;
		while(base <= n) {
			if(!winner(n-base)) {
				return true;
			}
			if(base > n/4) {
				break;
			}
			base *= 4; 
		}
		return false;
	}
	
}
