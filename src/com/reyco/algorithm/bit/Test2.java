package com.reyco.algorithm.bit;

/**
 * 二进制位出现1的次数
 * @author reyco
 *
 */
public class Test2 {
	public static void main(String[] args) {
		for(int i=0;i<100000;i++){
			int result = hammingWeight(i);
			int result2 = hammingWeight1(i);
			if(result!=result2) {
				System.out.println("fail");
				System.out.println("i:"+j+",result:"+result);
				System.out.println("i:"+j+",result2:"+result2);
				return;
			}
		}
		System.out.println("success");
	}
	/**
	 * 效率高
	 */
	public static int hammingWeight1(int n) {
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
	/**
	 * 效率低
	 */
	public static int hammingWeight(int n) {
		int times = 0;
		while(n!=0) {
			int temp = n & (~n+1);
			n ^=temp;
			times++;
		}
		return times;
	}
}
