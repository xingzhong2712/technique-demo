package com.example.other.test.datastructure;

/**
 * @Title: Hanoi.java
 * @Package com.example.other.test.datastructure
 * @Description: 递归实现汉诺塔
 * @author: Seen
 * @date: 2019.02.21 下午 5:17
 * @Copyright: Copyright (c) 2019 浙江执御信息技术有限公司
 */

public class Hanoi {
	
	public static void main(String[] args) {
//		recursion(1, 'A', 'B', 'C');
//		recursion(2, 'A', 'B', 'C');
		recursion(3, 'A', 'B', 'C');
	}
	
	private static void recursion(int nums, char from, char middle, char dest) {
		if (nums == 1) {
			System.out.println("1:从" + from + "移到" + dest);
		} else {
			recursion(nums - 1, from, dest, middle);
			System.out.println(nums + ":从" + from + "移到" + dest);
			recursion(nums-1, middle, from, dest);
		}
	}
}
