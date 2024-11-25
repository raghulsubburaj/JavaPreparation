package com.sample;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest {
	
	public static void main(String[] args) {
	
		try {
			FileInputStream fInStream = new FileInputStream("D:\\IO Operation\\Test.txt");
			
			try {
				//int readData = fInStream.read();
				
				//System.out.println("Data Read from File : " + (char)readData);
				
				System.out.println(fInStream.available());
				
				int i =0;
				while ((i=fInStream.read())!= -1) {
					
					System.out.print((char)i);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			System.out.println(e);
		}
		
	}

}