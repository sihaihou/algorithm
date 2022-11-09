package com.reyco.algorithm.test.test1;

/**
 * 55
 * 给你一个数，返回以中文方式输出。
 * @author reyco
 *
 */
public class Test7 {
	
	public static void main(String[] args) {
		System.out.println(num1To9(9));
		System.out.println(num1To99(99,false));
		System.out.println(num1To999(999));
		System.out.println(num1To9999(9999));
		System.out.println(num1To99999(99999));
	}
	
	public static String num1To9(int num) {
		if(num<0 || num>9) {
			return "";
		}
		String[] names = {"一","二","三","四","五","六","七","八","九"};
		return names[num-1];
	}
	public static String num1To99(int num,boolean hasBai) {
		if(num<0 || num>99) {
			return "";
		}
		if(num<10) {
			return num1To9(num);
		}
		int shi = num/10;
		if(shi==1 && !hasBai) {
			return "十"+num1To9(num%10);
		}else{
			return num1To9(shi)+"十"+num1To9(num%10);
		}
	}
	public static String num1To999(int num) {
		if(num<0 || num>999) {
			return "";
		}
		if(num<100) {
			return num1To99(num,false);
		}
		String res = num1To9(num/100)+"百";
		int rest = num%100;
		if(rest==0) {
			return res;
		}else if(rest>=10) {
			res += num1To99(rest, true);
		}else{
			res += "零"+num1To9(rest);
		}
		return res;
	}
	public static String num1To9999(int num) {
		if(num<0 || num>9999) {
			return "";
		}
		if(num<1000) {
			return num1To999(num);
		}
		String res = num1To9(num/1000)+"千";
		int rest = num%1000;
		if(rest==0) {
			return res;
		}else if(rest>=100) {
			res += num1To999(rest);
		}else{
			res += "零"+num1To99(rest,false);
		}
		return res;
	}
	public static String num1To99999(int num) {
		if(num<0 || num>99999) {
			return "";
		}
		if(num<10000) {
			return num1To9999(num);
		}
		String res = num1To9(num/10000)+"万";
		int rest = num%10000;
		if(rest==0) {
			return res;
		}else if(rest>=1000) {
			res += num1To9999(rest);
		}else{
			res += "零"+num1To999(rest);
		}
		return res;
	}
	
}
