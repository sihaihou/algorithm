package com.reyco.algorithm.link;

import java.util.Random;

/**
 * 链表工厂
 * @author reyco
 *
 */
public class ListNodeFactory {
	
	private static Random random = new Random();
	
	/**
	 * 创建顺序链表
	 * @param length 链表长度
	 * @return
	 */
	public static ListNode createOrder(int length) {
		ListNode pre = null;
		ListNode head = pre;
		for(int i=1;i<=length;i++) {
			ListNode node = new ListNode(i);
			if(pre==null) {
				pre = node;
				head = pre;
			}else {
				pre.next = node;
			}
			pre = node;
		}
		return head;
	}
	/**
	 * 创建回文链表
	 * @return
	 */
	public static ListNode createPalindrome(int length) {
		if(length<=1) {
			return new ListNode(1);
		}
		ListNode pre = null;
		ListNode head = pre;
		boolean odd = (length&1)==1 ? true : false;
		int mid = length>>1;
		for(int i=1;i<=mid;i++) {
			ListNode node = new ListNode(i);
			if(pre==null) {
				pre = node;
				head = pre;
			}else {
				pre.next = node;
			}
			pre = node;
		}
		if(odd) {
			mid++;
		}
		for(int i=mid;i>0;i--) {
			ListNode node = new ListNode(i);
			pre.next = node;
			pre = node;
		}
		return head;
	}
	/**
	 * 随机创建固定长度链表
	 * @param maxVal	最大值
	 * @return
	 */
	public static ListNode createRandomFixedMax(int maxVal) {
		return createRandom(20, maxVal);
	}
	/**
	 * 随机创建链表
	 * @param length	链表长度
	 * @return
	 */
	public static ListNode createRandomFixedLength(int length) {
		return createRandom(length, 20);
	}
	/**
	 * 随机创建链表
	 * @param length
	 * @param maxVal
	 * @return
	 */
	public static ListNode createRandom(int length,int maxVal) {
		ListNode pre = null;
		ListNode head = null;
		for(int i=0;i<length;i++) {
			ListNode node = new ListNode(random.nextInt(maxVal)+1);
			if(pre==null) {
				pre = node;
				head = pre;
			}else {
				pre.next = node;
			}
			pre = node;
		}
		return head;
	}
}
