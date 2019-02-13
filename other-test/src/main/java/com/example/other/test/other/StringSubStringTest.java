package com.example.other.test.other;

import java.util.ArrayList;
import java.util.List;

/**
 * 类职责：调试subString()<br/>
 *
 * <p>Title: StringSubStringTest.java</p>
 * <p>Description: 调试subString()</p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2019年02月11日 下午 4:36
 * <p>Seen</p>
 * <p>V1.0 </p>
 */
public class StringSubStringTest {
	
	static class HugeStr {
		private String str = new String(new char[10000000]);
		
		public String getSubString(int begin, int end) {
			return str.substring(begin, end);
		}
	}
	
	static class ImprovedHugeStr {
		private String str = new String(new char[10000000]);
		
		public String getSubString(int begin, int end) {
			return new String(str.substring(begin, end));
		}
	}
	
	
	public static void main(String[] args) {
		List<String> handler = new ArrayList<>();
		for (int i = 0; i < 10000; i++) {
			HugeStr hugeStr = new HugeStr();
//			ImprovedHugeStr hugeStr = new ImprovedHugeStr();
			handler.add(hugeStr.getSubString(1, 5));
		}
	}
}
