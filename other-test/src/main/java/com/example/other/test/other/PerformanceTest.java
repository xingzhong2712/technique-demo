package com.example.other.test.other;

import lombok.Data;

import java.time.Instant;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

/**
 * 类职责：<br/>
 *
 * <p>Title: PerformanceTest.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2019年02月14日 下午 1:32
 * <p></p>
 * <p> </p>
 */
public class PerformanceTest {
	
	static int amount = Integer.MAX_VALUE;
	
	
	public static void main(String[] args) {
		Student student1 = new Student();
		student1.setId(1);
		student1.setName("xiao ming");
		Vector<String> courseV = new Vector<>();
		courseV.add("Java");
		courseV.add("Math");
		student1.setCourse(courseV);
		
		Student student2 = student1.newInstance();
		student2.setId(1);
		student2.setName("xiao hong");
		courseV.add("Python");
		student2.setCourse(courseV);
		
		System.out.println("student1 'name:" + student1.getName());
		System.out.println("student2 'name:" + student2.getName());
		
		System.out.println(student1.getCourse() == student2.getCourse());
//		amount = 100000000;
//		testSwitch1();
//		testSwitch2();
		// 经测试，switch比array效率高很多

//		testBitOpera();
//		testMultiplyDivide();
		// 经测试，位运算效率远高于乘除法

//		testVariable1();
//		testVariable2();
		// 经测试，局部变量的效率远高于静态变量

//		testException1();
//		testException2();
		// 经测试区别不明显！！！
	}
	
	@Data
	private static
	class Student implements Cloneable {
		private int id;
		private String name;
		private Vector course;
		
		public Student() {
			try {
				TimeUnit.MILLISECONDS.sleep(2000);
				System.out.println("Student constructor called.");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		public Student newInstance() {
			try {
				// 浅复制
				return (Student) this.clone();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
			
			return null;
		}
	}
	
	static void testSwitch1() {
		long begin = Instant.now().toEpochMilli();
		long a = 0;
		for (int i = 0; i < amount; i++) {
			a = switchInt(i);
		}
		
		System.out.println("耗时：" + (Instant.now().toEpochMilli() - begin) + " ms");
	}
	
	private static int switchInt(int a) {
		int i = a % 10 + 1;
		switch (i) {
			case 1:
				return 3;
			case 2:
				return 6;
			case 3:
				return 7;
			case 4:
				return 8;
			case 5:
				return 10;
			case 6:
				return 16;
			case 7:
				return 18;
			case 8:
				return 44;
			default:
				return -1;
		}
	}
	
	static void testSwitch2() {
		long begin = Instant.now().toEpochMilli();
		int a = 0;
		int[] sw = new int[]{0, 3, 6, 7, 8, 10, 16, 18, 44};
		for (int i = 0; i < amount; i++) {
			a = arrayInt(sw, i);
		}
		
		System.out.println("耗时：" + (Instant.now().toEpochMilli() - begin) + " ms");
	}
	
	private static int arrayInt(int[] sw, int a) {
		int i = a % 10 + 1;
		if (i > 7 || i < 1) {
			return -1;
		} else {
			return sw[i];
		}
	}
	
	static void testBitOpera() {
		long begin = Instant.now().toEpochMilli();
		long a = 0;
		for (int i = 0; i < amount; i++) {
			a *= 2;
			a /= 2;
		}
		
		System.out.println("耗时：" + (Instant.now().toEpochMilli() - begin) + " ms");
	}
	
	static void testMultiplyDivide() {
		long begin = Instant.now().toEpochMilli();
		long a = 0;
		for (int i = 0; i < amount; i++) {
			a <<= 1;
			a >>= 1;
		}
		
		System.out.println("耗时：" + (Instant.now().toEpochMilli() - begin) + " ms");
	}
	
	static void testVariable1() {
		long begin = Instant.now().toEpochMilli();
		int a = 0;
		for (int i = 0; i < amount; i++) {
			a++;
		}
		
		System.out.println("耗时：" + (Instant.now().toEpochMilli() - begin) + " ms");
	}
	
	static int b = 0;
	
	static void testVariable2() {
		long begin = Instant.now().toEpochMilli();
		for (int i = 0; i < amount; i++) {
			b++;
		}
		
		System.out.println("耗时：" + (Instant.now().toEpochMilli() - begin) + " ms");
	}
	
	static void testException1() {
		long begin = Instant.now().toEpochMilli();
		int a = 0;
		for (int i = 0; i < amount; i++) {
			try {
				a++;
			} catch (Exception e) {
			}
		}
		
		System.out.println("耗时：" + (Instant.now().toEpochMilli() - begin) + " ms");
	}
	
	static void testException2() {
		long begin = Instant.now().toEpochMilli();
		int a = 0;
		
		try {
			for (int i = 0; i < amount; i++) {
				a++;
			}
		} catch (Exception e) {
		}
		
		System.out.println("耗时：" + (Instant.now().toEpochMilli() - begin) + " ms");
	}
}
