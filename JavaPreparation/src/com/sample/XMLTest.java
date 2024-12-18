package com.sample;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLTest {

	public static void main(String[] args) {
		
   try {
		
		 File fs = new File("D:\\IO Operation\\TestXML.xml");
		 
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		 
	
			DocumentBuilder db = dbf.newDocumentBuilder();
			
			Document doc = db.parse(fs);
			
			//doc.getDocumentElement().normalize();
			
			System.out.println("Root element: " + doc.getDocumentElement().getNodeName());  
			
			NodeList nodeList = doc.getElementsByTagName("Employee");
			
			for(int i = 0; i < nodeList.getLength(); i++) {
				 
				Node node = nodeList.item(i);
				
				System.out.println(node.getNodeName());
				
				if (node.getNodeType() == Node.ELEMENT_NODE)   {
					
					Element element = (Element)node;
					
					System.out.println(element.getElementsByTagName("firstname").item(0).getTextContent());
					
				}
				
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		 
		 
		 
	}

}
