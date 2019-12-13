package com.core;

import static com.core.BaseTest.getUrl;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.core.Propriedades.TipoExecucao;

public class DriverFactory {
	
	private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>() {
		@Override
		protected synchronized WebDriver initialValue() {
			return initDriver();
		}
	};
	
	private DriverFactory() {}
	
	public static WebDriver getDriver() {
		return threadDriver.get();
	}
	
	public static WebDriver initDriver() {
		WebDriver driver = null;
		if (Propriedades.TIPO_EXECUCAO == TipoExecucao.LOCAL) {
			if (System.getProperty("BROWSER") != null &&
					System.getProperty("BROWSER").equalsIgnoreCase("FIREFOX")) {
				driver = new FirefoxDriver();
			} 
			else {
				driver = new ChromeDriver();
			}
		}
		if (Propriedades.TIPO_EXECUCAO == TipoExecucao.GRID) {
			DesiredCapabilities dc = null;

			if (System.getProperty("BROWSER") != null &&
				System.getProperty("BROWSER").equalsIgnoreCase("FIREFOX")) {
				dc = DesiredCapabilities.firefox();
			} 
			else {	
				dc = DesiredCapabilities.chrome();
			}
			try {
				driver = new RemoteWebDriver(new URL(getUrl()), dc);
			} catch (MalformedURLException e) {
				System.err.println("Falha na conexão com o GRID");
				e.printStackTrace();
			}
		}
				driver.manage().window().maximize();
		return driver;
	}
	
	public static void killDriver() {
		WebDriver driver = getDriver();
		if(driver != null) {
			driver.quit();
			driver = null;		
		}
		if(threadDriver != null) {
			threadDriver.remove();
		}
	}	
}
