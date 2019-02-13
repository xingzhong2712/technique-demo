package com.example.other.test.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 类职责：调试ByteBuffer<br/>
 *
 * <p>Title: ByteBufferTest.java</p>
 * <p>Description: 调试ByteBuffer</p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2019年02月13日 上午 10:37
 * <p></p>
 * <p> </p>
 *
 * @author Administrator
 */
public class ByteBufferTest {
	
	public static void main(String[] args) throws IOException {
		test7();
//		test6();
//		test5();
//		test4();
//		test3();
//		test2();
//		test1();
	}
	
	/**
	 * 创建缓存区
	 */
	static void test1() {
		// 从堆中分配缓冲区
		ByteBuffer byteBuffer = ByteBuffer.allocate(15);
		// 从即有数组中分配缓冲区
		byte[] bytes = new byte[1024];
		ByteBuffer byteBuffer2 = ByteBuffer.wrap(bytes);
		
		
		System.out.print("1:	");
		System.out.println("limit=" + byteBuffer.limit() + " capacity=" + byteBuffer.capacity() + " position=" + byteBuffer.position());
		
		for (int i = 0; i < 10; i++) {
			byteBuffer.put((byte) i);
		}
		System.out.print("2:	");
		System.out.println("limit=" + byteBuffer.limit() + " capacity=" + byteBuffer.capacity() + " position=" + byteBuffer.position());
		
		byteBuffer.flip();
		System.out.print("3:	");
		System.out.println("limit=" + byteBuffer.limit() + " capacity=" + byteBuffer.capacity() + " position=" + byteBuffer.position());
		
		for (int i = 0; i < 5; i++) {
			System.out.print("\t");
			System.out.println(byteBuffer.get());
		}
		System.out.print("4:	");
		System.out.println("limit=" + byteBuffer.limit() + " capacity=" + byteBuffer.capacity() + " position=" + byteBuffer.position());
		
		byteBuffer.flip();
		System.out.print("5:	");
		System.out.println("limit=" + byteBuffer.limit() + " capacity=" + byteBuffer.capacity() + " position=" + byteBuffer.position());
	}
	
	/**
	 * 标记缓冲区
	 */
	static void test2() {
		// 从堆中分配缓冲区
		ByteBuffer byteBuffer = ByteBuffer.allocate(15);
		// 从即有数组中分配缓冲区
		byte[] bytes = new byte[1024];
		ByteBuffer byteBuffer2 = ByteBuffer.wrap(bytes);
		
		
		System.out.print("1:	allocate	");
		System.out.println("limit=" + byteBuffer.limit() + " capacity=" + byteBuffer.capacity() + " position=" + byteBuffer.position());
		
		for (int i = 0; i < 10; i++) {
			byteBuffer.put((byte) i);
		}
		System.out.print("2:	put			");
		System.out.println("limit=" + byteBuffer.limit() + " capacity=" + byteBuffer.capacity() + " position=" + byteBuffer.position());
		
		byteBuffer.flip();
		System.out.print("3:	flip		");
		System.out.println("limit=" + byteBuffer.limit() + " capacity=" + byteBuffer.capacity() + " position=" + byteBuffer.position());
		
		for (int i = 0; i < byteBuffer.limit(); i++) {
			System.out.print("\t");
			System.out.println(byteBuffer.get());
			if (i == 4) {
				byteBuffer.mark();
				System.out.print("4:	mark		");
				System.out.println("limit=" + byteBuffer.limit() + " capacity=" + byteBuffer.capacity() + " position=" + byteBuffer.position());
			}
		}
		System.out.print("5:	mark after	");
		System.out.println("limit=" + byteBuffer.limit() + " capacity=" + byteBuffer.capacity() + " position=" + byteBuffer.position());
		
		byteBuffer.reset();
		System.out.print("6:	reset		");
		System.out.println("limit=" + byteBuffer.limit() + " capacity=" + byteBuffer.capacity() + " position=" + byteBuffer.position());
		while (byteBuffer.hasRemaining()) {
			System.out.print("\t");
			System.out.println(byteBuffer.get());
		}
		System.out.print("7:	get after	");
		System.out.println("limit=" + byteBuffer.limit() + " capacity=" + byteBuffer.capacity() + " position=" + byteBuffer.position());
		
	}
	
