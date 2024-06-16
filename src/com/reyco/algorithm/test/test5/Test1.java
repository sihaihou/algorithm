package com.reyco.algorithm.test.test5;

import java.util.HashMap;
import java.util.Map;

/**
 * 58
 *  给出几个数字，1，2，3，。。。n，问最多有多少不重叠的非空区间，使得每个区间内数字的xor都等于0.
 *  答：使用前缀异或和
 * 	求i位置结尾异或和为0的长度是多少?
 *  	   假设0-i位置存在最优划分的情况:最后一部分异或和等于0，那么0-i最优划分长度等于i-1位置的值+1;最后一部分异或和不等于0，那么0-i最优划分长度等于i-1位置值；
 *  	   最后一部分异或和等于0，那么必然存在一个k位置一直异或和到i位置异或和等于0；
 *  	       假设0-i位置的异或和等于j，那么只需要找到之前出现异或和等于j的位置，这个j所在的位置就是离我最近使最后一部分异或和等于0,所以需要用Map记录我之前出现的异或和和最近的索引位置即可。
 *  	例 ： 3，2，1，4，0，1，2，3
 *  	   i=-1,map.put(0,-1)	
 *         i=0,map.put(3,0)		dp[0]=0
 *         i=1,map.put(1,1)     dp[1]=0
 *         i=2,map.put(0,2)     dp[2]=math.max(dp[map.get(0)],0~2只有一个)
 *         i=3,map.put(4,3)     dp[3]=1
 *         i=4,map.put(0,4)     dp[4]=math.max(dp[map.get(0)],2~4有两个)
 *         。。。。
 * @author reyco
 *
 */
public class Test1 {

	public static void main(String[] args) {
		int[] arr = {3,2,1,4,0,1,2,3};
		int mostEOR = mostEOR(arr);
		System.out.println(mostEOR);
	}
	
	public static int mostEOR(int[] arr) {
		int xor = 0;
		//dp[i]--->arr[0~i]在最优划分的情况下，异或和为0最多的部分是多少。
		int[] dp = new int[arr.length];
		//key:从0出发的某个前缀异或和
		//value:这个前缀异或和出现的最晚位置（index）
		Map<Integer,Integer> map = new HashMap<>();
		map.put(0, -1);
		for (int i = 0; i < arr.length; i++) {
			xor ^= arr[i];   //0~i所有数的异或和
			if(map.containsKey(xor)) {//上一次，这个异或和出现的位置
				//pre-->pre+1-->i,最优划分，最后一部分的开始位置
				//(pre+1,i)最后一部分
				int pre = map.get(xor);	//a   0~a (a+1...i)
				dp[i] = pre==-1 ? 1 : (dp[pre]+1);
			}
			//dp[i]-->Max(dp[i-1],dp[k-1]+1)
			if(i>0) {
				dp[i] = Math.max(dp[i-1], dp[i]);
			}
			map.put(xor, i);
		}
		return dp[dp.length-1];
	}
}
