package deshaw.automation.wires.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import appdriverng.common.AppWait;
import appdriverng.common.Setup;

public class WRSCloneRequestPage extends Page {

	WebElement txtRequestNo;
	WebElement headerCloneRequest;
	WebElement btnClone;

	public WRSCloneRequestPage() {
		super();

		txtRequestNo = driver.findElement(By.id("cloneRequestId"));
		btnClone = driver.findElement(By
				.xpath("/html/body/div[9]/div[2]/div/div[2]/input"));

	}

	@Override
	public void open() {
		try {
			pageURL = Setup.getAppURL();
			driver.get(pageURL);
			AppWait.waitForTime(10L);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("openCloneRequestDialog()");
			AppWait.waitForTime(5L);
			driver.switchTo().activeElement();
			headerCloneRequest = driver.findElement(By
					.xpath("/html/body/div[9]/div/span"));

			Assert.assertTrue(headerCloneRequest.getText().trim()
					.equalsIgnoreCase("clone request"));
			LOG.info("Clone Request window is loaded successfully");

		} catch (Exception e) {
			LOG.error("FAILED WHILE LOADING  Clone Request window");
			Assert.fail(" FAILED WHILE LOADING  Clone Request window");

		}

	}

	public void verifyCloneRequestElements() {
		try {
			Assert.assertTrue(txtRequestNo.isDisplayed());
			Assert.assertTrue(btnClone.isDisplayed());
			LOG.info("Clone Request window elements are loaded properly");
		} catch (Exception e) {
			LOG.error("FAILED WHILE LOADING  Clone Request window");
			Assert.fail(" FAILED WHILE LOADING  Clone Request window");
		}
	}

}
