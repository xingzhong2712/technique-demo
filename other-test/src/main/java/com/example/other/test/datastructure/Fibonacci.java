package com.example.other.test.datastructure;

/**
 * @Title: Fibonacci.java
 * @Package com.example.other.test.datastructure
 * @Description: 递归实现斐波那契数列：当前数位前两个数的和：1,1,2,3,5,8,13,21,34,55,89,144,....
 * @author: Seen
 * @date: 2019.02.21 下午 4:39
 * @Copyright: Copyright (c) 2019 浙江执御信息技术有限公司
 */

public class Fibonacci {
	
	public static void main(String[] args) {
		System.out.println(recursion(1));
		System.out.println(recursion(2));
		System.out.println(recursion(3));
		System.out.println(recursion(4));
		System.out.println(recursion(5));
		System.out.println(recursion(6));
		System.out.println(recursion(7));
		System.out.println(recursion(8));
		System.out.println(recursion(9));
	}
	
	private static int recursion(int num) {
		if (num < 3) {
			return 1;
		} else {
			return recursion(num - 1) + recursion(num - 2);
		}
	}
	
}
