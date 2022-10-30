package com.reyco.algorithm.link;

/**
 * 获取链表最大、最小值
 * @author reyco
 *
 */
public class Test4 {
	public static void main(String[] args) {
		ListNode head = ListNodeFactory.createOrder(10);
		int max = getMax(head);
		int min = getMin(head);
		System.out.println("max:"+max+",min:"+min);
	}
	/**
	 * 获取链表长度
	 * @param head
	 * @return
	 */
	public static int getMax(ListNode head) {
		int max = Integer.MIN_VALUE;
		ListNode curr = head;
		while(curr!=null) {
			max = Math.max(curr.val, max);
			curr = curr.next;
		}
		return max;
	}
	/**
	 * 获取链表长度
	 * @param head
	 * @return
	 */
	public static int getMin(ListNode head) {
		int max = Integer.MAX_VALUE;
		ListNode curr = head;
		while(curr!=null) {
			max = Math.min(curr.val, max);
			curr = curr.next;
		}
		return max;
	}
}
