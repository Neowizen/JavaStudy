package com.neowiz.example.java7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author nal<daygoods@neowiz.com>
 * @date 2015. 2. 10. 오후 5:43:31
 */
public class SyntaxTest {

	private static final long TIMEOUT = 3600_000;
	private static final int THOUSAND =  1_000;
	private static final int MILLION  =  1_000_000;
	
	public void instanceTest() {
		Map<String, List<String>> test = new HashMap<>();
	}
	
	public void switchTest() {
		String key = "OK";
		
		switch (key) {
			case "OK" :
				break;
	
			default:
				break;
		}
	}
	
	public void resourceTest() {
		try (
			InputStream in = new FileInputStream(new File(""));
			OutputStream out = new FileOutputStream("")
		) {
		} catch (IOException e) {
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
			else {

			}
		} 
		catch (NullPointerException | IllegalArgumentException e) {
		}
	}
	
	public void nioPathTest() {
		Path path = Paths.get("c:\\Temp\\temp");

		System.out.println("Number of Nodes:" + path.getNameCount());
		System.out.println("File Name:" + path.getFileName());
		System.out.println("File Root:" + path.getRoot());
		System.out.println("File Parent:" + path.getParent());
	}
	
	public void nioFilesTest() {
		Path path = Paths.get(System.getProperty("user.home"), "Downloads");
		try {
			Files.delete(path);			// NoSuchFileException
			Files.deleteIfExists(path); // Withdraw NoSuchFileException
			
//			Files.createDirectory
//			Files.createFile
//			Files.copy
//			Files.move
//			Files.createLink
//			Files.exists
		} catch (IOException e) {
		}
	}
	
//	public void collectionsTest() {
//		List<String> list = null;
//		
//		Map<String, String> tes = {"key", 1};
//		
//		
//		List<Integer> test1 = new ArrayList<Integer>();
//		test1.add(1);
//		test1.add(1);
//		test1.add(3);
//		
//		List<Integer> test2 = Collections.unmodifiableList(Arrays.asList(1, 2, 3));
//	}
}
