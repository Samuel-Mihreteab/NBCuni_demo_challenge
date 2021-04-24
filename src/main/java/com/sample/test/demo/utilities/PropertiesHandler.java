package com.sample.test.demo.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class PropertiesHandler {
	final static Logger logger = Logger.getLogger(PropertiesHandler.class);
	Properties prop;
	
	public PropertiesHandler (String filepath){
		try {
		prop = new Properties();
		File path = new File(filepath);
		FileInputStream input = new FileInputStream(path);
		prop.load(input);
		
		}catch (Exception e) {
		logger.error("Error: Please check the Properties-Handler Contructor method block",e);
		}
		
	}
	
	public String reader(String key) {
		String value= null;
		
		try {
			
			value= prop.getProperty(key);
			
		}catch (Exception e) {
			logger.error("Error: Please check the Properties-Handler reader helper-method block",e);
		}
return value;
	}

}
