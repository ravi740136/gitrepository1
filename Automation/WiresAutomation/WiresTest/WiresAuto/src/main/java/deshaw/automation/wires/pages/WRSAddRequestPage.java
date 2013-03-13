package deshaw.automation.wires.pages;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import appdriverng.common.AppConstants;
import appdriverng.common.AppDatabase;
import appdriverng.common.AppWait;
import appdriverng.common.Setup;

import com.thoughtworks.selenium.SeleneseTestBase;

public class WRSAddRequestPage extends Page {

	static final Logger LOG = Logger.getLogger("deshaw.automation");
	protected static String PAGETITLE = "WRS New Wire Request";;

	protected static final String OPTIONSXPATH1 = "html body div.ac_results ul li.ac_even";
	protected static final String OPTIONSXPATH2 = "html body div.ac_results ul li.ac_odd";
	Map<String, String> actualValues = new HashMap();
	Map<String, WebElement> mapWebElementNames = new HashMap();

	protected enum AccountType {
		Source, Destination
	};

	@FindBy(how = How.XPATH, using = "/html/body/div[9]/fieldset/div[19]/div/div/a")
	WebElement lnkReset;

	@FindBy(how = How.XPATH, using = "/html/body/div[9]/fieldset/div[4]/div[2]/input")
	WebElement txtCurrency;

	@FindBy(how = How.ID, using = "actualValueDate")
	WebElement txtActValueDate;

	@FindBy(how = How.ID, using = "frDate")
	WebElement txtFundRetDate;

	@FindBy(how = How.ID_OR_NAME, using = "subject")
	WebElement txtSubject;

	@FindBy(how = How.ID_OR_NAME, using = "subscribers")
	WebElement txtSubscriber;

	@FindBy(how = How.ID_OR_NAME, using = "cc")
	WebElement txtCc;

	@FindBy(how = How.ID_OR_NAME, using = "add_selectPriority")
	WebElement optPriority;

	@FindBy(how = How.ID_OR_NAME, using = "confidentialRequestCheckBox")
	WebElement chkIsprivate;

	@FindBy(how = How.CSS, using = "html body div.full_width_container form#form_addRequest fieldset.content_fieldset div.container_12 div.field_inline input#emailNotificationCheckBox")
	WebElement chkEmail;

	@FindBy(how = How.ID_OR_NAME, using = "comments")
	WebElement txtaReqComments;

	@FindBy(how = How.XPATH, using = "//*[@id='srcAccountID']")
	WebElement txtSrcAcctId;

	@FindBy(how = How.XPATH, using = "//*[@id='destAccountID']")
	WebElement txtDestAcctId;

	@FindBy(how = How.ID_OR_NAME, using = "sourcePortfolio")
	WebElement optSrcPortfolio;

	Select sOptSrcPortfolio;

	@FindBy(how = How.ID_OR_NAME, using = "destinationPortfolio")
	WebElement optDestPortfolio;

	Select sOptDestPortfolio;

	@FindBy(how = How.XPATH, using = "/html/body/div[9]/fieldset/div[10]/div[2]/input")
	WebElement txtStrategy;

	@FindBy(how = How.ID_OR_NAME, using = "add_selectUploadStatus")
	WebElement optCodaUploadInfo;

	@FindBy(how = How.ID_OR_NAME, using = "wireAmount")
	WebElement txtAmount;

	@FindBy(how = How.ID_OR_NAME, using = "wireDate")
	WebElement txtWireDate;

	@FindBy(how = How.ID_OR_NAME, using = "valueDate")
	WebElement txtValueDate;

	@FindBy(how = How.ID_OR_NAME, using = "wireComments")
	WebElement txtWireComments;

	@FindBy(how = How.ID_OR_NAME, using = "add_selectCategory")
	WebElement optCategory;

	@FindBy(how = How.ID_OR_NAME, using = "actions")
	WebElement optAction;

	@FindBy(how = How.ID_OR_NAME, using = "saveAndSubmitWire")
	WebElement btnSubmit;

	@FindBy(how = How.ID_OR_NAME, using = "wire_details")
	WebElement formWireDetails;

	@FindBy(id = "dest_tradeId_3")
	WebElement txtDestTradeId;

	@FindBy(id = "dest_gboType_3")
	WebElement txtDestGBOType;

	@FindBy(id = "dest_amount_3")
	WebElement txtDestAmount;

