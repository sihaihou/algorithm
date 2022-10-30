package com.reyco.algorithm.link;

/**
 * 获取中节点
 * @author reyco
 *
 */
public class Test5 {
	public static void main(String[] args) {
		ListNode head = ListNodeFactory.createOrder(6);
		ListNodeUtils.forEach(head);
		System.out.println();
		ListNode midUp = getMidUp(head);
		ListNode midDown = getMidDown(head);
		System.out.println("midUp:"+midUp.val+",midDown:"+midDown.val);
	}
	/**
	 * 获取中上节点
	 * @param head
	 * @return
	 */
	public static ListNode getMidUp(ListNode head) {
		if(head==null || head.next==null || head.next.next==null) {
			return head;
		}
		ListNode slow  = head.next;
		ListNode fast  = head.next.next;
		while(fast.next!=null && fast.next.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	/**
	 * 获取中下节点
	 * @param head
	 * @return
	 */
	public static ListNode getMidDown(ListNode head) {
		if(head==null || head.next==null) {
			return head;
		}
		ListNode slow  = head.next;
		ListNode fast  = head.next;
		while(fast.next!=null && fast.next.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
}
