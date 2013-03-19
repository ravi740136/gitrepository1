package com.test.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XpathTest {
	public static final String xpression1 = "//input[@id='Email']/preceding-sibling::*";
	public static final String xpression2 = "//input[@id='Email']/preceding::strong[@class='email-label']";
	public static final String xpression3 = "//input[@id='Email']/following::div[1]";
	public static final String xpression4 = "//input[@id='Email']/preceding-sibling::*/child::*[contains(.,'User')]";
	public static final String xpression5 = "//input[@id='Email']/preceding-sibling::*/child::*[.='Username']";
	public static final String xpression6 = "//input[@id='Email']";
	public static final String xpression7 = "//input[@id='Email']/following::input[@class='g-button g-button-submit']";
	public static final String xpression8 = "//div[@class='passwd-div']//input";
	public static final String xpression9 = "//div[@class='passwd-div']/following::input[@id='signIn']";
	public static void testXpression(WebDriver driver, String xpression) {
		WebElement we = driver.findElement(By.xpath(xpression));
		System.out.println(we.getAttribute("id"));

	}

}
