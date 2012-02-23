package com.tryitout.selenium.screenshots;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class ScreenShotRule implements TestRule {
	private WebDriver webDriver;

	public ScreenShotRule(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public Statement apply(final Statement base, final Description description) {
		return new Statement() {
			@Override
			public void evaluate() throws Throwable {
				try {
					base.evaluate();
					// Tutaj mo¿na dowolnie manipulowaæ wyj¹tkami dla jakich
					// chce siê robiæ fotki
					// Exception powinno ogarn¹æ zarówno problemy selenium jak i
					// standardowe Faile testów
				} catch (WebDriverException e) {
					takeScreenShot(description);
				}
			}

			private void takeScreenShot(Description description) {
				try {
					FileOutputStream out = openStreamToTargetFile(description);
					out.write(((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES));
					out.close();
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}

			private FileOutputStream openStreamToTargetFile(Description description) throws FileNotFoundException {
				File targetDirectory = new File("target/selenium/" + description.getTestClass().getSimpleName());
				targetDirectory.mkdirs();
				String targetFileName = description.getMethodName() + ".png";
				return new FileOutputStream(new File(targetDirectory, targetFileName));
			}
		};
	}

}