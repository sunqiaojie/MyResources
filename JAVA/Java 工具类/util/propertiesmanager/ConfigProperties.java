package com.dezhong.util.propertiesmanager;

import java.io.IOException;
import java.util.Properties;


public class ConfigProperties {

	private static String config_file = "../../../../config.properties";
	private static Properties prop = new Properties();
	
	static {
		try {
			prop.load(ConfigProperties.class.getResourceAsStream(config_file));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getConfig(String key) {
		return prop.getProperty(key);
	}
	
	public static void main(String[] args) {
		System.out.println(getConfig("result.invalid"));
	}
	
}
