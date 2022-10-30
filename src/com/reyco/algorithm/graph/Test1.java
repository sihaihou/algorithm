package com.reyco.algorithm.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import com.reyco.algorithm.graph.Graph.Node;
//  A————B
//  |\  /|
//  | \/ |
//	|E/\ |
//  |/  \| 
//  C————d
/**
 * 图宽度优先遍历--用队列
 * @author reyco
 *
 */
public class Test1 {
	
	public static void main(String[] args) {
		
	}
	public static void bfs(Node node){
		if(node==null) {
			return;
		}
		Queue<Node> queue = new LinkedList<Node>();
		Set<Node> setNode = new HashSet<>();
		queue.add(node);
		setNode.add(node);
		while(!queue.isEmpty()) {
			Node curr = queue.poll();
			System.out.println(curr.value);
			for (Node next : curr.nexts) {
				if(!setNode.contains(next)) {
					queue.add(next);
					setNode.add(next);
				}
			}
		}
	}
}
