package com.reyco.algorithm.matrix;

/**
 * 矩阵用zigzag的方法打印矩阵，如：
 *  {
 * 		{0,  1,  2,  3}
 * 		{10, 11, 12, 4}
 * 		{9,  8,  7,  5}
 *  }
 *  打印：0 1 10 9 11 2 3 12 8 7 4 5
 * @author reyco
 *
 */
public class Test6 {
	
	public static void main(String[] args) {
		int[][] matrix =  {
				  		{0,  1,  2,  3},
				  		{10, 11, 12, 4},
				  		{9,  8,  7,  5}
				   };
		printZigzag(matrix);
	}
	
	public static void printZigzag(int[][] matrix) {
		int x1=0;
		int y1=0;
		int x2=0;
		int y2=0;
		int xLength = matrix.length;
		int yLength = matrix[0].length;
		boolean upToDown = false;
		while(x1!=xLength) {
			print(matrix, upToDown, x1, y1, x2, y2);
			x1 = y1==yLength-1 ? x1+1 : x1;
			y1 = y1==yLength-1 ? y1 : y1+1;
			y2 = x2==xLength-1 ? y2+1 : y2;
			x2 = x2==xLength-1 ? x2 : x2+1;
			upToDown = !upToDown;
		}
		
	}
	
	private static void print(int[][] matrix,boolean upToDown,int x1,int y1,int x2,int y2) {
		if(upToDown) {
			while(x1!=x2+1) {
				System.out.println(matrix[x1++][y1--]+" ");
			}
		}else {
			while(x2!=x1-1) {
				System.out.println(matrix[x2--][y2++]+" ");
			}
		}
	}
}
