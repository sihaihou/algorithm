package com.reyco.algorithm.matrix;

/**
 * 二维矩阵种只有0和1，每一行0一定在1的左边，求哪行的1数量最多。
 * 答：从右上角开始遇1则count++，往左移动，遇0，则计数max，并往下移动，最后计数max
 * @author reyco
 *
 */
public class Test2 {
	public static void main(String[] args) {
		int[][] matrix = {
		  {0, 0, 0, 0, 1},
		  {0, 1, 1, 1, 1},
		  {0, 0, 1, 1, 1},
		  {1, 1, 1, 1, 1},
		  {0, 0, 0, 0, 0}
		};
		int max = max(matrix);
		System.out.println(max);
	}
	public static int max(int[][] matrix) {
		int max = 0;
		int count = 0;
		int x = 0;
		int y = matrix[0].length-1;
		while(x<matrix.length && y>=0) {
			if(matrix[x][y]==1) {
				count++;
				y--;
			}else {
				max = Math.max(max, count);
				x++;
			}
		}
		return Math.max(max, count);
    }
}
