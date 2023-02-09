package com.reyco.algorithm.matrix;

/**
 * 中-7
 * 返回子矩阵的最大累加和。
 * 答：第一步：求0行的最大累加和子矩阵、求0、1行的最大累加和子矩阵、求0~matrix[0].lenth-1行的最大累加和子矩阵；
 * 	     求1行的最大累加和子矩阵、求1、2行的最大累加和子矩阵、求1~matrix[0].lenth-1行的最大累加和子矩阵.
 *    ...
 *    第二步：子矩阵进行累加和压缩：
 *    		例：
 *    		  {
 *    			[-5,3, 6,4]
 *    			[-7,9,-5,3]
 *    			[-8,1,-3,4]
 *            }
 *            第0行、1行加起来：
 *              [-12,12,1,7]
 *            第0行、1行、2行加起来：  
 *              [-20,13,-2,11]
 *            第1行、2行加起来：  
 *              [-15,10,-8,7]
 *     第三步：求每一次的最大累加和的子矩阵。
 * @author reyco
 *
 */
public class Test9 {

	public static void main(String[] args) {
		
	}
	//时间复杂度：N²*M (N：行，M：列)
	public static int maxSum(int[][] matrix) {
		if(matrix==null || matrix.length==0 || matrix[0].length==0) {
			return 0;
		}
		int max = Integer.MIN_VALUE;
		for (int i=0;i!=matrix.length;i++) {             //开始的行号i
			int[] sumArr = new int[matrix[0].length];	 //结束的行号j,i~j的范围
			for(int j=i;j!=matrix.length;j++) {
				int curr = 0;
				for (int k=0; k!= sumArr.length; k++) {
					sumArr[k] += matrix[j][k];
					curr += sumArr[k];
					max = Math.max(max, curr);
					curr = curr<0 ? 0 : curr;
				}
				return max;
			}
		}
		return max;
	}
	
}
