package deshaw.automation.wires.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import appdriverng.common.AppWait;
import appdriverng.common.Setup;

public class WRSSearchConfigureGrid extends Page {
	String parent;
	WebElement btnDefaultSettings;
	public WRSSearchConfigureGrid() {
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
			parent = driver.getWindowHandle();

		} catch (Exception e) {
			LOG.error("FAILED WHILE LOADING CONFIGURE SETTINGS WINDOW: ");
			Assert.fail("FAILED WHILE LOADING CONFIGURE SETTINGS WINDOW:");

		}

	}

	public void verifyTitleAndElements() {
		WebElement btnConfigureGrid = driver.findElement(By.id("configure"));
		btnConfigureGrid.click();

		try {
			AppWait.waitForTime(10l);
			LOG.warn("Loading Configure Frid  in Search page..  " );
			boolean found = false;
			for (String s : driver.getWindowHandles()) {
				if (driver.switchTo().window(s).getTitle()
						.contains("Configure Grid")) {
					found = true;
					break;
				}
			}
			if (found) {
				String title = driver.getTitle();
				LOG.info("Configure Grid is loaded properly, the title of the window is "
						+ title);
			}
			btnDefaultSettings = driver.findElement(By.id("gridconfigure_button1"));
			
			if (found == false) {

				LOG.error("Configure Grid window is not found");
				Assert.fail("Window Loading FAILURE");

			}
			if (driver.findElement(By.id("gridconfigure_button2")).isDisplayed()){
				LOG.info("Configure Grid elements are loaded properly ");
			}
			else{
				LOG.error("Configure Grid elements are not loaded");
				Assert.fail("Configure Grid elements are not loaded");
			}

		} catch (Exception e) {
			LOG.error("Problem in loading Configure grid window");
			Assert.fail("Configure grid Window Loading FAILURE");

		}

	}
	
	public void setDefaultSettings() throws Exception{
		btnDefaultSettings.click();
		driver.switchTo().alert().accept();
		driver.switchTo().alert().accept();
		AppWait.waitForTime(5l);
		driver.switchTo().window(parent);
	}

}
