package deshaw.automation.wires.pages;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import appdriverng.common.AppDatabase;
import appdriverng.common.AppWait;
import appdriverng.common.Setup;

public class WRSAdvSearchPage extends Page {



	@FindBy(xpath="/html/body/div[2]/div[4]/ul/li[2]/div/div/div/form/fieldset/legend")
	WebElement headerRequestSearchWindow;
	
	@FindBy(xpath="/html/body/div[2]/div[4]/ul/li[2]/div/div/div/form/fieldset[2]/legend")
	WebElement headerWireSearchWindow;
	
	@FindBy(id="selectModifiedDate")
	private WebElement lstModified;
	
	private Select sLstModified;
	
	@FindBy(id="nModifiedDates")
	private WebElement txtSearchperiod;	

	
	@FindBy(id="logger")
	private WebElement txtLogger;
	
	@FindBy(id="selectCategory")
	private WebElement lstCategory;
	
	private Select sLstCategory; 
	
	@FindBy(id="advanced_selectCurrency")
	private WebElement lstCurrency;
	
	private Select sLstCurrency; 
	
	@FindBy(id="advanced_selectStrategy")
	private WebElement lstStrategy;
	
	private Select sLstStrategy; 
	
	@FindBy(id="srcAdvAccountID")
	WebElement txtSrcAccountId;
	
	@FindBy(id="destAdvAccountID")
	WebElement txtDestAccountId;
	
	@FindBy(id="srcAdvCompanyId")
	private WebElement lstSrcCompany;
	
	private Select sLstSrcCompany;
	
	@FindBy(id="destAdvCompanyId")
	private WebElement lstDstCompany;
	
	private Select sLstDestCompany;
	
	@FindBy(id="selectRequestStatus")
	private WebElement lstRequestStatus;
	
	private Select sLstRequestStatus;
	
	@FindBy(id="srcAdvPortfolioId")
	private WebElement lstSrcPortfolio;
	
	private Select sLstSrcPortfolio;
	
	@FindBy(id="destAdvPortfolioId")
	private WebElement lstDestPortfolio;
	
	private Select sLstDestPortfolio;



	

	private String parent;
private static final By requestIdValuesPath = By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[2]/div/div/div/table/tbody/tr[3]/td/div/div/table/tbody/tr[position()>1]/td[3]");
	private List<WebElement> lRequestIds;
	private static final By categoryColumnValuesPath = By
			.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[2]/div/div/div/table/tbody/tr[3]/td[2]/div/div/table/tbody/tr[position()>1]/td[2]");
	private static final By strategyColumnValuesPath = By
			.xpath("//*[@id='wireSearchGrid']/tbody/tr[3]/td[2]/div/div[1]/table/tbody/tr[position()>1]/td[3]");
	private static final By srcAccountColumnValuesPath = By
			.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[2]/div/div/div/table/tbody/tr[3]/td[2]/div/div/table/tbody/tr[position()>1]/td[5]/span");
	private static final By destAccountColumnValuesPath = By
			.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[2]/div/div/div/table/tbody/tr[3]/td[2]/div/div/table/tbody/tr[position()>1]/td[8]/span");
	private static final By srcCompanyColumnValuesPath = By
			.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[2]/div/div/div/table/tbody/tr[3]/td[2]/div/div/table/tbody/tr[position()>1]/td[4]");
	private static final By destCompanyColumnValuesPath = By
			.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[2]/div/div/div/table/tbody/tr[3]/td[2]/div/div/table/tbody/tr[position()>1]/td[7]");

	private static final By srcPortfolioColumnValuesPath = By
			.xpath("//*[@id='wireSearchGrid']/tbody/tr[3]/td[2]/div/div[1]/table/tbody/tr[position()>1]/td[6]");

	private static final By destPortfolioColumnValuesPath = By
			.xpath("//*[@id='wireSearchGrid']/tbody/tr[3]/td[2]/div/div[1]/table/tbody/tr[position()>1]/td[9]");

	private static final By currencyColumnValuesPath = By
			.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[2]/div/div/div/table/tbody/tr[3]/td[2]/div/div/table/tbody/tr[position()>1]/td[13]");
	
	private List<WebElement> srcCompanyElements;
	private List<WebElement> destCompanyElements;
	private List<WebElement> srcPortfolioElements;
	private List<WebElement> destPortfolioElements;

