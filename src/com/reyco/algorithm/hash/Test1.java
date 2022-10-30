package com.reyco.lgorithm.hash;

public class Test1 {
	
	public static void main(String[] args) {
		int[] bit = new int[12];
		int numIndex = 365 / 32;
		int bitIndex = 365 % 32;
		System.out.println("numIndex:" + numIndex + ",bitIndex:" + bitIndex);

		System.out.println(bit[numIndex]);
		//设置1
		bit[numIndex] = bit[numIndex] | (1 << bitIndex);
		
		System.out.println(bit[numIndex]);
		//查询状态
		int s = (bit[numIndex] >> bitIndex) & 1;
		System.out.println(s);

	}
}
