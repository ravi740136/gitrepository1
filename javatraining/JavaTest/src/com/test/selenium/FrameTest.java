package com.test.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FrameTest {
	WebDriver driver;
public void getframeProps() throws InterruptedException{
	try{
	driver = new FirefoxDriver();
	driver.get("http://docs.oracle.com/javase/7/docs/api/index.html?overview-summary.html");
	String handle = driver.getWindowHandle();
	Thread.sleep(5000l);
	driver.switchTo().frame("classFrame");
	System.out.println(driver.getTitle());
	System.out.println(driver.getWindowHandle());
	Thread.sleep(1000l);
	driver.switchTo().window(handle);
//	System.out.println(driver.getTitle());
//	System.out.println(driver.getWindowHandle());
//	Thread.sleep(1000l);
	//driver.switchTo().frame(driver.findElement(By.xpath("/html/frameset/frameset/frame[2]")));
	driver.switchTo().frame("packageFrame");
	System.out.println(driver.getTitle());
	System.out.println(driver.getWindowHandle());
	Thread.sleep(1000l);
	driver.switchTo().window(handle);
	System.out.println(driver.getTitle());
	System.out.println(driver.getWindowHandle());
	Thread.sleep(1000l);
	driver.switchTo().frame("packageListFrame");
	System.out.println(driver.getTitle());
	System.out.println(driver.getWindowHandle());
	}
	finally{
		driver.quit();
	}

}

public static void main(String args[]) throws InterruptedException{
	FrameTest f = new FrameTest();
	f.getframeProps();

}
	
}
