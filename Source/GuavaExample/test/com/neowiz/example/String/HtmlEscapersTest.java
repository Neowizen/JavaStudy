package com.neowiz.example.String;

import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.google.common.html.HtmlEscapers;

public class HtmlEscapersTest {

	private String HTML_TO_ESCAPE = "";
	
	@Before
	public void setUp() throws Exception {
		HTML_TO_ESCAPE = "<html><p>Escape this</p></html>";
	}

	@Test
	public void escape_with_guava() {
		String actual = HtmlEscapers.htmlEscaper().escape(HTML_TO_ESCAPE);

		assertThat(actual).isEqualTo("&lt;html&gt;&lt;p&gt;Escape this&lt;/p&gt;&lt;/html&gt;");
	}
	
	@Test
	public void escape_with_java() {
		String actual = HTML_TO_ESCAPE
								.replaceAll("&", "&amp;")
								.replaceAll("\"", "&quot;")
								.replaceAll("<", "&lt;")
								.replaceAll(">", "&gt;");
		
		assertThat(actual).isEqualTo("&lt;html&gt;&lt;p&gt;Escape this&lt;/p&gt;&lt;/html&gt;");
	}
}
