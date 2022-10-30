package com.reyco.algorithm.tree.tree2;

import java.util.List;

/**
 *  class Employee{
 * 		int happy;
 *		List<Employee> employees;
 *	}
 * 公司办party，
 * 1，如果员工来了，那么他的直属下级都不能来，给定一个root节点boss，求party的最大快乐值。
 * @author reyco
 *
 */
public class Test2 {
	
	public static void main(String[] args) {
		Employee boss = new Employee();
		System.out.println(maxHappy(boss));
	}
	public static int maxHappy(Employee boss) {
		Info info = process(boss);
		return Math.max(info.laiMaxHappy, info.buMaxHappy);
	}
	public static Info process(Employee employee) {
		if(employee.employees==null) {
			return new Info(employee.happy, 0);
		}
		int lai = employee.happy;
		int bu = 0;
		for (Employee next : employee.employees) {
			Info info = process(next);
			lai += info.buMaxHappy;
			bu += Math.max(info.laiMaxHappy, info.buMaxHappy);
		}
		return new Info(lai, bu);
	}
	
	public static class Info {
		//来的最大快乐值
		int laiMaxHappy;
		//不来的最大快乐值
		int buMaxHappy;
		public Info(int laiMaxHappy, int buMaxHappy) {
			super();
			this.laiMaxHappy = laiMaxHappy;
			this.buMaxHappy = buMaxHappy;
		}
	}
	
	
	public static class Employee{
		int happy;
		List<Employee> employees;
		public int getHappy() {
			return happy;
		}
		public void setHappy(int happy) {
			this.happy = happy;
		}
		public List<Employee> getEmployees() {
			return employees;
		}
		public void setEmployees(List<Employee> employees) {
			this.employees = employees;
		}
	}
}
