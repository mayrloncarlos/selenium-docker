package com.core;

import static com.core.DriverFactory.killDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

	private static String urlCompleta;

	@BeforeTest
	public void init() {
		String host = "192.168.1.4";
		
		if(System.getProperty("HUB_HOST") != null) {
			host = System.getProperty("HUB_HOST");
		}

		urlCompleta = "http://" + host + ":4444/wd/hub";

	}

	@AfterTest
	public void down() {
		if (Propriedades.FECHAR_BROWSER) {
			killDriver();
		}
	}
	
	public static String getUrl() {
		return urlCompleta;
	}
}
