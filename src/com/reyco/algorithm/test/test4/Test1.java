package com.reyco.algorithm.test.test4;

/**
 * 机器人
 * @author reyco
 *
 */
public class Test1 {
	public static void main(String[] args) {
		//1 2 3 4 5
		//N=5 S=2 E=4 k=4
		for(int k=0;k<35;k++) {
			long start1 = System.currentTimeMillis();
			int walkWays1 = walkWays1(5, 2, 4, k );
			//System.out.println(walkWays1);
			long end1 = System.currentTimeMillis();
			//System.out.println("end1-statr1:"+(end1-start1));
			
			long start2 = System.currentTimeMillis();
			int walkWays2 = walkWays2(5, 2, 4, k);
			//System.out.println(walkWays2);
			long end2 = System.currentTimeMillis();
			//System.out.println("end2-start2:"+(end2-start2));
			
			long start3 = System.currentTimeMillis();
			int walkWays3 = walkWays3(5, 2, 4, k);
			//System.out.println(walkWays3);
			long end3 = System.currentTimeMillis();
			//System.out.println("end3-start3:"+(end3-start3));
			if(walkWays1!= walkWays2 || walkWays2!=walkWays3) {
				System.out.println("fail");
				break;
			}
		}
		System.out.println("OK");
	}
	/**
	 * 暴力递归
	 * @param N		一共1~N个位置
	 * @param M		开始位置
	 * @param P		我的目的地
	 * @param K		有多少步
	 * @return
	 */
	public static int walkWays1(int N,int M,int P,int K) {
		return f1(N, P, K, M);
	}
	/**
	 * 暴力递归
	 * @param N		一共1~N个位置
	 * @param E		我的目的地
	 * @param rest	还有多少步
	 * @param curr	当前位置
	 */
	private static int f1(int N,int E,int rest,int curr) {
		if(rest==0) {
			return curr==E ? 1 : 0;
		}
		if(curr==1) {
			return f1(N, E, rest-1, 2);
		}
		if(curr==N) {
			return f1(N, E, rest-1, curr-1);
		}
		return f1(N, E, rest-1, curr-1) + f1(N, E, rest-1, curr+1);
	}
	/**
	 * 暴力递归+记忆优化方法
	 * @param N		一共1~N个位置
	 * @param M		开始位置
	 * @param P		我的目的地
	 * @param K		有多少步
	 * @return
	 */
	public static int walkWays2(int N,int M,int P,int K) {
		int[][] dp = new int[K+1][N+1];
		for(int i=0;i<=K;i++) {
			for(int j=0;j<=N;j++) {
				dp[i][j] = -1;
			}
		}
		return f2(N, P, K, M,dp);
	}
	/**
	 * 动态规划+记忆优化方法
	 * @param N		一共1~N个位置
	 * @param E		我的目的地
	 * @param rest	还有多少步
	 * @param curr	当前位置
	 * @param dp	缓存
	 */
	private static int f2(int N,int E,int rest,int curr,int[][] dp) {
		if(dp[rest][curr]!=-1) {
			return dp[rest][curr];
		}
		if(rest==0) {
			dp[rest][curr] = (curr==E ? 1 : 0);
			return dp[rest][curr];
		}
		if(curr==1) {
			dp[rest][curr] = f2(N, E, rest-1, 2,dp);
		}else if(curr==N) {
			dp[rest][curr] = f2(N, E, rest-1, curr-1,dp);
		}else {
			dp[rest][curr] = f2(N, E, rest-1, curr-1,dp) + f2(N, E, rest-1, curr+1,dp);
		}
		return dp[rest][curr];
	}
	/**
	 * 经典动态规划
	 * @param N		一共1~N个位置
	 * @param M		开始位置
	 * @param P		我的目的地
	 * @param K		有多少步
	 * @return
	 */
	public static int walkWays3(int N,int M,int P,int K) {
		int[][] dp = new int[K+1][N+1];
		dp[0][P] = 1;
		for(int rest=1;rest<=K;rest++) {
			for(int curr=1;curr<=N;curr++) {
				if(curr==1) {
					dp[rest][curr] = dp[rest-1][curr+1];
				}else if(curr==N) {
					dp[rest][N] = dp[rest-1][N-1];
				}else {
					dp[rest][curr] = dp[rest-1][curr-1] + dp[rest-1][curr+1];
				}
			}
		}
		return dp[K][M];
	}
}
