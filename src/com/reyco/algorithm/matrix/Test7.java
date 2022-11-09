package com.reyco.algorithm.matrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

/**
 * 68
 * 平面内有n个矩形，第i个矩形的左下角坐标为(x1[i],y1[i]),右上角的坐标为(x2[i],y2[i])。如果两个或者多个矩阵有公共区域则认为它们是相互重叠的。
 * 请你计算出平面内重叠矩形数量最多的地方，有多少个矩形相互重叠。
 * 
 * 注意：线段怎么判断最大重叠区域？
 * 	   答：根据左边界排序,左边界小的右边界的值放入有序表，把有序表中右边界值小于当前的左边界值的都删除掉,看有序表中有多少个数,就有多少个矩形重叠，每次放入计算最大重叠数。
 * 
 * 答：
 *    第一步： 每次操作先按底边排序:先操作底边小的矩形，有序表中底边小于当前的底边的都删除掉；
 *    第一步： 再按有序表中每个矩形的左边界排序:操作左边界小的矩形，有序表中右边界小于当前的左边界的都删除掉(线段怎么判断最大重叠区域?).
 * @author reyco
 *
 */
public class Test7 {

	public static void main(String[] args) {
		int[][] matrix = {{1,9},{2,5},{2,4},{3,10},{6,8}};
		int maxLineOverlap = maxLineOverlap(matrix);
		System.out.println("线段最大重叠数："+maxLineOverlap);
		System.out.println("-----------------------------------");
	}
	
	
	/**
	 * 最大线段重叠数:
	 * 	matrix[i][0]表示第i个线段左边界
	 * 	matrix[i][1]表示第i个线段右边界
	 * @param matrix 
	 * @return
	 */
	public static int maxLineOverlap(int[][] matrix) {
		//先排序
		List<Line> lines = new ArrayList<>();
		for (int i = 0; i < matrix.length; i++) {
			lines.add(new Line(matrix[i][0],matrix[i][1]));
		}
		Collections.sort(lines);
		//计算最大的重叠数
		TreeSet<Integer> treeSet = new TreeSet<>();
		int max = 0;
		for (Line line : lines) {
			while(!treeSet.isEmpty() && treeSet.first()<line.left) {
				treeSet.pollFirst();
			}
			treeSet.add(line.right);
			max = Math.max(max, treeSet.size());
		}
		return max;
	}
	public static class Line implements Comparable<Line>{
		public int left;
		public int right;
		public Line() {
		}
		public Line(int left, int right) {
			this.left = left;
			this.right = right;
		}
		@Override
		public int compareTo(Line line) {
			return line.left;
		}
	}
}
