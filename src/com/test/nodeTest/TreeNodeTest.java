package com.test.nodeTest;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
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
	//后序遍历
	public List<Integer> postorderTraversal(TreeNode root){
		List<Integer> result = new ArrayList<>();
		if(root == null){
			return result;
		}
		Deque<TreeNode> stack = new ArrayDeque<>();
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode node = stack.pop();
			result.add(node.val);
			if(node.left != null)
				stack.push(node.left);
			if(node.right != null)
				stack.push(node.right);
		}
		Collections.reverse(result);
		return result;
	}
	/**
	 * 中序遍历
	 * @param root
	 * @中序遍历思路: 中序遍历迭代法思路不同于前序和后序.
	 * 首先针对对当前节点,一直对其左子树迭代并将非空节点入栈
     * 节点指针迭代为空(到树底了)后不再入栈,然后取栈顶元素,存结果;
     * 将当前指针用出栈的节点的右子节点替代,然后回到第一步继续迭代,直到当前节点为空且栈为空.
	 */
	public List<Integer> inorderTraversal(TreeNode root){
	      List<Integer> result = new ArrayList<>();
	      if(root==null) return result;
	      Deque<TreeNode> stack = new ArrayDeque<>();
	      while (root!=null||!stack.isEmpty()){
	          while(root!=null){
	              stack.push(root);
	              root=root.left;
	          }
	          TreeNode node=stack.pop();
	          result.add(node.val);
	          root=node.right;
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