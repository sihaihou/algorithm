package com.reyco.algorithm.test.test3;

/**
 * 49
 * 小明去商店买苹果，只能买6或8个每袋,每个袋子不能拆分，求小明买n个苹果，最少需要几个袋子，如果搞不定，返回-1.
 * @author reyco
 *
 */
public class Test4 {
	
	public static void main(String[] args) {
		for (int i=0;i<100;i++) {
			int minBag = minBag(i);
			if(minBag==-1) {
				System.out.println("搞不顶数n："+i);
			}else {
				System.out.println(minBag);
			}
		}
	}

	public static int minBag(int n) {
		if(n<5 || (n&1)==1) {
			return -1;
		}
		int bag6 = -1;
		int bag8 = n/8;
		int rest = n-bag8*8;
		while(bag8>=0 && rest<24) {
			if(rest%6!=0) {
				rest = n-(--bag8)*8;
				continue;
			}
			bag6 = rest/6;
			break;
		}
		return bag6!=-1 ? bag6+bag8 : -1;
	}
	
}
