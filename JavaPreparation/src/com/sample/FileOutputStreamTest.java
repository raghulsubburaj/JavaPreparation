package com.sample;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest {

	public static void main(String[] args) {
		
		
		String name = "Raghul";
		try {
			FileOutputStream fOutStream = new FileOutputStream("D:\\IO Operation\\Test.txt");
			
			byte byteName[] = name.getBytes();
			
		    try {
				fOutStream.write(byteName);
				
				 System.out.println("Data successfully written to the file.");
				 
				fOutStream.close();
				
			} catch (IOException e) {
				
				e.printStackTrace();
				System.out.println(e);
			}
		    
		  
		    
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			System.out.println(e);
		}
		
		

	
	}

}
