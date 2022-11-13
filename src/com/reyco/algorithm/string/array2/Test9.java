package com.reyco.algorithm.string.array2;

/**
 * 65
 * 返回数组arr中的子数组最大异或和。
 * 答：求arr[start...i] = arr[0...i] ^ arr[0...start-1]
 *    前缀树放的是arr[0...i-1]的所有异或和，
 *    不使用前缀树时，当我来的i的时候，我不知道从哪[start]开始能使我的异或和最大，
 *    这个时候前缀树就知道我应该从哪开始了，从高位往低位和我相反的时候能使异或和最大，
 *    	比如：0110，我最想要的是1001，能使异或和最大：0110^1001=1111
 * @author reyco
 *
 */
public class Test9 {
	
	public static void main(String[] args) {
		int[] arr = {9,6,11,3,5,12,8,7,10,15,14,4,1,13,2};
		if(maxEor1(arr)!=maxEor2(arr) 
				|| maxEor1(arr)!=maxEor3(arr)) {
			System.out.println("fail");
		}else {
			System.out.println("success");
		}
	}
	
	/**
	 * 方法3：前缀树
	 * @param arr
	 * @return
	 */
	public static int maxEor3(int[] arr) {
		if(arr==null || arr.length==0) {
			return 0;
		}
		int ans = 0;
		int sum = 0;
		NumTrie numTrie = new NumTrie();
		numTrie.add(0);
		for (int i = 0; i < arr.length; i++) {
			sum ^= arr[i];
			ans = Math.max(ans, numTrie.maxXor(sum));
			numTrie.add(sum);
		}
		return ans;
	}
	public static class Node{
		public Node[] nexts = new Node[2];
	}
	public static class NumTrie{
		public Node head = new Node();
		/**
		 * 
		 * @param num
		 */
		public void add(int num) {
			Node cur = head;
			for (int move = 31; move >= 0; move--) {
				int path = (num>>move)&1;
				cur.nexts[path] = cur.nexts[path]==null ? new Node() : cur.nexts[path];
				cur = cur.nexts[path];
			}
		}

		public int maxXor(int sum) {
			Node cur = head;
			int res = 0;
			for(int move=31;move>=0;move--) {
				int path = (sum>>move)&1;
				int best = move==31 ? path : path^1;
				best = cur.nexts[best]!=null ? best : (best^1);
				res |= (path^best)<<move;
				cur = cur.nexts[best];
			}
			return res;
		}
		
	}
	/**
	 * 方法2：时间复杂度： O(n^2)
	 * 尝试必须以arr[i]为结尾的子数组，最大异或和是多少,尝试所有的arr[i].
	 * @param arr
	 * @return
	 */
	public static int maxEor2(int[] arr) {
		if(arr==null || arr.length==0) {
			return 0;
		}
		//pre0ToIEor[i]表示arr[0...i]的异或和
		int[] pre0ToIEor = new int[arr.length];
		pre0ToIEor[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			pre0ToIEor[i] = pre0ToIEor[i-1]^arr[i]; 
		}
		int ans = 0;
		for (int i = 0; i < arr.length; i++) {
			//必须以arr[i]结尾，0...i每一个开头
			for (int start = 0; start <= i; start++) {
				int sum = pre0ToIEor[i]^(start-1==-1 ? 0 : pre0ToIEor[start-1]);
				ans = Math.max(ans, sum);
			}
		}
		return ans;
	}
	/**
	 * 方法1：时间复杂度： O(n^3)
	 * 尝试必须以arr[i]为结尾的子数组，最大异或和是多少,尝试所有的arr[i].
	 * @param arr
	 * @return
	 */
	public static int maxEor1(int[] arr) {
		if(arr==null || arr.length==0) {
			return 0;
		}
		int ans = 0;
		for (int i = 0; i < arr.length; i++) {
			//必须以arr[i]结尾，0...i每一个开头
			for (int start = 0; start <= i; start++) {
				int sum = 0;
				for (int index = start; index < i; index++) {
					sum ^= arr[index]; 
				}
				ans = Math.max(ans, sum);
			}
		}
		return ans;
	}
	
	
}
