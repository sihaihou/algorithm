package com.reyco.algorithm.test.test3;

/**
 * 56、57
 * 给定一个只有0、1、&、|、^ 五种字符组成的字符串express，再给定一个布尔值desired。返回express有多少种组合方式，可以达到desired的结果。
 * 如：
 * 	express = "1^0|0|1",desired=false,只有“1^((0|0)|1)”和"1^(0|(0|1))"的组合可以得到false，返回2.
 * 答：范围上尝试的模型，尝试L...R范围上的每一个逻辑符号都是最后结合的。
 * @author reyco
 *
 */
public class Test9 {

	public static void main(String[] args) {
		String express = "1^0|0|1";
		boolean desired=true;
		int ways = ways(express, desired);
		System.out.println(ways);
		int ways1 = ways1(express, desired);
		System.out.println(ways1);
	}
	
	public static int ways(String express,boolean desired) {
		if(express==null || express.equals("")) {
			return 0;
		}
		if(!isValid(express)) {
			return 0;
		}
		return process(express, desired, 0, express.length()-1);
	}
	/**
	 * L、R不要是逻辑符号
	 * @param express
	 * @param desired
	 * @param L
	 * @param R
	 * @return
	 */
	private static int process(String express,boolean desired,int L,int R) {
		if(L==R) {
			if(express.charAt(L)=='1') {
				return desired ? 1 : 0;
			}else {
				return desired ? 0 : 1;
			}
		}
		int ans = 0;
		if(desired) { //期待为true
			//i位置尝试L...R范围上的每一个逻辑符号都是最后结合的。
			for (int i = L+1; i < R; i += 2) { 
				switch (express.charAt(i)) {
				case '&':
					ans += process(express, true, L, i-1)*process(express, true, i+1, R);
					break;
				case '|':
					ans += process(express, true, L, i-1)*process(express, false, i+1, R);
					ans += process(express, false, L, i-1)*process(express, true, i+1, R);
					ans += process(express, true, L, i-1)*process(express, true, i+1, R);
					break;
				case '^':
					ans += process(express, true, L, i-1)*process(express, false, i+1, R);
					ans += process(express, false, L, i-1)*process(express, true, i+1, R);
					break;
				}
			}
		}else {//期待为true
			//i位置尝试L...R范围上的每一个逻辑符号都是最后结合的。
			for (int i = L+1; i < R; i += 2) {
				switch (express.charAt(i)) {
				case '&':
					ans += process(express, true, L, i-1)*process(express, false, i+1, R);
					ans += process(express, false, L, i-1)*process(express, true, i+1, R);
					ans += process(express, false, L, i-1)*process(express, false, i+1, R);
					break;
				case '|':
					ans += process(express, false, L, i-1)*process(express, false, i+1, R);
					break;
				case '^':
					ans += process(express, true, L, i-1)*process(express, true, i+1, R);
					ans += process(express, false, L, i-1)*process(express, false, i+1, R);
					break;
				}
			}
		}
		return ans;
	}
	private static boolean isValid(String express) {
		if(express==null || express.equals("")) {
			return false;
		}
		//长度必须是奇数
		if((express.length()&1)==0) {
			return false;
		}
		for (int i = 0; i < express.length(); i++) {
			//偶数位置必须是0或1
			if((i&1)==0 && express.charAt(i)!='0' && express.charAt(i)!='1') {
				return false;
			}
			//奇数位置必须是逻辑符号
			if((i&1)==1 && express.charAt(i)!='&' && express.charAt(i)!='|' && express.charAt(i)!='^') {
				return false;
			}
		}
		return true;
	}
	
	public static int ways1(String express,boolean desired) {
		int N = express.length();
		int[][] trueDp = new int[N][N];
		int[][] falseDp = new int[N][N];
		for (int i = 0; i < N; i+=2) {
			trueDp[i][i] = express.charAt(i)=='1' ? 1 : 0;
			falseDp[i][i] = express.charAt(i)=='0' ? 1 : 0;
		}
		for (int L = N-3 ; L>=0; L-=2) {
			for (int R = L+2; R < N; R+=2) {
				//i位置尝试L...R范围上的每一个逻辑符号都是最后结合的。
				for (int i = L+1; i < R; i += 2) { 
					switch (express.charAt(i)) {
					case '&':
						trueDp[L][R] += trueDp[L][i-1]*trueDp[i+1][R];
						break;
					case '|':
						trueDp[L][R] += trueDp[L][i-1]*falseDp[i+1][R];
						trueDp[L][R] +=falseDp[L][i-1]*trueDp[i+1][R];
						trueDp[L][R] += trueDp[L][i-1]*trueDp[i+1][R];
						break;
					case '^':
						trueDp[L][R] += trueDp[L][i-1]*falseDp[i+1][R];
						trueDp[L][R] += falseDp[L][i-1]*trueDp[i+1][R];
						break;
					}
					switch (express.charAt(i)) {
					case '&':
						falseDp[L][R] += trueDp[L][i-1]*falseDp[i+1][R];
						falseDp[L][R] += falseDp[L][i-1]*trueDp[i+1][R];
						falseDp[L][R] += falseDp[L][i-1]*falseDp[i+1][R];
						break;
					case '|':
						falseDp[L][R] += falseDp[L][i-1]*falseDp[i+1][R];
						break;
					case '^':
						falseDp[L][R] += trueDp[L][i-1]*trueDp[i+1][R];
						falseDp[L][R] += falseDp[L][i-1]*falseDp[i+1][R];
						break;
					}
				}
			}
		}
		return desired ? trueDp[0][N-1] : falseDp[0][N-1];
	}
}
