package com.reyco.algorithm.test.test1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

/**
 * 53
 * 给定一个job类型的数组jobar，表示所有的工作，给定一个int类型的数组arr,表示所有小伙伴的能力，在难度不超过自身能力的情况下，返回所有小伙伴获得的最高劳动报酬（int数组类型）。
 * @author reyco
 *
 */
public class Test6 {
	
	public static void main(String[] args) {
		Job[] jobar = new Job[5];
		jobar[0] = new Job(8, 8);
		jobar[1] = new Job(3, 4);
		jobar[2] = new Job(5, 5);
		jobar[3] = new Job(3, 2);
		jobar[4] = new Job(4, 3);
		int[] arr = {5,2,3,5,7,8,4,7,3,7,5,24};
		int[] maxRemuneration = maxRemuneration(jobar, arr);
		print(maxRemuneration);
	}
	public static int[] maxRemuneration(Job[] jobar,int[] arr) {
		//排序：难度递增，难度一样，报酬递增
		Arrays.sort(jobar,new JobComparator());
		//难度递增报酬也递增
		TreeMap<Integer, Integer> treeMap = new TreeMap<>();
		treeMap.put(jobar[0].hard, jobar[0].money);
		Job pre = jobar[0];
		for (int i=1;i<jobar.length;i++) {
			if(jobar[i].hard!=pre.hard && jobar[i].money>pre.money) {
				treeMap.put(jobar[i].hard, jobar[i].money);
				pre = jobar[i];
			}
		}
		int[] ans = new int[arr.length];
		for (int i=0;i<arr.length;i++) {
			Integer floorKey = treeMap.floorKey(arr[i]);
			ans[i] = floorKey!=null ? treeMap.get(floorKey) : 0;
		}
		return ans;
	}
	public static class JobComparator implements Comparator<Job>{
		@Override
		public int compare(Job o1, Job o2) {
			return o1.hard!=o2.hard ? o1.hard-o2.hard : o2.money-o1.money;
		}
	}
	
	public static class Job{
		//报酬
		private int money;
		//难度
		private int hard;
		
		public Job(int money, int hard) {
			super();
			this.money = money;
			this.hard = hard;
		}
		public int getMoney() {
			return money;
		}
		public void setMoney(int money) {
			this.money = money;
		}
		public int getHard() {
			return hard;
		}
		public void setHard(int hard) {
			this.hard = hard;
		}
	}
	/**
	 * 打印数组
	 * @param arr
	 */
	private static void print(int[] arr){
		for (int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}
