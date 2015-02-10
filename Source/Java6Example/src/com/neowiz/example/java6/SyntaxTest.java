package com.neowiz.example.java6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author nal<daygoods@neowiz.com>
 * @date 2015. 2. 10. 오후 5:43:23
 */
public class SyntaxTest {

	private static final long TIMEOUT = 3600000;
	private static final int THOUSAND =  1000;
	private static final int MILLION  =  1000000;
	
	public void instanceTest() {
		Map<String, List<String>> test = new HashMap<String, List<String>>();
	}
	
	public void switchTest() {
		Integer key = 1;
		
		switch (key) {
			case 1 :
				break;
	
			default:
				break;
		}
		
		String check = "OK";
		if ("OK".equalsIgnoreCase(check)) {
			
		}
		else if ("FAIL".equalsIgnoreCase(check)) {
			
		}
	}
	
	public void resourceTest() {
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new FileInputStream(new File(""));
			out = new FileOutputStream("");
		} 
		catch (FileNotFoundException e) {
		}
		finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
				}
			}
			
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
				}
			}
		}
	}
	
	public void multiCatchTest(String test) {
		try {
			if (test == null) {
				throw new NullPointerException();	
			}
			else if (test.length() == 0) {
				throw new IllegalArgumentException();
			}
		} 
		catch (NullPointerException e) {
		} 
		catch (IllegalArgumentException e) {
		} 
	}
	
	public void collectionsTest() {
		List<Integer> test1 = new ArrayList<Integer>();
		test1.add(1);
		test1.add(1);
		test1.add(3);
				
		List<Integer> test2 = Collections.unmodifiableList(Arrays.asList(1, 2, 3));
	}
}
