package com.sample;

import java.io.File;

import javax.xml.crypto.dsig.Transform;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class WriteXML {

	public static void main(String[] args) {
		try {
	  DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	  
		DocumentBuilder db = dbf.newDocumentBuilder();
		 Document doc = db.newDocument();
		 
		 Element rootElement = doc.createElement("EmployeeDetails");
		 doc.appendChild(rootElement);
		 
		 Element chilElement = doc.createElement("EmployeeName");
		 rootElement.appendChild(chilElement);
		 
		 chilElement.appendChild(doc.createTextNode("Raghul"));
		 
		 TransformerFactory tFactory = TransformerFactory.newInstance();
		 Transformer tForm = tFactory.newTransformer();
		 DOMSource domSource = new DOMSource(doc);
		 
		 
		 StreamResult result = new StreamResult(new File("D:\\IO Operation\\Write.xml"));
		 tForm.transform(domSource, result);
		 //File fs = new File("D:\\IO Operation\\Write.xml");
		 
		 
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  

	}

}
