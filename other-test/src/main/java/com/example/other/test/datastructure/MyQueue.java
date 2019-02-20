package com.example.other.test.datastructure;

import java.util.Arrays;

/**
 * @Title: MyQueue.java
 * @Package com.example.other.test.datastructure
 * @Description: 自定义一个队列
 * @author: Seen
 * @date: 2019.02.20 上午 10:34
 * @Copyright: Copyright (c) 2019 浙江执御信息技术有限公司
 */

public class MyQueue {
	
	private int[] elements = new int[0];
	
	public void add(int element) {
		int[] newElements = new int[length() + 1];
		for (int i = 0; i < length(); i++) {
			newElements[i] = elements[i];
		}
		newElements[length()] = element;
		elements = newElements;
	}
	
	public int remove() {
		if (isEmpty()) {
			return 0;
		}
		int element = elements[0];
		int[] newElements = new int[length() - 1];
		for (int i = 0; i < newElements.length; i++) {
			newElements[i] = elements[i + 1];
		}
		elements = newElements;
		
		return element;
	}
	
	
	public int length() {
		return elements.length;
	}
	
	public boolean isEmpty() {
		return length() == 0;
	}
	
	@Override
	public String toString() {
		return Arrays.toString(elements);
	}
	
}
