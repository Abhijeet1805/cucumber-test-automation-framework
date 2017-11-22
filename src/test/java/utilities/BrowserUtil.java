package utilities;

import enums.Browser;

public class BrowserUtil {
	private static Browser browser;
	
	public static void setBrowser(String browserName) {
		
		switch(browserName.toUpperCase()) {
		case "CHROME":
			browser = Browser.CHROME;
			break;
		case "FIREFOX":
			browser = Browser.FIREFOX;
			break;
		case "IE":
			browser = Browser.IE;
			break;
		case "SAFARI":
			browser = Browser.SAFARI;
			break;
			default: // does nothing
				break; 
		}
	}
	
	public static Browser getBrowser() {
		return browser;
	}
}
