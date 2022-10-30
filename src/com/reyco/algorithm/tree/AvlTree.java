package com.reyco.lgorithm.tree;

/** 
 *   AVL树
 * @author  reyco
 * @date    2022.09.07
 * @version v1.0.1 
 */
public class AvlTree {
	
	public static void main(String[] args) {
		AvlTree avlTree = new AvlTree();
		long start = System.currentTimeMillis();
		/**
		 * 			
		 */
		//int[] nums = {-10,-3,0,5,9};
		for(int i=0;i<=10;i++) {
			avlTree.add(i);
		}
		long end = System.currentTimeMillis();
		System.out.println("end-start:"+(end-start));
		TreeNode search = avlTree.search(9);
		System.out.println(search.val);
		avlTree.remove(5);
		process(avlTree.root);
	}
	
	public static void process(TreeNode root) {
		if(root==null) {
			return;
		}
		System.out.print(root.val+" ");
		process(root.left);
		process(root.right);
	}
	
	TreeNode root;
	
	public void add(int value) {
		processAdd(value);
	}
	private void processAdd(int value) {
		TreeNode newTreeNode = new TreeNode(value, null, null, null);
		if(root==null) {
			root = newTreeNode;
		}else {
			TreeNode curr = root;
			TreeNode parent = root;
			while(curr!=null) {
				parent = curr;
				if(curr.val>value) {
					curr = curr.left;
				}else if(curr.val<value) {
					curr = curr.right;
				}
			}
			if(parent.val>value) {
				parent.left = newTreeNode;
				newTreeNode.parent = parent;
			}else {
				parent.right = newTreeNode;
				newTreeNode.parent = parent;
			}
		}
		//调整高度
		mt(newTreeNode);
	}
	/**
	 * 自动调整高度
	 * @author  reyco
	 * @date    2022年9月7日
	 * @version v1.0.1 
	 * @param node
	 */
	private void mt(TreeNode node) {
		TreeNode parent = node.parent;
		while(node!=null) {
			parent = node.parent;
			//如果不平衡，则调整平衡
			Response response = getResponse(node);
			if(!response.balanceTree) {
				if(response.leftHeight-response.rightHeight>=2) {
					if(node.left.left!=null) {
						rotateRight(node);
					}else {
						TreeNode root = rotateLeft(node);
						rotateRight(root);
					}
				}else if(response.leftHeight-response.rightHeight<2) {
					if(node.right.right!=null) {
						rotateLeft(node);
					}else {
						TreeNode root = rotateRight(node);
						rotateLeft(root);
					}
				}
			}
			node = parent;
		}
	}
	final static class Response{
		int minHeight;
		int maxheight;
		int leftHeight;
		int rightHeight;
		boolean balanceTree;
		public Response() {
		}
		public Response(int minHeight, int maxheight, int leftHeight, int rightHeight, boolean balanceTree) {
			super();
			this.minHeight = minHeight;
			this.maxheight = maxheight;
			this.leftHeight = leftHeight;
			this.rightHeight = rightHeight;
			this.balanceTree = balanceTree;
		}
	}
	private Response getResponse(TreeNode node) {
		if(node==null) {
			return new Response(0,0,0,0,true);
		}
		Response leftResponse = getResponse(node.left);
		Response rightResponse = getResponse(node.right);
		int minHeight = Math.min(leftResponse.minHeight, rightResponse.minHeight)+1;
		int maxHeight = Math.max(leftResponse.maxheight, rightResponse.maxheight)+1;
		boolean balanceTree = leftResponse.balanceTree && rightResponse.balanceTree 
				&& Math.abs(leftResponse.maxheight-rightResponse.maxheight)<2 && Math.abs(maxHeight-minHeight)<2;
		return new Response(minHeight,maxHeight,leftResponse.leftHeight+1,rightResponse.rightHeight+1,balanceTree);
	}
	public TreeNode search(int value) {
		if(root==null) {
			return null;
		}
		TreeNode curr = root;
		while(curr!=null) {
			if(curr.val==value) {
				return curr;
			}else if(curr.val>value) {
				curr = curr.left;
			}else{
				curr = curr.right;
			}
		}
		return curr;
	}
	/**
	 * 
	 * @author  reyco
	 * @date    2022年9月7日
	 * @version v1.0.1 
	 * @param value
	 * @return
	 */
	public void remove(int value) {
		if(root==null) {
			return;
		}
		TreeNode curr = root;
		while(curr!=null) {
			if(curr.val > value) {
				curr = curr.left;
			}else if(curr.val < value){
				curr = curr.right;
			}else {
				break;
			}
		}
		if(curr.left==null) {
			if(curr==root) {
				root = curr.right;
				root.parent = null;
			}else if(curr.parent.left==curr) {
				curr.parent.left = curr.right;
			}else if(curr.parent.right==curr){
				curr.parent.right = curr.right;
			}
			if(curr.right!=null) {
				curr.right.parent = curr.parent;
			}
			mt(curr.parent);
		}else if(curr.right==null) {
			if(curr==root) {
				root = curr.left;
				root.parent = null;
			}else if(curr.parent.left==curr) {
				curr.parent.left = curr.left;
				curr.left.parent = curr.parent;
			}else if(curr.parent.right==curr){
				curr.parent.right = curr.left;
				curr.left.parent = curr.parent;
			}
			mt(curr.left);
		}else{
			TreeNode target = curr.right;
			while(target.left!=null) {
				target = target.left;
			}
			TreeNode parent = target.parent;
			curr.val = target.val;
			if(parent.left==target) {
				parent.left = target.right;
			}else {
				parent.right = target.right;
			}
			if(target.right!=null) {
				target.right.parent = parent;
			}
			mt(parent);
		}
		
	}
	/**
	 * 左旋
	 * @author  reyco
	 * @date    2022年9月7日
	 * @version v1.0.1 
	 * @param node
	 */
	public TreeNode rotateLeft(TreeNode root) {
		TreeNode oldRoot = root;
		TreeNode newRoot = root.right;
		TreeNode temp = newRoot.left;
		TreeNode tempParent = oldRoot.parent;
		newRoot.parent = tempParent;
		newRoot.left = oldRoot;
		if(oldRoot.parent!=null) {
			oldRoot.parent.right = newRoot;
		}
		oldRoot.parent = newRoot;
		oldRoot.right = temp;
		if(temp!=null) {
			temp.parent = oldRoot;
		}
		if(this.root == root) {
			this.root = newRoot;
		}
		return newRoot;
	}
	/**
	 * 右旋
	 * @author  reyco
	 * @date    2022年9月7日
	 * @version v1.0.1 
	 * @param node
	 */
	public TreeNode rotateRight(TreeNode root) {
		TreeNode oldRoot = root;
		TreeNode newRoot = root.left;
		TreeNode temp = newRoot.right;
		TreeNode tempParent = oldRoot.parent;
		newRoot.parent = tempParent;
		newRoot.right = oldRoot;
		if(oldRoot.parent!=null) {
			oldRoot.parent.left = newRoot;
		}
		oldRoot.parent = newRoot;
		oldRoot.left = temp;
		if(temp!=null) {
			temp.parent = oldRoot;
		}
		if(this.root == root) {
			this.root = newRoot;
		}
		return newRoot;
	}
	final static class TreeNode {
		int val;
		TreeNode parent;
		TreeNode left;
		TreeNode right;

		TreeNode(int val,TreeNode parent,TreeNode left, TreeNode right) {
			this.val = val;
			this.parent = parent;
			this.left = left;
			this.right = right;
		}
	} 
}
