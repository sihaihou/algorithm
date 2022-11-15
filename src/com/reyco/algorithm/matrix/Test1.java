package com.reyco.algorithm.matrix;

/**
 * 50
 * 给定M×N矩阵，每一行、每一列都按升序排列，请编写代码找出某元素。
 * 答：从右上开始，等于目标值直接返回true，小于目标值往下方走，大于目标向左走，如果越界，则不存在，返回false。
 * @author reyco
 *
 */
public class Test1 {
	
	public static void main(String[] args) {
		int[][] matrix = {
		  {1,   4,  7, 11, 15},
		  {2,   5,  8, 12, 19},
		  {3,   6,  9, 16, 22},
		  {10, 13, 14, 17, 24},
		  {18, 21, 23, 26, 30}
		};
		for (int i=1;i<35;i++) {
			boolean isExeit = searchMatrix(matrix, i);
			System.out.println(isExeit);
			if(!isExeit) {
				System.out.println("fail");
				break;
			}
		}
	}
	public static boolean searchMatrix(int[][] matrix, int target) {
		int x = 0;
		int y = matrix[0].length-1;
		while(x<matrix.length && y>=0) {
			if(matrix[x][y]==target) {
				return true;
			}
			if(matrix[x][y]>target) {
				y--;
			}else {
				x++;
			}
		}
		return false;
    }
}
