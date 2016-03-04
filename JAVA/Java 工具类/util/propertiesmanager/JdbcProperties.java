package com.dezhong.util.propertiesmanager;

import java.io.IOException;
import java.util.Properties;

public class JdbcProperties {

	private static String config_file = "../../../../jdbc.properties";
	private static Properties prop = new Properties();
	
	static {
		try {
			prop.load(JdbcProperties.class.getResourceAsStream(config_file));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getConfig(String key) {
		return prop.getProperty(key);
	}
	
}
