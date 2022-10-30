package com.reyco.algorithm.graph;

import com.reyco.algorithm.graph.Graph.Edge;
import com.reyco.algorithm.graph.Graph.Node;

/**
 * 给定N*3矩阵的matrix,索引0位置表示边的权重，索引1位置表示from,索引2位置表示to，转成我的图结构
 * @author reyco
 *
 */
public class Test {	
	
	public static void main(String[] args) {
		int[][] matrix = {
				{1,1,2},{2,1,3},{3,1,4},
				{1,2,1},{1,2,3},{2,2,4},
				{2,3,1},{1,3,2},{1,3,4},
				{3,4,1},{2,4,2},{1,4,3}
				};
		Graph graph = matrixToGraph(matrix);
		System.out.println(graph);
	}
	public static Graph matrixToGraph(int[][] matrix) {
		Graph graph = new Graph();
		for (int i=0;i<matrix.length;i++) {
			int weight = matrix[i][0];
			int from = matrix[i][1];
			int to = matrix[i][2];
			Node fromNode = new Node(from);
			Node toNode = new Node(to);
			if(!graph.nodes.containsKey(from)) {
				graph.nodes.put(from, fromNode);
			}
			if(!graph.nodes.containsKey(to)) {
				graph.nodes.put(to, toNode);
			}
			Edge edge = new Edge(weight,fromNode,toNode);
			graph.edges.add(edge);
			//
			fromNode.nexts.add(toNode);
			fromNode.edges.add(edge);
			fromNode.out++;
			toNode.in++;
		}
		return graph;
	}
}