	@FindBy(id = "splitAmountAnchor")
	WebElement lnkSplitAmountAnchor;

	@FindBy(xpath = "/html/body/div[9]/fieldset/div[6]/div[2]/div[4]/input")
	WebElement txtDestBroker;

	@FindBy(xpath = "/html/body/div[9]/fieldset/div[6]/div[2]/div[2]/input")
	WebElement txtDestCompany;

	@FindBy(xpath = "/html/body/div[9]/fieldset/div[6]/div/div[2]/input")
	WebElement txtSrcCompany;

	@FindBy(xpath = "/html/body/div[9]/fieldset/div[6]/div/div[5]/input")
	WebElement txtSrcBroker;

	@FindBy(id = "destAccountName")
	WebElement txtDestAccountName;

	@FindBy(id = "srcAccountName")
	WebElement txtSrcAccountName;

	private Alert reqConfirm;

	public WRSAddRequestPage() {
		PageFactory.initElements(driver, this);
	}

	public WRSAddRequestPage(String idString) {
		super(idString);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void open() {
		try {
			pageURL = Setup.getAppURL() + Setup.getPageURL("WRSAddRequestPage");
			driver.get(pageURL);
			LOG.warn("Loading Add Request Page - URL:  " + pageURL);
			AppWait.waitForTime(30l);
			Assert.assertTrue(driver.getTitle().equalsIgnoreCase(PAGETITLE));
			try {
				new File("c:\\temp\\selenium").mkdir();
				TakesScreenshot screenShot = (TakesScreenshot) driver;
				File f = screenShot.getScreenshotAs(OutputType.FILE);
				LOG.info(f.getAbsolutePath());
				LOG.info(f.getName());
				FileUtils.copyFile(f, new File(
						"c:\\temp\\selenium\\selenium.jpg"));
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			LOG.error("FAILED WHILE LOADING ADD REQUEST PAGE: " + pageURL);
			Assert.fail("FAILED WHILE LOADING THE PAGE");

		}

	}

	private void setSplitAmount(String tradeId, String gboType, String amount)
			throws Exception {

		Thread.sleep(5000l);
		txtDestTradeId.clear();
		txtDestTradeId.sendKeys(tradeId);
		txtDestGBOType.clear();
		txtDestGBOType.sendKeys(gboType);
		txtDestAmount.clear();
		txtDestAmount.sendKeys(amount);

	}

	private void selectOptionUsingAutofill(AccountType sourceOrDestination,
			String option) throws Exception {

		switch (sourceOrDestination) {
		case Source:
			LOG.warn("Clearing Source account details..");

			LOG.warn("Clearing Source broker details..");
			txtSrcBroker.click();
			txtSrcBroker.clear();
			LOG.warn("Clearing Source company details..");
			txtSrcCompany.click();
			txtSrcCompany.clear();
			// txtSrcAccountName.click();
			// txtSrcAccountName.clear();
			txtSrcAcctId.click();
			txtSrcAcctId.clear();
			txtSrcAcctId.sendKeys(option + " ");
			break;
		case Destination:
			LOG.warn("Clearing Destination account details..");

			LOG.warn("Clearing Destination broker details..");
			txtDestBroker.click();
			txtDestBroker.clear();

			LOG.warn("Clearing Destinaion company details..");
			txtDestCompany.click();
			txtDestCompany.clear();
			// txtDestAccountName.click();
			// txtDestAccountName.clear();
			txtDestAcctId.click();
			txtDestAcctId.clear();
			txtDestAcctId.sendKeys(option + " ");
			break;
		}
		;

		List<WebElement> autofillOptions;
		List<WebElement> autofillOptions1;

		boolean found = false;
		AppWait.waitForTime(5l);

		autofillOptions = driver.findElements(By.cssSelector(OPTIONSXPATH1));
		autofillOptions1 = driver.findElements(By.cssSelector(OPTIONSXPATH2));
		autofillOptions.addAll(autofillOptions1);

		for (WebElement o : autofillOptions) {
			String currentAutofillOption = o.getText().toLowerCase().trim()
					.replaceAll("\\s", "");
			String currentOption = option.toLowerCase().trim()
					.replaceAll("\\s", "");
			if (currentAutofillOption.startsWith(currentOption)) {
				String s = String.format("Found the Account " + option);
				LOG.warn(s);
				o.click();

				found = true;
				break;
			}

		}

		try {
			Assert.assertTrue(found, "Spcified Account " + option
					+ " does not exist");
		} catch (AssertionError e) {
			LOG.fatal(option + " not found");
			refresh();
			// reset();
			Assert.fail();

		}
	}

	private boolean matchFound(String patternString, String text) {

		Pattern pattern = Pattern.compile(patternString);
		Matcher matcher = pattern.matcher(text);
		return matcher.find() ? true : false;
	}

	public void selectAccountDetails(String srcAccount, String dstAccount)
			throws Exception {
		// Select Accounts
		AppWait.waitForTime(5l);
		selectOptionUsingAutofill(AccountType.Source, srcAccount);
		AppWait.waitForTime(5l);
		selectOptionUsingAutofill(AccountType.Destination, dstAccount);
		Thread.sleep(3000l);
		// Select Portfolios
		List<WebElement> portOptions;
		portOptions = optSrcPortfolio.findElements(By.tagName("option"));
		LOG.warn("Source portfolio Options Size" + portOptions.size());
		if (portOptions.size() >= 2) {

			portOptions.get(1).click();
		}

		Thread.sleep(3000l);
		portOptions = optDestPortfolio.findElements(By.tagName("option"));

		LOG.warn("Destination portfolio Options Size" + portOptions.size());
		if (portOptions.size() >= 2) {

			portOptions.get(1).click();
		}

	}

	public void selectAccountDetails(String srcAccount, String dstAccount,
			String portfolioText) throws Exception {
		// Select Accounts
		AppWait.waitForTime(5l);
		selectOptionUsingAutofill(AccountType.Source, srcAccount);
		AppWait.waitForTime(5l);
		selectOptionUsingAutofill(AccountType.Destination, dstAccount);
		Thread.sleep(3000l);

		String portfolioValue = portfolioText.substring(portfolioText
				.indexOf("=") + 1);
		if (portfolioText.startsWith("source=")) {
			// Select Portfolios
			sOptSrcPortfolio = new Select(optSrcPortfolio);
			sOptSrcPortfolio.selectByVisibleText(portfolioValue);
		} else if (portfolioText.startsWith("dest=")) {
			// Select Portfolios
			sOptDestPortfolio = new Select(optDestPortfolio);
			sOptDestPortfolio.selectByVisibleText(portfolioValue);
		}

		Thread.sleep(3000l);
	}

	public void reset() throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("resetForm('wire_details',true)");
		AppWait.waitForTime(10l);
	}

	public void refresh() throws Exception {
		driver.get(pageURL);

		AppWait.waitForTime(15l);

		// reset();
	}

	public void setRequestCommonDetails() {
		// Enter subject for Wire Request
		txtSubject.click();
		txtSubject.clear();
		txtSubject.sendKeys("Logging this automated test request at "
				+ System.currentTimeMillis());
		txtaReqComments.sendKeys(AppConstants.ALLSPECIALCHAR);

	}

	public void setWireCommonDetails(String comments) {
		// disable email

		// Enter Wire Comments
		txtWireComments.click();
		txtWireComments.clear();
		txtWireComments.sendKeys(comments);
	}

	public void setAmountDetails(String amount) {
		txtAmount.click();
		txtAmount.clear();
		txtAmount.sendKeys(amount);

		txtWireDate.click();
		txtWireDate.clear();
		txtWireDate.sendKeys(AppConstants.WIRE_DATE);

		txtValueDate.click();
		txtValueDate.clear();
		txtValueDate.sendKeys(AppConstants.VALUE_DATE);

	}

	public void setUploadDetails(String category, String uploadStatus) {

		Select catOptions = new Select(optCategory);
		catOptions.selectByVisibleText(category);

		Select uploadOptions = new Select(optCodaUploadInfo);
		uploadOptions.selectByVisibleText(uploadStatus);

	}

	public void submitAndVerify(String message) throws Exception {
		ExpectedCondition<Boolean> e = new ExpectedCondition<Boolean>() {

			public Boolean apply(WebDriver d) {
				chkEmail.click();
				return (chkEmail.isSelected() == false);
			}
		};
		new WebDriverWait(driver, 120).until(e);

		// Submit Request
		AppWait.waitForTime(5l);
		LOG.warn("clicking on submit from addrequest module..");
		getFieldvaluesForVerification();
		btnSubmit.click();
		AppWait.waitForTime(5l);
		Setup.acceptDuplicateWire();
		AppWait.waitForTime(5l);
		try {
			// Accept saved changes confirmation
			Setup.verifyConfirmation(message);
		} catch (Exception e1) {
			Setup.acceptWarnings();
			AppWait.waitForTime(5l);
			try {
				// Accept saved changes confirmation
				Setup.verifyConfirmation(message);
			} catch (Exception ex) {
				LOG.error("Submission failed, request is not saved");
				// ex.printStackTrace();
				Assert.fail();
			}
		}

		/*
		 * String requestId = getNewRequestId(); WRSWireDetailsPage page = new
		 * WRSWireDetailsPage(requestId); verifyFieldValues();
		 */
	}

	private void verifyFieldValues() {
		SeleneseTestBase tb = new SeleneseTestBase();

		for (String k : actualValues.keySet()) {
			if (k.startsWith("txt")) {
				String actual = actualValues.get(k);
				WebElement w = mapWebElementNames.get(k);
				if (SeleneseTestBase.seleniumEquals(actual,
						w.getAttribute("value"))) {

					LOG.info(k + " is matching");
				} else {
					tb.verifyTrue(false);
					LOG.info(k + " .......IS NOT MATCHING......");
					LOG.info("actual value: " + actual);
					LOG.info("result value: " + w.getAttribute("value"));
				}
			}

			if (k.startsWith("chk")) {
				String actual = actualValues.get(k);
				WebElement w = mapWebElementNames.get(k);
				String result = String.valueOf(w.isSelected());
				if (actual.equals(result)) {
					LOG.info(k + "is matching");
				} else {
					tb.verifyTrue(false);
					LOG.info(k + " .......IS NOT MATCHING......");
					LOG.info("actual value: " + actual);
					LOG.info("result value: " + result);
					// Assert.fail("Test case failed because of fail in checkbox field value verification");
				}
			}

			if (k.startsWith("opt")) {
				String actual = actualValues.get(k);
				WebElement w = mapWebElementNames.get(k);
				Select selectObject = new Select(w);
				String result = selectObject.getFirstSelectedOption().getText();
				if (actual.equals(result)) {
					LOG.info(k + "is matching");
				} else {
					tb.verifyTrue(false);
					LOG.info(k + " .......IS NOT MATCHING......");
					LOG.info("actual value: " + actual);
					LOG.info("result value: " + result);
					// Assert.fail("Test case failed because of fail in field value verification");
				}
			}
		}
		tb.checkForVerificationErrors();
	}

	private void getFieldvaluesForVerification() {

		String value = txtSubject.getAttribute("value");
		actualValues.put("txtSubject", value);
		mapWebElementNames.put("txtSubject", txtSubject);

		value = txtAmount.getAttribute("value");
		actualValues.put("txtAmount", value);
		mapWebElementNames.put("txtAmount", txtAmount);

		value = txtCurrency.getAttribute("value");
		actualValues.put("txtCurrency", value);
		mapWebElementNames.put("txtCurrency", txtCurrency);

		value = txtSubscriber.getAttribute("value");
		actualValues.put("txtSubscriber", value);
		mapWebElementNames.put("txtSubscriber", txtSubscriber);

		value = txtWireDate.getAttribute("value");
		actualValues.put("txtWireDate", value);
		mapWebElementNames.put("txtWireDate", txtWireDate);

		value = txtValueDate.getAttribute("value");
		actualValues.put("txtValueDate", value);
		mapWebElementNames.put("txtValueDate", txtValueDate);

		value = txtWireComments.getAttribute("value");
		actualValues.put("txtWireComments", value);
		mapWebElementNames.put("txtWireComments", txtWireComments);

		value = txtSrcAccountName.getAttribute("value");
		actualValues.put("txtSrcAccountName", value);
		mapWebElementNames.put("txtSrcAccountName", txtSrcAccountName);

		value = txtDestAccountName.getAttribute("value");
		actualValues.put("txtDestAccountName", value);
		mapWebElementNames.put("txtDestAccountName", txtDestAccountName);

		value = txtSrcBroker.getAttribute("value");
		actualValues.put("txtSrcBroker", value);
		mapWebElementNames.put("txtSrcBroker", txtSrcBroker);

		value = txtDestBroker.getAttribute("value");
		actualValues.put("txtDestBroker", value);
		mapWebElementNames.put("txtDestBroker", txtDestBroker);

		value = txtSrcCompany.getAttribute("value");
		actualValues.put("txtSrcCompany", value);
		mapWebElementNames.put("txtSrcCompany", txtSrcCompany);

		value = txtDestCompany.getAttribute("value");
		actualValues.put("txtDestCompany", value);
		mapWebElementNames.put("txtDestCompany", txtDestCompany);

		Select catOptions = new Select(optCategory);
		Select uploadOptions = new Select(optCodaUploadInfo);
		Select priorityOptions = new Select(optPriority);
		Select srcPortfolioOptions = new Select(optSrcPortfolio);
		Select destPortfolioOptions = new Select(optDestPortfolio);

		value = priorityOptions.getFirstSelectedOption().getText();

		actualValues.put("optPriority", value);
		mapWebElementNames.put("optPriority", optPriority);

		value = srcPortfolioOptions.getFirstSelectedOption().getText();
		actualValues.put("optSrcPortfolio", value);
		mapWebElementNames.put("optSrcPortfolio", optSrcPortfolio);

		value = destPortfolioOptions.getFirstSelectedOption().getText();
		actualValues.put("optDestPortfolio", value);
		mapWebElementNames.put("optDestPortfolio", optDestPortfolio);

		value = catOptions.getFirstSelectedOption().getText();
		actualValues.put("optCategory", value);
		mapWebElementNames.put("optCategory", optCategory);

		value = txtStrategy.getAttribute("value");
		actualValues.put("txtStrategy", value);
		mapWebElementNames.put("txtStrategy", txtStrategy);

		value = uploadOptions.getFirstSelectedOption().getText();
		actualValues.put("optCodaUploadInfo", value);
		mapWebElementNames.put("optCodaUploadInfo", optCodaUploadInfo);

		boolean bvalue = chkIsprivate.isSelected();
		actualValues.put("chkIsprivate", String.valueOf(bvalue));
		mapWebElementNames.put("chkIsprivate", chkIsprivate);

		LOG.info("Printing from hash map\n");
		for (String k : actualValues.keySet()) {
			LOG.info(k + ": " + actualValues.get(k));
		}

	}

	public String getNewRequestId() {
		String successMessage = Setup.successMessage;
		String requestId = parseStringAndGetId(successMessage);
		LOG.warn("New request Id is: " + requestId);
		return requestId;
		/*
		 * if (!(successMessage.equals(null) || successMessage.equals("") ||
		 * successMessage.isEmpty())){ String [] tokens =
		 * successMessage.split("\\s"); Pattern p = Pattern.compile("\\d+");
		 * String requestId=""; for (String s: tokens){ Matcher m =
		 * p.matcher(s); if (m.find()){ requestId = m.group(); break; } } return
		 * requestId; }
		 */

	}

	public void submitNewRequest(String paramString) throws Exception {
		LOG.warn("Trying to create --------NEW WIRES REQUEST-------");
		String category = "Other";
		if (paramString.startsWith("category=")) {
			category = paramString.split("=")[1];
		}

		setRequestCommonDetails();
		// setWireCommonDetails(AppConstants.ALLSPECIALCHAR);
		setWireCommonDetails("Deshaw Custody Fees March May 2010 - June 2011 attention Irene Oleska Fees and Remittance");
		setUploadDetails(category, "DNU");
		//selectAccountDetails("2116 CSI USD Swap Payments (890-0360-968)",
		//		"2048 DB USD VALINC - Coll");
		selectAccountDetails("2804 *HSBC USD COMPPORT OP (639-73700-5)",
				"3608 MS USD Swap Payments (03385VHQ6)");
		
		if (paramString.startsWith("strategy=")) {
			String strategy = paramString.split("=")[1];
			txtStrategy.clear();
			txtStrategy.sendKeys(strategy);
			AppWait.waitForTime(5l);
			driver.findElement(By.xpath("//li[@class='ac_even ac_over']")).click();
					
		}
		setAmountDetails("8000");
		submitAndVerify(AppConstants.ADD_REQUEST_CONFIRM);

		if (paramString.startsWith("logger=")) {
			String requestId = getNewRequestId();
			String logger = paramString.split("=")[1];
			AppDatabase.changeRequestLogger(requestId, logger);
		}

	}

	public void submitNewRequest(String srcAcctId, String dstAcctId,
			String amount, String category, String uploadStatus)
			throws Exception {
		LOG.warn("Trying to create --------NEW WIRES REQUEST-------");
		setRequestCommonDetails();
		// setWireCommonDetails(AppConstants.ALLSPECIALCHAR);
		setWireCommonDetails("Deshaw Custody Fees March May 2010 - June 2011 attention Irene Oleska Fees and Remittance");
		setUploadDetails(category, uploadStatus);
		selectAccountDetails(srcAcctId, dstAcctId);
		setAmountDetails(amount);
		submitAndVerify(AppConstants.ADD_REQUEST_CONFIRM);

	}

	public void submitNewRequest(String srcAcctId, String dstAcctId,
			String amount, String category, String uploadStatus,
			String portfolioText) throws Exception {
		LOG.warn("Trying to create --------NEW WIRES REQUEST-------");
		setRequestCommonDetails();
		// setWireCommonDetails(AppConstants.ALLSPECIALCHAR);
		setWireCommonDetails("Deshaw Custody Fees March May 2010 - June 2011 attention Irene Oleska Fees and Remittance");
		setUploadDetails(category, uploadStatus);
		selectAccountDetails(srcAcctId, dstAcctId, portfolioText);
		setAmountDetails(amount);
		submitAndVerify(AppConstants.ADD_REQUEST_CONFIRM);

	}

	public void submitNewRequest(String srcAcctId, String dstAcctId,
			String amount, String category, String uploadStatus,
			String tradeId, String gboType, String amountS) throws Exception {
		LOG.warn("Trying to create --------NEW WIRES REQUEST-------");
		setRequestCommonDetails();
		setWireCommonDetails(AppConstants.ALLSPECIALCHAR);
		setUploadDetails(category, uploadStatus);
		selectAccountDetails(srcAcctId, dstAcctId);
		setAmountDetails(amount);
		AppWait.waitForTime(10l);
		setSplitAmount(tradeId, gboType, amountS);
		submitAndVerify(AppConstants.ADD_REQUEST_CONFIRM);

	}

	public void submitMultipleWiresRequest(String srcAcctId, String dstAcctId,
			String amount, String category, String uploadStatus,
			String srcAcctId2, String srcAcctId3) throws Exception {
		submitNewRequest(srcAcctId, dstAcctId, amount, category, uploadStatus);
		String requestId = getNewRequestId();
		getRequestDetailsPage(requestId);
		fillAndSubmitWireDetails(category, uploadStatus, srcAcctId2, dstAcctId,
				amount);
		fillAndSubmitWireDetails(category, uploadStatus, srcAcctId3, dstAcctId,
				amount);

	}

	public void fillAndSubmitWireDetails(String category, String uploadStatus,
			String srcAcctId2, String dstAcctId, String amount)
			throws Exception {
		setWireCommonDetails(AppConstants.ALLSPECIALCHAR);
		setUploadDetails(category, uploadStatus);
		selectAccountDetails(srcAcctId2, dstAcctId);
		setAmountDetails(amount);
		LOG.warn("Trying to add --------NEW WIRE-------");
		submitAndVerify(AppConstants.UPDATE_REQUEST_CONFIRM);
	}

	public void submitNewWireForGivenRequest(String srcAcctId,
			String dstAcctId, String amount, String category,
			String uploadStatus, String requestId) throws Exception {
		getRequestDetailsPage(requestId);
		// setRequestCommonDetails();
		setWireCommonDetails(AppConstants.ALLSPECIALCHAR);
		setUploadDetails(category, uploadStatus);
		selectAccountDetails(srcAcctId, dstAcctId);
		setAmountDetails(amount);
		LOG.warn("Trying to add --------NEW WIRE-------");
		submitAndVerify(AppConstants.UPDATE_REQUEST_CONFIRM);

	}

	public void getRequestDetailsPage(String requestId) throws Exception {
		requestId = requestId.toLowerCase().trim();
		requestId = parseStringAndGetId(requestId);
		String requestURL = Setup.getAppURL() + "/wrs/Q/" + requestId;
		LOG.warn("Loading Request Details Page - URL: " + requestURL);
		driver.get(requestURL);
		AppWait.waitForTime(10l);
	}

	protected String parseStringAndGetId(String message) {
		String id = null;
		Pattern p = Pattern.compile("\\d+");
		Matcher m = p.matcher(message);
		if (m.find()) {
			id = m.group();
		}
		return id;
	}

}
