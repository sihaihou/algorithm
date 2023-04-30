package com.reyco.algorithm.Union;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 41
 * 并查集
 *  判断o1、o2是否在同一个集合中： 看看o1和o2的顶级父类是否相同，相同，在同一个集合中；否则不在同一个集合。
 *  设置o1、o2到同一个集合中：先找到各自的顶级父类，看谁的父类节点数多，就把它设置为公共的顶级父类。
 * @author reyco
 *
 */
public class UnionFind<V> {
	
	private Map<V,Node<V>> nodes;
	private Map<Node<V>,Node<V>> parents;
	private Map<Node<V>,Integer> size;

	public UnionFind(Collection<V> values) {
		nodes = new HashMap<V, Node<V>>();
		parents = new HashMap<>();
		size = new HashMap<>();
		for (V v : values) {
			Node<V> node = new Node<>(v);
			nodes.put(v, node);
			parents.put(node, node);
			size.put(node, 1);
		}
	}
	/**
	 * 查找顶级父类
	 * @param node
	 * @return
	 */
	private Node<V> findFather(Node<V> node){
		Node<V> curr = node;
		Stack<Node<V>> nodesStack = new Stack<>();
		while(curr!=parents.get(curr)) {
			nodesStack.push(curr);
			curr = parents.get(curr);
		}
		while(!nodesStack.isEmpty()) {
			parents.put(nodesStack.pop(), curr);
		}
		return curr;
	}
	
	/**
	 * v1和v2是否同一个集合
	 * @param v1
	 * @param v2
	 * @return
	 */
	public boolean isSameSet(V v1,V v2) {
		Node<V> node1;
		Node<V> node2;
		if((node1=nodes.get(v1))==null || (node2=nodes.get(v2))==null) {
			return false;
		}
		return findFather(node1)==findFather(node2);
	}
	
	/**
	 * 合并v1和v2到一个集合
	 * @param v1
	 * @param v2
	 */
	public void union(V v1,V v2) {
		Node<V> node1;
		Node<V> node2;
		if((node1=nodes.get(v1))==null || (node2=nodes.get(v2))==null) {
			return;
		}
		Node<V> nodeFather1 = findFather(node1);
		Node<V> nodeFather2 = findFather(node2);
		if(nodeFather1!=nodeFather2) {
			Integer nodeSize1 = size.get(nodeFather1);
			Integer nodeSize2 = size.get(nodeFather2);
			if(nodeSize1>=nodeSize2) {
				parents.put(nodeFather2, nodeFather1);
				size.put(nodeFather1, nodeSize1+nodeSize2);
				size.remove(nodeFather2);
			}else {
				parents.put(nodeFather1, nodeFather2);
				size.put(nodeFather2, nodeSize1+nodeSize2);
				size.remove(nodeFather1);
			}
		}
	}
	protected Map<V, Node<V>> getNodes() {
		return nodes;
	}
	protected void setNodes(Map<V, Node<V>> nodes) {
		this.nodes = nodes;
	}
	protected Map<Node<V>, Node<V>> getParents() {
		return parents;
	}
	protected void setParents(Map<Node<V>, Node<V>> parents) {
		this.parents = parents;
	}
	protected Map<Node<V>, Integer> getSize() {
		return size;
	}
	protected void setSize(Map<Node<V>, Integer> size) {
		this.size = size;
	}

	public static class Node<V>{
		V val;
		public Node(V val) {
			super();
			this.val = val;
		}
	}
}
