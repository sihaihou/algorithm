package com.reyco.algorithm.link;

/**
 * 单向链表
 * @author reyco
 *
 */
public class ListNode {
	
	int val;
	
	ListNode next;
	
	public ListNode(int val) {
		super();
		this.val = val;
	}

	public ListNode(int val, ListNode next) {
		super();
		this.val = val;
		this.next = next;
	}
}
