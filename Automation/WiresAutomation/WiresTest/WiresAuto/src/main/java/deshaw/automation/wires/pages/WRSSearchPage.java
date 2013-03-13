package deshaw.automation.wires.pages;

import javax.swing.plaf.basic.BasicScrollPaneUI.HSBChangeListener;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


import appdriverng.common.*;

public class WRSSearchPage extends Page{

	static final Logger LOG = Logger.getLogger("deshaw.automation");
	
	@FindBy(id="uniqueSearchId")
	WebElement txtIdSearch;	
	
	@FindBy(id="adv_search_search_link")
	WebElement lnkSearchButton;
	
	@FindBy(id="hsbcNetBtn")
	WebElement btnHsbcNet;
	
//No need of ANNOTATION as variable name matches with id of the element
	WebElement faxBtn;
	
	@FindBy(how=How.CSS, using = "html body div#search_results div.search_grid div.container_12 div#div_section2.section2 div#section2content div#sec2_grid_container div#grid table#wireSearchGrid.GTable tfoot tr td div.GHeadLeft div table tfoot tr td.GPanelTop center")
	WebElement radioSelectIds;
	
	@FindBy(id="selectSearchType")
	WebElement optSearchType;
	
	@FindBy(id="bulkUpdateBtn")
	WebElement btnBulkUpdate;
	
	Select selectSearchType;
	public WRSSearchPage() throws Exception{
		PageFactory.initElements(driver, this);
		selectSearchType = new Select(optSearchType);
	}	
	
	@Override
	public void open() {
		try{
		pageURL = Setup.getAppURL()+Setup.getPageURL("WRSSearchPage");
		driver.get(pageURL);
		AppWait.waitForTime(10l);
		
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void searchForRequestIds(String... requestId) throws Exception{
		if (requestId.length ==1){
		LOG.warn("Searching for Request Id: "+requestId[0]);
		txtIdSearch.clear();
		txtIdSearch.sendKeys(requestId[0]+","+requestId[0]);
		}
		else {String searchString="";
			
			for (int i=0; i<(requestId.length); i++){
				searchString = searchString + requestId[i]+ ", ";
				
				
			}
			searchString.trim();
			txtIdSearch.clear();
			txtIdSearch.sendKeys(searchString);
		}
		lnkSearchButton.click();
		AppWait.waitForTime(10l);	
		}
	
	public void searchForWireIds(String... wireId) throws Exception{
		int no_Of_Ids = wireId.length;
		selectSearchType.selectByVisibleText("Wire ID");
		if (no_Of_Ids == 1){
		LOG.warn("Searching for Wire Id: "+wireId[0]);		
		txtIdSearch.clear();
		txtIdSearch.sendKeys(wireId[0]+","+wireId[0]);
	}
	else{
		String searchString = "";
		LOG.warn("Searching for Wire Ids: ");
		for (int i=0; i<no_Of_Ids; i++){
			LOG.info("id: " + wireId[i]);
			searchString = searchString + wireId[i] + ",";
		}
		//searchString.trim();
		txtIdSearch.clear();
		txtIdSearch.sendKeys(searchString);
	}
		lnkSearchButton.click();
		AppWait.waitForTime(10l);	
		}
	
	public void releaseWiresByHsbcNet() throws Exception{
		LOG.warn("Trying to update wire by  ---------RELEASING WIRE USING HSBC NET------");
		radioSelectIds.click();
		btnHsbcNet.click();	
		AppWait.waitForTime(10l);
		try{
			Setup.verifyConfirmation(AppConstants.HSBCNET_CONFIRM);
		}
		catch (Exception e){
			e.printStackTrace();			
		}
	}
	
	public void releaseWiresByFax(String wireId) throws Exception{
		LOG.warn("Trying to update wire by  ---------RELEASING WIRE USING FAX------");
		AppWait.waitForTime(5l);
		//System.out.println(driver.findElements(By.xpath("//td[child::a[. = '381423']]")).size());  GPendingRelease GMPx1xx GMCellPanel GMEmpty GMCellBorderFF3 HideCol5Panel
		String xpath = "//td[child::a[. = '"+wireId+"']]/preceding-sibling::td[@class[contains (. , 'GPendingRelease')]]";
		//radioSelectIds.click();
		driver.findElement(By.xpath(xpath)).click();
		faxBtn.click();	
		AppWait.waitForTime(5l);
		if (driver.findElement(By.xpath("//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all modalWindow ui-draggable ui-resizable']/child::div[child::span[. = 'Fax Template and Contact Selection']]")).isDisplayed())
		{
			driver.findElement(By.xpath("//button[span[. = 'Send']]")).click();
		}
		else {
			System.out.println("false");		
		}
		try{
			//Setup.verifyConfirmation(AppConstants.HSBCNET_CONFIRM);
		}
		catch (Exception e){
			e.printStackTrace();			
		}
	}
	

	public void refresh() throws Exception {
		driver.get(pageURL);
		AppWait.waitForTime(15l);
	

		//reset();
	}
	
}
