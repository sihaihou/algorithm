package com.reyco.algorithm.link;

/**
 * 判断链表是否回文结构
 * 答：
 * 	1）快慢指针先找到下中节点;
 *  2）然后反转后半部分链表结构；
 *  3）双指针从头和下中节点遍历是否相等,只要有一个不等，否回文链表；否则是回文链表。
 *  4）恢复反转后的后半部分链表结构。
 * @author reyco
 *
 */
public class Test6 {
	public static void main(String[] args) {
		ListNode head = ListNodeFactory.createPalindrome(5);
		//ListNode head = ListNodeFactory.createRandomFixedLength(10);
		System.out.print("判断回文前：");
		ListNodeUtils.forEach(head);
		
		System.out.println();
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
		//快慢指针先找到下中节点;
		ListNode slow = head.next;
		ListNode fast = head.next;
		while(fast.next!=null && fast.next.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		//然后反转后半部分链表结构；
		ListNode pre = null;
		ListNode next = null;
		ListNode curr = slow;
		while(curr!=null) {
			next = curr.next;
			curr.next = pre;
			pre = curr;
			curr = next;
		}
		System.out.print("反转的链表：");
		ListNodeUtils.forEach(pre);
		//双指针从头和下中节点遍历是否相等,只要有一个不等，否回文链表；否则是回文链表。
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
		//恢复反转后的后半部分链表结构。
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
