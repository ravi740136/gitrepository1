package deshaw.automation.wires.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import appdriverng.common.AppWait;
import appdriverng.common.Setup;

public class WRSConfigureSettings extends Page {
	public WRSConfigureSettings() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void open() {
		try {
			pageURL = Setup.getAppURL() + Setup.getPageURL("WRSSearchPage");
			driver.get(pageURL);
			LOG.warn("Loading Search Page - URL:  " + pageURL);
			AppWait.waitForTime(30l);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			LOG.warn("Loading Configure Settings Dialog..  ");
			js.executeScript("openUserSettingsDialog()");
			AppWait.waitForTime(30l);

		} catch (Exception e) {
			LOG.error("FAILED WHILE LOADING CONFIGURE SETTINGS WINDOW: " );
			Assert.fail("FAILED WHILE LOADING CONFIGURE SETTINGS WINDOW:");

		}

	}
	
	public void verifyTitleAndElements() {
		try {
		
			WebElement configDialog = driver.switchTo().activeElement();
		
			String title = configDialog.findElement(By.xpath("div/span")).getText();
			Assert.assertEquals(title, "Configure User Settings");
		LOG.info("Configure settings page is oaded properly, title is " +title);
		WebElement defaultApp = driver.findElement(By.id("dayMonthValue"));
		Assert.assertTrue(defaultApp.isDisplayed());
		LOG.info("window elements are displayed");

		} catch (Exception e) {
			LOG.error("Problem in loading Configure settings window" );
			Assert.fail("Window Loading FAILURE");

		}

	}

}
