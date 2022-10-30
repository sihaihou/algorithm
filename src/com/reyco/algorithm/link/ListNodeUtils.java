package com.reyco.algorithm.link;

/**
 * 链表工具类
 * @author reyco
 *
 */
public class ListNodeUtils {
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
	/**
	 * 判断链表是否回文结构
	 * @param head
	 * @return
	 */
	public static boolean isPalindrome(ListNode head) {
		if(head==null || head.next==null) {
			return true;
		}
		ListNode slow = head.next;
		ListNode fast = head.next;
		while(fast.next!=null && fast.next.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		//反正后半部分
		ListNode pre = null;
		ListNode next = null;
		ListNode curr = slow;
		while(curr!=null) {
			next = curr.next;
			curr.next = pre;
			pre = curr;
			curr = next;
		}
		//判断是否回文
		boolean flag = true;
		ListNode curr1 = pre;
		ListNode curr2 = head;
		while(curr1.next!=null && curr2.next!=null) {
			if(curr1.val!=curr2.val) {
				flag = false;
				break;
			}
			curr1 =curr1.next;
			curr2 =curr2.next;
		}
		//还原链表
		ListNode preNode = pre;
		pre = null;
		next = null;
		curr = preNode;
		while(curr!=null) {
			next = curr.next;
			curr.next = pre;
			pre = curr;
			curr = next;
		}
		return flag;
	}
	/**
	 * 找到链表的第一个入环点,如果没有返回null
	 * @param head
	 * @return
	 */
	public static ListNode getLoop(ListNode head) {
		if(head==null || head.next==null || head.next.next==null) {
			return null;
		}
		ListNode slowNode = head.next;
		ListNode quickNode = head.next.next;
		while(slowNode!=quickNode) {
			if(quickNode.next==null || quickNode.next.next==null) {
				return null;
			}
			slowNode = slowNode.next;
			quickNode = quickNode.next.next;
		}
		quickNode = head;
		while(slowNode != quickNode) {
			slowNode = slowNode.next;
			quickNode = quickNode.next;	
		}
		return slowNode;
	}
}
