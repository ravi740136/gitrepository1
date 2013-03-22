package com.test.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverTest {
	private static WebDriver driver;
	public static void setDriver(String URL) throws InterruptedException{
		System.setProperty("webdriver.firefox.bin","C:\\Program Files (x86)\\Mozilla Firefox\\Firefox.exe");
		driver = new FirefoxDriver();
		driver.get(URL);
		Thread.sleep(5000l);

		
	}

	public static WebDriver getDriver(){
		return driver;
	}
}
