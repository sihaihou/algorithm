package com.reyco.algorithm.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;
import java.util.Map.Entry;

/**
 * 
 * 给定一个N*3的矩阵matrix，对于每一个长度为3的小数组arr,都表示一个大楼的三个数据,arr[0]表示大楼的左边界，arr[1]表示大楼的右边界，arr[2]表示大楼的高度；
 * 每座大楼的地基都在X轴上，大楼之间可能会有重叠，请返回整理的轮廓线数据？
 * 答：例：{
 * 		{2,6,8}，
 * 		{7,11,9}，
 * 		{4,8,5}，
 * 		{1,14,4}，
 * 		{3,5,3}
 *   }
 * 	  第一步：生成Node数组: node的x相等，add类型放前面：
 *    {
 *    	{1,add,4},
 *    	{2,add,8},
 *    	{3,add,3},
 *    	{4,add,5},
 *    	{5,del,3},
 *    	{6,del,8},
 *    	{7,add,9},
 *    	{8,del,5},
 *    	{11,del,9},
 *    	{14,del,4},
 *    }
 *    第二步：通过高度词频获取每个位置的最大高度
 *    第三步：根据最大高度变化生成大楼轮廓。
 * @author reyco
 *
 */
public class Test8 {
	
	public static void main(String[] args) {
		int[][] matrix = new int[5][3];
		matrix[0] = new int[] {2,6,8};
		matrix[1] = new int[] {7,11,9};
		matrix[2] = new int[] {4,8,5};
		matrix[3] = new int[] {1,14,4};
		matrix[4] = new int[] {3,5,3};
		List<List<Integer>> buildContourLine = buildContourLine(matrix);
		System.out.println(buildContourLine);
	}
	
	public static List<List<Integer>> buildContourLine(int[][] matrix){
		//1,生成Node数组: node的x相等，add类型放前面：
		Node[] arr = new Node[matrix.length<<1];
		for(int i=0;i<matrix.length;i++) {
			arr[i*2] = new Node(matrix[i][0],true, matrix[i][2]);
			arr[i*2+1] = new Node(matrix[i][1],false, matrix[i][2]);
		}
		Arrays.sort(arr, new NodeComparator());
		//print(arr);
		
		//2,通过高度词频获取每个位置的最大高度
		// key:高度h	value:出现的次数
		TreeMap<Integer,Integer> heightTimesMap = new TreeMap<>();
		// key:x轴    value： 高度
		TreeMap<Integer,Integer> xHeightMap = new TreeMap<>();
		for (int i=0;i<arr.length;i++) {
			Node curr = arr[i];
			if(curr.add) { //如果当前是增加操作
				//有了就词频+1,没有就put
				if(!heightTimesMap.containsKey(curr.h)) {
					heightTimesMap.put(curr.h, 1);
				}else {
					heightTimesMap.put(curr.h, heightTimesMap.get(curr.h)+1);
				}
			}else {
				//当前是减少操作
				//如果当前词频等于1，直接移除，否则词频-1操作
				if(heightTimesMap.get(curr.h)==1) {
					heightTimesMap.remove(curr.h);
				}else {
					heightTimesMap.put(curr.h, heightTimesMap.get(curr.h)-1);
				}
			}
			//如果高度词频表没有高度了，那么高度就是0，否则就取最大的高度
			if(heightTimesMap.isEmpty()) { 
				xHeightMap.put(curr.x, 0);
			}else {
				xHeightMap.put(curr.x, heightTimesMap.lastKey());
			}
		}
		//3,根据最大高度变化生成大楼轮廓。
		List<List<Integer>> res = new ArrayList<>();
		int start = 0;
		int prevHeiht = 0;
		for (Entry<Integer, Integer> enter : xHeightMap.entrySet()) {
			//当前位置、当前最大高度
			int currX = enter.getKey();
			int currMaxHeight = enter.getValue();
			if(prevHeiht != currMaxHeight) {//当前最大高度和之前最大高度不一致时
				res.add(new ArrayList<>(Arrays.asList(start,currX,prevHeiht))); //start:开始   currX:结束   prevHeiht：高度
				start = currX;  //下一个开始位置设置为当前位置
			}
			prevHeiht = currMaxHeight;  //之前最大高度设置成当前最大高度
		}
		return res;
	}
	public static class NodeComparator implements Comparator<Node>{
		@Override
		public int compare(Node o1, Node o2) {
			if(o1.x!=o2.x) {
				return o1.x>o2.x ? 1 : -1;
			}
			if(o1.add != o2.add) {
				return o1.add ? -1 : 1;
			}
			return 0;
		}
	}
	public static class Node{
		/**
		 * X轴
		 */
		private int x;
		/**
		 * 是否高度增加
		 */
		private boolean add;
		/**
		 * 高度
		 */
		private int h;
		public Node(int x, boolean add, int h) {
			super();
			this.x = x;
			this.add = add;
			this.h = h;
		}
		@Override
		public String toString() {
			return "Node [x=" + x + ", add=" + add + ", h=" + h + "]";
		}
	}
	public static void print(Node[] arr) {
		for (int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
		System.out.println();
	}
	
}
