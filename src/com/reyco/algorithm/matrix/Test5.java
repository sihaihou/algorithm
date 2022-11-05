package com.reyco.algorithm.matrix;

/**
 * 给定一个正方形矩阵，只用有限几个变量，实现矩阵中，每个位置的数顺时针旋转90度，如：
 * 	{
 * 		{0,  1, 2,  3}
 * 		{11, 12,13, 4}
 * 		{10, 15,14, 5}
 * 		{9,  8,  7, 6}
 *  }
 * 旋转后：
 *  {
 * 		{9, 10, 11, 0}
 * 		{8, 15, 12, 1}
 * 		{7, 14, 13, 2}
 * 		{6,  5,  4, 3}
 *  }
 * @author reyco
 *
 */
public class Test5 {
	
	public static void main(String[] args) {
		int[][] matrix = {
				  		{0,  1, 2,  3},
				  		{11, 12,13, 4},
				  		{10, 15,14, 5},
				  		{9,  8,  7, 6}
				   };
		rotateMatrix(matrix);
		System.out.println();
	}
	
	public static void rotateMatrix(int[][] matrix) {
		int x1=0;
		int y1=0;
		int x2=matrix.length-1;
		int y2=matrix[0].length-1;
		while(x1<x2) {
			//左上往右下移动，右下往左上移动
			rotate(matrix, x1++, y1++, x2--, y2--);
		}
	}
	
	private static void rotate(int[][] matrix,int x1,int y1,int x2,int y2) {
		for(int i=0;i<y2-y1;i++) {
			int temp = matrix[x1][y1+i];
			matrix[x1][y1+i] = matrix[x2-i][y1];//i组第一个位置
			matrix[x2-i][y1] = matrix[x2][y2-i];//i组第四个位置
			matrix[x2][y2-i] = matrix[x1+i][y2];//i组第三个位置
			matrix[x1+i][y2] = temp;            //i组第二个位置
		}
	}
}
