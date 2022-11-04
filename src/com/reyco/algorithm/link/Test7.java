package com.reyco.algorithm.link;

/**
 * 两个可能有环的链表相交,返回第一个相交的节点
 * 答：
 *    1）快慢指针找到第一个入环的节点（只要有环）；
 *    2）一个有环一个无环绝对不相交；
 *    3）无环：先把长的那一部分走完，保证两个链表长度一致，在遍历节点是否相等，只要相等就是第一个相交的节点,否则不相交;
 *    4）都有环：
 *    	      两个环的节点相等（只有可能在在入环前相交）:先计算入环前的长度，先把长的那一部分走完，保证两个链表长度一致，在遍历节点是否相等，只要相等就是第一个相交的节点,否则不相交;
 *            两个环的节点不等（要么不相交，要么有两个交点）： 判断链表一中的节点是否有等于链表2的入环节点，只要有这个相等的节点就是其中一个相交的点。
 * @author reyco
 *
 */
public class Test7 {
	public static void main(String[] args) {
		ListNode node9 = new ListNode(9);
		ListNode node8 = new ListNode(8,node9);
		ListNode node7 = new ListNode(7,node8);
		ListNode node6 = new ListNode(6,node7);
		ListNode node5 = new ListNode(5,node6);
		ListNode node4 = new ListNode(4,node5);
		ListNode node3 = new ListNode(3,node4);
		ListNode node2 = new ListNode(2,node3);
		
		ListNode head1 = new ListNode(1);
		head1.next = node2;
		node9.next = node6;
		
		ListNode head3_1 = new ListNode(3,node4);
		ListNode node2_1 = new ListNode(3,head3_1);
		ListNode head2 = new ListNode(1,node2_1);
		//
		ListNode insertsectLoop = getInsertsectLoop(head1, head2);
		if(insertsectLoop!=null) {
			System.out.println(insertsectLoop.value);
		}
	}
	/**
	 * 返回两个可能有环链表相交的第一个节点
	 * @param head1
	 * @param head2
	 * @return
	 */
	public static ListNode getInsertsectLoop(ListNode head1,ListNode head2) {
		ListNode loop1 = loop(head1);
		ListNode loop2 = loop(head2);
		//两个没有入环的相交
		if(loop1==null && loop2==null) {
			return noLoop(head1,head2);
		}
		//两个有环的相交
		if(loop1!=null && loop2!=null) {
			return bothLoop(head1,loop1,head2,loop2);
		}
		//一个有环，一个没环，绝对不相交
		return null;
	}
	/**
	 * 两个都有环的链表相交的第一个节点
	 * @param head1  
	 * @param loop1
	 * @param head2
	 * @param loop2
	 * @return
	 */
	private static ListNode bothLoop(ListNode head1, ListNode loop1, ListNode head2, ListNode loop2) {
		ListNode curr1 = null;
		ListNode curr2 = null;
		if(loop1 == loop2) {
			curr1 = head1;
			curr2 = head2;
			int len = 0;
			while(curr1!=loop1) {
				curr1 = curr1.next;
				len++;
			}
			while(curr2!=loop2) {
				curr2 = curr2.next;
				len--;
			}
			curr1 = len > 0 ? head1 : head2;
			curr2 = curr1==head1 ? head2 : head1;
			len = Math.abs(len);
			while(len!=0) {
				curr1 = curr1.next;
				len--;
			}
			while(curr1!=curr2) {
				curr1 = curr1.next;
				curr2 = curr2.next;
			}
			return curr1;
		}else{
			curr1 = loop1.next;
			while(curr1!=loop1) {
				if(curr1==loop2) {
					return curr1;
				}
				curr1 = curr1.next;
			}
			return null;
		}
	}
	/**
	 * 没有环的两个链表相交的第一个节点
	 * @param head1
	 * @param head2
	 * @return
	 */
	private static ListNode noLoop(ListNode head1, ListNode head2) {
		int len = 0;
		ListNode curr1 = head1;
		ListNode curr2 = head2;
		while(curr1.next!=null) {
			curr1 = curr1.next;
			len++;
		}
		while(curr2.next!=null) {
			curr2 = curr2.next;
			len--;
		}
		curr1 = len > 0 ? head1 : head2;
		curr2 = curr1==head1 ? head2 : head1;
		len = Math.abs(len);
		while(len>0) {
			curr1 = curr1.next;
			len--;
		}
		while(curr1.next!=null) {
			if(curr1==curr2) {
				return curr1;
			}
			curr1 = curr1.next;
			curr2 = curr2.next;
		}
		return null;
	}
	/**
	 * 找到链表的第一个入环点,如果没有返回null
	 * @param head
	 * @return
	 */
	public static ListNode loop(ListNode head) {
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
	
	public static class ListNode{
		int value;
		ListNode next;
		public ListNode() {
		}
		ListNode(int value) {
			this.value = value;
		}
		ListNode(int value, ListNode next) {
			this.value = value;
			this.next = next;
		}
	}
}
