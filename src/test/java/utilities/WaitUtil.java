package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * This file provides dynamic wait depending on the timeout specified in config.properties
 */

public class WaitUtil {
	private static WebDriverWait wait;

	/*
	 * setter and getter
	 */
	public static void setWait(WebDriver driver) {
		int timeOut = 0;
		try {
			timeOut = Integer.parseInt(PropertyUtil.getPropertyValue("timeOutInSec"));
		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		} finally {
			if(timeOut != 0)
				initWait(driver, timeOut);
			else // default timeout of 60 sec
				initWait(driver, 60);
		}
	}

	public static WebDriverWait getWait() {
		if(wait == null)
			setWait(DriverUtil.getDriver());
		return wait;
	}

	/* 
	 * other wait utils
	 */
	private static void initWait(WebDriver driver, int timeOut) {
		wait = new WebDriverWait(driver, timeOut);
	}

	public static void WaitTimeInMillis(long timeInMillisec) {
		try {
			Thread.sleep(timeInMillisec);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static boolean presenceOfElement(WebElement element) {
		if(wait.until(ExpectedConditions.visibilityOf(element)) != null) {
			return true;
		}
		return false;
	}

//	public static WebElement presenceOfElementById(WebDriverWait wait, String id) {
//		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
//		return element;	
//	}
}
