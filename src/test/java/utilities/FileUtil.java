package utilities;

import java.io.File;

import enums.Browser;

/*
 * This class finds the current user directory and then sets the absolute path to the exe files.
 * Includes getter methods for fetching absolute path to the drivers in the form of a string.
 */

public class FileUtil {
	private static String absolutePath;

	public static void setAbsolutePath(Browser browser) {
		File resourceDir;

		try {
			resourceDir = new File(constants.Values.userDir,
					"/src/test/resources/executables");

			switch(browser) {
			case CHROME:
				absolutePath = new File(resourceDir, "chromedriver.exe").getAbsolutePath();
				break;
			case FIREFOX:
				absolutePath = new File(resourceDir, "geckodriver.exe").getAbsolutePath();
				break;
			case IE:
				//	to be implemented
				break;
			case SAFARI:
				//	to be implemented
				break;
			}
		} catch (NullPointerException npe) {
			npe.printStackTrace();
		}
	}
	
	public static String getAbsolutePath() {
		return absolutePath;
	}
}