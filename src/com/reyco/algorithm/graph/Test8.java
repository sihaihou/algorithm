package com.reyco.algorithm.graph;

/**
 * N个加油站组成一个环形，给定两个长度都是N的非负数组oil和dis（N>1）,oil[i]代表第i个加油站的油可以跑多少千米，dis[i]代表第i个加油站到环中下一个加油站相隔多少千米。
 * 假设你有一辆油箱足够大的车，初始时车里没有油。如果车从第i个加油站开始出发，最后可以回答这个加油站，那么第i个加油站就算良好出发点，否则就不算。
 * 请返回长度为N的boolean型数组res，res[i]代表第i个加油站是不是良好出发点。
 * 答：
 *    1)先生成纯能值数组;
 *    2)定义一个左闭右开的连通区[start,end)和还剩多少油rest、连接到start需要多少油need；
 *    3)end向后扩，如果够，end右移；如果不够start向左移动；
 *    4)start到了end都没有连通，则没有良好出发点；
 *    5)如果出现良好出发点，则左移一个点只要能连到连通区的开始位置，则就是现良好出发点，否则不是。
 * @author reyco
 *
 */
public class Test8 {

	public static void main(String[] args) {
		
	}
	public static int[] points(int[] oil, int[] dis) {
		//纯能值
		int[] energy = new int[oil.length];
		for (int i = 0; i < dis.length; i++) {
			energy[i] = oil[i]+dis[i];
		}
		//连通区[start,end)
		int start = 0;
		int end = 1;
		
		//剩余多少
		int rest = energy[0];
		//连接到end需要多少
		int need = 0;
		
		
		
		return null;
	}
}
