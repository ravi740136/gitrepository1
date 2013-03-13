package deshaw.automation.wires.pages;

import junit.framework.Assert;

import org.openqa.selenium.support.ui.WebDriverWait;

import appdriverng.common.ExpectedConditions;
import appdriverng.common.Setup;

public class WRSBulkUpdateWires extends Page{

	public void open(){
		driver = Setup.getDriver();
		String className = this.getClass().getSimpleName();
		//int lastDot = className.lastIndexOf(".");
		//String sClassName = className.substring(lastDot+1, className.length());
		pageURL = Setup.getAppURL() + Setup.getPageURL(className);
		driver.get(pageURL);
		try{
		new WebDriverWait(driver, 20).until(ExpectedConditions.titleContains("Bulk Update Wires"));
		}
		catch (Exception e){
			Assert.fail();
		}
	}
}