	public WRSAdvSearchPage() {
		PageFactory.initElements(driver, this);	
		sLstStrategy = new Select(lstStrategy);
		sLstCategory = new Select(lstCategory);
		sLstRequestStatus= new Select(lstRequestStatus);
		sLstSrcCompany= new Select(lstSrcCompany);
		sLstDestCompany=new Select(lstDstCompany);
		sLstSrcPortfolio = new Select(lstSrcPortfolio);
		sLstDestPortfolio = new Select(lstDestPortfolio);
		sLstCurrency = new Select(lstCurrency);
		verifyAdvSearchWindowElements();
	}

	@Override
	public void open() {
		try {
			pageURL = Setup.getAppURL();
			driver.get(pageURL);
			AppWait.waitForTime(10L);
			parent = driver.getWindowHandle();
			WebElement btnAdvSearch = driver.findElement(By.id("adv_search"));
			btnAdvSearch.click();

			AppWait.waitForTime(5L);
			driver.switchTo().activeElement();
			
	

		} catch (Exception e) {
			LOG.error("FAILED WHILE LOADING  Advanced search window");
			Assert.fail("FAILED WHILE LOADING  Advanced search window");

		}

	}

	private void verifyAdvSearchWindowElements() {
		try {
		
			Assert.assertTrue(headerRequestSearchWindow.getText().trim()
					.equalsIgnoreCase("Request Details"));
			headerWireSearchWindow = driver
					.findElement(By
							.xpath("/html/body/div[2]/div[4]/ul/li[2]/div/div/div/form/fieldset[2]/legend"));
			Assert.assertTrue(headerWireSearchWindow.getText().trim()
					.equalsIgnoreCase("Wire Details"));
			LOG.info("Advanced search window is loaded successfully");
			
			Assert.assertTrue(lstRequestStatus.isDisplayed());
	
			sLstRequestStatus.deselectAll();			
			//Selecting "All" status instead of the default status instructed in Request status field
			sLstRequestStatus.selectByVisibleText("All");			
	
			Assert.assertTrue(lstSrcCompany.isDisplayed());	
			Assert.assertTrue(lstDstCompany.isDisplayed());
			LOG.info("Advanced search window elements are loaded properly");
		
			sLstModified = new Select(lstModified);
			// sLstModified.deselectAll();
			sLstModified.selectByVisibleText("Last n days");
	
			txtSearchperiod.clear();
			txtSearchperiod.sendKeys("7");
		} catch (Exception e) {
			LOG.error("FAILED WHILE LOADING  elements of Advanced search window");
			e.printStackTrace();
			Assert.fail(" FAILED WHILE LOADING  elements of Advanced search window");
		}
	}

