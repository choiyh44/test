package com.choiyh.test.util;

import org.apache.commons.lang.StringEscapeUtils;
import org.pegdown.Extensions;
import org.pegdown.PegDownProcessor;

public class PegDownTest {

	public static void main(String[] args) {
		new PegDownTest().run();
	}

	public void run() {
		PegDownProcessor pegDown;
		String html;
		String markdown = "# Marked in <script>alert('browser');</script>\n\nRendered by **marked**.";

		pegDown = new PegDownProcessor(Extensions.ALL);
		html = pegDown.markdownToHtml(StringEscapeUtils.escapeHtml(markdown));
		System.out.println("---SUPPRESS_ALL_HTML-------------------------------");
		System.out.println(html);

		pegDown = new PegDownProcessor(Extensions.SUPPRESS_ALL_HTML);
		html = pegDown.markdownToHtml(markdown);
		System.out.println("---SUPPRESS_ALL_HTML-------------------------------");
		System.out.println(html);

		pegDown = new PegDownProcessor(Extensions.SUPPRESS_HTML_BLOCKS);
		html = pegDown.markdownToHtml(markdown);
		System.out.println("---SUPPRESS_HTML_BLOCKS-------------------------------");
		System.out.println(html);

		pegDown = new PegDownProcessor(Extensions.SUPPRESS_INLINE_HTML);
		html = pegDown.markdownToHtml(markdown);
		System.out.println("---SUPPRESS_INLINE_HTML-------------------------------");
		System.out.println(html);

		pegDown = new PegDownProcessor(Extensions.SMARTYPANTS);
		html = pegDown.markdownToHtml(markdown);
		System.out.println("---SMARTYPANTS-------------------------------");
		System.out.println(html);

	}
}
