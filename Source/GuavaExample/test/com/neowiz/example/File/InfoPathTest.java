package com.neowiz.example.File;

import static org.fest.assertions.api.Assertions.assertThat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;

import org.apache.commons.codec.binary.Base64;
import org.junit.Before;
import org.junit.Test;

import com.google.common.primitives.Ints;

/**
 * @author nal<daygoods@neowiz.com>
 * @date 2015. 9. 24. 오전 11:02:44
 */
public class InfoPathTest {

	private String path;
	private String encodeData;

	@Before
	public void setUp() throws Exception {
		// 현재 위치 설정
		this.path = InfoPathTest.class.getResource("").getPath();

		// 파일 내용 읽기
		StringBuffer buffer = new StringBuffer();
		BufferedReader reader = new BufferedReader(new FileReader(this.path + "/encode.txt"));

		String inputLine = "";
		while ((inputLine = reader.readLine()) != null) {
			buffer.append(inputLine);
		}

		reader.close();

		this.encodeData = buffer.toString();
	}

	@Test
	public void ExtractFile() throws Exception {
		byte[] decodeByte = Base64.decodeBase64(this.encodeData);

		// header
		byte[] headerData = new byte[16];

		for (int i = 0; i < headerData.length; i++) {
			headerData[i] = decodeByte[i];
		}

		// fileName
		int fileNameLength = decodeByte[20] * 2;
		byte[] fileNameData = new byte[fileNameLength];

		for (int i = 0; i < fileNameLength; i++) {
			fileNameData[i] = decodeByte[24 + i];
		}

		// fileContents
		int fileContentsLength = decodeByte.length - (24 + fileNameLength);
		byte[] fileContentsData = new byte[fileContentsLength];

		for (int i = 0; i < fileContentsLength; i++) {
			fileContentsData[i] = decodeByte[24 + fileNameLength + i];
		}

		// fileName encoding - UTF-16LE
		String fileName = new String(fileNameData, "UTF-16LE");

		// fileName cleaning
		fileName = fileName.substring(0, fileName.length() - 1);

		// extract path
		String extractPath = this.path + fileName;

		// Extract File
		FileOutputStream fos = new FileOutputStream(extractPath);

		fos.write(fileContentsData);
		fos.flush();

		fos.close();

		// Read extract file - for debug
		File file = new File(extractPath);

		// debug...
		System.out.println("-----------");
		System.out.println(">>> headerData : " + new String(headerData));
		System.out.println(">>> fileNameData : " + fileName);
		System.out.println(">>> extractPath : " + extractPath);
		System.out.println("-----------");
		System.out.println(">>> fileContentsLength : " + fileContentsLength);
		System.out.println(">>> fileLength : " + file.length());
		System.out.println("-----------");

		// check!
		assertThat(fileName).isNotEmpty();
		assertThat(fileContentsLength).isEqualTo(Ints.checkedCast(file.length()));

	}
}
