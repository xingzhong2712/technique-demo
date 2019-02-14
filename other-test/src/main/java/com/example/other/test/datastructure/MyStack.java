package com.example.other.test.datastructure;

import java.util.Arrays;

/**
 * 类职责：<br/>
 *
 * <p>Title: MyStack.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2019年02月13日 上午 9:27
 * <p></p>
 * <p> </p>
 */
public class MyStack {
	
	private int[] elements = new int[0];
	
	/**
	 * 压栈
	 *
	 * @param element 入栈元素
	 */
	public void push(int element) {
		int[] newArray = new int[length() + 1];
		for (int i = 0; i < length(); i++) {
			newArray[i] = elements[i];
		}
		
		newArray[elements.length] = element;
		elements = newArray;
	}
	
	public void push2(int element) {
		int[] newArray = new int[length() + 1];
		System.arraycopy(elements, 0, newArray, 0, length());
		
		newArray[elements.length] = element;
		elements = newArray;
	}
	
	/**
	 * 弹栈
	 *
	 * @return
	 */
	public int pop() {
		if (empty()) {
			return 0;
		}
		
		int[] newArray = new int[length() - 1];
		for (int i = 0; i < length() - 1; i++) {
			newArray[i] = elements[i];
		}
		int element = elements[length() - 1];
		elements = newArray;
		return element;
	}
	
	public int pop2() {
		if (empty()) {
			return 0;
		}
		
		int[] newArray = new int[length() - 1];
		System.arraycopy(elements, 0, newArray, 0, newArray.length);
		int element = elements[length() - 1];
		elements = newArray;
		return element;
	}
	
	/**
	 * 获取栈顶元素
	 *
	 * @return
	 */
	public int peek() {
		if (empty()) {
			return 0;
		}
		
		return elements[length() - 1];
	}
	
	/**
	 * 栈深度
	 *
	 * @return
	 */
	public int length() {
		return elements.length;
	}
	
	/**
	 * 是否为空
	 *
	 * @return
	 */
	public boolean empty() {
		return length() == 0;
	}
	
	@Override
	public String toString() {
		return Arrays.toString(elements);
	}
	
}
