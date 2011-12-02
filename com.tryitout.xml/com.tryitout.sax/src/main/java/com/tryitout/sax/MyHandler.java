package com.tryitout.sax;

import java.util.StringTokenizer;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * A SAX handler that prints out the start tags, end tags, and first word of tag
 * body. Indents two spaces for each nesting level.
 */

public class MyHandler extends DefaultHandler {
	private int indentation = 0;

	/**
	 * When you see a start tag, print it out and then increase indentation by
	 * two spaces. If the element has attributes, place them in parens after the
	 * element name.
	 */

	public void startElement(String namespaceUri, String localName, String qualifiedName, Attributes attributes) throws SAXException {
		indent(indentation);
		System.out.print("Start tag: " + qualifiedName);
		int numAttributes = attributes.getLength();
		// For <someTag> just print out "someTag". But for
		// <someTag att1="Val1" att2="Val2">, print out
		// "someTag (att1=Val1, att2=Val2).
		if (numAttributes > 0) {
			System.out.print(" (");
			for (int i = 0; i < numAttributes; i++) {
				if (i > 0) {
					System.out.print(", ");
				}
				System.out.print("ATTR: " + attributes.getQName(i) + "=" + attributes.getValue(i));
			}
			System.out.print(")");
		}
		System.out.println();
		indentation = indentation + 2;
	}

	/**
	 * When you see the end tag, print it out and decrease indentation level by
	 * 2.
	 */

	public void endElement(String namespaceUri, String localName, String qualifiedName) throws SAXException {
		indentation = indentation - 2;
		indent(indentation);
		System.out.println("End tag: " + qualifiedName);
	}

	/** Print out the first word of each tag body. */

	public void characters(char[] chars, int startIndex, int endIndex) {
		String data = new String(chars, startIndex, endIndex);
		// Whitespace makes up default StringTokenizer delimeters
		StringTokenizer tok = new StringTokenizer(data);
		if (tok.hasMoreTokens()) {
			indent(indentation);
			System.out.print(tok.nextToken());
			if (tok.hasMoreTokens()) {
				System.out.println("...");
			} else {
				System.out.println();
			}
		}
	}

	private void indent(int indentation) {
		for (int i = 0; i < indentation; i++) {
			System.out.print(" ");
		}
	}
}
