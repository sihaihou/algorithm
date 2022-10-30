package com.reyco.algorithm.graph;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import com.reyco.algorithm.graph.Graph.Node;
//  A————B
//  |\  /|
//  | \/ |
//	|E/\ |
//  |/  \| 
//  C————d
/**
 * 深宽度优先遍历---用栈
 * @author reyco
 *
 */
public class Test2 {
	
	public static void main(String[] args) {
		
	}
	public static void bfs(Node node){
		if(node==null) {
			return;
		}
		Stack<Node> stack = new Stack<Node>();
		Set<Node> setNode = new HashSet<>();
		stack.push(node);
		System.out.println(node.value);
		setNode.add(node);
		while(!stack.isEmpty()) {
			Node curr = stack.pop();
			for (Node next : curr.nexts) {
				if(!setNode.contains(next)) {
					stack.push(curr);
					stack.push(next);
					System.out.println(next.value);
					setNode.add(next);
					break;
				}
			}
		}
		
	}
}
