package com.reyco.algorithm.top;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 排行榜记录---前k条记录
 * TopRecord
 * 答：词频组织的小根堆：堆顶是门槛，只要出现的词频大于堆顶的词频，就把堆顶的替换掉并调整小根堆
 * 	      属性1: Map<String,Node> wordMap：某个字符串是否在存在（key:字符串,value:字符串的节点）；
 *    属性2: Map<Node,Integer> indexMap：每个字符串节点在堆上的索引位置;
 *    属性3： Node[] heap： 堆数组,索引0位置无效；
 *    属性4： heapSize：当前堆数组中有几个节点
 *    
 *    流程：添加一个字符串，看wordMap是否存在
 *    		情况1：如果不存在，则创建好放入wordMap中并在indexMap放入，索引为-1，无效;
 *          情况2：如果存在，词频加1,看堆是否已满：
 *               如果没有满，直接放入堆中heapSize位置并调整小根堆；
 *               如果满了，看当前的词频是否大于堆顶词频，如果大于，放在堆顶并调整小根堆
 * @author reyco
 *
 */
public class Test1 {
	
	public static void main(String[] args) {
		Random random = new Random();
		TopRecord topRecord = new TopRecord(3);
		String s = "abcdefghijklmnopqrstwvuxyz";
		//String s = "abc";
		for(int i=0;i<100;i++) {
			String word = s.charAt(random.nextInt(s.length()))+"";
			//System.out.println(word);
			topRecord.add(word);
		}
		topRecord.printTop();
	}
	/**
	 * 排行榜记录---前k条记录
	 * @author reyco
	 *
	 */
	public static class TopRecord{
		
		private final static int CAPACITY = 16;
		//词频
		private Map<String,Node> wordMap;
		//堆
		private Node[] heap;
		//词在堆中的索引位置
		private Map<Node,Integer> indexMap;
		
		private int heapSize;

		public TopRecord() {
			this(CAPACITY);
		}
		public TopRecord(int capacity) {
			super();
			this.wordMap = new HashMap<>();
			this.heap = new Node[capacity+1];
			this.indexMap = new HashMap<>();
			this.heapSize = 1;
		}
		/**
		 * 添加
		 * @param word
		 */
		public void add(String word) {
			Node currNode;
			int preIndex = -1;
			if((currNode=wordMap.get(word))==null) {
				currNode = new Node(word, 1);
				wordMap.put(word, currNode);
				indexMap.put(currNode, -1);
			}else {
				currNode.times++;
				preIndex = indexMap.get(currNode);
			}
			if(preIndex==-1) {
				if(heapSize==heap.length) {
					if(currNode.times>heap[1].times) {
						indexMap.put(heap[1], -1);
						indexMap.put(currNode, 1);
						heap[1] = currNode;
						heapify(1,heapSize);
					}
				}else {
					indexMap.put(currNode, heapSize);
					heap[heapSize] = currNode;
					heapInsert(heapSize++);
				}
			}else {
				heapify(preIndex, heapSize);
			}
		}
		public void printTop() {
			for (int i=1;i<heap.length;i++) {
				if(heap[i]==null) {
					break;
				}
				System.out.println("word:"+heap[i].word+",times:"+heap[i].times);
			}
		}
		/**
		 * 向上heapify
		 * heapInsert
		 * @param arr
		 * @param index
		 */
		private void heapInsert(int index) {
			while (index!=1 && heap[index].times < heap[index>>1].times) {
				swap(index, index>>1);
				index = index>>1;
			}
		}
		/**
		 * 向下heapify
		 * @param index
		 * @param size
		 */
		private void heapify(int index, int size) {
			int left = index<<1;
			while (left < size) {
				int less = left + 1 < size && heap[left + 1].times < heap[left].times ? left + 1 : left;
				less = heap[less].times < heap[index].times ? less : index;
				if (less == index) {
					break;
				}
				swap(less, index);
				index = less;
				left = index<<1;
			}
		}
		/**
		 * 数组索引交换位置
		 * @param arr
		 * @param i
		 * @param j
		 */
		private void swap(int i,int j) {
			indexMap.put(heap[i], j);
			indexMap.put(heap[j], i);
			Node temp = heap[i];
			heap[i]=heap[j];
			heap[j]=temp;
		}
	}
	public static class Node{
		public String word;
		public Integer times;
		public Node(String word, Integer times) {
			super();
			this.word = word;
			this.times = times;
		}
	}
}
