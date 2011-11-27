package com.tryitout.xslt;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;

import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;

/**
 * Hello world!
 * 
 */
public class TransformerXalan {

	public String transformXML(String xml, String xslt) throws TransformerException {
		javax.xml.transform.TransformerFactory tFactory = javax.xml.transform.TransformerFactory.newInstance();

		// Get the XML input document and the stylesheet, both in the servlet
		// engine document directory.
		javax.xml.transform.Source xmlSource = new javax.xml.transform.stream.StreamSource(xml);
		// (new
		// FileInputStream("/home/osbmaster/www/invoice/invoice.xml"));
		javax.xml.transform.Source xslSource = new javax.xml.transform.stream.StreamSource(xslt);
		// (new
		// FileInputStream("/home/osbmaster/www/invoice/invoice.xsl"));
		// Generate the transformer.
		javax.xml.transform.Transformer transformer = tFactory.newTransformer(xslSource);
		// Perform the transformation, sending the output to the response.
		StringWriter writer = new StringWriter();
		transformer.transform(xmlSource, new javax.xml.transform.stream.StreamResult(writer));

		return writer.getBuffer().toString();

	}

}
