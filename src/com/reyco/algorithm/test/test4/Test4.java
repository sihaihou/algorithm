package com.reyco.algorithm.test.test4;

/**
 * 62
 * 给定一个二维矩阵matrix，小Q操纵蛇从最左侧出发，每次只能向右上、右、右下走一步，即可获得该位置上的数值，任何情况达到负值就停止，蛇有一次改变节点值变成相反数。
 * 问小Q的蛇最长是多少？
 * @author reyco
 *
 */
public class Test4 {
	public static void main(String[] args) {
		int[][] matrix = {
				{1,-2,3},
				{-4,5,6},
				{7,-8,9}
			};
		int maxLength = maxLength(matrix);
		System.out.println(maxLength);
	}
	public static int maxLength(int[][] matrix) {
		int ans = Integer.MIN_VALUE;
		for (int x = 0; x < matrix.length; x++) {
			for (int y = 0; y < matrix[0].length; y++) {
				Info curr = process(matrix, x, y);
				ans = Math.max(ans, Math.max(curr.no, curr.yes));
			}
		}
		return ans;
	}
	private static Info process(int[][] matrix,int x,int y) {
		if(y==0) {
			return new Info(matrix[x][y], -matrix[x][y]);
		}
		int preNo = -1;
		int preYes = -1;
		//左上
		if(x>0) {
			Info leftUp = process(matrix, x-1, y-1);
			if(leftUp.no>=0) {
				preNo = leftUp.no;
			}
			if(leftUp.yes>=0) {
				preYes = leftUp.yes;
			}
		}
		//左
		Info left = process(matrix, x, y-1);
		if(left.no>=0) {
			preNo = Math.max(preNo, left.no);
		}
		if(left.yes>=0) {
			preYes = Math.max(preYes, left.yes);
		}
		//左下
		if(x<matrix.length-1) {
			Info leftDown = process(matrix, x+1, y-1);
			if(leftDown.no>=0) {
				preNo = Math.max(preNo, leftDown.no);
			}
			if(leftDown.yes>=0) {
				preYes = Math.max(preYes, leftDown.yes);
			}
		}
		int no = -1;
		int yes = -1;
		if(preNo>=0) {
			no = preNo+matrix[x][y];
			yes = preYes+(-matrix[x][y]);
		}
		if(preYes>=0) {
			yes = Math.max(yes, preYes+matrix[x][y]);
		}
		
		return new Info(no,yes);
	}
	public static class Info{
		public int no;
		public int yes;
		public Info(int no, int yes) {
			super();
			this.no = no;
			this.yes = yes;
		}
	}
}
