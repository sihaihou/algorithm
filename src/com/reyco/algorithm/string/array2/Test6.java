package com.reyco.lgorithm.string.array2;

/**
 * 59
 * 给定两个排好序的一维数组A和B，其中A长度为m,B长度为n，希望从A和B数组中，找出最大的前k个数，要求:使用尽量少的比较次数。
 * @author reyco
 *
 */
public class Test6 {
	
	public static void main(String[] args) {
		int[] A = {1,2,3,4,5,6,7};
		int[] B = {3,4,5};
		int K = 3;
		int findK = findK(A, B, K);
		System.out.println(findK);
	}
	
	public static int findK(int[] A,int[] B,int K) {
		if(A==null || B==null) {
			throw new RuntimeException("第k大的数不存在");
		}
		if(K<1 || K>A.length+B.length) {
			throw new RuntimeException("k无效");
		}
		int[] longs = A.length>=B.length ? A : B;
		int[] shorts = A.length<B.length ? A : B;
		int L = longs.length;
		int S = shorts.length;
		if(K<=S) {
			return getUpMedian(shorts,0,K-1,longs,0,K-1);
		}
		if(K>L) {
			if(shorts[K-L-1]>=longs[L-1]) {
				return shorts[K-L-1];
			}
			if(longs[K-S-1]>=shorts[S-1]) {
				return longs[K-S-1];
			}
			return getUpMedian(shorts, K-L, S-1, longs, K-S, L-1);
		}
		if(longs[K-S-1]>=shorts[S-1]) {
			return longs[K-S-1];
		}
		return getUpMedian(shorts, 0, S-1, longs, K-S, K-L);
	}
	/**
	 * 求上中位数
	 * @param a1
	 * @param s1
	 * @param e1
	 * @param a2
	 * @param s2
	 * @param e2
	 * @return
	 */
	private static int getUpMedian(int[] a1, int s1, int e1, int[] a2, int s2, int e2) {
		int mid1 = 0;
		int mid2 = 0;
		int offset = 0;
		while(s1<e1) {
			mid1 = (s1+e1)/2;
			mid2 = (s2+e2)/2;
			offset = ((e1-s1+1)&1)^1;
			if(a1[mid1]==a2[mid2]) {
				return a1[mid1];
			}else if(a1[mid1]>a2[mid2]){
				e1 = mid1;
				s2 = mid2+offset;
			}else if(a1[mid1]<a2[mid2]) {
				s1 = mid1+offset;
				e2 = mid2;
			}
		}
		return Math.min(a1[s1],a2[s2]);
	}
	
}
