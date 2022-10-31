package com.reyco.algorithm.gameTheory;

import com.reyco.lgorithm.recursion1.RandomArrayFactory;

/**
 * 给定一个整数数组arr，代表数值不同的纸牌排成一条线,玩家A和B依次拿走每张牌，
 * 规定玩家A先拿，玩家B后拿，但是每个玩家只能拿走最左或最右的牌，
 * 玩家A和B都绝顶聪明，请返回最后获胜者的分数。
 * @author reyco
 *
 */
public class Test1 {
	
	public static void main(String[] args) {
		int[] arr = RandomArrayFactory.createRandomArray(5, 10);
		RandomArrayFactory.print(arr);
		int grade = grade(arr);
		System.out.println(grade);
		int grade1 = grade1(arr);
		System.out.println(grade1);
	}
	public static int grade(int[] arr) {
		return Math.max(f(arr, 0, arr.length-1),s(arr, 0, arr.length-1));
	}
	public static int f(int[] arr,int L,int R) {
		if(L==R) {
			return arr[L];
		}
		return Math.max(arr[L]+s(arr,L+1,R), arr[R]+s(arr,L,R-1));
	}
	public static int s(int[] arr, int L, int R) {
		if(L==R) {
			return 0;
		}
		return Math.min(f(arr,L+1,R),f(arr,L,R-1));
	}
	
	/**
	 * 动态规划
	 * @param arr
	 * @return
	 */
	public static int grade1(int[] arr) {
		int[][] f = new int[arr.length][arr.length];
		int[][] s = new int[arr.length][arr.length];
		for(int i=0;i<arr.length;i++) {
			f[i][i] = arr[i];
		}
		for(int i=1;i<arr.length;i++) {
			int L = 0;
			int R = i;
			while(L<arr.length && R<arr.length) {
				f[L][R] = Math.max(arr[L]+s[L+1][R], arr[R]+s[L][R-1]);
				s[L][R] = Math.min(f[L+1][R],f[L][R-1]);
				L++;
				R++;
			}
		}
		return Math.max(f[0][arr.length-1],s[0][arr.length-1]);
	}
	
}
