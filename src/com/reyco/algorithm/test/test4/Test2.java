package com.reyco.algorithm.test.test4;

/**
 * 41
 * 有一片1连接在一起就是一个岛屿，求一个矩阵右多少个岛屿？
 * 可以优化成多线程并行执行
 * @author reyco
 *
 */
public class Test2 {
	public static void main(String[] args) {
		int[][] m = {
				{0,1,0,0,0,1,0,1},
				{0,1,1,0,0,1,1,1},
				{0,1,0,1,0,0,1,0},
				{0,0,1,0,0,1,0,1},
				{0,1,1,1,0,0,1,1},
				{0,1,0,1,0,1,1,1},
				{0,1,0,1,0,1,0,0},
				};
		System.out.println(m[0][1]);
		int countIslands = countIslands(m);
		System.out.println(countIslands);
	}
	public static int countIslands(int[][] m) {
		if(m==null || m[0]==null) {
			return 0;
		}
		int x = m.length;
		int y = m[0].length;
		int count = 0;
		for(int i=0;i<x;i++) {
			for(int j=0;j<y;j++) {
				if(m[i][j]==1) {
					count++;
					infact(m,i,j,x,y);
				}
			}
		}
		return count;
	}
	private static void infact(int[][] m, int i, int j, int x, int y) {
		if(i<0 || i>=x || j<0 || j>=y || m[i][j]!=1) {
			return;
		}
		m[i][j] = 2;
		infact(m,i+1,j,x,y);
		infact(m,i-1,j,x,y);
		infact(m,i,j+1,x,y);
		infact(m,i,j-1,x,y);
	}
}
