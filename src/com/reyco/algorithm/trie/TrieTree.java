/**
 * 38
 * 前缀树1.0
 * @author reyco
 *
 */
public class TrieTree {
	
	private Node root;
	
	public TrieTree() {
		root = new Node();
	}
	/**
	 * 添加一个字符串
	 * @param word
	 */
	public void insert(String word) {
		if(word==null || word.equals("")) {
			return;
		}
		Node curr = root;
		int i=0;
		while(i<word.length()) {
			if(curr.nexts[word.charAt(i)-'a']==null) {
				curr.nexts[word.charAt(i)-'a'] = new Node();
			}
			curr = curr.nexts[word.charAt(i)-'a'];
			curr.pass++;
			i++;
		}
		curr.end++;
	}
	public void delete(String word) {
		if(search(word)!=0) {
			Node curr = root;
			int i=0;
			while(i<word.length()) {
				if(--curr.nexts[word.charAt(i)-'a'].pass==0) {
					curr.nexts[word.charAt(i)-'a']=null;
					return;
				}
				curr = curr.nexts[word.charAt(i)-'a'];
				i++;
			}
			curr.end--;
		}
	}
	/**
	 * 这个字符串被加入过几次
	 * @param word
	 * @return
	 */
	public int search(String word) {
		if(word==null || word.equals("")) {
			return 0;
		}
		Node curr = root;
		int i=0;
		while(i<word.length()) {
			if(curr.nexts[word.charAt(i)-'a']==null) {
				return 0;
			}
			curr = curr.nexts[word.charAt(i)-'a'];
			i++;
		}
		return curr.end;
	}
	/**
	 * 有多少个字符串是以pre开头的
	 * @param pre
	 * @return
	 */
	public int prefixNumber(String pre) {
		if(pre==null || pre.equals("")) {
			return 0;
		}
		Node curr = root;
		int i=0;
		while(i<pre.length()) {
			if(curr.nexts[pre.charAt(i)-'a']==null) {
				return 0;
			}
			curr = curr.nexts[pre.charAt(i)-'a'];
			i++;
		}
		return curr.pass;
	}
	
	public static class Node{
		//通过我的节点有多少个
		int pass;
		//以我结尾的有多少个
		int end;
		//表示我下级的路
		Node[] nexts;
		public Node() {
			this.pass = 0;
			this.end = 0;
			// 0  --->  a
			// 1  --->  b
			// 2  --->  c
			// ...--->  
			// 25 --->  z
			//nexts[i]==null,i方向的路不存在
			this.nexts = new Node[26]; //如果都是小写字符，就是26个字符
		}
	}
}
