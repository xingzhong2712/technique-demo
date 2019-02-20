package com.example.other.test.datastructure;

/**
 * @Title: Node.java
 * @Package com.example.other.test.datastructure
 * @Description: 自定义单链表
 * @author: Seen
 * @date: 2019.02.20 上午 11:00
 */

public class Node {
	
	private int data;
	
	private Node next;
	
	public Node() {
	
	}
	
	public Node(int data) {
		this.data = data;
	}
	
	public Node append(int data) {
		return append(new Node(data));
	}
	
	/**
	 * @Author      Seen
	 * @Description 追加子节点
	 * @Date        下午 1:30 2019-2-20
	 * @Param       [node]
	 * @return      com.example.other.test.datastructure.Node
	 */
	public Node append(Node node) {
		Node curNode = this;
		while (true) {
			if (curNode.next != null) {
				curNode = curNode.next;
			} else {
				curNode.next = node;
				break;
			}
		}
		
		return node;
	}
	
	/**
	 * @Author      Seen
	 * @Description 指定节点后，增加新节点
	 * @Date        下午 2:07 2019-2-20
	 * @Param       [node]
	 * @return      void
	 */
	public void after(Node node){
		Node newNext = next;
		next = node;
		node.next = newNext;
	}
	
	/**
	 * @Author      Seen
	 * @Description 删除当前节点的后一个节点
	 * @Date        下午 2:08 2019-2-20
	 * @Param       []
	 * @return      com.example.other.test.datastructure.Node
	 */
	public Node remove() {
		if (next != null) {
			Node newNext = next.next;
			Node oldNext = next;
			next = null;
			next = newNext;
			
			return oldNext;
		}
		
		return new Node();
	}
	
	public boolean hasNext() {
		return this.next != null;
	}
	
	/**
	 * @Author      Seen
	 * @Description 获取下个节点
	 * @Date        下午 2:08 2019-2-20
	 * @Param       []
	 * @return      com.example.other.test.datastructure.Node
	 */
	public Node next() {
		return next;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		Node curNode = this;
		do {
			sb.append(curNode.data);
			if (curNode.next != null) {
				sb.append(" ");
				curNode = curNode.next;
			} else {
				break;
			}
		} while (true);
		
		sb.append("]");
		
		return sb.toString();
	}
}
