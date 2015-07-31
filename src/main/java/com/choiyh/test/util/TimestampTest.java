package com.choiyh.test.util;

import java.sql.Timestamp;
import java.util.Date;

public class TimestampTest {
	public static void main(String[] args) {
		Timestamp timestamp = new Timestamp(new Date().getTime());

		System.out.println("Timestamp.toString(): " + timestamp.toString());
	}
}
