package com.vtechsolution01.orangehrm.utility;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {

	public static Properties prop;

	public ConfigDataProvider(String ConfigPath) {

		try {
			FileInputStream fins = new FileInputStream(ConfigPath);
			prop = new Properties();
			prop.load(fins);

		} catch (Exception e) {
			System.out.println("File is not Found: " + e.getMessage());

		}

	}

	public String searchKey(String keyname) {
		return prop.getProperty("keyname");
	}

	public String getUserName() {
		return prop.getProperty("username");
	}

	public String getPassword() {
		return prop.getProperty("password");
	}

	public String getAppUrl() {
		return prop.getProperty("AppUrl");
	}
}
