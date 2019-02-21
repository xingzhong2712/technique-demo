package com.example.other.test.datastructure;

/**
 * @Title: DoubleLoopNode.java
 * @Package com.example.other.test.datastructure
 * @Description: 自定义双向循环链表
 * @author: Seen
 * @date: 2019.02.21 上午 11:48
 */

public class DoubleLoopNode {
	
	private int data;
	
	private DoubleLoopNode pre = this;
	
	private DoubleLoopNode next = this;
	
	public DoubleLoopNode(int data) {
		this.data = data;
	}
	
	public DoubleLoopNode getPre() {
		return pre;
	}
	
	public DoubleLoopNode getNext() {
		return next;
	}
	
	public int getData() {
		return data;
	}
	
	public void after(DoubleLoopNode node) {
		DoubleLoopNode curNode = this;
		DoubleLoopNode nextNext = next;
		curNode.next = node;
		node.pre = curNode;
		node.next = nextNext;
		nextNext.pre = node;
	}
	
}
