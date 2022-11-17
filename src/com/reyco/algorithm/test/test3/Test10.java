package com.reyco.algorithm.test.test3;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个小写字母字符串数组stickers,stickers[i]代表一张贴纸，每张贴纸可以按单个字母剪开使用，目的是拼出字符串target，
 * 求:最少需要多少张贴纸才可以完成这个任务？
 *  答： 第一步：先生成每张贴纸的词频、被搞定target的词频
         第二步: 枚举每一张贴纸搞定target部分字后，剩余多少没有搞定的字递归调用
	 第三部：之前搞定和当前搞定比较哪个少就用哪个？
 * @author reyco
 *
 */
public class Test10 {

	public static void main(String[] args) {
		String[] stickers = {"aaaabbb","bbbbcccc","ddddeeee"};
		String target = "aaaae";
		System.out.println(minSticker(stickers, target));
	}
	/**
	 * 暴力递归
	 */
	public static int minSticker(String[] stickers,String target) {
	        //生成每张贴纸的词频
		int[][] stickerMatrix = new int[stickers.length][26];
		for (int i=0;i<stickers.length;i++) {
			for(int j=0;j<stickers[i].length();j++) {
				stickerMatrix[i][stickers[i].charAt(j)-'a']++;
			}
		}
		//搞定字符串需要的贴纸数，当要搞定空串是需要0张贴纸。
		Map<String,Integer> dp = new HashMap<>(); 
		dp.put("", 0);
		return process(stickerMatrix, target,dp);
	}
	/**
	 * 暴力递归
	 * @param stickerMatrix		贴纸矩阵
	 * @param rest			要搞定的字符串
	 * @param dp			搞定rest需要的贴纸数
	 * @return
	 */
	private static int process(int[][] stickerMatrix,String rest,Map<String,Integer> dp) {
		if(dp.containsKey(rest)) {
			return dp.get(rest);
		}
		//rest转数组
		int[] restArr = new int[26];
		for(int i=0;i<rest.length();i++) {
			restArr[rest.charAt(i)-'a']++;
		}
		//主流程
		int ans = Integer.MAX_VALUE;
		for(int i=0;i<stickerMatrix.length;i++) {
			// 枚举每一张贴
			//贴纸i中必须包含rest中的字符，不然程序跑不完了
			if(stickerMatrix[i][rest.charAt(0)-'a']==0) {
				continue;
			}
			// 第i张贴纸搞定后还剩的字符放入sbRest，然后递归调用
			StringBuilder sbRest = new StringBuilder();
			for(int j=0;j<26;j++) {
				if(restArr[j]>0) { //第j位置还有未搞定的才去搞定
					//第i张贴纸搞定j位置字符还剩多少，追加到剩余sbRest字符中去
					for (int k=0;k < Math.max(0, restArr[j]-stickerMatrix[i][j]);k++) {
						sbRest.append((char)('a'+j));
					}
				}
			}
			String s = sbRest.toString();
			int p1 = process(stickerMatrix,s,dp);
			if(p1!=-1) {
				ans = Math.min(ans, 1+p1);
			}
		}
		//经过贴纸一轮尝试搞定后，依然没有任何变化时，说明贴纸无法搞定目标字符串，直接返回-1。
		dp.put(rest, ans==Integer.MAX_VALUE ? -1 : ans);
		return ans;
	}
}
