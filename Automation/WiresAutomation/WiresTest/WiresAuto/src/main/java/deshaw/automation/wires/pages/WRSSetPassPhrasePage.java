package deshaw.automation.wires.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import appdriverng.common.AppWait;
import appdriverng.common.Setup;

public class WRSSetPassPhrasePage extends Page {
	Select selectRefDataType;
	WebElement txtPassPhrase;

	public WRSSetPassPhrasePage() {
		super();
		txtPassPhrase = driver.findElement(By.id("passPhrase"));
	
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public void open() {
		try {
			pageURL = Setup.getPageURL("WRSSetPassPhrasePage");
			driver.get(pageURL);
			LOG.warn("Loading Set Pass Phrase Page - URL:  " + pageURL);
			AppWait.waitForTime(10l);
			Assert.assertTrue(driver.getTitle().contains(
					"Token Server"));

		} catch (Exception e) {
			LOG.error("FAILED WHILE LOADING  Set Pass Phrase Page");
			Assert.fail(" FAILED WHILE LOADING  Set Pass Phrase Page");

		}

	}

	public void verifyPassPhrasePageElements() {
		try{
		Assert.assertTrue(txtPassPhrase.isDisplayed());
		LOG.info("Pass Phrase page elements are loaded properly");
	}
	catch(Exception e){
		LOG.error("FAILED WHILE LOADING  Set Pass Phrase Page");
		Assert.fail(" FAILED WHILE LOADING  Set Pass Phrase Page");
	}
	}
}
