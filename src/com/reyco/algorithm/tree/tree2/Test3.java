package com.reyco.algorithm.tree.tree2;

/**
 * 48
 * 给你一个非负正整数n,代表二叉树的节点个数，返回能形成多少种不同的二叉树结构
 * @author reyco
 *
 */
public class Test3 {

	public static void main(String[] args) {
		int ways = ways(10);
		System.out.println(ways);
	}
	/**
	 * 方法数
	 * @param n
	 * @return
	 */
	public static int ways(int n) {
		return process(n);
	}
	private static int process(int n) {
		if(n<0) {
			return 0;
		}
		if(n==0 || n==1) {
			return 1;
		}
		if(n==2) {
			return 2;
		}
		int ans = 0;
		for (int leftNums=0;leftNums<=n-1;leftNums++) {
			int leftWays = process(leftNums);
			int rightWays = process(n-leftNums-1);
			ans += leftWays * rightWays;
		}
		return ans;
	}
}
