package com.neowiz.example.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.junit.Test;

/**
 * @author nal<daygoods@neowiz.com>
 * @date 2015. 9. 22. 오후 7:13:34
 */
public class DateTest {

	@Test
	public void dateFormat1() throws ParseException {

		String testDate1 = "2011-05-16 오후 5:24:17";
		String testDate2 = "2011-05-17 오전 10:13:46";

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd a HH:mm:ss");
		Date valueDate1 = dateFormat.parse(testDate1);
		Date valueDate2 = dateFormat.parse(testDate2);

		System.out.println(valueDate1.toString());
		System.out.println(valueDate2.toString());
	}

	@Test
	public void dateFormat2() throws ParseException {

		String testDate1 = "11/5/2010 PM 4:25:22";
		String testDate2 = "11/5/2010 PM 4:5:2";

		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy a HH:mm:ss", Locale.US);
		Date valueDate1 = dateFormat.parse(testDate1);
		Date valueDate2 = dateFormat.parse(testDate2);

		System.out.println(valueDate1.toString());
		System.out.println(valueDate2.toString());
	}

}
