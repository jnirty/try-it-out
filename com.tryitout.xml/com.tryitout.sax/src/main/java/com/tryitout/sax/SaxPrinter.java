package com.tryitout.sax;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.helpers.DefaultHandler;

public class SaxPrinter {


	public static void parse(String filename) {
		DefaultHandler handler = new MyHandler();
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser parser = factory.newSAXParser();
			parser.parse(filename, handler);
		} catch (Exception e) {
			String errorMessage = "Error parsing " + filename + ": " + e;
			System.err.println(errorMessage);
			e.printStackTrace();
		}
	}
}
