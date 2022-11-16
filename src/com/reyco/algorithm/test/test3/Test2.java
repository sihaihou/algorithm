package com.reyco.algorithm.test.test3;

/**
 * 38-39
 * N皇后问题
 * @author reyco
 *
 */
public class Test2 {
	public static void main(String[] args) {
		int n = 18;
		long start = System.currentTimeMillis();
		int num = num(n);
		System.out.println(num);
		long end = System.currentTimeMillis();
		System.out.println("end-start:"+(end-start));
		System.out.println("--------------------------------------");
		/*long start1 = System.currentTimeMillis();
		int num2 = num1(n);
		System.out.println(num2);
		long end1 = System.currentTimeMillis();
		System.out.println("end1-start1:"+(end1-start1));*/
	}
	/**
	 * 暴力递归
	 * @param n
	 * @return
	 */
	public static int num(int n) {
		int[] record = new int[n];
		return process(n, record, 0);
	}
	private static int process(int n,int[] record,int index) {
		if(index==n) {
			return 1;
		}
		int ans = 0;
		for (int j=0;j<n;j++) {
			if(isVaild(record,index,j)) {
				record[index] = j; 
				ans += process(n, record, index+1);
			}
		}
		return ans;
	}
	/**
	 * 是否有效的
	 * @param record
	 * @param index
	 * @param j
	 * @return
	 */
	private static boolean isVaild(int[] record,int index,int j) {
		for (int i=0;i<index;i++) {
			if(record[i]==j || Math.abs(record[i]-j)==Math.abs(index-i)) {
				return false;
			}
		}
		return true;
	}
	/**
	 * 位运算加速
	 * @param n
	 * @return
	 */
	public static int num1(int n) {
		int limit = n==32 ? -1 : (1<<n)-1; 
		return process1(limit, 0, 0, 0);
	}
	private static int process1(int limit,int colLim,int leftLim,int rightLim) {
		if(limit==colLim) {
			return 1;
		}
		int pos = limit & (~(colLim | leftLim | rightLim));
		int ans = 0;
		int mostRightOne = 0;
		while(pos!=0) {
			mostRightOne = pos & (~pos+1);
			pos = pos - mostRightOne;
			ans += process1(limit, colLim|mostRightOne, (leftLim|mostRightOne)<<1, (rightLim|mostRightOne)>>>1);
		}
		return ans;
	}

	
}