	/**
	 * 复制缓冲区
	 */
	static void test3() {
		// 从堆中分配缓冲区
		ByteBuffer byteBuffer = ByteBuffer.allocate(15);
		// 从即有数组中分配缓冲区
		byte[] bytes = new byte[1024];
		ByteBuffer byteBuffer2 = ByteBuffer.wrap(bytes);
		
		
		System.out.print("1:	allocate	");
		System.out.println("limit=" + byteBuffer.limit() + " capacity=" + byteBuffer.capacity() + " position=" + byteBuffer.position());
		
		for (int i = 0; i < 10; i++) {
			byteBuffer.put((byte) i);
		}
		System.out.print("2:	put			");
		System.out.println("limit=" + byteBuffer.limit() + " capacity=" + byteBuffer.capacity() + " position=" + byteBuffer.position());
		
		ByteBuffer byteBuffer1 = byteBuffer.duplicate();
		System.out.print("3:	duplicate	");
		System.out.println("byteBuffer1:	limit=" + byteBuffer1.limit() + " capacity=" + byteBuffer1.capacity() + " position=" + byteBuffer1.position());
		System.out.println("byteBuffer:		limit=" + byteBuffer.limit() + " capacity=" + byteBuffer.capacity() + " position=" + byteBuffer.position());
		
		byteBuffer1.flip();
		System.out.print("4:	flip		");
		System.out.println("byteBuffer1:	limit=" + byteBuffer1.limit() + " capacity=" + byteBuffer1.capacity() + " position=" + byteBuffer1.position());
		System.out.println("byteBuffer:		limit=" + byteBuffer.limit() + " capacity=" + byteBuffer.capacity() + " position=" + byteBuffer.position());
		
		byteBuffer1.put((byte) 100);
		System.out.print("5:	put	100		");
		System.out.println("byteBuffer1:	limit=" + byteBuffer1.limit() + " capacity=" + byteBuffer1.capacity() + " position=" + byteBuffer1.position());
		System.out.println("byteBuffer1:	[0]" + byteBuffer1.get(0));
		System.out.println("byteBuffer:		limit=" + byteBuffer.limit() + " capacity=" + byteBuffer.capacity() + " position=" + byteBuffer.position());
		System.out.println("byteBuffer:		[0]" + byteBuffer.get(0));
	}
	
	/**
	 * 缓冲区分片
	 */
	static void test4() {
		// 从堆中分配缓冲区
		ByteBuffer byteBuffer = ByteBuffer.allocate(15);
		// 从即有数组中分配缓冲区
		byte[] bytes = new byte[1024];
		ByteBuffer byteBuffer2 = ByteBuffer.wrap(bytes);
		
		
		System.out.print("1:	allocate	");
		System.out.println("limit=" + byteBuffer.limit() + " capacity=" + byteBuffer.capacity() + " position=" + byteBuffer.position());
		
		for (int i = 0; i < 10; i++) {
			byteBuffer.put((byte) i);
		}
		System.out.print("2:	put			");
		System.out.println("limit=" + byteBuffer.limit() + " capacity=" + byteBuffer.capacity() + " position=" + byteBuffer.position());
		
		byteBuffer.position(2);
		byteBuffer.limit(6);
		ByteBuffer subByteBuffer = byteBuffer.slice();
		System.out.print("3:	slice		");
		System.out.println("subByteBuffer:	limit=" + subByteBuffer.limit() + " capacity=" + subByteBuffer.capacity() + " position=" + subByteBuffer.position());
		System.out.println("byteBuffer:		limit=" + byteBuffer.limit() + " capacity=" + byteBuffer.capacity() + " position=" + byteBuffer.position());
		
		for (int i = 0; i < subByteBuffer.capacity(); i++) {
			byte subByte = subByteBuffer.get(i);
			subByte *= 10;
			subByteBuffer.put(i, subByte);
			System.out.print("\t\t");
			System.out.println(subByteBuffer.get());
		}
		System.out.print("4:	sub	after put		");
		System.out.println("limit=" + subByteBuffer.limit() + " capacity=" + subByteBuffer.capacity() + " position=" + subByteBuffer.position());
		
		byteBuffer.position(0);
		byteBuffer.limit(byteBuffer.capacity());
		while (byteBuffer.hasRemaining()) {
			System.out.print("\t");
			System.out.println(byteBuffer.get());
		}
		System.out.print("5:	get after	");
		System.out.println("limit=" + byteBuffer.limit() + " capacity=" + byteBuffer.capacity() + " position=" + byteBuffer.position());
	}
	
