package com.reyco.algorithm.bit;

/**
 * 二进制位出现1的次数
 * @author reyco
 *
 */
public class Test2 {
	public static void main(String[] args) {
		int hammingWeight = hammingWeight(11);
		System.out.println(hammingWeight);
	}
	public static int hammingWeight(int n) {
        int times = 0;
        int i = 0;
        while(i<32) {
        	if((n&(1<<i))!=0) {
        		times++;
        	}
        	i++;
        }
        return times;
    }
}
