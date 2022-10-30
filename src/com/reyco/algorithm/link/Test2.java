package com.reyco.algorithm.link;

/**
 * 反转链表
 * @author reyco
 *
 */
public class Test2 {
	public static void main(String[] args) {
		ListNode head = ListNodeFactory.createOrder(10);
		System.out.print("反正前：");
		ListNodeUtils.forEach(head);
		ListNode reversalHead = reversal(head);
		System.out.println();
		System.out.print("反正后：");
		ListNodeUtils.forEach(reversalHead);
	}
	/**
	 * 反转链表
	 * @param head
	 * @return
	 */
	public static ListNode reversal(ListNode head) {
		ListNode pre = null;
		ListNode next = null;
		ListNode curr = head;
		while(curr!=null) {
			next = curr.next;
			curr.next = pre;
			pre = curr;
			curr = next;
		}
		return pre;
	}
}
