package com.reyco.algorithm.tree.tree2;

/**
 * 已知一棵二叉树中没有重复节点，滨崎给定了这棵树的先序遍历数组和中序遍历数组，返回后续遍历数组。
 * 比如：
 *  pre: [1,2,4,5,3,6,7]
 *  in:  [4,2,5,1,6,3,7]
 *  返回
 *       [4,5,2,6,7,3,1]
 * @author reyco
 *
 */
public class Test6 {
	
	public static void main(String[] args) {
		int[] pre = {1,2,4,5,3,6,7};
		int[] in = {4,2,5,1,6,3,7};
		int[] pos = pos(pre, in);
		print(pos);
	}
	public static int[] pos(int[] pre,int[] in) {
		if(pre==null) {
			return null;
		}
		int N = pre.length;
		int[] pos = new int[N];
		process(pre, 0, N-1, in, 0, N-1, pos, 0, N-1);
		return pos;
	}
	
	public static void process(int[] pre,int prei,int prej,
			                   int[] in,int ini,int inj,
			                   int[] pos,int posi,int posj) {
		if(prei>prej) {
			return;
		}
		if(prei==prej) {
			pos[posi] = pre[prei];
			return;
		}
		pos[posj] = pre[prei]; 
		int find = ini;
		for(;find<=inj;find++) {
			if(in[find] == pre[prei]) {
				break;
			}
		}
		process(pre, prei+1, prei+find-ini, in,ini, find-1,pos,posi, posi+find-ini-1);
		process(pre, prei+find-ini+1, prej, in, find+1, inj, pos, posi+find-ini, posj-1);
	}
	/**
	 * 打印数组
	 * 
	 * @param arr
	 */
	private static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
