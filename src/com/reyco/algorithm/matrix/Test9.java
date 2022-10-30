package com.reyco.algorithm.matrix;

/**
 * 返回子矩阵的最大累加和。
 * @author reyco
 *
 */
public class Test9 {

	public static void main(String[] args) {
		
	}
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
