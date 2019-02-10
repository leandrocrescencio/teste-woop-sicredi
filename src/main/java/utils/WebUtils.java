package utils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebUtils {

	private WebUtils() {
		throw new IllegalStateException("Utility class");
	}

	public static void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception {
		// Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File(fileWithPath);
		FileUtils.copyFile(SrcFile, DestFile);
	}

	public static boolean isPresent(WebDriver webdriver, By selector) {
		try {
			webdriver.findElement(selector);
		} catch (NoSuchElementException e) {
			return false;
		}
		return true;
	}

	public static WebElement clickWait(WebDriver driver, By selector) {
		return (new WebDriverWait(driver, StaticValues.TIMEOUT))
				.until(ExpectedConditions.elementToBeClickable(selector));
	}

	public static WebElement elementWait(WebDriver driver, By selector) {
		return (new WebDriverWait(driver, StaticValues.TIMEOUT))
				.until(ExpectedConditions.presenceOfElementLocated(selector));
	}

	public static void titleWait(WebDriver driver, String title) {
		(new WebDriverWait(driver, StaticValues.TIMEOUT)).until(ExpectedConditions.titleIs(title));
	}

}