	//implementation is not complete yet
	public void searchForLogger(String loggerId, String requestid) {
		try {
			
			txtLogger.sendKeys(loggerId + Keys.TAB);
			AppWait.waitForTime(5l);
			txtLogger.submit();
			boolean idTest = verifyForRequestidInSearchResults(requestid);
			if (!idTest){
				Assert.fail();
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	// verify if newly added request is displayed in search results
	private boolean verifyForRequestidInSearchResults(String requestId) throws Exception{
		AppWait.waitForTime(5l);
		boolean idTest = true;
		lRequestIds = driver.findElements(requestIdValuesPath);
		List<String> lSRequestIds = new ArrayList<String>();
		
		String id;
		
		for (WebElement i:lRequestIds){
			id = i.getText().trim();
			if (!id.isEmpty()){
			lSRequestIds.add(id);
			LOG.info("Request Id: "+i.getText().trim());
			}
		}
		LOG.info("Total search Results "+lSRequestIds.size());
		if (lSRequestIds.contains(requestId.trim())){
			LOG.info("Newly added request "+requestId+" is found in the search results");
		}
		else{
			LOG.info("Newly added request "+requestId+" is NOT found in the search results");
			idTest = false;
		}
		return idTest;
	}

	public void searchForCategory(String category, String requestId) {
		try {
			LOG.info("Searching for Category: " + category);
		
	
			sLstCategory.deselectAll();
			sLstCategory.selectByVisibleText(category);
			AppWait.waitForTime(10l);
			lstCategory.submit();
			AppWait.waitForTime(5l);
			driver.switchTo().window(parent);

			// verify if newly added request is displayed in search results
			boolean idTest = verifyForRequestidInSearchResults(requestId);
			
			// verify if all the values in category column belong to specified
			// search criteria
	
			List<WebElement> categoryElements = driver
					.findElements(categoryColumnValuesPath);
			
			boolean columnTest = verifyColumnValues(category, categoryElements);

			if (idTest == false || columnTest == false){
				Assert.fail();
			}

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	public void searchForStrategy(String strategy, String requestId) {
		try {
			LOG.info("Searching for Strategy: " + strategy);
		
	
			sLstStrategy.deselectAll();
			sLstStrategy.selectByVisibleText(strategy);
			AppWait.waitForTime(10l);
			lstStrategy.submit();
			AppWait.waitForTime(5l);
			driver.switchTo().window(parent);

			// verify if newly added request is displayed in search results
			boolean idTest = verifyForRequestidInSearchResults(requestId);
			
			// verify if all the values in strategy column belong to specified
			// search criteria
	
			List<WebElement> startegyElements = driver
					.findElements(strategyColumnValuesPath);
			
			boolean columnTest = verifyColumnValues(strategy, startegyElements);

			if (idTest == false || columnTest == false){
				Assert.fail();
			}

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	public void searchForSourceAccount(String eSourceAccount, String requestId) {
		try {
			LOG.info("Searching for Source Account: " + eSourceAccount);
	
			txtSrcAccountId.clear();
			txtSrcAccountId.sendKeys(eSourceAccount+Keys.TAB);
			AppWait.waitForTime(5l);
			txtSrcAccountId.submit();
			AppWait.waitForTime(5l);
			driver.switchTo().window(parent);

			// verify if newly added request is displayed in search results
			boolean idTest = verifyForRequestidInSearchResults(requestId);
			
			// verify if all the values in source account column belong to specified
			// search criteria		
			List<WebElement> srcAccountElements = driver
					.findElements(srcAccountColumnValuesPath);
			
			//Convert the expected value as it is displayed in UI
			int pos = eSourceAccount.indexOf(" ");
			eSourceAccount = eSourceAccount.substring(pos);
			
			boolean columnTest = verifyColumnValues(eSourceAccount, srcAccountElements);
			
			if (idTest == false || columnTest == false){
				Assert.fail();
			}

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	public void searchForDestAccount(String eDestAccount, String requestId) {
		try {
			LOG.info("Searching for Destination Account: " + eDestAccount);
	
			txtDestAccountId.clear();
			txtDestAccountId.sendKeys(eDestAccount+Keys.TAB);
			AppWait.waitForTime(5l);
			txtDestAccountId.submit();
			AppWait.waitForTime(5l);
			driver.switchTo().window(parent);

			// verify if newly added request is displayed in search results
			boolean idTest = verifyForRequestidInSearchResults(requestId);
			
			// verify if all the values in source account column belong to specified
			// search criteria		
			List<WebElement> destAccountElements = driver
					.findElements(destAccountColumnValuesPath);
			
			//Convert the expected value as it is displayed in UI
			int pos = eDestAccount.indexOf(" ");
			eDestAccount = eDestAccount.substring(pos);
			
			boolean columnTest = verifyColumnValues(eDestAccount, destAccountElements);
			
			if (idTest == false || columnTest == false){
				Assert.fail();
			}

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	public void searchForCurrency(String eCurrency, String requestId) {
		try {
			LOG.info("Searching for Currency: " + eCurrency);
	
			sLstCurrency.selectByVisibleText(eCurrency);
			AppWait.waitForTime(5l);
			lstCurrency.submit();
			AppWait.waitForTime(5l);
			driver.switchTo().window(parent);

			// verify if newly added request is displayed in search results
			boolean idTest = verifyForRequestidInSearchResults(requestId);
			
			// verify if all the values in source account column belong to specified
			// search criteria		
			List<WebElement> currencyElements = driver
					.findElements(currencyColumnValuesPath);
			
			//Convert the expected value as it is displayed in UI
			Connection con = AppDatabase.getConnection();
			PreparedStatement ps = con.prepareStatement("select currencycode from tcurrency where CurrencyDesc = ? " );
			ps.setString(1, eCurrency);
			ResultSet rs = ps.executeQuery();
			rs.next();
			eCurrency = rs.getString(1);
			rs.close();
			if (con != null){
				con.close();			
			}
			
			boolean columnTest = verifyColumnValues(eCurrency, currencyElements);
			
			if (idTest == false || columnTest == false){
				Assert.fail();
			}

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	private boolean verifyColumnValues(String expectedValue , List<WebElement> actualElements) throws Exception{
		boolean columnTest = true;
		String actualValue;
			for (WebElement e : actualElements) {
			if (actualElements.indexOf(e) < 29){

			
			actualValue = e.getText().trim();
			if (actualValue.equals(expectedValue.trim())) {
				LOG.info(actualValue
						+ " match with the expected value "
						+ expectedValue);			
			}
			else {
				LOG.info(actualValue
						+ " does not match with the expected value "
						+ expectedValue);
				columnTest=false;
			}
		}
			}
		

		if (columnTest == true){
		
		LOG.info("All the search results match with the expected value "
				+ expectedValue);
		}
		
		return columnTest;
	}
	
	public void searchForSourceCompany(String eSourceCompany, String requestId) {
		try {
			LOG.info("Searching for Source Company: " + eSourceCompany);
	
			sLstSrcCompany.deselectAll();
			sLstSrcCompany.selectByVisibleText(eSourceCompany);		
		
			lstSrcCompany.submit();
			AppWait.waitForTime(5l);
			driver.switchTo().window(parent);

			// verify if newly added request is displayed in search results
			boolean idTest = verifyForRequestidInSearchResults(requestId);
			
			// verify if all the values in Source Company column belong to specified
			// search criteria
	
			srcCompanyElements= driver
					.findElements(srcCompanyColumnValuesPath);

			boolean columnTest = verifyColumnValues(eSourceCompany, srcCompanyElements);
			if (idTest == false || columnTest == false){
				Assert.fail();
			}

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	public void searchForDestCompany(String eDestCompany, String requestId) {
		try {
			LOG.info("Searching for Destination Company: " + eDestCompany);
	
			sLstDestCompany.deselectAll();
			sLstDestCompany.selectByVisibleText(eDestCompany);		
		
			lstDstCompany.submit();
			AppWait.waitForTime(5l);
			driver.switchTo().window(parent);

			// verify if newly added request is displayed in search results
			boolean idTest = verifyForRequestidInSearchResults(requestId);
			
			// verify if all the values in Destination Company column belong to specified
			// search criteria
	
			destCompanyElements= driver
					.findElements(destCompanyColumnValuesPath);

			boolean columnTest = verifyColumnValues(eDestCompany, destCompanyElements);
			if (idTest == false || columnTest == false){
				Assert.fail();
			}

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	public void searchForSourcePortfolio(String eSourcePortfolio, String requestId) {
		try {
			LOG.info("Searching for Source Portfolio " + eSourcePortfolio);
	
			
			sLstSrcPortfolio.deselectAll();
			sLstSrcPortfolio.selectByVisibleText(eSourcePortfolio);		
		
			lstSrcPortfolio.submit();
			AppWait.waitForTime(5l);
			driver.switchTo().window(parent);

			// verify if newly added request is displayed in search results
			boolean idTest = verifyForRequestidInSearchResults(requestId);
			
			// verify if all the values in Source Portfolio column belong to specified
			// search criteria
	
			srcPortfolioElements= driver
					.findElements(srcPortfolioColumnValuesPath);

			boolean columnTest = verifyColumnValues(eSourcePortfolio, srcPortfolioElements);
			if (idTest == false || columnTest == false){
				Assert.fail();
			}

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	public void searchForDestPortfolio(String eDestPortfolio, String requestId) {
		try {
			LOG.info("Searching for Destination Portfolio " + eDestPortfolio);
	
			
			sLstDestPortfolio.deselectAll();
			sLstDestPortfolio.selectByVisibleText(eDestPortfolio);		
		
			lstDestPortfolio.submit();
			AppWait.waitForTime(5l);
			driver.switchTo().window(parent);

			// verify if newly added request is displayed in search results
			boolean idTest = verifyForRequestidInSearchResults(requestId);
			
			// verify if all the values in Source Portfolio column belong to specified
			// search criteria
	
			destPortfolioElements= driver
					.findElements(destPortfolioColumnValuesPath);

			boolean columnTest = verifyColumnValues(eDestPortfolio, destPortfolioElements);
			if (idTest == false || columnTest == false){
				Assert.fail();
			}

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}



}
