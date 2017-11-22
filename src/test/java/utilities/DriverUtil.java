package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import enums.Browser;

/*
 * This class instantiates WebDriver & WebDriverWait objects
 * Also includes few getter methods
 */

public class DriverUtil {

	private static WebDriver driver;
	
	public static void setDriver() {
		PropertyUtil.readPropertyFile();
		BrowserUtil.setBrowser(PropertyUtil.getPropertyValue("browser"));
		FileUtil.setAbsolutePath(BrowserUtil.getBrowser());
		initDriver(BrowserUtil.getBrowser());
//		WaitUtil.setWait(driver);
	}

	public static WebDriver getDriver() {
		if(driver == null)
			setDriver();
		return driver;
	}
	
	private static void initDriver(Browser browser) {
		String absolutePath = FileUtil.getAbsolutePath();
		
		switch(browser) {
		case CHROME:
			System.setProperty("webdriver.chrome.driver", absolutePath);
			driver = new ChromeDriver();
			break;
		case FIREFOX:
			System.setProperty("webdriver.gecko.driver", absolutePath);
			driver = new FirefoxDriver();
			break;
		case IE:
			// to be implemented
			break;
		case SAFARI:
			// to be implemented
			break;
		default:
			break;
		}
	}
}
