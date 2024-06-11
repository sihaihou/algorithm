package com.reyco.algorithm.hash;

/**
 * 有一个包含100一个URL的大文件，假设每个URL占用64B，请找出所有重复的URL.
 * 答： 
 *     1.如果内存够大，用布隆过滤器过滤每个数值是否出现过，出现过的添加到Hash表中。
 *     2.内存比较小，可以可以用一致性hash把大文件分流到N个小文件，如果文件还大，继续hash分流到M个小文件，求出每个小文件的重复URL，在整体合并所有重复的URL。
 * 
 * 
 * 
 * 补充：某公司一天的用户搜索词汇量是海里的（百亿数据量），请设计一种求出每天热门Top100词汇的可行方法!
 * 答：1.hash分流到N小文件，如果文件还大，继续hash分流到M个小文件，利用小根堆求出每个小文件的的Top100,然后在利用小根堆求出总的Top100。
 * 
 * 
 * @author reyco
 *
 */
public class Test3 {
	
	public static void main(String[] args) {
		
	}
	
}
