package com.tryitout.sax;

import java.io.File;
import java.net.MalformedURLException;

import junit.framework.Assert;

import org.junit.Ignore;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class SaxPrinterTest {
	private static final String XML_FILE_NAME = "orders.xml";

	@Test
	@Ignore("false")
	public void test() {

		String jaxpPropertyName = "javax.xml.parsers.SAXParserFactory";
		// Pass the parser factory in on the command line with
		// -D to override the use of the Apache parser.
		if (System.getProperty(jaxpPropertyName) == null) {
			String apacheXercesPropertyValue = "org.apache.xerces.jaxp.SAXParserFactoryImpl";
			System.setProperty(jaxpPropertyName, apacheXercesPropertyValue);
		}

		try {
			SaxPrinter.parse(new File(XML_FILE_NAME).toURI().toURL().toExternalForm());
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
			Assert.fail();
		}

	}
	@Test
	public void test2() {

		String jaxpPropertyName = "javax.xml.parsers.SAXParserFactory";
		// Pass the parser factory in on the command line with
		// -D to override the use of the Apache parser.
		if (System.getProperty(jaxpPropertyName) == null) {
			String apacheXercesPropertyValue = "org.apache.xerces.jaxp.SAXParserFactoryImpl";
			System.setProperty(jaxpPropertyName, apacheXercesPropertyValue);
		}

		SaxPrinter.parse("http://www.lodzka.policja.gov.pl/content/blogsection/5/135/20/120/");

	}
}
