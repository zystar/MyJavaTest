package com.test.nodeTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author STAR
 * 二叉树深度遍历的非递归算法分析及Java实现
 * 参考：https://my.oschina.net/husthang/blog/852982
 */
public class TreeNodeTest {
	//前序遍历，迭代法
	public List<Integer> preorderTraversal(TreeNode root){
		List<Integer> result = new ArrayList<>();
		if(root == null){
			return result;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode node = stack.pop();
			result.add(node.val);
			if(node.right != null)
				stack.push(node.right);
			if(node.left != null)
				stack.push(node.left);
		}
		return result;
	}
}
class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int val){
		this.val = val;
	}
	public void display(){
		System.out.println("val:" + val);
	}
}