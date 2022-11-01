package com.reyco.algorithm.test.test3;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个小写字母字符串数组stickers,stickers[i]代表一张贴纸，每张贴纸可以按单个字母剪开使用，目的是拼出字符串target，
 * 求:最少需要多少张贴纸才可以完成这个任务？
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
		int[][] stickerMatrix = new int[stickers.length][26];
		for (int i=0;i<stickers.length;i++) {
			for(int j=0;j<stickers[i].length();j++) {
				stickerMatrix[i][stickers[i].charAt(j)-'a']++;
			}
		}
		Map<String,Integer> dp = new HashMap<>(); 
		dp.put("", 0);
		return process(stickerMatrix, target,dp);
	}
	/**
	 * 暴力递归
	 * @param stickerMatrix	贴纸矩阵
	 * @param rest			要搞定的字符串
	 * @param dp			缓存
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
			//贴纸必须包含rest中的字符
			if(stickerMatrix[i][rest.charAt(0)-'a']==0) {
				continue;
			}
			StringBuilder sb = new StringBuilder();
			for(int j=0;j<26;j++) {
				if(restArr[j]>0) {
					for (int k=0;k < Math.max(0, restArr[j]-stickerMatrix[i][j]);k++) {
						sb.append((char)('a'+j));
					}
				}
			}
			String s = sb.toString();
			int p1 = process(stickerMatrix,s,dp);
			if(p1!=-1) {
				ans = Math.min(ans, 1+p1);
			}
		}
		dp.put(rest, ans==Integer.MAX_VALUE ? -1 : ans);
		return ans;
	}
}
