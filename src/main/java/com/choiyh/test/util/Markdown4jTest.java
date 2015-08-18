package com.choiyh.test.util;

import java.io.IOException;

import org.apache.commons.lang.StringEscapeUtils;
import org.markdown4j.Markdown4jProcessor;

public class Markdown4jTest {

	public static void main(String[] args) throws IOException {
		new Markdown4jTest().run();
	}

	public void run() throws IOException {
		Markdown4jProcessor markdown4j;
		String html;
		String markdown = "# Marked in <script>alert('browser');</script>\n\nRendered by **marked**.";

		System.out.println("---ORG markdown -------------------------------");
		System.out.println(markdown);

		markdown4j = new Markdown4jProcessor();
		html = markdown4j.process(markdown);
		//html = markdown4j.process(StringEscapeUtils.escapeHtml(markdown));
		System.out.println("---process-------------------------------");
		System.out.println(html);

	}
}
