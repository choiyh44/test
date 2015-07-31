package com.choiyh.test.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TestDateFormat {
	public static void main(String[] args) throws Exception {
		Date now = new Date();

		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		System.out.println(format.format(now)); // 20090529
		format = new SimpleDateFormat("E MMM dd HH:mm:ss", Locale.UK);
		System.out.println(format.format(now)); // Fri May 29 11:06:29
	}
}
