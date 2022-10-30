package com.reyco.algorithm.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 图类
 * @author reyco
 *
 */
public class Graph {
	/**
	 * 所有节点
	 */
	Map<Integer,Node> nodes;
	/**
	 * 所有边
	 */
	Set<Edge> edges;
	
	public Graph() {
		this.nodes = new HashMap<>();
		this.edges = new HashSet<>();;
	}
	/**
	 * 点结构
	 * @author reyco
	 *
	 */
	public static class Node{
		int value;
		int in;  //连入我的边数量
		int out; //我连出的边数量
		List<Node> nexts; //我连出的所有点
		List<Edge> edges; //我连出的所有边
		
		public Node(int value) {
			this.value = value;
			this.in = 0;
			this.out = 0;
			this.nexts = new ArrayList<>();
			this.edges = new ArrayList<>();
		}
	}
	/**
	 * 边结构
	 * @author reyco
	 *
	 */
	public static class Edge{
		int weight;	//边的权重
		Node from;  //出的点
		Node to;    //目的点
		public Edge(int weight, Node from, Node to) {
			this.weight = weight;
			this.from = from;
			this.to = to;
		}
	}
	
}
