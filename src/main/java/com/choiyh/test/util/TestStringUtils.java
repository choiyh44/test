package com.choiyh.test.util;

import org.springframework.util.StringUtils;

public class TestStringUtils {
	public static void main(String[] args) throws Exception {
		String resultStr;
		String testStr = "    1234567890    ";
		String nullStr = null;

		resultStr = StringUtils.trimWhitespace(testStr);
		System.out.println("[" + resultStr + "]");
		resultStr = StringUtils.trimWhitespace(nullStr);
		System.out.println("[" + resultStr + "]");

	}
}
