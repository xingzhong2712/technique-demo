package com.example.other.test.other;

import java.util.Arrays;

/**
 * 类职责：<br/>
 *
 * <p>Title: ArrayTest.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2019年02月12日 下午 5:13
 * <p></p>
 * <p> </p>
 */
public class ArrayTest {
	
	static int[] ints = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
	
	public static void main(String[] args) {
		int len = removeDuplicates(ints);
		System.out.println(Arrays.toString(ints));
		for (int i = 0; i < len; i++) {
			System.out.println(ints[i]);
		}
	}
	
	/*public static int removeDuplicates(int[] nums) {
		if (nums.length == 0) return 0;
		
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i+1; j < nums.length; j++) {
				if (nums[i] != nums[j]) {
					nums[i+1] = nums[j];
					break;
				}
			}
		}
		
		return count;
	}*/
	public static int removeDuplicates(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		
		int i = 0;
		for (int j = 1; j < nums.length; j++) {
			if (nums[j] != nums[i]) {
				nums[++i] = nums[j];
			}
		}
		
		return ++i;
	}
	
}
