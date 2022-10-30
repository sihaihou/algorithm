package com.reyco.algorithm.Union;

import java.util.Arrays;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
		UnionFind<Integer> union = new UnionFind<>(list);
		boolean sameSet = union.isSameSet(1, 2);
		System.out.println(sameSet);
		union.union(1, 2);
		union.union(2, 3);
		union.union(3, 4);
		sameSet = union.isSameSet(1, 2);
		System.out.println(sameSet);
		sameSet = union.isSameSet(1, 4);
		System.out.println(sameSet);
	}
}
