package deshaw.automation.wires.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.ExecuteMethod;
import org.openqa.selenium.remote.RemoteKeyboard;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import appdriverng.common.*;

public class WRSApprovalsPage extends Page {
	static final Logger LOG = Logger.getLogger("deshaw.automation");
	String approvalsURL;

	@FindBy(how = How.CSS, using = "html body div#request_details_grid.container_12 div#sec2_grid_container div#grid table#wireApprovalGrid.GTable tfoot tr td div.GHeadLeft div table tfoot tr td.GPanelTop center")
	WebElement radioSelectAll;

	@FindBy(how = How.CSS, using = "html body div#approveButtonsContainer div.container_12 div.grid_3 div#blockui-buttons-8 button.approve_btn")
	WebElement btnApprove;

	@FindBy(id = "approvalComments")
	WebElement txtaComments;

	@FindBy(id = "Submit")
	WebElement btnSubmit;

	public WRSApprovalsPage() throws Exception{

	}
	
	public void open(){
		try {
			approvalsURL = Setup.getAppURL() + 	Setup.getPageURL("WRSApprovalsPage");
			driver.get(approvalsURL);
			AppWait.waitForTime(10l);
			PageFactory.initElements(driver, this);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void approveSpecifiedWire(String wireId) {
		try {
			LOG.warn("Trying to update wire by  ---------APPROVING WIRE------");
			//Pressing on Approve button
			AppWait.waitForTime(5l);
	
/*			((JavascriptExecutor) driver).executeScript("scroll(0,250);");
			String xpath = "//td[child::a[. = '"+wireId+"']]/preceding-sibling::td[@class[contains(.,'GAwaitingSignApproval')]]";
			LOG.info("XPATH is " + xpath);*/
			try{
			driver.findElement(By.xpath("//td[child::a[. = '"+wireId+"']]/preceding-sibling::td[@class[contains(.,'GAwaitingSignApproval')]]")).click();
			}
			catch (Exception ElementNotVisibleException){
				Action a = new Actions(driver).clickAndHold(driver.findElement(By.xpath("//div[@onscroll='Grids[0].Scrolled();']"))).moveByOffset(0, 250).release().build();
				a.perform();
				driver.findElement(By.xpath("//td[child::a[. = '"+wireId+"']]/preceding-sibling::td[@class[contains(.,'GAwaitingSignApproval')]]")).click();
			}
			btnApprove.click();
			AppWait.waitForTime(5l);
			txtaComments.sendKeys(AppConstants.ALLSPECIALCHAR);
			btnSubmit.click();
			AppWait.waitForTime(15l);
			WebDriver parent = driver;
			//Entering Approver credentials
			driver = Setup.switchWindow("Token Server");
			LOG.info("Entering credentials for Approver");
			driver.findElement(By.id("passwordField")).sendKeys(AppConstants.APPROVER_KEY);
			AppWait.waitForTime(5l);
		
			WebElement btnSubmitAuth=driver.findElement(By.xpath("/html/body/div[2]/form/div/div[3]/input"));
			btnSubmitAuth.click();
			/*RemoteKeyboard rk = new RemoteKeyboard(driver);
			rk.pressKey(Keys.ENTER);*/				
			AppWait.waitForTime(10l);
	
			//driver.switchTo().defaultContent();
			driver = Setup.switchWindow("WRS Approver View");
			//Accepting confirmation alert
//new Actions(driver).sendKeys(Keys.ENTER).perform();
			LOG.info("Trying to accept alert");

/*			Alert a = driver.switchTo().alert();
			LOG.info(a.getText());
			a.accept();*/

			//new Actions(driver).sendKeys(Keys.ENTER).perform();
		AppWait.waitForTime(5l);

			LOG.warn("Approved the wire Successfully");
			AppWait.waitForTime(5l);

		} catch (Exception e) {
		
		}
	}

	public void approveWires() {
		try {
			LOG.warn("Trying to update wire by  ---------APPROVING WIRE------");
			//Pressing on Approve button
			radioSelectAll.click();
			btnApprove.click();
			AppWait.waitForTime(5l);
			txtaComments.sendKeys(AppConstants.ALLSPECIALCHAR);
			btnSubmit.click();
			AppWait.waitForTime(15l);
			
			//Entering Approver credentials
			driver = Setup.switchWindow("Token Server");
			LOG.info("Entering credentials for Approver");
			driver.findElement(By.id("passwordField")).sendKeys(AppConstants.APPROVER_KEY);
			AppWait.waitForTime(5l);
		
			WebElement btnSubmitAuth=driver.findElement(By.xpath("/html/body/div[2]/form/div/div[3]/input"));
			btnSubmitAuth.click();
			/*RemoteKeyboard rk = new RemoteKeyboard(driver);
			rk.pressKey(Keys.ENTER);*/				
			AppWait.waitForTime(10l);
			
			//Accepting confirmation alert
			driver = Setup.switchWindow("WRS Approver View");
			AppWait.waitForTime(10l);
			driver.switchTo().alert().accept();
			LOG.warn("Approved the wire Successfully");
			AppWait.waitForTime(10l);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
