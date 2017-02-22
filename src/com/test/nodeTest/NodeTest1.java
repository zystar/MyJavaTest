package com.test.nodeTest;

import java.util.List;

public class NodeTest1 {
	public static void process(Node node){
		for (int i = 0; i < node.children.size(); i++) {
			Node child = node.children.get(i);
			if(child.value < node.value){
				process(child);
			}
		}
		System.out.println(node.value);
		for (int i = 0; i < node.children.size(); i++) {
			Node child = node.children.get(i);
			if(child.value >= node.value){
				process(child);
			}
		}
	}
}

class Node {
	public Double value;
	public List<Node> children;
}