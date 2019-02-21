package com.example.other.test.datastructure;

/**
 * @Title: DoubleLoopNodeTest.java
 * @Package com.example.other.test.datastructure
 * @Description: 双向循环链表调试
 * @author: Seen
 * @date: 2019.02.21 下午 1:20
 * @Copyright: Copyright (c) 2019 浙江执御信息技术有限公司
 */

public class DoubleLoopNodeTest {
	public static void main(String[] args) {
		// 1::pre:1 next:1
		DoubleLoopNode doubleLoopNode1 = new DoubleLoopNode(1);
		System.out.println(doubleLoopNode1.getPre().getData() + ":" + doubleLoopNode1.getNext().getData());
		System.out.println("************************************************");
		DoubleLoopNode doubleLoopNode2 = new DoubleLoopNode(2);
		DoubleLoopNode doubleLoopNode3 = new DoubleLoopNode(3);
		// 2::pre:1 next:1
		// 1::pre:2 next:2
		doubleLoopNode1.after(doubleLoopNode2);
		System.out.println(doubleLoopNode1.getPre().getData() + ":" + doubleLoopNode1.getNext().getData());
		System.out.println(doubleLoopNode2.getPre().getData() + ":" + doubleLoopNode2.getNext().getData());
		System.out.println("************************************************");
		// 3::pre:2 next:1
		// 2::pre:1 next:3
		// 1::pre:3 next:2
		doubleLoopNode2.after(doubleLoopNode3);
		System.out.println(doubleLoopNode1.getPre().getData() + ":" + doubleLoopNode1.getNext().getData());
		System.out.println(doubleLoopNode2.getPre().getData() + ":" + doubleLoopNode2.getNext().getData());
		System.out.println(doubleLoopNode3.getPre().getData() + ":" + doubleLoopNode3.getNext().getData());
		System.out.println("************************************************");
		DoubleLoopNode doubleLoopNode4 = new DoubleLoopNode(4);
		// 4::pre:1 next:2
		// 2::pre:4 next:3
		// 3::pre:2 next:1
		// 1::pre:3 next:4
		doubleLoopNode1.after(doubleLoopNode4);
		System.out.println(doubleLoopNode1.getPre().getData() + ":" + doubleLoopNode1.getNext().getData());
		System.out.println(doubleLoopNode2.getPre().getData() + ":" + doubleLoopNode2.getNext().getData());
		System.out.println(doubleLoopNode3.getPre().getData() + ":" + doubleLoopNode3.getNext().getData());
		System.out.println(doubleLoopNode4.getPre().getData() + ":" + doubleLoopNode4.getNext().getData());
		System.out.println("************************************************");
		DoubleLoopNode doubleLoopNode5 = new DoubleLoopNode(5);
		// 3::pre:2 next:5
		// 5::pre:3 next:1
		// 1::pre:5 next:4
		// 4::pre:1 next:2
		// 2::pre:4 next:3
		doubleLoopNode3.after(doubleLoopNode5);
		System.out.println(doubleLoopNode1.getPre().getData() + ":" + doubleLoopNode1.getNext().getData());
		System.out.println(doubleLoopNode2.getPre().getData() + ":" + doubleLoopNode2.getNext().getData());
		System.out.println(doubleLoopNode3.getPre().getData() + ":" + doubleLoopNode3.getNext().getData());
		System.out.println(doubleLoopNode4.getPre().getData() + ":" + doubleLoopNode4.getNext().getData());
		System.out.println(doubleLoopNode5.getPre().getData() + ":" + doubleLoopNode5.getNext().getData());
		System.out.println("************************************************");
	}
}
