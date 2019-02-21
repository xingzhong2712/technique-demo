package com.example.other.test.datastructure;

/**
 * @Title: LoopNodeTest.java
 * @Package com.example.other.test.datastructure
 * @Description: 循环链表调试
 * @author: Seen
 * @date: 2019.02.21 上午 11:38
 * @Copyright: Copyright (c) 2019 浙江执御信息技术有限公司
 */

public class LoopNodeTest {
	public static void main(String[] args) {
		LoopNode loopNode1 = new LoopNode(1);
		LoopNode loopNode2 = new LoopNode(2);
		LoopNode loopNode3 = new LoopNode(3);
		LoopNode loopNode4 = new LoopNode(4);
		LoopNode loopNode5 = new LoopNode(5);
		LoopNode loopNode6 = new LoopNode(6);
		LoopNode loopNode7 = new LoopNode(7);
		LoopNode loopNode8 = new LoopNode(8);
		LoopNode loopNode9 = new LoopNode(9);
		
		System.out.println(loopNode1.getData() + "-next-"+loopNode1.next().getData());
		loopNode1.after(loopNode2);
		System.out.println(loopNode1.getData() + "-next-"+loopNode1.next().getData()+"-next-"+loopNode2.next().getData());
		loopNode2.after(loopNode3);
		loopNode3.after(loopNode4);
		loopNode4.after(loopNode5);
		loopNode5.after(loopNode6);
		System.out.println(loopNode1.getData() + "-next-"+loopNode1.next().getData()+"-next-"+loopNode2.next().getData()+"-next-"+loopNode3.next().getData()+"-next-"+loopNode4.next().getData()+"-next-"+loopNode5.next().getData()+"-next-"+loopNode6.next().getData());
		
		loopNode3.after(loopNode8);
		loopNode1.after(loopNode9);
		
		loopNode6.after(loopNode7);
		
	}
}
