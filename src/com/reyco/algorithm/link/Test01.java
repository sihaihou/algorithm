package com.reyco.algorithm.link;

/**
 * 遍历链表
 * @author reyco
 *
 */
public class Test01 {
	public static void main(String[] args) {
		ListNode head = ListNodeFactory.createOrder(10);
		forEach(head);
	}
	/**
	 * 遍历链表
	 * @param head
	 */
	public static void forEach(ListNode head) {
		ListNode curr = head;
		while(curr!=null) {
			System.out.print(curr.val);
			System.out.print(", ");
			curr = curr.next;
		}
	}
}
