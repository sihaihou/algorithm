package com.reyco.lgorithm.string.array2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 全部子序列
 * @author reyco
 *
 */
public class Test4 {
	
	public static void main(String[] args) {
		String str = "abca";
		List<String> paths = new ArrayList<String>();
		process(str, 0, paths ,"");
		System.out.println(paths);
	}
	/**
	 * 全部子序列
	 * @param str
	 * @param index
	 * @param paths
	 * @param path
	 */
	public static void process(String str,int index,List<String> paths,String path){
		if(index==str.length()) {
			if(!path.equals("")) {
				paths.add(path);
			}
		}else {
			process(str, index+1, paths, path+str.charAt(index));
			process(str, index+1, paths, path);
		}
	}
	/**
	 * 全部子序列--去重
	 * @param str
	 * @param index
	 * @param paths
	 * @param path
	 */
	public static void process(String str,int index,Set<String> paths,String path){
		if(index==str.length()) {
			if(!path.equals("")) {
				paths.add(path);
			}
		}else {
			process(str, index+1, paths, path+str.charAt(index));
			process(str, index+1, paths, path);
		}
	}
	
}
