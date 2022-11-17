package com.reyco.algorithm.test.test3;

/**
 * 39-65
 * N层汉诺塔移动次数：(n^2)-1
 * 
 * 汉诺塔问题：
 * 在经典汉诺塔问题中，有 3 根柱子及 N 个不同大小的穿孔圆盘，盘子可以滑入任意一根柱子。一开始，所有盘子自上而下按升序依次套在第一根柱子上(即每一个盘子只能放在更大的盘子上面)。移动圆盘时受到以下限制:
 * (1) 每次只能移动一个盘子;
 * (2) 盘子只能从柱子顶端滑出移到下一根柱子;
 * (3) 盘子只能叠在比它大的盘子上。
 *
 * 请编写程序，用栈将所有盘子从第一根柱子移到最后一根柱子。
 * 你需要原地修改栈。
 *
 * 答：第一步：把1~N-1移动到other； 
 *    第二步：把第N移动到to；
 *    第三步：把第1~N-1移动到to；
 * @author reyco
 *
 */
public class Test1 {
	
	public static void main(String[] args) {
		hanota(3, "left", "right", "mid");
	}
	
	public static void hanota(int n,String from,String to,String other) {
		if(n==1) {
			System.out.println("n:"+n+",from:"+from+"——>to："+to);
		}else {
			hanota(n-1, from, other, to);
			System.out.println("n:"+n+",from:"+from+"——>to："+to);
			hanota(n-1, other, to, from);
		}
	}
}
