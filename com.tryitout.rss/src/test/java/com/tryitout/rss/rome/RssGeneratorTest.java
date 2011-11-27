package com.tryitout.rss.rome;

import static org.junit.Assert.fail;

import org.junit.Test;

public class RssGeneratorTest {

	@Test
	public void test() {
		try {
			System.out.println(RssGenerator
					.getDummyRssFeed(RssGenerator.FeedType.RSS_20));
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

}
