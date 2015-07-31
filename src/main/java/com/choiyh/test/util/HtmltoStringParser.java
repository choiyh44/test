package com.choiyh.test.util;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class HtmltoStringParser {

	public static void main(String[] args) throws IOException {
		System.out.println(new HtmltoStringParser().parseHtmlToString("abcd"));
	}

	public static String parseHtmlToString(String html) throws IOException {
		Document doc = Jsoup.parse(html);
		String textOnly = doc.body().text();
		return textOnly;
	}
}
