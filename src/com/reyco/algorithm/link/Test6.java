package com.reyco.algorithm.link;

/**
 * 判断链表是否回文结构
 * @author reyco
 *
 */
public class Test6 {
	public static void main(String[] args) {
		//ListNode head = ListNodeFactory.createPalindrome(5);
		ListNode head = ListNodeFactory.createRandomFixedLength(10);
		System.out.print("判断回文前：");
		ListNodeUtils.forEach(head);
		boolean palindrome = isPalindrome(head);
		System.out.println();
		System.out.print("判断回文后：");
		ListNodeUtils.forEach(head);
		System.out.println();
		System.out.println(palindrome);
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
}
