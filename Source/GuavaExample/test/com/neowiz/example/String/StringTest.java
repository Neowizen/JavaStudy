package com.neowiz.example.String;

import static org.fest.assertions.api.Assertions.assertThat;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.codec.binary.Base64;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author nal<daygoods@neowiz.com>
 * @date 2015. 9. 25. 오후 3:10:25
 */
public class StringTest {

	@Ignore
	@Test
	public void test() {
		String text = "박 상진(재무)";

		String check = text.substring(0, text.indexOf("("));

		System.out.println(check);
		assertThat(check).isEqualTo("박 상진");
	}

	@Ignore
	@Test
	public void test2() throws UnsupportedEncodingException {
		String text = "ab5ee8109ea444e2";

		byte[] decodeByte = Base64.decodeBase64(text);

		System.out.println(new String(decodeByte));
		System.out.println(new String(decodeByte, "EUC-KR"));
		System.out.println(new String(decodeByte, "UTF-8"));
		System.out.println(new String(decodeByte, "UTF-8"));
		System.out.println(new String(decodeByte, "UTF-8"));
		System.out.println(new String(decodeByte, "UTF-16"));
		System.out.println(new String(decodeByte, "UTF-16LE"));
	}

	@Test
	public void test3() {
		String text = "tabIndex=\"-1\" src=\"msoinline/ab5ee8109ea444e2\" xd:inline=\"iVBORw0KGg\"   dsdsds  tabIndex=\"-1\" src=\"msoinline/ab5ee8109ea444e2\" xd:inline=\"iVBORw0KGg\" src=\"x-view://44bade4a/msoinline/a0efd3114606487d\" xmlns=\"http://www.w3.org/1999/xhtml\" xd:inline=\"22iVBORw0KGgoAAAAN\"";

		System.out.println(text);

		// clean
		text = text.replaceAll("src=\"msoinline\\/.*?\"", "").replaceAll("src=\"x-view:\\/\\/.*?\"", "");
		System.out.println(text);

		Pattern msoPattern = Pattern.compile("xd:inline=\"");

		Matcher msoMatch = msoPattern.matcher(text);
		if (msoMatch.find()) {
			System.out.println("OK");
			text = msoMatch.replaceAll("src=\"data:image/*;base64,");
		}

		System.out.println(text);
	}

}
