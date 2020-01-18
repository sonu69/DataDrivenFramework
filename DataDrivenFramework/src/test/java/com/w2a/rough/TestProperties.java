package com.w2a.rough;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

	private static FileInputStream fis;
	
	public static void main(String[] args) throws IOException {

		Properties config = new Properties();
		fis = new FileInputStream(new File(System.getProperty("user.dir")+"/src/test/resources/properties/Config.properties"));
		config.load(fis);
		System.out.println(config.getProperty("browser"));

		
		
		Properties OR = new Properties();
		fis = new FileInputStream(new File(System.getProperty("user.dir")+"/src/test/resources/properties/OR.properties"));
		config.load(fis);
		System.out.println(config.getProperty("name"));


	}

}
