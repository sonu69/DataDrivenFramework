package com.w2a.rough;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class PropertyClass {
	
	
	
	@Test
	public void readfile() throws IOException {
		
		Properties cfg = new Properties();
		
		FileInputStream fis = new FileInputStream(new File(System.getProperty("user.dir")+"/src/test/resources/properties/Config.properties"));
		
		cfg.load(fis);
		
		System.out.println(cfg.getProperty("browser"));
		
	}
	
	

}
