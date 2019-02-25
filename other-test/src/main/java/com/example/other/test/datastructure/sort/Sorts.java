package com.example.other.test.datastructure.sort;

import java.util.Arrays;

/**
 * @Title: Sorts.java
 * @Package com.example.other.test.datastructure.sort
 * @Description: 八种排序算法：默认递增
 * @author: Seen
 * @date: 2019.02.25 上午 9:26
 */

public class Sorts {
	
	public static void main(String[] args) {
		int[] arr = new int[]{4, 9, 0, 6, 5, 1, 2, 7, 3, 8, 2, 4};
//		arr = new int[]{4, 4, 8, 8, 4, 4, 8, 8, 8, 8, 8, 4};
		System.out.println("排序前：" + Arrays.toString(arr));
//		bubble(arr);
//		quick(arr, 0, arr.length - 1);
		quick2(arr, 0, arr.length - 1);
		System.out.println("排序后：" + Arrays.toString(arr));
	}
	
	/**
	 * 冒泡排序：第一轮将最大的数放到最后，第二轮将第二大的数放到倒数第二位，依次类推。
	 * 时间复杂度O(n(n-1)) = O(n^2)
	 *
	 * @param arr 待排序数组
	 */
	private static void bubble(int[] arr) {
		// 对比的轮数
		for (int i = 0; i < arr.length; i++) {
			// 对比的次数：如第一轮，要对比的次数是除了自己外的所有数字即arr.length - 1次。第二轮，除了自己外的并且不包含最后一个，因为最后一个是第一轮排好的数，所以不需要比较，即arr.length - 1 - 1
			for (int j = 0; j < arr.length - 1 - i; j++) {
				// 如果当前值比下一个值大，则交换位置
				if (arr[j] > arr[j + 1]) {
					int tmp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = tmp;
				}
			}
		}
	}
	
	/**
	 * 快速排序（挖坑法）：
	 *
	 * @param arr        待排序数组
	 * @param beginIndex 开始的位置
	 * @param endIndex   结束的位置
	 */
	private static void quick(int[] arr, int beginIndex, int endIndex) {
		if (beginIndex >= endIndex) {
			return;
		}
		
		// 开始的位置
		int begin = beginIndex;
		// 结束的位置
		int end   = endIndex;
		// 基准值
		int refer = arr[beginIndex];
		
		while (begin < end) {
			// 从右侧开始比较，如果当前值比基准值大，则一直遍历，直到找到一个小的数
			while (begin < end && refer <= arr[end]) {
				end--;
			}
			// 将当前值赋给前面
			arr[begin] = arr[end];
			// 从左侧开始比较，如果当前值比基准值小，则一直遍历，直到找到一个大的数
			while (begin < end && refer >= arr[begin]) {
				begin++;
			}
			// 将当前值赋给后面
			arr[end] = arr[begin];
		}
		
		// 将基准值赋给结束位置
		arr[begin] = refer;
		
		// 处理小的数字
		quick(arr, beginIndex, end);
		// 处理大的数字
		quick(arr, begin + 1, endIndex);
	}
	
	/**
	 * 快速排序（左右指针法）：
	 *
	 * @param arr        待排序数组
	 * @param beginIndex 开始的位置
	 * @param endIndex   结束的位置
	 */
	private static void quick2(int[] arr, int beginIndex, int endIndex) {
		if (beginIndex >= endIndex) {
			return;
		}
		
		// 开始的位置
		int begin = beginIndex;
		// 结束的位置
		int end   = endIndex;
		// 基准值
		int refer = arr[beginIndex];
		
		while (begin < end) {
			// 从右侧开始比较，如果当前值比基准值大，则一直遍历，直到找到一个小的数
			while (begin < end && refer <= arr[end]) {
				end--;
			}
			// 从左侧开始比较，如果当前值比基准值小，则一直遍历，直到找到一个大的数
			while (begin < end && refer >= arr[begin]) {
				begin++;
			}
			
			if (begin < end) {
				int tmp    = arr[begin];
				arr[begin] = arr[end];
				arr[end]   = tmp;
			}
		}
		
		// 将基准值赋给结束位置
//		arr[beginIndex] = arr[begin];
//		arr[begin] 		= refer;
		
		// 处理小的数字
		quick(arr, beginIndex, end);
		// 处理大的数字
		quick(arr, begin + 1, endIndex);
	}
	
}
