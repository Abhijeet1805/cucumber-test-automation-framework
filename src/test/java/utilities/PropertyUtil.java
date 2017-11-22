package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/*
 * This file reads the config.property file. Includes getters for the properties. 
 */

public class PropertyUtil {
	private static Properties prop;

	public static void readPropertyFile() {		

		FileInputStream input = null;
		prop = new Properties();

		File locConfigFile = new File(constants.Values.userDir,"config.properties");

		try {
			input = new FileInputStream(locConfigFile);

			// load a properties file
			prop.load(input);
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (NullPointerException npe) {
			npe.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static String getPropertyValue(String key) {
		return prop.getProperty(key);
	}
}