package com.tryitout.rss.rome;

import java.io.IOException;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.sun.syndication.feed.synd.SyndContent;
import com.sun.syndication.feed.synd.SyndContentImpl;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndEntryImpl;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.feed.synd.SyndFeedImpl;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedOutput;

public class RssGenerator {
	
	public static enum FeedType {
		RSS_20("rss_2.0"), ATOM_10("atom_1.0");
		
		private String _value = null;
		
		FeedType(String s){
		_value  = s;	
		}
		
		@Override
		public String toString() {
			return _value;
		}
		
	};
	
	private static final DateFormat DATE_PARSER = new SimpleDateFormat(
			"yyyy-MM-dd");


	public static String getDummyRssFeed(FeedType feedType) throws IOException, FeedException, ParseException {

		SyndFeed feed = new SyndFeedImpl();
		feed.setFeedType(feedType.toString());

		feed.setTitle("Sample Feed (created with ROME)");
		feed.setLink("http://rome.dev.java.net");
		feed.setDescription("This feed has been created using ROME (Java syndication utilities");

		List entries = new ArrayList();
		SyndEntry entry;
		SyndContent description;

		entry = new SyndEntryImpl();
		entry.setTitle("ROME v1.0");
		entry.setLink("http://wiki.java.net/bin/view/Javawsxml/Rome01");
		entry.setPublishedDate(DATE_PARSER.parse("2004-06-08"));
		description = new SyndContentImpl();
		description.setType("text/plain");
		description.setValue("Initial release of ROME");
		entry.setDescription(description);
		entries.add(entry);

		entry = new SyndEntryImpl();
		entry.setTitle("ROME v3.0");
		entry.setLink("http://wiki.java.net/bin/view/Javawsxml/Rome03");
		entry.setPublishedDate(DATE_PARSER.parse("2004-07-27"));
		description = new SyndContentImpl();
		description.setType("text/html");
		description
				.setValue("<p>More Bug fixes, mor API changes, some new features and some Unit testing</p>"
						+ "<p>For details check the <a href=\">Changeshttps://rometools.jira.com/wiki/display/ROME/Change+Log#ChangeLog-Changesmadefromv0.3tov0.4\" Log</a></p>");
		entry.setDescription(description);
		entries.add(entry);

		feed.setEntries(entries);

		SyndFeedOutput output = new SyndFeedOutput();
		StringWriter writer = new StringWriter();
		output.output(feed, writer);

		return writer.getBuffer().toString();
	}
}
