package com.example.other.test.other;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 类职责：测试Arrays类<br/>
 *
 * <p>Title: ArraysTest.java</p>
 * <p>Description: 测试Arrays类</p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2019年02月12日 上午 10:48
 * <p></p>
 * <p> </p>
 */
public class ArraysTest {
	
	static String[] strings = new String[]{"Hello", ",", "world", "!"};
	static int[] orderInts = new int[]{11, 22, 33, 44, 55, 66, 77, 88};
	static int[] disorderInts = new int[]{89, 1, 0, 12, 15, 1222, 256, 29};
	static int[] disorderInts2 = new int[]{89, 1, 0, 12, 15, 1222, 256, 29};
	static long[] disorderLongs = new long[]{8900, 1231, 5000000, 899652152, 5120315, 1222, 256, 0, 29};
	static byte[] disorderBytes = new byte[]{11, 3, 49, 56, 33, 98, 127, 0, 29};
	static Object[] objects = new Object[]{new HashMap<>(), Boolean.TRUE, "String", strings};
	
	public static void main(String[] args) {
//		testSpliterator();
//		testToString();
//		testHashCode();
//		testAsList();
//		testCopyOfRange();
//		testCopyOfInt();
//		testCopyOf();
//		testFill();
//		testEquals();
//		testBinarySearch();
//		testSortInt();
//		testSortInt(1, 4);
//		testSortLong();
//		testSortByte();
	}
	
	static void testSpliterator() {
		System.out.println(Arrays.deepToString(objects));
		System.out.println(Arrays.spliterator(objects) );
		System.out.println(Arrays.deepToString(objects));
	}
	
	/**
	 * toString		：只遍历一层
	 * deepToString ：可以遍历数组内部的数组
	 */
	static void testToString() {
		System.out.println(Arrays.toString(objects));
		System.out.println(Arrays.deepToString(objects));
	}
	
	/**
	 * 获取hashCode
	 */
	static void testHashCode() {
		System.out.println(Arrays.toString(disorderInts));
		System.out.println(Arrays.hashCode(disorderInts));
		
		System.out.println(Arrays.toString(disorderInts2));
		System.out.println(Arrays.hashCode(disorderInts2));
	}
	
	/**
	 * 将原数组转化为List
	 */
	static void testAsList() {
		System.out.println("原数组：" + Arrays.toString(strings));
		List<String> newList = Arrays.asList(strings);
		System.out.println("新List：" + newList);
	}
	
	/**
	 * 将原数组指定范围复制到新数组中
	 */
	static void testCopyOfRange() {
		System.out.println("原数组：" + Arrays.toString(strings));
		String[] newStrings = Arrays.copyOfRange(strings, 1, 3, String[].class);
		System.out.println("新数组：" + Arrays.toString(newStrings));
	}
	
	/**
	 * 将原数组指定长度复制到新数组中，newLength为新数组的长度
	 */
	static void testCopyOf() {
		System.out.println("原数组：" + Arrays.toString(strings));
		String[] newStrings = Arrays.copyOf(strings, strings.length - 3);
		System.out.println("新数组：" + Arrays.toString(newStrings));
	}
	
	/**
	 * 将原数组指定长度复制到新数组中
	 */
	static void testCopyOfInt() {
		System.out.println("原数组：" + Arrays.toString(orderInts));
		int[] newInts = Arrays.copyOf(orderInts, orderInts.length - 3);
		System.out.println("新数组：" + Arrays.toString(newInts));
	}
	
	/**
	 * 将指定值，塞入数组中
	 */
	static void testFill() {
		int[] emptyInt = new int[5];
		System.out.println("空数组长度：" + emptyInt.length);
		System.out.println(Arrays.toString(emptyInt));
		Arrays.fill(emptyInt, 12);
		System.out.println(Arrays.toString(emptyInt));
	}
	
	/**
	 * 判断两个数组是否相同
	 */
	static void testEquals() {
		System.out.println(Arrays.equals(disorderInts, disorderInts2));
	}
	
	/**
	 * 二分法查询指定值在数组的中位置
	 */
	static void testBinarySearch() {
		System.out.println(Arrays.toString(orderInts));
		System.out.println(Arrays.binarySearch(orderInts, 5000000));
		
	}
	
	
	/**
	 * 对数组排序：递增
	 */
	static void testParallelSortInt() {
		System.out.println(Arrays.toString(disorderInts));
		Arrays.parallelSort(disorderInts);
		System.out.println(Arrays.toString(disorderInts));
	}
	
	/**
	 * 对数组排序：递增
	 */
	static void testSortInt() {
		System.out.println(Arrays.toString(disorderInts));
		Arrays.sort(disorderInts);
		System.out.println(Arrays.toString(disorderInts));
	}
	
	static void testSortInt(int fromIndex, int toIndex) {
		System.out.println(Arrays.toString(disorderInts));
		Arrays.sort(disorderInts, fromIndex, toIndex);
		System.out.println(Arrays.toString(disorderInts));
	}
	
	static void testSortLong() {
		System.out.println(Arrays.toString(disorderLongs));
		Arrays.sort(disorderLongs);
		System.out.println(Arrays.toString(disorderLongs));
	}
	
	static void testSortByte() {
		System.out.println(Arrays.toString(disorderBytes));
		Arrays.sort(disorderBytes);
		System.out.println(Arrays.toString(disorderBytes));
	}
}
