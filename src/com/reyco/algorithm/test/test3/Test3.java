package com.reyco.algorithm.test.test3;

/**
 * 46
 * 在9*10的中国象棋棋盘中马从(0,0)跳K步到达M(x,y)有多少种方法？
 * @author reyco
 *
 */
public class Test3 {
	/**
	 * x小于10
	 * y小于9
	 * @param args
	 */
	public static void main(String[] args) {
		long start1 = System.currentTimeMillis();
		int ways = ways(3, 3, 12);
		System.out.println(ways);
		long end1 = System.currentTimeMillis();
		System.out.println("end1-start1:"+(end1-start1));
		
		long start2 = System.currentTimeMillis();
		int ways1 = ways1(3, 3, 12);
		System.out.println(ways1);
		long end2 = System.currentTimeMillis();
		System.out.println("end2-start2:"+(end2-start2));
		
		
		long start3 = System.currentTimeMillis();
		int ways2 = ways2(3, 3, 12);
		System.out.println(ways2);
		long end3 = System.currentTimeMillis();
		System.out.println("end3-start3:"+(end3-start3));
		
		System.out.println(ways==ways1 && ways1==ways2);
	}
	/**
	 * 方法数
	 * @param x		目的地x轴
	 * @param y		目的地y轴
	 * @param step	跳多少步
	 * @return
	 */
	public static int ways(int x,int y,int step) {
		return process(x, y, step);
	}
	/**
	 * 暴力递归
	 * @param CX	当前位置X轴
	 * @param CY	当前位置Y轴
	 * @param step	还剩多少步
	 * @return
	 */
	private static int process(int CX,int CY,int step) {
		if(step==0) {
			return (CX==0 && CY==0) ? 1 : 0;
		}
		if(CX>9 || CX<0 || CY>8 || CY<0) {
			return 0;
		}
		return process(CX-2, CY-1, step-1)
				+ process(CX-1, CY-2, step-1)
				+ process(CX+1, CY-2, step-1)
				+ process(CX+2, CY-1, step-1)
				+ process(CX+2, CY+1, step-1)
				+ process(CX+1, CY+2, step-1)
				+ process(CX-1, CY+2, step-1)
				+ process(CX-2, CY+1, step-1);
	}
	/**
	 * 方法数
	 * @param x		目的地x轴
	 * @param y		目的地y轴
	 * @param step	跳多少步
	 * @return
	 */
	public static int ways1(int x,int y,int step) {
		int[][][] dp = new int[10][9][step+1];
		for (int i=0;i<10;i++) {
			for (int j=0;j<9;j++) {
				for (int s=0;s<=step;s++) {
					dp[i][j][s] = -1;
				}
			}
		}
		return process1(x, y, step,dp);
	}
	/**
	 * 暴力递归
	 * @param CX	当前位置X轴
	 * @param CY	当前位置Y轴
	 * @param step	还剩多少步
	 * @return
	 */
	private static int process1(int CX,int CY,int step,int[][][] dp) {
		if(CX>9 || CX<0 || CY>8 || CY<0) {
			return 0;
		}
		if(dp[CX][CY][step]!=-1) {
			return dp[CX][CY][step];
		}
		if(step==0) {
			return dp[CX][CY][step] = (CX==0 && CY==0) ? 1 : 0;
		}
		return dp[CX][CY][step]= process1(CX-2, CY-1, step-1,dp)
				+ process1(CX-1, CY-2, step-1,dp)
				+ process1(CX+1, CY-2, step-1,dp)
				+ process1(CX+2, CY-1, step-1,dp)
				+ process1(CX+2, CY+1, step-1,dp)
				+ process1(CX+1, CY+2, step-1,dp)
				+ process1(CX-1, CY+2, step-1,dp)
				+ process1(CX-2, CY+1, step-1,dp);
	}
	/**
	 * 方法数
	 * @param x		目的地x轴
	 * @param y		目的地y轴
	 * @param step	跳多少步
	 * @return
	 */
	public static int ways2(int x,int y,int step) {
		int[][][] dp = new int[10][9][step+1];
		dp[0][0][0] = 1;
		for (int h=1;h<=step;h++) {
			for (int CX=9;CX>=0;CX--) {
				for (int CY=8;CY>=0;CY--) {
					int p1 = getValue(dp,CX-2,CY-1,h-1);
					int p2 = getValue(dp,CX-1,CY-2,h-1);
					int p3 = getValue(dp,CX+1,CY-2,h-1);
					int p4 = getValue(dp,CX+2,CY-1,h-1);
					int p5 = getValue(dp,CX+2,CY+1,h-1);
					int p6 = getValue(dp,CX+1,CY+2,h-1);
					int p7 = getValue(dp,CX-1,CY+2,h-1);
					int p8 = getValue(dp,CX-2,CY+1,h-1);
					dp[CX][CY][h] = p1+p2+p3+p4+p5+p6+p7+p8;
				}
			}
		}
		return dp[x][y][step];
	}
	private static int getValue(int[][][] dp,int x,int y,int step) {
		if(x>9 || x<0 || y>8 || y<0) {
			return 0;
		}
		return dp[x][y][step];
	}
	
}
