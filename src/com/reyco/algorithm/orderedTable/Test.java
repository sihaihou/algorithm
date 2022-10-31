package com.reyco.algorithm.orderedTable;

public class Test {
	
	public static void main(String[] args) {
		SkipList<String, String> test = new SkipList<>();
		test.printAll(test);
		System.out.println("======================");
		test.put("A", "10");
		test.printAll(test);
		System.out.println("======================");
		test.remove("A");
		test.printAll(test);
		System.out.println("======================");
		test.put("E", "E");
		test.put("B", "B");
		test.put("A", "A");
		test.put("F", "F");
		test.put("C", "C");
		test.put("D", "D");
		test.printAll(test);
		System.out.println("======================");
		System.out.println(test.containsKey("B"));
		System.out.println(test.containsKey("Z"));
		System.out.println(test.firstKey());
		System.out.println(test.lastKey());
		System.out.println(test.floorKey("D"));
		System.out.println(test.ceilingKey("D"));
		System.out.println("======================");
		test.remove("D");
		test.printAll(test);
		System.out.println("======================");
		System.out.println(test.floorKey("D"));
		System.out.println(test.ceilingKey("D"));
		

	}

}
