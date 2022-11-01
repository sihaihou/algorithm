package com.reyco.algorithm.test.test1;

import java.util.Stack;

/**
 * 给定一个字符串str,str表示一个公式，公式里有整数、加减乘除符符号，返回公式的计数结果！
 * @author reyco
 *
 */
public class Test4 {
	
	public static void main(String[] args) {
		String str= "33+12*9+42/2+2/3";
		int resulut = getValue(str);
		System.out.println(resulut);
	}
	public static int getValue(String str) {
		Stack<Object> stack = new Stack<Object>();
		int num = 0;
		for(int i=0;i<str.length();i++) {
			char ati,peek;
			if((ati=str.charAt(i))>='0' && ati<='9') {
				num = num*10 + (ati-'0');
			}else {
				Character pop1;
				int pop2;
				if(!stack.isEmpty() && ((peek = (Character) stack.peek())=='*' || peek=='/')) {
					pop1 = (Character) stack.pop();
					pop2 = (int) stack.pop();
					stack.push(pop1=='*' ? pop2*num : pop2/num);
				}else {
					stack.push(num);
				}
				num =0;
				stack.push(ati);
			}
		}
		return addSum(stack, num);
	}
	/**
	 * 求和
	 * @param stack
	 * @param num
	 * @return
	 */
	public static int addSum(Stack<Object> stack,int num) {
		int sum=num;
		String symbol = "";
		while(!stack.isEmpty()) {
			Object pop = stack.pop();
			String temp = pop.toString();
			if(temp.equalsIgnoreCase("+") 
					|| temp.equalsIgnoreCase("-") 
					|| temp.equalsIgnoreCase("*") 
					|| temp.equalsIgnoreCase("/")) {
				symbol = temp;
			}else{
				int v = Integer.parseInt(temp);
				if(symbol.equalsIgnoreCase("+")) {
					sum += v;
				}else if(symbol.equalsIgnoreCase("-")) {
					sum = v-sum;
				}else if(symbol.equalsIgnoreCase("*")) {
					sum *= v;
				}else if(symbol.equalsIgnoreCase("/")) {
					sum = v / sum;
				}
			}
		}
		return sum;
	}
	
}
