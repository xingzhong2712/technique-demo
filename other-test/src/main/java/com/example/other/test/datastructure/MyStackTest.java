package com.example.other.test.datastructure;

/**
 * 类职责：测试自定义栈<br/>
 *
 * <p>Title: MyStackTest.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2019年02月13日 上午 10:10
 * <p></p>
 * <p> </p>
 */
public class MyStackTest {
	
	public static void main(String[] args) {
		MyStack stack = new MyStack();
		stack.push2(1);
		stack.push2(2);
		stack.push2(3);
		stack.push2(4);
		stack.push2(5);
		stack.push2(6);
		
		System.out.println(stack);
		System.out.println(stack.pop2());
		System.out.println(stack);
		System.out.println(stack.pop2());
		System.out.println(stack);
		System.out.println(stack.pop2());
		System.out.println(stack);
		System.out.println(stack.pop2());
		System.out.println(stack);
		System.out.println(stack.pop2());
		System.out.println(stack);
		System.out.println(stack.pop2());
		System.out.println(stack);
		System.out.println(stack.pop2());
		System.out.println(stack);
		System.out.println(stack.pop2());
		System.out.println(stack);
		System.out.println(stack.pop2());
		System.out.println(stack);
		System.out.println(stack.peek());
		System.out.println(stack);
	}
	
}
