package com.reyco.algorithm.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.reyco.algorithm.graph.Graph.Node;

/**
 * 拓扑排序---无环有向图
 * @author reyco
 *
 */
public class Test3 {
	public static void main(String[] args) {
		
	}
	
	
	public static List<Node> topology(Graph graph){
		if(graph==null) {
			return null;
		}
		//key:节点  value:入度
		Map<Node,Integer> inMap = new HashMap<>();
		//没有入度的放入
		Queue<Node> zereInQueue = new LinkedList<Node>();
		for(Node  curr : graph.nodes.values()) {
			inMap.put(curr, curr.in);
			if(curr.in==0) {
				zereInQueue.add(curr);
			}
		}
		//拓扑排序的结果
		List<Node> result = new ArrayList<>();
		while(!zereInQueue.isEmpty()) {
			Node curr = zereInQueue.poll();
			result.add(curr);
			for (Node next : curr.nexts) {
				inMap.put(next, inMap.get(next)-1);
				if(inMap.get(next)==0) {
					zereInQueue.add(next);
				}
			}
		}
		return result;
	}
}
