package com.reyco.algorithm.matrix;

/**
 * 中-1
 * 给定一个由 0 和 1 组成的矩阵 matrix ，返回边框全是1的最大正方形边的边长长度。
 * 答：1，预处理生成从下往上连续1的数量；从右往左连续1的数量；2，三层for循环找到所有的边，根据预处理的结果找到都是1的边，返回最大的边
 * @author reyco
 *
 */
public class Test3 {
	
	public static void main(String[] args) {
		int[][] matrix = {
					{1,0,1,0,0},
					{1,0,1,1,1},
					{1,1,1,1,1},
					{1,0,0,1,0}
				};
		int maxBorder = maxBorder(matrix);
		System.out.println(maxBorder);
	}
	
	public static int maxBorder(int[][] matrix) {
		int x = matrix.length;
		int y = matrix[0].length;
		//预处理rightOne：rightOne[x][i]右边有多少个连续的1
		int[][] rightOne = new int[x][y];
		//预处理downOne：downOne[i][y]下边有多少个连续的1
		int[][] downOne = new int[x][y];
		prepare(matrix,rightOne,downOne);
		
		//处理
		int maxBorder = 0;
		for (int row=0;row<x;row++) {
			for (int col=0;col<y;col++) {
				for (int border=1;border<=Math.min(x-row, y-col);border++) {
					if(rightOne[row][col]>=border 
							&& downOne[row][col]>=border
							&& rightOne[row+border-1][col]>=border
							&& downOne[row][col+border-1]>=border
							) {
						maxBorder = Math.max(maxBorder, border);
					}
				}
			}			
		}
		return maxBorder;
	}
	private static void prepare(int[][] matrix,int[][] rightOne,int[][] downOne) {
		int x = matrix.length;
		int y = matrix[0].length;
		//预处理rightOne：rightOne[x][i]右边有多少个连续的1
		for(int row=0;row<x;row++) {
			int count = 0;
			for(int col=y-1;col>=0;col--) {
				if(matrix[row][col]==0) {
					count=0;
				}else {
					count++;
				}
				rightOne[row][col] = count;
			}
		}
		//预处理downOne：downOne[i][y]下边有多少个连续的1
		for(int col=0;col<y;col++) {
			int count = 0;
			for(int row=x-1;row>=0;row--) {
				if(matrix[row][col]==0) {
					count=0;
				}else {
					count++;
				}
				downOne[row][col] = count;
			}
		}
	}
}
