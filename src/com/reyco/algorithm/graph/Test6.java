package com.reyco.algorithm.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;

import com.reyco.algorithm.graph.Graph.Edge;
import com.reyco.algorithm.graph.Graph.Node;

/**
 * dijkstra算法---求单元最小路径
 * @author reyco
 *
 */
public class Test6 {
	public static void main(String[] args) {
		
	}
	public static Map<Node, Integer> dijkstra(Node from) {
		//从head出发到所有点的距离
		Map<Node, Integer> distanceMap = new HashMap<>();
		distanceMap.put(from, 0);
		//已经选择过的节点，防止重复
		HashSet<Node> selectedNodes = new HashSet<>();
		//获取distanceMap中最小距离的记录（不在已选择过的节点中），
		Node minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
		while (minNode != null) {
			//  原始点  ->  minNode(跳转点)   最小距离distance
			int distance = distanceMap.get(minNode);
			for (Edge edge : minNode.edges) {
				Node toNode = edge.to;
				//没有新增，如果已经存在，并且距离更小了，就更新
				if (!distanceMap.containsKey(toNode)) {
					distanceMap.put(toNode, distance + edge.weight);
				} else { // toNode 
					distanceMap.put(edge.to, Math.min(distanceMap.get(toNode), distance + edge.weight));
				}
			}
			//添加到已选择过集合中
			selectedNodes.add(minNode);
			//重新获取最小的，周而复始
			minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
		}
		return distanceMap;
	}

	public static Node getMinDistanceAndUnselectedNode(Map<Node, Integer> distanceMap, HashSet<Node> touchedNodes) {
		//当前最小距离距离的点
		Node minNode = null;
		//当前最小距离的距离
		int minDistance = Integer.MAX_VALUE;
		for (Entry<Node, Integer> entry : distanceMap.entrySet()) {
			Node node = entry.getKey();
			int distance = entry.getValue();
			if (!touchedNodes.contains(node) && distance < minDistance) { //不在已选择过的中
				minNode = node;
				minDistance = distance;
			}
		}
		return minNode;
	}
}