	/**
	 * 只读缓冲区
	 */
	static void test5() {
		// 从堆中分配缓冲区
		ByteBuffer byteBuffer = ByteBuffer.allocate(15);
		// 从即有数组中分配缓冲区
		byte[] bytes = new byte[1024];
		ByteBuffer byteBuffer2 = ByteBuffer.wrap(bytes);
		
		
		System.out.print("1:	allocate	");
		System.out.println("limit=" + byteBuffer.limit() + " capacity=" + byteBuffer.capacity() + " position=" + byteBuffer.position());
		
		for (int i = 0; i < 10; i++) {
			byteBuffer.put((byte) i);
		}
		System.out.print("2:	put			");
		System.out.println("limit=" + byteBuffer.limit() + " capacity=" + byteBuffer.capacity() + " position=" + byteBuffer.position());
		
		ByteBuffer readOnlyByteBuffer = byteBuffer.asReadOnlyBuffer();
		System.out.print("3:	asReadOnlyBuffer		");
		System.out.println("readOnlyByteBuffer:	limit=" + readOnlyByteBuffer.limit() + " capacity=" + readOnlyByteBuffer.capacity() + " position=" + readOnlyByteBuffer.position());
		System.out.println("byteBuffer:		limit=" + byteBuffer.limit() + " capacity=" + byteBuffer.capacity() + " position=" + byteBuffer.position());
		
		readOnlyByteBuffer.flip();
		System.out.print("4:	flip		");
		System.out.println("readOnlyByteBuffer:	limit=" + readOnlyByteBuffer.limit() + " capacity=" + readOnlyByteBuffer.capacity() + " position=" + readOnlyByteBuffer.position());
		System.out.println("byteBuffer:		limit=" + byteBuffer.limit() + " capacity=" + byteBuffer.capacity() + " position=" + byteBuffer.position());
		
		while (readOnlyByteBuffer.hasRemaining()) {
			System.out.print("\t\t");
			System.out.println(readOnlyByteBuffer.get());
		}
		
		byteBuffer.put(2, (byte) 20);
//		readOnlyByteBuffer.put(3, (byte) 30); 	//throw java.nio.ReadOnlyBufferException
		readOnlyByteBuffer.flip();
		System.out.print("5:	flip		");
		System.out.println("readOnlyByteBuffer:	limit=" + readOnlyByteBuffer.limit() + " capacity=" + readOnlyByteBuffer.capacity() + " position=" + readOnlyByteBuffer.position());
		System.out.println("byteBuffer:		limit=" + byteBuffer.limit() + " capacity=" + byteBuffer.capacity() + " position=" + byteBuffer.position());
		
		while (readOnlyByteBuffer.hasRemaining()) {
			System.out.print("\t\t");
			System.out.println(readOnlyByteBuffer.get());
		}
	}
	
	/**
	 * 文件映射到缓存
	 *
	 * @throws IOException
	 */
	static void test6() throws IOException {
		RandomAccessFile randomAccessFile = new RandomAccessFile("F:/tests.txt", "rw");
		FileChannel fileChannel = randomAccessFile.getChannel();
		MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, randomAccessFile.length());
		
		while (mappedByteBuffer.hasRemaining()) {
			byte temp = mappedByteBuffer.get();
			System.out.print(temp + "--");
			System.out.println((char) temp);
		}
		
		mappedByteBuffer.put(0, (byte) 98);
		randomAccessFile.close();
		/*System.out.println("after modified..");
		for (int i = 0; i < mappedByteBuffer.limit(); i++) {
			System.out.println(mappedByteBuffer.get());
		}*/
	}
	
	/**
	 * 处理结构化数据：多buffer处理数据
	 */
	static void test7() throws IOException {
		ByteBuffer bookBuffer = ByteBuffer.wrap("Java性能技巧".getBytes("UTF-8"));
		ByteBuffer authBuffer = ByteBuffer.wrap("各一名".getBytes("UTF-8"));
		
		
		ByteBuffer[] buffers = new ByteBuffer[]{bookBuffer, authBuffer};
		File file = new File("F:/test2.txt");
		if (!file.exists()) {
			file.createNewFile();
		}
		
		FileOutputStream fos = new FileOutputStream(file);
		FileChannel fileChannel = fos.getChannel();
		// 聚集写文件
		fileChannel.write(buffers);
		fos.close();
		
		// 将文件中的内容读到缓存区
		int bookLength = bookBuffer.limit();
		int authLength = authBuffer.limit();
		ByteBuffer bookBuffer1 = ByteBuffer.allocate(bookLength);
		ByteBuffer authBuffer1 = ByteBuffer.allocate(authLength);
		
		ByteBuffer[] buffers1 = new ByteBuffer[]{bookBuffer1, authBuffer1};
		File file1 = new File("F:/test2.txt");
		FileInputStream fis = new FileInputStream(file1);
		FileChannel fileChannel1 = fis.getChannel();
		fileChannel1.read(buffers1);
		String bookName = new String(buffers1[0].array(), "UTF-8");
		String authName = new String(buffers1[1].array(), "UTF-8");
		
		System.out.println(bookName + authName);
	}
	
}
