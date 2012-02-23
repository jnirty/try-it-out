package com.tryitout.selenium.screenshots;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestSearchGoogle {
	private static WebDriver remoteDriver;

	@BeforeClass
	public static void setUp() throws Exception {
		remoteDriver = new FirefoxDriver();
	}

	@AfterClass
	public static void tearDown() throws Exception {
		remoteDriver.close();
	}

	@Test
	public void shouldFindProperPageTitleAfterSearching() throws Exception {
		// given
		remoteDriver.get("http://www.google.com/");
		String searchPhrase = "Lodz";
		// when
		remoteDriver.findElement(By.name("q")).sendKeys("Selenium 2.0 WebDriver");
		remoteDriver.findElement(By.name("q")).submit();
		System.out.println("Page title is: " + remoteDriver.getTitle());
		waitForSearchResult(searchPhrase);
		// then
		assertThat(remoteDriver.getTitle(), containsString(searchPhrase + "aaa"));
	}

	private void waitForSearchResult(final String searchPhrase) {
		(new WebDriverWait(remoteDriver, 2)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return driver.getTitle().toLowerCase().startsWith(searchPhrase);
			}
		});
	}

}
