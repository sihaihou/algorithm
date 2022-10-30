package com.reyco.algorithm.matrix;

/**
 * 用顺时针螺旋的方式打印矩阵，如：
 * 	{
 * 		{0,  1, 2,  3}
 * 		{11, 12,13, 4}
 * 		{10, 15,14, 5}
 * 		{9,  8,  7, 6}
 *  }
 *  打印顺序:0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
 * @author reyco
 *
 */
public class Test4 {
	
	public static void main(String[] args) {
		int[][] matrix = {
				  		{0 , 1, 2,  3},
				  		{11, 12,13, 4},
				  		{10, 15,14, 5},
				  		{9,  8,  7, 6}
				   };
		printMatrix(matrix);
		
	}
	
	public static void printMatrix(int[][] matrix) {
		int x1=0;
		int y1=0;
		int x2=matrix.length-1;
		int y2=matrix[0].length-1;
		while(x1<=x2 && y1<=y2) {
			print(matrix, x1++, y1++, x2--, y2--);
		}
	}
	
	private static void print(int[][] matrix,int x1,int y1,int x2,int y2) {
		if(x1==x2) { // 同一行
			for (int y=y1;y<y2;y++) {
				System.out.print(matrix[x1][y]+" ");
			}
		}else if(y1==y2) {
			for (int x=x1;x<x2;x++) {
				System.out.print(matrix[x][y1]+" ");
			}
		}else {
			for (int y=y1;y<y2;y++) {
				System.out.print(matrix[x1][y]+" ");
			}
			for (int x=x1;x<x2;x++) {
				System.out.print(matrix[x][y2]+" ");
			}
			for (int y=y2;y>y1;y--) {
				System.out.print(matrix[x2][y]+" ");
			}
			for (int x=x2;x>x1;x--) {
				System.out.print(matrix[x][y1]+" ");
			}
		}
	}
}
