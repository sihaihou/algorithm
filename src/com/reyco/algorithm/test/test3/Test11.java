package com.reyco.algorithm.test.test3;

/**
 * 给定一个长度为偶数的数组arr，长度记为2*N，前N个部分为左部分，后N个为右部分，
 * arr可以表示为{L1,L2,...Ln,R1,R2,...Rn};
 * 请将数组调整成{R1,L1,R2,L2,...Rn,Ln}.  (要求时间复杂的：O(n) 空间复杂度：O(1)
 * 
 * 答：(完美洗牌问题)循环怼结论：N = 3^k-1,如: 2,8,26... ;它的触发点是3^(k-1):1,3,9,27
 *   任意偶数长度解决：
 *   		[L1,L2,L3,L4,L5,L6,L7,R1,R2,R3,R4,R5,R6,R7]
 *   第一步: 让L1...L4和R1...R4到一起：
 *   		[L1,L2,L3,L4,  L5,L6,L7,R1,R2,R3,R4,  R5,R6,R7]
 *   						|  L5,L6,L7逆序,R1,R2,R3,R4逆序，两部分整体逆序，就如下：
 *   						v
 *   		[L1,L2,L3,L4,  R1,R2,R3,R4,L5,L6,L7,  R5,R6,R7]
 *   						|  让L1,L2,L3,L4, R1,R2,R3,R4整体循环怼
 *   						v
 *   		[R1,L1,R2,L2,R3,L3,R4,L4,  L5,L6,L7,R5,R6,R7]
 *  第二步：把L5,L6,L7,R5,R6,R7看成单独的数组
 *  		让L5和R5到一起：
 *  			[L5,  L6,L7,R5,  R6,R7]
 *  					|  L6,L7逆序,R5逆序，两部分整体逆序，就如下：
 *   					v
 *  			[L5,  R5,L6,L7,  R6,R7]
 *  					|  让L5,R5整体循环怼
 *   					v
 *   			[R5,L5,  L6,L7,R6,R7]
 *  第三步：把L6,L7,R6,R7看成单独的数组，继续第二步的操作，就整体调整好了。		
 * @author reyco
 *
 */
public class Test11 {
	public static void main(String[] args) {
		
	}
	public static void adjust(int[] arr) {
		
	}
}
