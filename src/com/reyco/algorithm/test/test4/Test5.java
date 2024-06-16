package com.reyco.algorithm.test.test4;

/**
 * 57
 * a（1）、b（2）、c（3）、d（4）..z(26)、ab(27)、ac(28)...
 * 输入一个任意长度不超过16的升序字符串，计算它在上述字典中的编码。
 * 例：dhk：长度为1、2的 + 长度为3的以a、b、c开头的数量 + 以d开头长度为2的（e、f、g）数量 + 以dh开头长度为1的（i、j）数量
 * @author reyco
 *
 */
public class Test5 {
	
	public static void main(String[] args) {
		int num = num("ab");
		System.out.println(num);
	}
	public static int num(String s) {
		int length = s.length();
		int sum = 0;
		//第一部分
		for (int i = 1; i < length; i++) {
			sum += f(i);
		}
		//第二部分
		int first = s.charAt(0)-'a'+1;
		for (int i = 1; i < first; i++) {
			sum += g(i,length);
		}
		int pre = first;
		for (int i = 1; i < length; i++) {
			int curr = s.charAt(i)-'a'+1;
			for (int j = pre+1; j < curr; j++) {
				sum += g(j,length-1);
			}
			pre = curr;
		}
		return sum+1;
	}
	
	/**
	 * 长度为len的数量有多少个？
	 * @param len
	 * @return
	 */
	private static int f(int len) {
		int sum = 0;
		for (int i = 1; i <= 26; i++) {
			sum += g(i, len);
		}
		return sum;
	}
	/**
	 * 以i开头，长度为len的数量有多少个？
	 * @param i
	 * @param len
	 * @return
	 */
	private static int g(int i,int len) {
		int sum = 0;
		if(len==1) {
			return 1;
		}
		for (int j = i+1; j <= 26; j++) {
			sum += g(j, len-1);
		}
		return sum;
	}
}
