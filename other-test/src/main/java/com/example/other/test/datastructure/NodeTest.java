package com.example.other.test.datastructure;

/**
 * @Title: NodeTest.java
 * @Package com.example.other.test.datastructure
 * @Description: 自定义单链表调试
 * @author: Seen
 * @date: 2019.02.20 上午 11:32
 * @Copyright: Copyright (c) 2019 浙江执御信息技术有限公司
 */

public class NodeTest {
	
	public static void main(String[] args) {
		Node node1 = new Node(11);
		Node node2 = new Node(22);
		Node node3 = new Node(33);
		Node node4 = new Node(44);
		System.out.println(node1);
		node1.append(2);
		System.out.println(node1);
		node1.append(3);
		System.out.println(node1);
		
		node1.append(node2).append(node3).append(node4);
		System.out.println(node1);
		node1.after(new Node(55));
		System.out.println(node1);
		node1.remove();System.out.println(node1);
		node1.next().remove();System.out.println(node1);
		node1.next().remove();System.out.println(node1);
		node1.next().remove();System.out.println(node1);
		node1.next().remove();System.out.println(node1);
		node1.next().remove();System.out.println(node1);
		node1.next().remove();System.out.println(node1);
		node1.next().remove();System.out.println(node1);
		node1.next().remove();System.out.println(node1);
		node1.next().remove();System.out.println(node1);
		node1.next().remove();System.out.println(node1);
		node1.next().remove();System.out.println(node1);
		node1.next().remove();System.out.println(node1);
		node1.next().remove();System.out.println(node1);
	}
}
