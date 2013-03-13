package deshaw.automation.wires.pages;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import appdriverng.common.AppConstants;
import appdriverng.common.AppDatabase;
import appdriverng.common.AppWait;
import appdriverng.common.Setup;


public class WRSWireDetailsPage extends WRSAddRequestPage {	

	private String wireId_wd = "";
	private String requestId_wd = "";
	public String requestPageURL ="";
	private Select action=null;

	@FindBy(id = "actions")
	WebElement optActions;

	@FindBy(id = "faxTemplateSelection")
	WebElement optFaxTemplates;
	
	@FindBy(id = "actualValueDate")
	WebElement txtActualValueDate;

	WebElement btnpreviewCoda;
	WebElement btnApprove;
	WebElement btnBulkUpdate;
	
	public WRSWireDetailsPage(String idString)  {
		super(idString);	
		PageFactory.initElements(driver, this);
		action = new Select(optActions);
	}
	
	@Override
	public void open() {
		
		try {
			
			if (idString.toLowerCase().startsWith("wire#")){
				this.wireId_wd = parseStringAndGetId(idString);
				this.requestId_wd = AppDatabase.getRequestId(wireId_wd);
			}
			else{				
					this.requestId_wd = parseStringAndGetId(idString);
					this.wireId_wd = AppDatabase.getLatestWireId(requestId_wd);
				}
			
		
			LOG.info("request id: " +requestId_wd);
			LOG.info("wire id: " +wireId_wd);
			pageURL = Setup.getAppURL() + "/wrs/Q/" + requestId_wd + "/" + wireId_wd;
			LOG.warn("Loading Wire Details Page - URL: " +pageURL);
			driver.get(pageURL);
			AppWait.waitForTime(20l);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public String getRequestId(){
		return requestId_wd;
		
	}
	
	public String getWireId(){
		return wireId_wd;
		
	}
	public void selectWire(){
		
		WebElement optSelectWire = driver.findElement(By.xpath("/html/body/div[8]/div/div/div[2]/table/tfoot/tr[3]/td/div/div/div/table/tfoot/tr/td/center"));
		optSelectWire.click();
		btnpreviewCoda =  driver.findElement(By.id("previewJournalBtn"));	
		btnApprove = driver.findElement(By.id("showWiresInApprovalPageBtn"));
		btnBulkUpdate= driver.findElement(By.id("bulkUpdateBtn"));
		
	}
	
	public void openPreviewCoda() {
		try{
		btnpreviewCoda.click();
		AppWait.waitForTime(5l);
		}
		catch (Exception e){
			
		}
		
	}
	
	public void openAndApproveWires() throws Exception{
		try{
			btnApprove.click();
			driver.switchTo().alert().accept();
		AppWait.waitForTime(5l);
		driver = Setup.switchWindow("WRS Approver View");
		Assert.assertTrue(driver.getTitle().trim().equalsIgnoreCase("WRS Approver view"));
		LOG.info("Approve Wires window is loaded properly");		
		}
		catch (Exception e){
			LOG.error("problem in loading Approve wires window..");
			Assert.fail("problem in loading Approve wires window..");
		}
		AppWait.waitForTime(5l);
		approveWires();
		
	}
	
	private void approveWires() {
		try{
			WebElement taComments = driver.findElement(By.id("comemnts"));
			taComments.sendKeys("test comments for testing approvals");
			WebElement btnApprove_window = driver.findElement(By.id("approve_button"));
			btnApprove_window.click();
			AppWait.waitForTime(5l);
			WebElement txtPasswordField = driver.findElement(By.id("passwordField"));
			txtPasswordField.sendKeys(AppConstants.APPROVER_KEY);
			WebElement btnSubmit_window = driver.findElement(By.xpath("/html/body/div[2]/form/div/div[3]/input"));
			btnSubmit_window.click();
			AppWait.waitForTime(5l);
			Assert.assertTrue(driver.getPageSource().contains("The selected Wires have been approved"));
			LOG.info("Wire has been approved successfully");	
		
		}
		catch (Exception e){
			LOG.error("problem in Approving Wires..");
			Assert.fail("problem in Approving Wires..");
		}
		
	}
	
	public void verifyReleasedStatus(String wireId){
		WebElement releasedText = driver.findElement(By.xpath("//div[@id = '1']/div[6][contains(., 'In Wire ID "+wireId+"')][contains(., ' Wire Status changed from \" Pending Release \" to \" Released \"')]"));
		//WebElement releasedText = driver.findElement(By.xpath("//div[@id = '1']/div[6][contains(., 'In Wire ID "+wireId+"')]"));
		//WebElement releasedText = driver.findElement(By.xpath("//div[@id = '1']/div[6]"));
		Assert.assertTrue(releasedText.getText().contains("Transmission Type changed from \"  \" to \" Fax \""));
	}
	
	public void verifyBulkUpdateWindowAndElements(String requestIdBU) throws Exception{


		try{
			btnBulkUpdate.click();
			
		AppWait.waitForTime(5l);
		driver = Setup.switchWindow("Bulk Update");
		Assert.assertTrue(driver.getTitle().trim().equalsIgnoreCase("Bulk Update"));
		LOG.info("Bulk Update window is loaded properly");		
		}
		catch (Exception e){
			LOG.error("problem in loading Approve wires window..");
			Assert.fail("problem in loading Approve wires window..");
		}
		String wireIdBU = AppDatabase.getLatestWireId(requestIdBU);
		verifyBulkUpdateWindowElements(wireIdBU);
		
	}
	
	private void verifyBulkUpdateWindowElements(String wireIdBU){
		try{
			AppWait.waitForTime(5l);		
	WebElement wireIdValue = driver.findElement(By.id("bulkUpdateForm_wires_0__wireId"));
	Assert.assertTrue(wireIdValue.getAttribute("value").trim().equals(wireIdBU));
	LOG.info("Bulk Update window elements are loaded properly");	
		}
		catch(Exception e){
			LOG.error("Problem in loading Bulk Update window elements..");
			Assert.fail("Problem in loading Bulk Update window elements..");
		}
	}
	
	
		public void verifyCodaEntries() throws Exception{
			Setup.switchWindow("WRS Preview Journal Entries");
			
			try{
			Assert.assertFalse(driver.getPageSource().contains("Error:") || driver.getPageSource().contains("ERRORS"));
			LOG.warn("No errors are found in 'Preview Coda Entries' screen for Wire Id: " + wireId_wd);
			LOG.warn("\n");
			
			Assert.assertTrue(driver.getPageSource().contains("Transfer"));		
			LOG.warn("checking for the Wire Id " + wireId_wd + " in journal entries");
			Assert.assertTrue(driver.getPageSource().contains(wireId_wd));
			LOG.warn("Transfer keyword and Wire Id "+ wireId_wd +" found in Journal entries window");
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
			
			AppWait.waitForTime(5l);
			}
		}	
		
		
	
	
	
	public void getOnlyRequestDetailsPage() throws Exception {
			requestPageURL = Setup.getAppURL() + "/wrs/Q/" + requestId_wd;
			LOG.warn("Loading Only Request Details Page - URL: " +requestPageURL);
			driver.get(requestPageURL);
			AppWait.waitForTime(20l);

	}

	public void submitToSignatory(String requestId) throws Exception {
		LOG.warn("Trying to update wire by  ---------SUBMITTING SIGNATORY------");
		try {
			LOG.warn("DB Changes ---------CHANGING LOGGER FOR THE REQUEST------");
			AppDatabase.changeWireLogger(requestId);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		action.selectByVisibleText("Submit to Signatory");		
		Select faxTemplate = new Select(optFaxTemplates);
		faxTemplate.selectByVisibleText("Source");		
		submitAndVerify(AppConstants.UPDATE_REQUEST_CONFIRM);
	}
	
	public void moveFunds() throws Exception {
		
		LOG.warn("Trying to update wire by  ---------MOVING FUNDS------");
		Select action = new Select(optActions);
		action.selectByVisibleText("Funds Moved");
		txtActualValueDate.sendKeys(AppConstants.ACTUAL_VALUE_DATE);
		submitAndVerify(AppConstants.UPDATE_REQUEST_CONFIRM);

	}
	
	public void refresh() throws Exception {
		driver.get(pageURL);
		AppWait.waitForTime(10l);	
	}
	
	public String getActualValueDate(){
		 String avd = txtActualValueDate.getAttribute("value").trim();
		 return avd;		 
	}
	
	public String getActualValueDateByRemovingStartingZeroes(){
		 String avd = getActualValueDate();
		String[] arrs =   avd.split("/");
		 for (int i = 0 ; i<2; i++) {
			 arrs[i] = removeStartingZeroes(arrs[i]);			 
		 }
		 
		 avd = arrs[0]+"/"+arrs[1]+"/"+arrs[2];
		 return avd;		 
	}
	
	private String removeStartingZeroes(String s){
	if (s.startsWith("0")){
		 s = s.replaceFirst("0", " ");
	 }
	 return s.trim();
	}
	
	public String getWireAmount(){
		return txtAmount.getAttribute("value").trim();
	}
	
	public String getWireAmountByRemovingCommas(){
		return txtAmount.getAttribute("value").trim().replaceAll(",", "");
	}
	
	public void rejectWire() throws Exception{
		action.selectByVisibleText("Reject");
		LOG.warn("Trying to update wire by  ---------REJECTING WIRE------");
		submitAndVerify(AppConstants.UPDATE_REQUEST_CONFIRM);
	}
	
	public void voidWire(String voidWireId) throws Exception{
		submitToSignatory(AppDatabase.getRequestId(voidWireId));
		WRSApprovalsPage wrsApprovalspage = new WRSApprovalsPage();
		wrsApprovalspage.approveWires();		
		WRSSearchPage wrsSearchPage = new WRSSearchPage();
		wrsSearchPage.searchForWireIds(voidWireId);
		wrsSearchPage.releaseWiresByHsbcNet();
		WRSWireDetailsPage wireDetailsPage = new WRSWireDetailsPage("wire#"+voidWireId);
		wireDetailsPage.moveFunds();
		wireDetailsPage.refresh();
		action.selectByVisibleText("VOID");
		LOG.warn("Trying to update wire by  ---------VOIDING WIRE------");
		submitAndVerify(AppConstants.UPDATE_REQUEST_CONFIRM);
	}
}
