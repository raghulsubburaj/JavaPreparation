package com.sample;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamTest {

	public static void main(String[] args) throws IOException {
		String name = "Buffered Output Stream";
		try {
			BufferedOutputStream bOutputStream = new BufferedOutputStream(new FileOutputStream("D:\\IO Operation\\Test.txt"));
			byte nameData[] = name.getBytes();
			
			bOutputStream.write(nameData);
			
			bOutputStream.flush();
			
			bOutputStream.close();
			
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			System.out.println(e);
		}
		

	}

}
