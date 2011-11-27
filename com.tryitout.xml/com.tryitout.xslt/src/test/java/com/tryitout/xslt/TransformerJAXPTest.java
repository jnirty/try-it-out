package com.tryitout.xslt;

import static org.junit.Assert.fail;

import java.io.File;
import java.net.MalformedURLException;

import javax.xml.transform.TransformerException;

import org.apache.log4j.Logger;

import org.junit.BeforeClass;
import org.junit.Test;

public class TransformerJAXPTest {
	private static Logger logger = Logger.getLogger(TransformerJAXPTest.class);
	private static String xmlSystemId = null;
	private static String xsltSystemId = null;
	private static final String XML_FILE_NAME = "toTransform.xml";
	private static final String XSLT_FILE_NAME = "stylesheet.xslt";

	@BeforeClass
	public static void setup() throws MalformedURLException {
		logger.debug("TransformerJAXPTest.setup() - begin");

		xmlSystemId = new File(XML_FILE_NAME).toURI().toURL().toExternalForm();
		xsltSystemId = new File(XSLT_FILE_NAME).toURI().toURL().toExternalForm();
		logger.debug("xmlSystemId = " + xmlSystemId);
		logger.debug("xsltSystemId = " + xsltSystemId);
		logger.debug("TransformerJAXPTest.setup() - end");
	}

	@Test
	public void testTransformXML() {
		try {
			String out = new TransformerJAXP().transformXML(xmlSystemId, xsltSystemId);
			logger.info("OUT: \n" + out);
		} catch (TransformerException e) {
			e.printStackTrace();
			fail(e.getLocalizedMessage());
		}
	}

}
