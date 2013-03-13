package deshaw.automation.wires.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import appdriverng.common.AppWait;
import appdriverng.common.Setup;

public class WRSMaintainRefData extends Page {
	Select selectRefDataType;
	WebElement btnConfigureGrid;

	public WRSMaintainRefData() {
		super();
		WebElement RefDataType = driver.findElement(By.id("referenceDataId"));
		selectRefDataType = new Select(RefDataType);
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public void open() {
		try {
			pageURL = Setup.getAppURL() + Setup.getPageURL("WRSRefDataPage");
			driver.get(pageURL);
			LOG.warn("Loading Maintain refernce data Page - URL:  " + pageURL);
			AppWait.waitForTime(10l);
			Assert.assertTrue(driver.getTitle().contains(
					"WRS Maintain Reference Data"));

		} catch (Exception e) {
			LOG.error("FAILED WHILE LOADING  Maintain refernce data Page ");
			Assert.fail(" Maintain refernce data Page");

		}

	}

	public void verifyCategoryReferenceData() {
		selectRefDataType.selectByVisibleText("Category");

		try {
			AppWait.waitForTime(5l);
			LOG.warn("Loading Category Details Grid..  ");
			WebElement gridHeader = driver
					.findElement(By
							.xpath("/html/body/div[5]/div/div/div/div[3]/table/tfoot/tr[2]/td[2]/div/div"));
			Assert.assertTrue(gridHeader.isDisplayed());
			LOG.info("Grid header is loaded properly");
			AppWait.waitForTime(5l);
			WebElement gridHeaderCatId = gridHeader.findElement(By
					.xpath("table/tfoot/tr/td/div/table/tfoot/tr/td/div"));
			Assert.assertTrue(gridHeaderCatId.getText().toLowerCase().equals("Category Id".toLowerCase()));
			LOG.info("Grid Column header 'Category id' is displayed properly");
			AppWait.waitForTime(5l);
			WebElement catIdValue = driver.findElement(By
					.xpath("/html/body/div[5]/div/div/div/div[3]/table/tfoot/tr[3]/td[2]/div/div/div/table/tfoot/tr/td/div/div"));
			Assert.assertTrue(catIdValue.isDisplayed());
			LOG.info("Category id value is displayed properly in the tree grid");
			LOG.warn("Loading Category Details..  ");
			WebElement txtCatName = driver.findElement(By.id("categoryName"));
			Assert.assertTrue(txtCatName.isDisplayed());
			LOG.info("Category details Form and elements are loaded properly.. ");

		} catch (Exception e) {
			LOG.error("Problem in loading Category details window");
			Assert.fail("Problem in loading Category details window");

		}

	}
	
	public void verifyCodaFQAData() {
		selectRefDataType.selectByVisibleText("CODA FQA");

		try {
			AppWait.waitForTime(5l);
			LOG.warn("Loading FQA Details Grid..  ");
			WebElement gridHeader = driver
					.findElement(By
							.xpath("/html/body/div[5]/div/div/div/div[3]/table/tfoot/tr[2]/td[2]/div/div"));
			Assert.assertTrue(gridHeader.isDisplayed());
			LOG.info("Grid header is loaded properly");
			AppWait.waitForTime(5l);
			WebElement gridHeaderCatId = gridHeader.findElement(By
					.xpath("table/tfoot/tr/td/div/table/tfoot/tr/td/div"));
			Assert.assertTrue(gridHeaderCatId.getText().toLowerCase().equals("Id".toLowerCase()));
			LOG.info("Grid Column header 'Id' is displayed properly");
			AppWait.waitForTime(5l);
			WebElement idValue = driver.findElement(By
					.xpath("/html/body/div[5]/div/div/div/div[3]/table/tfoot/tr[3]/td[2]/div/div/div/table/tfoot/tr/td/div/div"));
			Assert.assertTrue(idValue.isDisplayed());
			LOG.info("FQA id value is displayed properly in the tree grid");
			LOG.warn("Loading Coda FQA Details..  ");
			WebElement txtEl1 = driver.findElement(By.id("el1"));
			Assert.assertTrue(txtEl1.isDisplayed());
			LOG.info("Coda FQA details Form and elements are loaded properly.. ");

		} catch (Exception e) {
			LOG.error("Problem in loading Coda FQA details window");
			Assert.fail("Problem in loading Coda FQA details window");

		}

	}
	
	public void verifyFinancialTypeData() {
		selectRefDataType.selectByVisibleText("Financial Type");

		try {
			AppWait.waitForTime(5l);
			LOG.warn("Loading Financial Details Grid..  ");
			WebElement gridHeader = driver
					.findElement(By
							.xpath("/html/body/div[5]/div/div/div/div[3]/table/tfoot/tr[2]/td[2]/div/div"));
			Assert.assertTrue(gridHeader.isDisplayed());
			LOG.info("Grid header is loaded properly");
			AppWait.waitForTime(5l);
			WebElement gridHeaderCatId = gridHeader.findElement(By
					.xpath("table/tfoot/tr/td/div/table/tfoot/tr/td/div"));
			Assert.assertTrue(gridHeaderCatId.getText().toLowerCase().equals("Financial Type Id".toLowerCase()));
			LOG.info("Grid Column header 'Financial Type Id' is displayed properly");
			AppWait.waitForTime(5l);
			WebElement idValue = driver.findElement(By
					.xpath("/html/body/div[5]/div/div/div/div[3]/table/tfoot/tr[3]/td[2]/div/div/div/table/tfoot/tr/td/div/div"));
			Assert.assertTrue(idValue.isDisplayed());
			LOG.info("Financial Type Id value is displayed properly in the tree grid");
			LOG.warn("Loading Financial Type Details..  ");
			WebElement txtFinTypeName = driver.findElement(By.id("financialTypeName"));
			Assert.assertTrue(txtFinTypeName.isDisplayed());
			LOG.info("Financial Type details Form and elements are loaded properly.. ");

		} catch (Exception e) {
			LOG.error("Problem in loading Financial Type details window");
			Assert.fail("Problem in loading Financial Type details window");

		}

	}
	
	public void verifySignatoryAmountRangeData() {
		selectRefDataType.selectByVisibleText("Signatory Amount Range");

		try {
			AppWait.waitForTime(5l);
			LOG.warn("Loading Signatory Amount Grid..  ");
			WebElement gridHeader = driver
					.findElement(By
							.xpath("/html/body/div[5]/div/div/div/div[3]/table/tfoot/tr[2]/td[2]/div/div"));
			Assert.assertTrue(gridHeader.isDisplayed());
			LOG.info("Grid header is loaded properly");
			AppWait.waitForTime(5l);
			WebElement gridHeaderCatId = gridHeader.findElement(By
					.xpath("table/tfoot/tr/td/div/table/tfoot/tr/td/div"));
			Assert.assertTrue(gridHeaderCatId.getText().toLowerCase().equals("Amount Range Id".toLowerCase()));
			LOG.info("Grid Column header 'Amount Range Id' is displayed properly");
			AppWait.waitForTime(5l);
			WebElement idValue = driver.findElement(By
					.xpath("/html/body/div[5]/div/div/div/div[3]/table/tfoot/tr[3]/td[2]/div/div/div/table/tfoot/tr/td/div/div"));
			Assert.assertTrue(idValue.isDisplayed());
			LOG.info("Amount Range Id value is displayed properly in the tree grid");
			LOG.warn("Loading Signatory Amount Range Details..  ");
			WebElement txtLowerbound = driver.findElement(By.id("lowerBound"));
			Assert.assertTrue(txtLowerbound.isDisplayed());
			LOG.info("Signatory Amount Range details Form and elements are loaded properly.. ");

		} catch (Exception e) {
			LOG.error("Problem in loading Signatory Amount Range details window");
			Assert.fail("Problem in loading Signatory Amount Range details window");

		}

	}
	
	public void verifySignatoryGroupData() {
		selectRefDataType.selectByVisibleText("Signatory Group");

		try {
			AppWait.waitForTime(5l);
			LOG.warn("Loading Signatory Group Grid..  ");
			WebElement gridHeader = driver
					.findElement(By
							.xpath("/html/body/div[5]/div/div/div/div[3]/table/tfoot/tr[2]/td[2]/div/div"));
			Assert.assertTrue(gridHeader.isDisplayed());
			LOG.info("Grid header is loaded properly");
			AppWait.waitForTime(5l);
			WebElement gridHeaderCatId = gridHeader.findElement(By
					.xpath("table/tfoot/tr/td/div/table/tfoot/tr/td/div"));
			Assert.assertTrue(gridHeaderCatId.getText().toLowerCase().equals("Signatory Group Id".toLowerCase()));
			LOG.info("Grid Column header 'Signatory Group Id' is displayed properly");
			AppWait.waitForTime(5l);
			WebElement idValue = driver.findElement(By
					.xpath("/html/body/div[5]/div/div/div/div[3]/table/tfoot/tr[3]/td[2]/div/div/div/table/tfoot/tr/td/div/div"));
			Assert.assertTrue(idValue.isDisplayed());
			LOG.info("Signatory Group Id value is displayed properly in the tree grid");
			LOG.warn("Loading Signatory Group Details..  ");
			WebElement txtSignGroupName = driver.findElement(By.id("name"));
			Assert.assertTrue(txtSignGroupName.isDisplayed());
			LOG.info("Signatory Group details Form and elements are loaded properly.. ");

		} catch (Exception e) {
			LOG.error("Problem in loading Signatory Group details window");
			Assert.fail("Problem in loading Signatory Group details window");

		}

	}
	
	public void verifySignatoryGroupMemberData() {
		selectRefDataType.selectByVisibleText("Signatory Group Member");

		try {
			AppWait.waitForTime(5l);
			LOG.warn("Loading Signatory Group Member Grid..  ");
			WebElement gridHeader = driver
					.findElement(By
							.xpath("/html/body/div[5]/div/div/div/div[3]/table/tfoot/tr[2]/td[2]/div/div"));
			Assert.assertTrue(gridHeader.isDisplayed());
			LOG.info("Grid header is loaded properly");
			AppWait.waitForTime(5l);
			WebElement gridHeaderCatId = gridHeader.findElement(By
					.xpath("table/tfoot/tr/td/div/table/tfoot/tr/td/div"));
			Assert.assertTrue(gridHeaderCatId.getText().toLowerCase().equals("Signatory Group Member Id".toLowerCase()));
			LOG.info("Grid Column header 'Signatory Group Member Id' is displayed properly");
			AppWait.waitForTime(5l);
			WebElement idValue = driver.findElement(By
					.xpath("/html/body/div[5]/div/div/div/div[3]/table/tfoot/tr[3]/td[2]/div/div/div/table/tfoot/tr/td/div/div"));
			Assert.assertTrue(idValue.isDisplayed());
			LOG.info("Signatory Group Member Id value is displayed properly in the tree grid");
			LOG.warn("Loading Signatory Group Member Details..  ");
			WebElement txtSignGroupMemId = driver.findElement(By.id("signatoryId"));
			Assert.assertTrue(txtSignGroupMemId.isDisplayed());
			LOG.info("Signatory Group Member details Form and elements are loaded properly.. ");

		} catch (Exception e) {
			LOG.error("Problem in loading Signatory Group Member details window");
			Assert.fail("Problem in loading Signatory Group Member details window");
		}
	}
	
	public void verifySignatoryRuleData() {
		selectRefDataType.selectByVisibleText("Signatory Rule");

		try {
			AppWait.waitForTime(5l);
			LOG.warn("Loading Signatory Rule Grid..  ");
			WebElement gridHeader = driver
					.findElement(By
							.xpath("/html/body/div[5]/div/div/div/div[3]/table/tfoot/tr[2]/td[2]/div/div"));
			Assert.assertTrue(gridHeader.isDisplayed());
			LOG.info("Grid header is loaded properly");
			AppWait.waitForTime(5l);
			WebElement gridHeaderCatId = gridHeader.findElement(By
					.xpath("table/tfoot/tr/td/div/table/tfoot/tr/td/div"));
			Assert.assertTrue(gridHeaderCatId.getText().toLowerCase().equals("Signatory Rule Id".toLowerCase()));
			LOG.info("Grid Column header 'Signatory Rule Id' is displayed properly");
			AppWait.waitForTime(5l);
			WebElement idValue = driver.findElement(By
					.xpath("/html/body/div[5]/div/div/div/div[3]/table/tfoot/tr[3]/td[2]/div/div/div/table/tfoot/tr/td/div/div"));
			Assert.assertTrue(idValue.isDisplayed());
			LOG.info("Signatory Rule Id value is displayed properly in the tree grid");
			LOG.warn("Loading Signatory Rule Details..  ");
			WebElement txtSignRulename = driver.findElement(By.id("name"));
			Assert.assertTrue(txtSignRulename.isDisplayed());
			LOG.info("Signatory Rule details Form and elements are loaded properly.. ");

		} catch (Exception e) {
			LOG.error("Problem in loading Signatory Rule details window");
			Assert.fail("Problem in loading Signatory Rule details window");
		}
	}
	
	public void verifyTransmissionTypeData() {
		selectRefDataType.selectByVisibleText("Transmission Type");

		try {
			AppWait.waitForTime(5l);
			LOG.warn("Loading Transmission Type Grid..  ");
			WebElement gridHeader = driver
					.findElement(By
							.xpath("/html/body/div[5]/div/div/div/div[3]/table/tfoot/tr[2]/td[2]/div/div"));
			Assert.assertTrue(gridHeader.isDisplayed());
			LOG.info("Grid header is loaded properly");
			AppWait.waitForTime(5l);
			WebElement gridHeaderCatId = gridHeader.findElement(By
					.xpath("table/tfoot/tr/td/div/table/tfoot/tr/td/div"));
			Assert.assertTrue(gridHeaderCatId.getText().toLowerCase().equals("Transmission Type Id".toLowerCase()));
			LOG.info("Grid Column header 'Transmission Type Id' is displayed properly");
			AppWait.waitForTime(5l);
			WebElement idValue = driver.findElement(By
					.xpath("/html/body/div[5]/div/div/div/div[3]/table/tfoot/tr[3]/td[2]/div/div/div/table/tfoot/tr/td/div/div"));
			Assert.assertTrue(idValue.isDisplayed());
			LOG.info("Transmission Type Id value is displayed properly in the tree grid");
			LOG.warn("Loading Transmission Type Details..  ");
			WebElement txtTransmissionTypeName = driver.findElement(By.id("transmissionTypeName"));
			Assert.assertTrue(txtTransmissionTypeName.isDisplayed());
			LOG.info("Transmission Type details Form and elements are loaded properly.. ");

		} catch (Exception e) {
			LOG.error("Problem in loading Transmission Type details window");
			Assert.fail("Problem in loading Transmission Type details window");
		}
	}
	
	public void verifyConfigureGridInRefernceData() {
		selectRefDataType.selectByVisibleText("Category");
		
		try {
			AppWait.waitForTime(5l);
			btnConfigureGrid = driver.findElement(By.id("configure"));
			btnConfigureGrid.click();
			AppWait.waitForTime(5l);
			LOG.warn("Loading Configure grid in Reference Data page..  " );
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

			if (found == false) {

				LOG.error("Configure Grid window is not found");
				Assert.fail("Window Loading FAILURE");

			}
			
			WebElement selectedColumns = driver.findElement(By.id("displayHeader"));
			Assert.assertTrue(selectedColumns.isDisplayed());		
			LOG.info("Configure Grid elements are loaded properly ");


		} catch (Exception e) {
			LOG.error("Problem in loading Configure grid window");
			Assert.fail("Configure grid Window Loading FAILURE");

		}
	}
	
}
