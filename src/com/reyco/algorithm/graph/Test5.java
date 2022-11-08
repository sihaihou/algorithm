package com.reyco.algorithm.graph;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

import com.reyco.algorithm.graph.Graph.Edge;
import com.reyco.algorithm.graph.Graph.Node;

/**
 * prim算法  ---生成最小生成树
 * @author reyco
 *
 */
public class Test5 {
	
	public static void main(String[] args) {
		
	}
	
	public static Set<Edge> prim(Graph graph){
		if(graph==null) {
			return null;
		}
		//小根堆解锁的边
		PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
		//被解锁的点
		Set<Node> nodeSet = new HashSet<>();
		
		//防止解锁的边重复放入小根堆
		Set<Edge> edgeSet = new HashSet<>();
		
		//选择的边
		Set<Edge> result = new HashSet<>();
		
		graph.nodes.values().stream().forEach(node->{   //随便找一个点
			if(!nodeSet.contains(node)) {
				nodeSet.add(node);
				node.edges.stream().forEach(edge->{	//由一个点，解锁所有相连的边
					if(!edgeSet.contains(edge)) {
						edgeSet.add(edge);
						priorityQueue.add(edge);
					}
				});
				while(!priorityQueue.isEmpty()) {
					//pop最小的边
					Edge edge = priorityQueue.poll();  //弹出解锁的最小边
					Node to = edge.to;
					if(!nodeSet.contains(to)) {        //被解锁的点是否已选择过
						nodeSet.add(to);
						result.add(edge);
						for (Edge nextEdge : to.edges) {
							if(!edgeSet.contains(nextEdge)) {	//被解锁的边是否放入过小根堆
								edgeSet.add(nextEdge);
								priorityQueue.add(nextEdge);
							}
						}
					}
				}
			}
		});
		return result;
	}
	/**
	 * 比较器
	 * @author reyco
	 *
	 */
	public static class EdgeComparator implements Comparator<Edge>{
		@Override
		public int compare(Graph.Edge o1, Graph.Edge o2) {
			return o1.weight-o2.weight;
		}
	}	
}
