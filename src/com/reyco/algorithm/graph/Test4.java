package com.reyco.algorithm.graph;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

import com.reyco.algorithm.graph.Graph.Edge;
import com.reyco.algorithm.graph.Graph.Node;


/**
 * Kruska算法  ---生成最小生成数
 * 从最小边开始,只要不形成环--就是最小值
 * @author reyco
 *
 */
public class Test4 {
	
	public static void main(String[] args) {
		
		
	}
	
	public static Set<Edge> kruska(Graph graph) {
		UnionFind unionFind = new UnionFind(graph.nodes.values());
		PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
		graph.edges.forEach(edge->{
			priorityQueue.add(edge);
		});
		Set<Edge> result = new HashSet<>();
		while(!priorityQueue.isEmpty()) {
			Edge edge = priorityQueue.poll();
			if(!unionFind.isSameSet(edge.from, edge.to)) {
				result.add(edge);
				unionFind.union(edge.from, edge.to);
			}
		}
		return result;
	}
	/**
	 * 比较器
	 * @author reyco
	 *
	 */
	public static class EdgeComparator implements Comparator<Edge>{
		@Override
		public int compare(Edge o1, Graph.Edge o2) {
			return o1.weight-o2.weight;
		}
	}	
	/**
	 * 并差集
	 * @author reyco
	 *
	 */
	public static class UnionFind{
		
		Map<Node,Set<Node>> nodesMap = new HashMap<>();
		
		public UnionFind(Collection<Node> nodes) {
			nodes.stream().forEach(node->{
				Set<Node> nodeSet = new HashSet<>();
				nodeSet.add(node);
				nodesMap.put(node,nodeSet);
			});
		}
		/**
		 * 是否在一个集合中
		 * @param from
		 * @param to
		 * @return
		 */
		public Boolean isSameSet(Node from,Node to) {
			return nodesMap.get(from) == nodesMap.get(to);
		}
		/**
		 * 合并两个节点到一个集合
		 * @param from
		 * @param to
		 */
		public void union(Node from,Node to) {
			Set<Node> fromSet = nodesMap.get(from);
			Set<Node> toSet = nodesMap.get(to);
			for (Node node : toSet) {
				fromSet.add(node);
				nodesMap.put(to, fromSet);
			}
		}
	}
}
