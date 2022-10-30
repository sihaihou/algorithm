package com.reyco.algorithm.link;

/**
 * 获取链表长度
 * @author reyco
 *
 */
public class Test3 {
	public static void main(String[] args) {
		ListNode head = ListNodeFactory.createOrder(10);
		int length = getLength(head);
		System.out.println("length:"+length);
	}
	/**
	 * 获取链表长度
	 * @param head
	 * @return
	 */
	public static int getLength(ListNode head) {
		int length = 0;
		ListNode curr = head;
		while(curr!=null) {
			length++;
			curr = curr.next;
		}
		return length;
	}
}
