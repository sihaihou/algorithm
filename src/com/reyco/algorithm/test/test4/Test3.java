package com.reyco.algorithm.test.test4;

import java.util.Stack;

/**
 * 39
 * 反转栈--逆序栈
 * @author reyco
 *
 */
public class Test3 {
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(3);
		stack.push(2);
		stack.push(1);
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
		stack.push(3);
		stack.push(2);
		stack.push(1);
		reverse(stack);
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}
	
	public static void reverse(Stack<Integer> stack) {
		if(stack.isEmpty()) {
			return;
		}
		int i = f(stack);
		reverse(stack);
		stack.push(i);
	}
	
	public static int f(Stack<Integer> stack) {
		int result = stack.pop();
		if(stack.isEmpty()) {
			return result;
		}
		int last = f(stack);
		stack.push(result);
		return last;
	}
	
}
