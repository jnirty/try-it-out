package com.tryitout.xslt;

import java.io.StringWriter;

import javax.xml.transform.TransformerException;

public class TransformerJAXP {
	public String transformXML(String xml, String xslt) throws TransformerException {
		javax.xml.transform.Source xmlSource = new javax.xml.transform.stream.StreamSource(xml);
		javax.xml.transform.Source xsltSource = new javax.xml.transform.stream.StreamSource(xslt);
		StringWriter writer = new StringWriter();
		javax.xml.transform.Result result = new javax.xml.transform.stream.StreamResult(writer);

		// create an instance of TransformerFactory
		javax.xml.transform.TransformerFactory transFact = javax.xml.transform.TransformerFactory.newInstance();

		javax.xml.transform.Transformer trans = transFact.newTransformer(xsltSource);

		trans.transform(xmlSource, result);

		return writer.getBuffer().toString();
	}
}
