package com.sample;

import java.util.Vector;

public class VectorSample {

	public static void main(String[] args) {
		
       Vector<String> vector = new Vector<String>();
       
       vector.add("Raghul");
       vector.add("Ram");
       System.out.println("Vector Data : " + vector); 
       System.out.println("Capacity of the vector ArrayList : " +  vector.capacity());
       
       Vector<String> vector1 = new Vector<String>();
       
      
       vector1.add("Praveen");
      vector1.add("Udhaya");
       
       System.out.println("Vector Data : " + vector1);
       
       vector1.addAll(vector);
       System.out.println("Added ArrayList : " + vector1);
       vector1.addElement("Gopi");
       System.out.println("Added ArrayList : " + vector1);
       
       System.out.println("Capacity of the vector1 ArrayList : " +  vector1.capacity());
       System.out.println("Contains Raghul in vector : " + vector.contains("Raghu"));
       System.out.println("Contains Raghul in vector : " + vector.containsAll(vector1));
       
       String arr [] = new String[2];
       
        vector.copyInto(arr);
        

     for(int i = 0; i<arr.length;i++ ) {
    	 
    	 System.out.print("Copy of vector Array : " + arr[i] );
    	 
     }
     
         System.out.println("Get value from index zero : " + vector.elementAt(0));
         System.out.println("Equals the Vector : " + vector.equals(vector1));
         
     
       
       
	}

}
