package com.reyco.algorithm.graph;

/**
 * 66 
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
		//           3,2,1,0,-2
		int[] oil = {-1,1,-2,2,-3};
		int[] dis = {4,1,3,-2,1};
		boolean[] points = points(oil, dis);
		for (int i = 0; i < points.length; i++) {
			System.out.print(points[i]+",");
		}
	}
	public static boolean[] points(int[] oil, int[] dis) {
		//纯能值
		int[] energy = new int[oil.length];
		for (int i = 0; i < dis.length; i++) {
			energy[i] = oil[i]+dis[i];
		}
		int index = 0;
		while(energy[index]<=0) {
			index++;
		}
		//连通区[start,end)
		int start = index;
		int end = start+1;
		//连接到end-1需要多少
		int need = 0;
		//还剩多少油
		int rest = energy[start];	
		//结果集
		boolean[] ans = new boolean[dis.length];
		//是否有良好出发点
		boolean through = false;
		while(start!=end && !through) {
			while(energy[end]<=rest) {
				rest += energy[end]; 
				if(end==energy.length-1) {
					end=0;
				}else {
					end++;
				}
				if(end==start) {
					through = true;
					break;
				}
			}
			ans[start] = through;
			start = start==0 ? energy.length-1 : start-1;
		}
		if(!through) {
			return ans;
		}
		while(start!=index){
			if(need==0 && energy[start]>=0) {
				ans[start] = need>=0 ? true : false;
				start = start==0 ? energy.length-1 : start-1;
			}else {
				need += energy[start];
				ans[start] = need>=0 ? true : false;
				if(need>=0) {
					need = 0;
				}
				start = start==0 ? energy.length-1 : start-1;
			}
		}
		return ans;
	}
}
