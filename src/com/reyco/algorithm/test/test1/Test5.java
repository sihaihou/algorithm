package com.reyco.algorithm.test.test1;

import java.util.Stack;

/**
 * 给定一个字符串str,str表示一个公式，公式里有整数、加减乘除、左括号、右括号符号，返回公式的计数结果！
 * @author reyco
 *
 */
public class Test5 {
	
	public static void main(String[] args) {
		String str= "33+((12*9+42/2)+2/3)";
		int resulut = getValue(str);
		System.out.println(resulut);
	}
	public static int getValue(String str) {
		return value(str, 0).sum;
	}
	public static Response value(String str,int i) {
		Stack<Object> stack = new Stack<>();
		int num = 0;
		char ati,peek;
		while(i<str.length() && (ati=str.charAt(i++))!=')') {
			if(ati>='0' && ati<='9') {
				num = num*10 + ati-'0';
			}else if(ati != '(') {
				if(!stack.isEmpty() && ((peek = (Character) stack.peek())=='*' || peek=='/')) {
					Character pop1 = (Character) stack.pop();
					int pop2 = (int) stack.pop();
					stack.push(pop1=='*' ? pop2*num : pop2/num);
				}else {
					stack.push(num);
				}
				num =0;
				stack.push(ati);
			}else {
				Response response = value(str, i);
				num = response.sum;
				i = response.index;
			}
		}
		int sum = addSum(stack, num);
		return new Response(sum,i);
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
	public static class Response{
		int sum;
		int index;
		public Response(int sum, int index) {
			super();
			this.sum = sum;
			this.index = index;
		}
	}
	
}
