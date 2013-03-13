package deshaw.automation.wires.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import appdriverng.common.*;

public class WRSGLUploadPage extends Page {

	static final Logger LOG = Logger.getLogger("deshaw.automation");
	private String wireId = null;
	
	@FindBy(id="codaWireId")
	WebElement txtWireId;
	
	@FindBy(how=How.CSS, using="html body form#codaForm div span#blockui-buttons-1 button.search_btn")
	WebElement btnSearch;
	
	@FindBy(how=How.CSS,using="html body div#search_results div.search_grid div.container_12 div#div_section2.section2 div#section2content div#sec2_grid_container div#grid table#wireSearchGrid.GTable tfoot tr td div.GHeadLeft div table tfoot tr td.GPanelTop center")
	WebElement radioGlSelectWires;
	
	@FindBy(how=How.XPATH,using="/html/body/div[7]/div[2]/div[2]/div[2]/div/div/button[2]")
	WebElement btnPreview;
	
	@FindBy(how=How.XPATH,using="/html/body/div[7]/div[2]/div[2]/div[2]/div/div/button[3]")
	WebElement btnClearCodaDate;
	
	@FindBy(how=How.XPATH,using="/html/body/div[7]/div[2]/div[2]/div[2]/div/div/button")
	WebElement btnGenerate;
	
	public WRSGLUploadPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void open() {
		try{
		pageURL=Setup.getAppURL()+Setup.getPageURL("WRSGLUploadPage");
		driver.get(pageURL);
		AppWait.waitForTime(10l);
	
		}
		catch(Exception e){
			e.printStackTrace();
		}
	
	}
	
	public void searchForWire(String lwireId) throws Exception{
		LOG.warn("--------G/L UPLOAD SCREEN------");
		this.wireId = lwireId;
		LOG.warn("Searching for wire id: "+ wireId+" in G/L Upload screen");
		txtWireId.sendKeys(wireId);
		btnSearch.click();
		AppWait.waitForTime(10l);	
		//JavascriptExecutor js = ( JavascriptExecutor) driver;
		//js.executeScript("SelectAllRows()");
		//AppWait.waitForTime(10l);	
	}
	
	public void previewCoda(String actualValueDate,String wireAmount) throws Exception{		
		radioGlSelectWires.click();
		btnPreview.click();
		AppWait.waitForTime(10l);	
		verifyCodaEntries(actualValueDate, wireAmount);
	}
	
	public void verifyPreviewCodaScreen() throws Exception{		
		radioGlSelectWires.click();
		btnPreview.click();
		AppWait.waitForTime(10l);	
		verifyCodaEntries();
		
	}
	
	
	private void verifyCodaEntries() throws Exception{
		Setup.switchWindow("WRS Preview Journal Entries");
		AppWait.waitForTime(10l);
		try{
		Assert.assertFalse(driver.getPageSource().contains("Error:") || driver.getPageSource().contains("ERRORS"));
		LOG.warn("No errors are found in 'Preview Coda Entries' screen for Wire Id: " + wireId);
		LOG.warn("\n");
		
		Assert.assertTrue(driver.getPageSource().contains("Transfer"));		
		LOG.warn("checking for the Wire Id " + wireId + " in journal entries");
		Assert.assertTrue(driver.getPageSource().contains(wireId));
		LOG.warn("Transfer keyword and Wire Id "+ wireId +" found in Journal entries window");
		LOG.warn("\n");
		
/*		LOG.warn("checking for the Wire Amount of the wire: " + wireAmount + " in journal entries");
		Assert.assertTrue(driver.getPageSource().contains(wireAmount));
		LOG.warn("Wire Amount "+ wireAmount +" found in Journal entries window");
		LOG.warn("\n");*/

		LOG.warn("\n");
		}
		catch(Error e){	
			LOG.error("Assertion failure in Journal entries window "+e);
	
			Assert.fail();
		}
		catch(Exception e){
			LOG.warn("Exception occured while checking journal entries "+e);
			Assert.fail();
		}
		finally{
		driver.findElement(By.id("btnOK")).click();
		Setup.switchWindow("WRS G/L Upload");
		AppWait.waitForTime(5l);
		}
	}	
	
	
	private void verifyCodaEntries(String actualValueDate, String wireAmount) throws Exception{
		Setup.switchWindow("WRS Preview Journal Entries");
		AppWait.waitForTime(10l);
		try{
		Assert.assertFalse(driver.getPageSource().contains("Error:") || driver.getPageSource().contains("ERRORS"));
		LOG.warn("No errors are found in 'Preview Coda Entries' screen for Wire Id: " + wireId);
		LOG.warn("\n");
		
		Assert.assertTrue(driver.getPageSource().contains("Transfer"));		
		LOG.warn("checking for the Wire Id " + wireId + " in journal entries");
		Assert.assertTrue(driver.getPageSource().contains(wireId));
		LOG.warn("Transfer keyword and Wire Id "+ wireId +" found in Journal entries window");
		LOG.warn("\n");
		
/*		LOG.warn("checking for the Wire Amount of the wire: " + wireAmount + " in journal entries");
		Assert.assertTrue(driver.getPageSource().contains(wireAmount));
		LOG.warn("Wire Amount "+ wireAmount +" found in Journal entries window");
		LOG.warn("\n");*/
		
		LOG.warn("checking for the actual value date of the wire " + actualValueDate + " in journal entries");
		Assert.assertTrue(driver.getPageSource().contains(actualValueDate));
		LOG.warn("---SUCCESS---: Actual value date " + actualValueDate + " found in Journal entries window");
		LOG.warn("\n");
		}
		catch(Error e){	
			LOG.error("Assertion failure in Journal entries window "+e);
	
			Assert.fail();
		}
		catch(Exception e){
			LOG.warn("Exception occured while checking journal entries "+e);
			Assert.fail();
		}
		finally{
		driver.findElement(By.id("btnOK")).click();
		Setup.switchWindow("WRS G/L Upload");
		AppWait.waitForTime(5l);
		}
	}	

	public void refresh() throws Exception {
		driver.get(pageURL);
		AppWait.waitForTime(10l);

	}
	
}
