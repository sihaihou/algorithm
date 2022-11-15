package com.reyco.algorithm.matrix;

/**
 * 51
 * 矩阵用zigzag的方法打印矩阵，如：
 *  {
 * 		{0,  1,  2,  3}
 * 		{10, 11, 12, 4}
 * 		{9,  8,  7,  5}
 *  }
 *  打印：0 1 10 9 11 2 3 12 8 7 4 5
 *  答：刚开始A,B两个点都停在[0,0]位置,A就一直往右走，走到不能往右走了，就往下走;B就一直往下走，走到不能往下走了，就往右走；每次A、B都只走一步。
 *     定义一个boolean类型的变量upToDown（是否从上往下走），每轮后upToDown取反。
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
