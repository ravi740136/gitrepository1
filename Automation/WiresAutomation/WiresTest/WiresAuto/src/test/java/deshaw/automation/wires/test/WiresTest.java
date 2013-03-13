package deshaw.automation.wires.test;

import java.lang.reflect.Method;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import appdriverng.common.AppConstants;
import appdriverng.common.AppDatabase;
import appdriverng.common.AppWait;
import appdriverng.common.ReadFromExcel;
import appdriverng.common.Setup;
import deshaw.automation.wires.pages.WRSAddRequestPage;
import deshaw.automation.wires.pages.WRSAdvSearchPage;
import deshaw.automation.wires.pages.WRSApprovalsPage;
import deshaw.automation.wires.pages.WRSBulkUpdateWires;
import deshaw.automation.wires.pages.WRSCloneRequestPage;
import deshaw.automation.wires.pages.WRSConfigureSettings;
import deshaw.automation.wires.pages.WRSGLUploadPage;
import deshaw.automation.wires.pages.WRSMaintainRefData;
import deshaw.automation.wires.pages.WRSSearchConfigureGrid;
import deshaw.automation.wires.pages.WRSSearchPage;
import deshaw.automation.wires.pages.WRSSetPassPhrasePage;
import deshaw.automation.wires.pages.WRSWireDetailsPage;

public class WiresTest {
	String currentTestMethod = "";
	String path;
	String sheet;
	WRSAddRequestPage addRequestPage;
	WRSWireDetailsPage wireDetailsPage;
	WRSApprovalsPage wrsApprovalspage;
	WRSSearchPage wrsSearchPage;
	WRSGLUploadPage wrsGLUploadPage;
	WRSConfigureSettings configureSettingsPage;
	WRSSearchConfigureGrid configureGrid;
	WRSMaintainRefData refDataPage;
	WRSSetPassPhrasePage passPhrasePage;
	WRSCloneRequestPage cloneRequest;
	WRSAdvSearchPage advSearchPage;
	static final Logger LOG = Logger.getLogger("deshaw.automation");

	@BeforeTest(alwaysRun = true)
	public void setUp() throws Exception {
		Setup.init();

		sheet = Setup.getDataSheet(this.getClass().getSimpleName());
		LOG.info("get data sheet uses = " + this.getClass().getSimpleName());
		path = Setup.getDataFile();
		LOG.info("Data File Path = " + path);
		// LOG.warn("Data sheet name= " + sheet);

	}

	// Select Source and Destination Accounts
	@Test(dataProvider = "requestData")
	public void tSubmitNewRequest(String srcAcctId, String dstAcctId,
			String amount, String category, String uploadStatus)
			throws Exception {
		LOG.warn("--------------STARTING NEW TEST-------------------:"
				+ currentTestMethod);
		try {
			addRequestPage = new WRSAddRequestPage();
			addRequestPage.submitNewRequest(srcAcctId, dstAcctId, amount,
					category, uploadStatus);

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();

		} finally {
			LOG.warn("--------------END OF THE TEST-------------------"
					+ currentTestMethod);
			System.out.println("\n\n\n");
		}

	}

	@Test(dataProvider = "requestData")
	public void tSubmitNewRequest_UPD(String srcAcctId, String dstAcctId,
			String amount, String category, String uploadStatus)
			throws Exception {
		LOG.warn("--------------STARTING NEW TEST-------------------:"
				+ currentTestMethod);
		try {
			addRequestPage = new WRSAddRequestPage();
			addRequestPage.submitNewRequest(srcAcctId, dstAcctId, amount,
					category, uploadStatus);

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();

		} finally {
			LOG.warn("--------------END OF THE TEST-------------------"
					+ currentTestMethod);
			System.out.println("\n\n\n");
		}

	}

	@Test(dataProvider = "requestData")
	public void tSubmitNewRequest_SUSP(String srcAcctId, String dstAcctId,
			String amount, String category, String uploadStatus)
			throws Exception {
		LOG.warn("--------------STARTING NEW TEST-------------------:"
				+ currentTestMethod);
		try {
			addRequestPage = new WRSAddRequestPage();
			addRequestPage.submitNewRequest(srcAcctId, dstAcctId, amount,
					category, uploadStatus);

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();

		} finally {
			LOG.warn("--------------END OF THE TEST-------------------"
					+ currentTestMethod);
			System.out.println("\n\n\n");
		}

	}

	@Test(dataProvider = "requestData")
	public void tSubmitNewRequest_DNUMI(String srcAcctId, String dstAcctId,
			String amount, String category, String uploadStatus)
			throws Exception {
		LOG.warn("--------------STARTING NEW TEST-------------------:"
				+ currentTestMethod);
		try {
			addRequestPage = new WRSAddRequestPage();
			addRequestPage.submitNewRequest(srcAcctId, dstAcctId, amount,
					category, uploadStatus);

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();

		} finally {
			LOG.warn("--------------END OF THE TEST-------------------"
					+ currentTestMethod);
			System.out.println("\n\n\n");
		}

	}

	@Test(dataProvider = "requestData")
	public void tSubmitNewRequest_UI(String srcAcctId, String dstAcctId,
			String amount, String category, String uploadStatus)
			throws Exception {
		LOG.warn("--------------STARTING NEW TEST-------------------:"
				+ currentTestMethod);
		try {
			addRequestPage = new WRSAddRequestPage();
			addRequestPage.submitNewRequest(srcAcctId, dstAcctId, amount,
					category, uploadStatus);

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();

		} finally {
			LOG.warn("--------------END OF THE TEST-------------------"
					+ currentTestMethod);
			System.out.println("\n\n\n");
		}

	}

	@Test(dataProvider = "requestData")
	public void tSubmitNewRequest_VOID(String srcAcctId, String dstAcctId,
			String amount, String category, String uploadStatus)
			throws Exception {
		LOG.warn("--------------STARTING NEW TEST-------------------:"
				+ currentTestMethod);
		try {
			addRequestPage = new WRSAddRequestPage();
			addRequestPage.submitNewRequest(srcAcctId, dstAcctId, amount,
					category, uploadStatus);

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();

		} finally {
			LOG.warn("--------------END OF THE TEST-------------------"
					+ currentTestMethod);
			System.out.println("\n\n\n");
		}

	}

	@Test(dataProvider = "requestData")
	public void tSubmitNewRequest_UPDSS(String srcAcctId, String dstAcctId,
			String amount, String category, String uploadStatus,
			String tradeId, String gboType, String amountS) throws Exception {
		LOG.warn("--------------STARTING NEW TEST-------------------:"
				+ currentTestMethod);
		try {
			addRequestPage = new WRSAddRequestPage();
			addRequestPage.submitNewRequest(srcAcctId, dstAcctId, amount,
					category, uploadStatus, tradeId, gboType, amountS);

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();

		} finally {
			LOG.warn("--------------END OF THE TEST-------------------"
					+ currentTestMethod);
			System.out.println("\n\n\n");
		}

	}

	@Test(dataProvider = "requestData")
	public void tSubmitMultipleWiresRequest(String srcAcctId, String dstAcctId,
			String amount, String category, String uploadStatus,
			String srcAcctId2, String srcAcctId3) throws Exception {
		LOG.warn("--------------STARTING NEW TEST-------------------:"
				+ currentTestMethod);
		try {
			addRequestPage = new WRSAddRequestPage();
			addRequestPage.submitMultipleWiresRequest(srcAcctId, dstAcctId,
					amount, category, uploadStatus, srcAcctId2, srcAcctId3);

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();

		} finally {
			LOG.warn(" --------------END OF THE TEST-------------------"
					+ currentTestMethod);
			System.out.println("\n\n\n");
		}

	}

	@Test(dataProvider = "requestData")
	public void tsubmitNewWireForGivenRequest(String srcAcctId,
			String dstAcctId, String amount, String category,
			String uploadStatus, String requestId) throws Exception {
		LOG.warn(" --------------STARTING NEW TEST-------------------"
				+ currentTestMethod);
		try {

			addRequestPage = new WRSAddRequestPage();
			if (requestId.matches("\\s*")) {
				addRequestPage.submitNewRequest(srcAcctId, dstAcctId, amount,
						category, uploadStatus);
				requestId = addRequestPage.getNewRequestId();
			}

			addRequestPage.submitNewWireForGivenRequest(srcAcctId, dstAcctId,
					amount, category, uploadStatus, requestId);
			AppWait.waitForTime(10l);

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
			AppWait.waitForTime(10l);
		} finally {
			LOG.warn(" --------------END OF THE TEST-------------------"
					+ currentTestMethod);
			System.out.println("\n\n\n");
		}

	}

	@Test(dataProvider = "requestData")
	public void tEffect_Of_Rejected_Void_Wires_On_Other_Wire_Submit_To_Signatory(
			String srcAcctId, String dstAcctId, String amount, String category,
			String uploadStatus, String srcAcctId2, String srcAcctId3)
			throws Exception {
		LOG.warn("--------------STARTING NEW TEST-------------------:"
				+ currentTestMethod);
		try {
			String requestId = prepare_Rejected_Void_Active_Wires(srcAcctId,
					dstAcctId, amount, category, uploadStatus, srcAcctId2,
					srcAcctId3);
			wireDetailsPage.submitToSignatory(requestId);

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();

		} finally {
			LOG.warn(" --------------END OF THE TEST-------------------"
					+ currentTestMethod);
			System.out.println("\n\n\n");
		}

	}

	private String prepare_Rejected_Void_Active_Wires(String srcAcctId,
			String dstAcctId, String amount, String category,
			String uploadStatus, String srcAcctId2, String srcAcctId3)
			throws Exception {
		addRequestPage = new WRSAddRequestPage();
		addRequestPage.submitMultipleWiresRequest(srcAcctId, dstAcctId, amount,
				category, uploadStatus, srcAcctId2, srcAcctId3);
		String requestId = addRequestPage.getNewRequestId();
		List wireList = AppDatabase.getAllWires(requestId);
		String wireId_Reject = (String) wireList.get(0);
		String wireId_Active = (String) wireList.get(1);
		String wireId_Void = (String) wireList.get(2);
		wireDetailsPage = new WRSWireDetailsPage("wire#" + wireId_Reject);
		wireDetailsPage.rejectWire();
		// wireDetailsPage = new WRSWireDetailsPage("wire#"+wireId_Void);
		// wireDetailsPage.voidWire(wireId_Void);
		wireDetailsPage = new WRSWireDetailsPage("wire#" + wireId_Active);
		return requestId;
	}

	@Test(dataProvider = "requestData")
	public void tEffect_Of_Rejected_Void_Wires_On_Other_Wire_Amount_Details(
			String srcAcctId, String dstAcctId, String amount, String category,
			String uploadStatus, String srcAcctId2, String srcAcctId3,
			String amount2) throws Exception {
		LOG.warn("--------------STARTING NEW TEST-------------------:"
				+ currentTestMethod);
		try {
			String requestId = prepare_Rejected_Void_Active_Wires(srcAcctId,
					dstAcctId, amount, category, uploadStatus, srcAcctId2,
					srcAcctId3);
			wireDetailsPage.setAmountDetails(amount2);
			wireDetailsPage
					.submitAndVerify(AppConstants.UPDATE_REQUEST_CONFIRM);

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();

		} finally {
			LOG.warn(" --------------END OF THE TEST-------------------"
					+ currentTestMethod);
			System.out.println("\n\n\n");
		}

	}

	@Test(dataProvider = "requestData")
	public void tEffect_Of_Rejected_Void_Wires_On_Other_Wire_Upload_Details(
			String srcAcctId, String dstAcctId, String amount, String category,
			String uploadStatus, String srcAcctId2, String srcAcctId3,
			String category2, String uploadStatus2) throws Exception {
		LOG.warn("--------------STARTING NEW TEST-------------------:"
				+ currentTestMethod);
		try {
			String requestId = prepare_Rejected_Void_Active_Wires(srcAcctId,
					dstAcctId, amount, category, uploadStatus, srcAcctId2,
					srcAcctId3);
			wireDetailsPage.setUploadDetails(category2, uploadStatus2);
			wireDetailsPage
					.submitAndVerify(AppConstants.UPDATE_REQUEST_CONFIRM);

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();

		} finally {
			LOG.warn(" --------------END OF THE TEST-------------------"
					+ currentTestMethod);
			System.out.println("\n\n\n");
		}

	}

	@Test(dataProvider = "requestData")
	public void tEffect_Of_Rejected_Void_Wires_On_Other_Wire_Account_Details(
			String srcAcctId, String dstAcctId, String amount, String category,
			String uploadStatus, String srcAcctId2, String srcAcctId4,
			String srcAcctId3, String dstAcctId3) throws Exception {
		LOG.warn("--------------STARTING NEW TEST-------------------:"
				+ currentTestMethod);
		try {
			String requestId = prepare_Rejected_Void_Active_Wires(srcAcctId,
					dstAcctId, amount, category, uploadStatus, srcAcctId2,
					srcAcctId4);
			wireDetailsPage.selectAccountDetails(srcAcctId3, dstAcctId3);
			wireDetailsPage
					.submitAndVerify(AppConstants.UPDATE_REQUEST_CONFIRM);

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();

		} finally {
			LOG.warn(" --------------END OF THE TEST-------------------"
					+ currentTestMethod);
			System.out.println("\n\n\n");
		}

	}

	@Test(dataProvider = "requestData")
	public void tEffect_Of_Rejected_Void_Wires_On_Other_Wire_Common_Details(
			String srcAcctId, String dstAcctId, String amount, String category,
			String uploadStatus, String srcAcctId2, String srcAcctId3)
			throws Exception {
		LOG.warn("--------------STARTING NEW TEST-------------------:"
				+ currentTestMethod);
		try {
			String requestId = prepare_Rejected_Void_Active_Wires(srcAcctId,
					dstAcctId, amount, category, uploadStatus, srcAcctId2,
					srcAcctId3);
			wireDetailsPage.setWireCommonDetails(AppConstants.ALLSPECIALCHAR
					+ " comments changed");
			wireDetailsPage
					.submitAndVerify(AppConstants.UPDATE_REQUEST_CONFIRM);

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();

		} finally {
			LOG.warn(" --------------END OF THE TEST-------------------"
					+ currentTestMethod);
			System.out.println("\n\n\n");
		}

	}

	// Select Source and Destination Accounts
	@Test(dataProvider = "requestData")
	public void tPreviewCodaGLUPloadScreen_CompleteWorkflow(String srcAcctId,
			String dstAcctId, String amount, String category,
			String uploadStatus) throws Exception {
		LOG.warn(" --------------STARTING NEW TEST-------------------"
				+ currentTestMethod);
		try {
			addRequestPage = new WRSAddRequestPage();
			addRequestPage.submitNewRequest(srcAcctId, dstAcctId, amount,
					category, uploadStatus);
			String requestId = addRequestPage.getNewRequestId();
			wireDetailsPage = new WRSWireDetailsPage(requestId);
			wireDetailsPage.submitToSignatory(requestId);
			wrsApprovalspage = new WRSApprovalsPage();
			wrsApprovalspage.approveWires();
			wrsSearchPage = new WRSSearchPage();
			wrsSearchPage.searchForRequestIds(requestId);
			wrsSearchPage.releaseWiresByHsbcNet();
			wireDetailsPage = new WRSWireDetailsPage(requestId);
			wireDetailsPage.moveFunds();
			wireDetailsPage.refresh();
			String avd = wireDetailsPage
					.getActualValueDateByRemovingStartingZeroes();
			String wireAmount = wireDetailsPage.getWireAmountByRemovingCommas();
			wrsGLUploadPage = new WRSGLUploadPage();
			String wireId = AppDatabase.getLatestWireId(requestId);
			wrsGLUploadPage.searchForWire(wireId);
			wrsGLUploadPage.previewCoda(avd, wireAmount);

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();

		} finally {
			LOG.warn(" --------------END OF THE TEST-------------------"
					+ currentTestMethod);
			System.out.println("\n\n\n");
		}

	}

	@Test(dataProvider = "requestData")
	public void tCompleteWorkflow_SUSP(String srcAcctId, String dstAcctId,
			String amount, String category, String uploadStatus)
			throws Exception {
		LOG.warn(" --------------STARTING NEW TEST-------------------"
				+ currentTestMethod);
		try {
			addRequestPage = new WRSAddRequestPage();
			addRequestPage.submitNewRequest(srcAcctId, dstAcctId, amount,
					category, uploadStatus);
			String requestId = addRequestPage.getNewRequestId();
			wireDetailsPage = new WRSWireDetailsPage(requestId);
			wireDetailsPage.submitToSignatory(requestId);
			wrsApprovalspage = new WRSApprovalsPage();
			wrsApprovalspage.approveWires();
			wrsSearchPage = new WRSSearchPage();
			wrsSearchPage.searchForRequestIds(requestId);
			wrsSearchPage.releaseWiresByHsbcNet();
			/*
			 * wireDetailsPage = new WRSWireDetailsPage(requestId);
			 * wireDetailsPage.moveFunds(); wireDetailsPage.refresh(); String
			 * avd =
			 * wireDetailsPage.getActualValueDateByRemovingStartingZeroes();
			 * String wireAmount =
			 * wireDetailsPage.getWireAmountByRemovingCommas(); wrsGLUploadPage
			 * = new WRSGLUploadPage(); String wireId =
			 * AppDatabase.getLatestWireId(requestId);
			 * wrsGLUploadPage.searchForWire(wireId);
			 * wrsGLUploadPage.previewCoda(avd,wireAmount );
			 */

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();

		} finally {
			LOG.warn(" --------------END OF THE TEST-------------------"
					+ currentTestMethod);
			System.out.println("\n\n\n");
		}

	}

	@Test(dataProvider = "requestData")
	public void tCompleteWorkflow_UI(String srcAcctId, String dstAcctId,
			String amount, String category, String uploadStatus)
			throws Exception {
		LOG.warn(" --------------STARTING NEW TEST-------------------"
				+ currentTestMethod);
		try {
			addRequestPage = new WRSAddRequestPage();
			addRequestPage.submitNewRequest(srcAcctId, dstAcctId, amount,
					category, uploadStatus);
			String requestId = addRequestPage.getNewRequestId();
			wireDetailsPage = new WRSWireDetailsPage(requestId);
			wireDetailsPage.submitToSignatory(requestId);
			wrsApprovalspage = new WRSApprovalsPage();
			wrsApprovalspage.approveWires();
			wrsSearchPage = new WRSSearchPage();
			wrsSearchPage.searchForRequestIds(requestId);
			wrsSearchPage.releaseWiresByHsbcNet();
			/*
			 * wireDetailsPage = new WRSWireDetailsPage(requestId);
			 * wireDetailsPage.moveFunds();
			 */

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();

		} finally {
			LOG.warn(" --------------END OF THE TEST-------------------"
					+ currentTestMethod);
			System.out.println("\n\n\n");
		}

	}

	@Test(dataProvider = "requestData")
	public void tCompleteWorkflow_UPDSS(String srcAcctId, String dstAcctId,
			String amount, String category, String uploadStatus,
			String tradeId, String gboType, String amountS) throws Exception {
		LOG.warn(" --------------STARTING NEW TEST-------------------"
				+ currentTestMethod);
		try {
			addRequestPage = new WRSAddRequestPage();
			addRequestPage.submitNewRequest(srcAcctId, dstAcctId, amount,
					category, uploadStatus, tradeId, gboType, amountS);
			String requestId = addRequestPage.getNewRequestId();
			wireDetailsPage = new WRSWireDetailsPage(requestId);
			wireDetailsPage.submitToSignatory(requestId);
			wrsApprovalspage = new WRSApprovalsPage();
			wrsApprovalspage.approveWires();
			wrsSearchPage = new WRSSearchPage();
			wrsSearchPage.searchForRequestIds(requestId);
			wrsSearchPage.releaseWiresByHsbcNet();
			/*
			 * wireDetailsPage = new WRSWireDetailsPage(requestId);
			 * wireDetailsPage.moveFunds(); wireDetailsPage.refresh(); String
			 * avd =
			 * wireDetailsPage.getActualValueDateByRemovingStartingZeroes();
			 * String wireAmount =
			 * wireDetailsPage.getWireAmountByRemovingCommas(); wrsGLUploadPage
			 * = new WRSGLUploadPage(); String wireId =
			 * AppDatabase.getLatestWireId(requestId);
			 * wrsGLUploadPage.searchForWire(wireId);
			 * wrsGLUploadPage.previewCoda(avd,wireAmount );
			 */

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();

		} finally {
			LOG.warn(" --------------END OF THE TEST-------------------"
					+ currentTestMethod);
			System.out.println("\n\n\n");
		}

	}

	@Test(dataProvider = "requestData")
	public void tCompleteWorkflow_VOID(String srcAcctId, String dstAcctId,
			String amount, String category, String uploadStatus)
			throws Exception {
		LOG.warn(" --------------STARTING NEW TEST-------------------"
				+ currentTestMethod);
		try {
			addRequestPage = new WRSAddRequestPage();
			addRequestPage.submitNewRequest(srcAcctId, dstAcctId, amount,
					category, uploadStatus);
			String requestId = addRequestPage.getNewRequestId();
			wireDetailsPage = new WRSWireDetailsPage(requestId);
			wireDetailsPage.submitToSignatory(requestId);
			wrsApprovalspage = new WRSApprovalsPage();
			wrsApprovalspage.approveWires();
			wrsSearchPage = new WRSSearchPage();
			wrsSearchPage.searchForRequestIds(requestId);
			wrsSearchPage.releaseWiresByHsbcNet();
			/*
			 * wireDetailsPage = new WRSWireDetailsPage(requestId);
			 * wireDetailsPage.moveFunds();
			 */

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();

		} finally {
			LOG.warn(" --------------END OF THE TEST-------------------"
					+ currentTestMethod);
			System.out.println("\n\n\n");
		}

	}

	@Test(dataProvider = "requestData")
	public void tCompleteWorkflow_DNUMI(String srcAcctId, String dstAcctId,
			String amount, String category, String uploadStatus)
			throws Exception {
		LOG.warn(" --------------STARTING NEW TEST-------------------"
				+ currentTestMethod);
		try {
			addRequestPage = new WRSAddRequestPage();
			addRequestPage.submitNewRequest(srcAcctId, dstAcctId, amount,
					category, uploadStatus);
			String requestId = addRequestPage.getNewRequestId();
			wireDetailsPage = new WRSWireDetailsPage(requestId);
			wireDetailsPage.submitToSignatory(requestId);
			wrsApprovalspage = new WRSApprovalsPage();
			wrsApprovalspage.approveWires();
			wrsSearchPage = new WRSSearchPage();
			wrsSearchPage.searchForRequestIds(requestId);
			wrsSearchPage.releaseWiresByHsbcNet();
			/*
			 * wireDetailsPage = new WRSWireDetailsPage(requestId);
			 * wireDetailsPage.moveFunds();
			 */

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();

		} finally {
			LOG.warn(" --------------END OF THE TEST-------------------"
					+ currentTestMethod);
			System.out.println("\n\n\n");
		}

	}

	@Test(dataProvider = "requestData")
	public void tCompleteWorkflow_DNU(String srcAcctId, String dstAcctId,
			String amount, String category, String uploadStatus)
			throws Exception {
		LOG.warn(" --------------STARTING NEW TEST-------------------"
				+ currentTestMethod);
		try {
			addRequestPage = new WRSAddRequestPage();
			addRequestPage.submitNewRequest(srcAcctId, dstAcctId, amount,
					category, uploadStatus);
			String requestId = addRequestPage.getNewRequestId();
			wireDetailsPage = new WRSWireDetailsPage(requestId);
			wireDetailsPage.submitToSignatory(requestId);
			wrsApprovalspage = new WRSApprovalsPage();
			wrsApprovalspage.approveWires();
			wrsSearchPage = new WRSSearchPage();
			wrsSearchPage.searchForRequestIds(requestId);
			wrsSearchPage.releaseWiresByHsbcNet();
			/*
			 * wireDetailsPage = new WRSWireDetailsPage(requestId);
			 * wireDetailsPage.moveFunds();
			 */

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();

		} finally {
			LOG.warn(" --------------END OF THE TEST-------------------"
					+ currentTestMethod);
			System.out.println("\n\n\n");
		}

	}

	@Test(dataProvider = "requestData")
	public void tReleaseWireUsingFAX(String srcAcctId, String dstAcctId,
			String amount, String category, String uploadStatus)
			throws Exception {
		LOG.warn(" --------------STARTING NEW TEST-------------------"
				+ currentTestMethod);
		try {
			addRequestPage = new WRSAddRequestPage();
			addRequestPage.submitNewRequest(srcAcctId, dstAcctId, amount,
					category, uploadStatus);
			String requestId = addRequestPage.getNewRequestId();

			wireDetailsPage = new WRSWireDetailsPage(requestId);
			wireDetailsPage.submitToSignatory(requestId);
			wrsApprovalspage = new WRSApprovalsPage();
			String wireId = AppDatabase.getLatestWireId(requestId);
			LOG.info("wire id is " + wireId);
			wrsApprovalspage.approveSpecifiedWire(AppDatabase
					.getLatestWireId(requestId));
			wrsSearchPage = new WRSSearchPage();
			wrsSearchPage.searchForRequestIds(requestId);
			wrsSearchPage.releaseWiresByFax(wireId);
			wireDetailsPage = new WRSWireDetailsPage(requestId);
			wireDetailsPage.verifyReleasedStatus(wireId);
			// wrsSearchPage.releaseWiresByHsbcNet();
			/*
			 * wireDetailsPage = new WRSWireDetailsPage(requestId);
			 * wireDetailsPage.moveFunds();
			 */

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();

		} finally {
			LOG.warn(" --------------END OF THE TEST-------------------"
					+ currentTestMethod);
			System.out.println("\n\n\n");
		}

	}

	@Test
	public void tReleaseWireUsingFAX1() throws Exception {
		LOG.warn(" --------------STARTING NEW TEST-------------------"
				+ currentTestMethod);
		try {

			wireDetailsPage = new WRSWireDetailsPage("203202");
			AppWait.waitForTime(10l);
			wireDetailsPage.verifyReleasedStatus("381484");

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();

		} finally {
			LOG.warn(" --------------END OF THE TEST-------------------"
					+ currentTestMethod);
			System.out.println("\n\n\n");
		}

	}

	// Select Source and Destination Accounts
	@Test(dataProvider = "requestData")
	public void tPreviewCodaGLUPloadScreen_UsingRequestId(String idString)
			throws Exception {
		LOG.warn("--------------STARTING NEW TEST-------------------:"
				+ currentTestMethod);
		try {
			wireDetailsPage = new WRSWireDetailsPage(idString);
			String actualValueDate = wireDetailsPage
					.getActualValueDateByRemovingStartingZeroes();
			String wireAmount = wireDetailsPage.getWireAmountByRemovingCommas();
			wrsGLUploadPage = new WRSGLUploadPage();
			String wireId = Setup.getWireId(idString);
			wrsGLUploadPage.searchForWire(wireId);
			wrsGLUploadPage.previewCoda(actualValueDate, wireAmount);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		} finally {
			LOG.warn("--------------END OF THE TEST-------------------"
					+ currentTestMethod);
			System.out.println("\n\n\n");
		}
	}

	@Test(dataProvider = "requestData")
	public void tVerifyGLUploadAndPreviewCodaScreens(String srcAcctId,
			String dstAcctId, String amount, String category,
			String uploadStatus) throws Exception {
		LOG.warn("--------------STARTING NEW TEST-------------------:"
				+ currentTestMethod);
		try {
			addRequestPage = new WRSAddRequestPage();
			addRequestPage.submitNewRequest(srcAcctId, dstAcctId, amount,
					category, uploadStatus);
			String requestId = addRequestPage.getNewRequestId();
			wireDetailsPage = new WRSWireDetailsPage(requestId);
			wireDetailsPage.selectWire();
			wireDetailsPage.openPreviewCoda();
			wireDetailsPage.verifyCodaEntries();

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		} finally {
			LOG.warn("--------------END OF THE TEST-------------------"
					+ currentTestMethod);
			System.out.println("\n\n\n");
		}
	}

	@Test(dataProvider = "requestData")
	public void tVerifyApproveWireFromWireDetails(String srcAcctId,
			String dstAcctId, String amount, String category,
			String uploadStatus) throws Exception {
		LOG.warn("--------------STARTING NEW TEST-------------------:"
				+ currentTestMethod);
		try {
			addRequestPage = new WRSAddRequestPage();
			addRequestPage.submitNewRequest(srcAcctId, dstAcctId, amount,
					category, uploadStatus);
			String requestId = addRequestPage.getNewRequestId();
			wireDetailsPage = new WRSWireDetailsPage(requestId);
			wireDetailsPage.submitToSignatory(requestId);
			// wireDetailsPage = new WRSWireDetailsPage(requestId);
			wireDetailsPage.selectWire();
			wireDetailsPage.openAndApproveWires();

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		} finally {
			LOG.warn("--------------END OF THE TEST-------------------"
					+ currentTestMethod);
			System.out.println("\n\n\n");
		}
	}

	@Test(dataProvider = "requestData")
	public void tVerifyBulkUpdateWindowFromWireDetails(String srcAcctId,
			String dstAcctId, String amount, String category,
			String uploadStatus) throws Exception {
		LOG.warn("--------------STARTING NEW TEST-------------------:"
				+ currentTestMethod);
		try {
			addRequestPage = new WRSAddRequestPage();
			addRequestPage.submitNewRequest(srcAcctId, dstAcctId, amount,
					category, uploadStatus);
			String requestId = addRequestPage.getNewRequestId();
			wireDetailsPage = new WRSWireDetailsPage(requestId);

			wireDetailsPage.selectWire();
			wireDetailsPage.verifyBulkUpdateWindowAndElements(requestId);

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		} finally {
			LOG.warn("--------------END OF THE TEST-------------------"
					+ currentTestMethod);
			System.out.println("\n\n\n");
		}
	}

	// Select Source and Destination Accounts
	@Test(dataProvider = "requestData")
	public void tUpdateRequestDetails(String requestId, String srcAccount,
			String dstAccount) throws Exception {
		LOG.warn(" --------------STARTING NEW TEST-------------------"
				+ currentTestMethod);
		try {
			wireDetailsPage = new WRSWireDetailsPage(requestId);
			wireDetailsPage.setRequestCommonDetails();
			wireDetailsPage.selectAccountDetails(srcAccount, dstAccount);
			wireDetailsPage
					.submitAndVerify(AppConstants.UPDATE_REQUEST_CONFIRM);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();

		} finally {
			LOG.warn("--------------END OF THE TEST-------------------"
					+ currentTestMethod);
			System.out.println("\n\n\n");
		}
	}

	@Test
	public void tOpenAndVerifyConfigureSettings() throws Exception {
		LOG.warn(" --------------STARTING NEW TEST-------------------"
				+ currentTestMethod);
		try {
			configureSettingsPage = new WRSConfigureSettings();
			configureSettingsPage.verifyTitleAndElements();

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();

		} finally {
			LOG.warn("--------------END OF THE TEST-------------------"
					+ currentTestMethod);
			System.out.println("\n\n\n");
		}
	}

	@Test
	public void tOpenAndVerifySearchConfigureGrid() throws Exception {
		LOG.warn(" --------------STARTING NEW TEST-------------------"
				+ currentTestMethod);
		try {
			configureGrid = new WRSSearchConfigureGrid();
			configureGrid.verifyTitleAndElements();

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();

		} finally {
			LOG.warn("--------------END OF THE TEST-------------------"
					+ currentTestMethod);
			System.out.println("\n\n\n");
		}
	}

	@Test
	public void tOpenAndVerifyRefDataPage() throws Exception {
		LOG.warn(" --------------STARTING NEW TEST-------------------"
				+ currentTestMethod);
		try {
			refDataPage = new WRSMaintainRefData();
			// configureGrid.verifyTitleAndElements();

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();

		} finally {
			LOG.warn("--------------END OF THE TEST-------------------"
					+ currentTestMethod);
			System.out.println("\n\n\n");
		}
	}

	@Test
	public void tVerifyCatReferenceData() throws Exception {
		LOG.warn(" --------------STARTING NEW TEST-------------------"
				+ currentTestMethod);
		try {
			refDataPage = new WRSMaintainRefData();
			refDataPage.verifyCategoryReferenceData();
			// configureGrid.verifyTitleAndElements();

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();

		} finally {
			LOG.warn("--------------END OF THE TEST-------------------"
					+ currentTestMethod);
			System.out.println("\n\n\n");
		}
	}

	@Test
	public void tVerifyCodaFQAData() throws Exception {
		LOG.warn(" --------------STARTING NEW TEST-------------------"
				+ currentTestMethod);
		try {
			refDataPage = new WRSMaintainRefData();
			refDataPage.verifyCodaFQAData();
			// configureGrid.verifyTitleAndElements();

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();

		} finally {
			LOG.warn("--------------END OF THE TEST-------------------"
					+ currentTestMethod);
			System.out.println("\n\n\n");
		}
	}

	@Test
	public void tVerifyFinancialTypeData() throws Exception {
		LOG.warn(" --------------STARTING NEW TEST-------------------"
				+ currentTestMethod);
		try {
			refDataPage = new WRSMaintainRefData();
			refDataPage.verifyFinancialTypeData();
			// configureGrid.verifyTitleAndElements();

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();

		} finally {
			LOG.warn("--------------END OF THE TEST-------------------"
					+ currentTestMethod);
			System.out.println("\n\n\n");
		}
	}

	@Test
	public void tVerifySignatoryAmountRangeData() throws Exception {
		LOG.warn(" --------------STARTING NEW TEST-------------------"
				+ currentTestMethod);
		try {
			refDataPage = new WRSMaintainRefData();
			refDataPage.verifySignatoryAmountRangeData();
			// configureGrid.verifyTitleAndElements();

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();

		} finally {
			LOG.warn("--------------END OF THE TEST-------------------"
					+ currentTestMethod);
			System.out.println("\n\n\n");
		}
	}

	@Test
	public void tVerifySignatoryGroupData() throws Exception {
		LOG.warn(" --------------STARTING NEW TEST-------------------"
				+ currentTestMethod);
		try {
			refDataPage = new WRSMaintainRefData();
			refDataPage.verifySignatoryGroupData();
			// configureGrid.verifyTitleAndElements();

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();

		} finally {
			LOG.warn("--------------END OF THE TEST-------------------"
					+ currentTestMethod);
			System.out.println("\n\n\n");
		}
	}

	@Test
	public void tVerifySignatoryGroupMemberData() throws Exception {
		LOG.warn(" --------------STARTING NEW TEST-------------------"
				+ currentTestMethod);
		try {
			refDataPage = new WRSMaintainRefData();
			refDataPage.verifySignatoryGroupMemberData();
			// configureGrid.verifyTitleAndElements();

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();

		} finally {
			LOG.warn("--------------END OF THE TEST-------------------"
					+ currentTestMethod);
			System.out.println("\n\n\n");
		}
	}

	@Test
	public void tVerifySignatoryRuleData() throws Exception {
		LOG.warn(" --------------STARTING NEW TEST-------------------"
				+ currentTestMethod);
		try {
			refDataPage = new WRSMaintainRefData();
			refDataPage.verifySignatoryRuleData();
			// configureGrid.verifyTitleAndElements();

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();

		} finally {
			LOG.warn("--------------END OF THE TEST-------------------"
					+ currentTestMethod);
			System.out.println("\n\n\n");
		}
	}

	@Test
	public void tVerifyTransmissionTypeData() throws Exception {
		LOG.warn(" --------------STARTING NEW TEST-------------------"
				+ currentTestMethod);
		try {
			refDataPage = new WRSMaintainRefData();
			refDataPage.verifyTransmissionTypeData();
			// configureGrid.verifyTitleAndElements();

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();

		} finally {
			LOG.warn("--------------END OF THE TEST-------------------"
					+ currentTestMethod);
			System.out.println("\n\n\n");
		}
	}

	@Test
	public void tVerifyConfigureGridInRefernceData() throws Exception {
		LOG.warn(" --------------STARTING NEW TEST-------------------"
				+ currentTestMethod);
		try {
			refDataPage = new WRSMaintainRefData();
			refDataPage.verifyConfigureGridInRefernceData();
			// configureGrid.verifyTitleAndElements();

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();

		} finally {
			LOG.warn("--------------END OF THE TEST-------------------"
					+ currentTestMethod);
			System.out.println("\n\n\n");
		}
	}

	@Test
	public void tVerifyPassPhrasePage() throws Exception {
		LOG.warn(" --------------STARTING NEW TEST-------------------"
				+ currentTestMethod);
		try {
			passPhrasePage = new WRSSetPassPhrasePage();
			passPhrasePage.verifyPassPhrasePageElements();
			// configureGrid.verifyTitleAndElements();

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();

		} finally {
			LOG.warn("--------------END OF THE TEST-------------------"
					+ currentTestMethod);
			System.out.println("\n\n\n");
		}
	}

	@Test
	public void tVerifyCloneRequestPage() throws Exception {
		LOG.warn(" --------------STARTING NEW TEST-------------------"
				+ currentTestMethod);
		try {
			cloneRequest = new WRSCloneRequestPage();
			cloneRequest.verifyCloneRequestElements();
			// configureGrid.verifyTitleAndElements();

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();

		} finally {
			LOG.warn("--------------END OF THE TEST-------------------"
					+ currentTestMethod);
			System.out.println("\n\n\n");
		}
	}

	@Test
	public void tVerifyAdvSearchPage() throws Exception {
		LOG.warn(" --------------STARTING NEW TEST-------------------"
				+ currentTestMethod);
		try {
			advSearchPage = new WRSAdvSearchPage();

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();

		} finally {
			LOG.warn("--------------END OF THE TEST-------------------"
					+ currentTestMethod);
			System.out.println("\n\n\n");
		}
	}

	@Test(dataProvider = "requestData", groups = { "searchtest" })
	public void tVerifySearchForLogger(String loggerId) throws Exception {
		LOG.warn(" --------------STARTING NEW TEST-------------------"
				+ currentTestMethod);
		try {
			loggerId = loggerId.toLowerCase().trim();
			WRSAddRequestPage arp = new WRSAddRequestPage();
			arp.submitNewRequest("logger="+loggerId);
			String requestId = arp.getNewRequestId();
			advSearchPage = new WRSAdvSearchPage();
			advSearchPage.searchForLogger(loggerId,requestId);

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();

		} finally {
			LOG.warn("--------------END OF THE TEST-------------------"
					+ currentTestMethod);
			System.out.println("\n\n\n");
		}
	}

	@BeforeGroups(groups = { "searchtest" })
	public void setConfigureGridSettings() throws Exception {
		configureGrid = new WRSSearchConfigureGrid();
		configureGrid.verifyTitleAndElements();
		configureGrid.setDefaultSettings();
	}

	@Test(dataProvider = "requestData", groups = { "searchtest" })
	public void tVerifySearchForCategory(String category) throws Exception {
		LOG.warn(" --------------STARTING NEW TEST-------------------"
				+ currentTestMethod);
		try {
			WRSAddRequestPage arp = new WRSAddRequestPage();

			// Add Request using given category for which we are searching for
			arp.submitNewRequest("category="+category);
			String requestId = arp.getNewRequestId();
			advSearchPage = new WRSAdvSearchPage();

			// Search for category and verify search results
			advSearchPage.searchForCategory(category, requestId);

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();

		} finally {
			LOG.warn("--------------END OF THE TEST-------------------"
					+ currentTestMethod);
			System.out.println("\n\n\n");
		}
	}
	
	@Test(dataProvider = "requestData",  groups = { "searchtest" })
	public void tVerifySearchForStrategy(String strategy) throws Exception {
		LOG.warn(" --------------STARTING NEW TEST-------------------"
				+ currentTestMethod);
		try {
			WRSAddRequestPage arp = new WRSAddRequestPage();

			// Add Request using given strategy for which we are searching for
			arp.submitNewRequest("strategy="+strategy);
			String requestId = arp.getNewRequestId();
			advSearchPage = new WRSAdvSearchPage();

			// Search for Strategy and verify search results
			advSearchPage.searchForStrategy(strategy, requestId);

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();

		} finally {
			LOG.warn("--------------END OF THE TEST-------------------"
					+ currentTestMethod);
			System.out.println("\n\n\n");
		}
	}
	
	@Test(dataProvider = "requestData", groups = { "searchtest" })
	public void tVerifySearchForSourceAccount(String srcAcctId, String dstAcctId,
			String amount, String category, String uploadStatus){
		LOG.warn(" --------------STARTING NEW TEST-------------------"
				+ currentTestMethod);
		try {
			addRequestPage = new WRSAddRequestPage();	

			// Add Request using given criteria for which we are searching for
			addRequestPage.submitNewRequest(srcAcctId, dstAcctId, amount,
					category, uploadStatus);
			String requestId = addRequestPage.getNewRequestId();
			advSearchPage = new WRSAdvSearchPage();

			// Search for source account and verify search results
			advSearchPage.searchForSourceAccount(srcAcctId,requestId);

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();

		} finally {
			LOG.warn("--------------END OF THE TEST-------------------"
					+ currentTestMethod);
			System.out.println("\n\n\n");
		}
	}
	
	@Test(dataProvider = "requestData", groups = { "searchtest" })
	public void tVerifySearchForDestAccount(String srcAcctId, String dstAcctId,
			String amount, String category, String uploadStatus){
		LOG.warn(" --------------STARTING NEW TEST-------------------"
				+ currentTestMethod);
		try {
			addRequestPage = new WRSAddRequestPage();	

			// Add Request using given criteria for which we are searching for
			addRequestPage.submitNewRequest(srcAcctId, dstAcctId, amount,
					category, uploadStatus);
			String requestId = addRequestPage.getNewRequestId();
			advSearchPage = new WRSAdvSearchPage();

			// Search for Destination account and verify search results
			advSearchPage.searchForDestAccount(dstAcctId,requestId);

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();

		} finally {
			LOG.warn("--------------END OF THE TEST-------------------"
					+ currentTestMethod);
			System.out.println("\n\n\n");
		}
	}
	
	
	
	@Test(dataProvider = "requestData", groups = { "searchtest" })
	public void tVerifySearchForSourceCompany(String srcAcctId, String dstAcctId,
			String amount, String category, String uploadStatus, String sourceCompany){
		LOG.warn(" --------------STARTING NEW TEST-------------------"
				+ currentTestMethod);
		try {
			addRequestPage = new WRSAddRequestPage();	

			// Add Request using given criteria for which we are searching for
			addRequestPage.submitNewRequest(srcAcctId, dstAcctId, amount,
					category, uploadStatus);
			String requestId = addRequestPage.getNewRequestId();
			advSearchPage = new WRSAdvSearchPage();

			// Search for source account and verify search results
			advSearchPage.searchForSourceCompany(sourceCompany,requestId);

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();

		} finally {
			LOG.warn("--------------END OF THE TEST-------------------"
					+ currentTestMethod);
			System.out.println("\n\n\n");
		}
	}
	
	@Test(dataProvider = "requestData", groups = { "searchtest" })
	public void tVerifySearchForDestCompany(String srcAcctId, String dstAcctId,
			String amount, String category, String uploadStatus, String destCompany){
		LOG.warn(" --------------STARTING NEW TEST-------------------"
				+ currentTestMethod);
		try {
			addRequestPage = new WRSAddRequestPage();	

			// Add Request using given criteria for which we are searching for
			addRequestPage.submitNewRequest(srcAcctId, dstAcctId, amount,
					category, uploadStatus);
			String requestId = addRequestPage.getNewRequestId();
			advSearchPage = new WRSAdvSearchPage();

			// Search for source account and verify search results
			advSearchPage.searchForDestCompany(destCompany, requestId);

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();

		} finally {
			LOG.warn("--------------END OF THE TEST-------------------"
					+ currentTestMethod);
			System.out.println("\n\n\n");
		}
	}
	
	@Test(dataProvider = "requestData", groups = { "searchtest" })

	public void tVerifySearchForCurrency(String srcAcctId, String dstAcctId,
			String amount, String category, String uploadStatus, String currency){

		LOG.warn(" --------------STARTING NEW TEST-------------------"
				+ currentTestMethod);
		try {
			addRequestPage = new WRSAddRequestPage();	

			// Add Request using given criteria for which we are searching for
			// select the accounts so that the required currency gets populated automatically
			addRequestPage.submitNewRequest(srcAcctId, dstAcctId, amount,
					category, uploadStatus);
			String requestId = addRequestPage.getNewRequestId();
			advSearchPage = new WRSAdvSearchPage();

			// Search for currency and verify search results
			advSearchPage.searchForCurrency(currency,requestId);

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();

		} finally {
			LOG.warn("--------------END OF THE TEST-------------------"
					+ currentTestMethod);
			System.out.println("\n\n\n");
		}
	}
	
	@Test(dataProvider = "requestData", groups = { "searchtest" })
	public void tVerifySearchForSourcePortfolio(String srcAcctId, String dstAcctId,
			String amount, String category, String uploadStatus, String sourcePortfolio){
		LOG.warn(" --------------STARTING NEW TEST-------------------"
				+ currentTestMethod);
		try {
			addRequestPage = new WRSAddRequestPage();	

			// Add Request using given criteria for which we are searching for
			addRequestPage.submitNewRequest(srcAcctId, dstAcctId, amount,
					category, uploadStatus, "source="+sourcePortfolio);
			String requestId = addRequestPage.getNewRequestId();
			advSearchPage = new WRSAdvSearchPage();

			// Search for source account and verify search results
			advSearchPage.searchForSourcePortfolio(sourcePortfolio, requestId);

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();

		} finally {
			LOG.warn("--------------END OF THE TEST-------------------"
					+ currentTestMethod);
			System.out.println("\n\n\n");
		}
	}
	
	@Test(dataProvider = "requestData", groups = { "searchtest" })
	public void tVerifySearchForDestPortfolio(String srcAcctId, String dstAcctId,
			String amount, String category, String uploadStatus, String destPortfolio){
		LOG.warn(" --------------STARTING NEW TEST-------------------"
				+ currentTestMethod);
		try {
			addRequestPage = new WRSAddRequestPage();	

			// Add Request using given criteria for which we are searching for
			addRequestPage.submitNewRequest(srcAcctId, dstAcctId, amount,
					category, uploadStatus, "dest="+destPortfolio);
			String requestId = addRequestPage.getNewRequestId();
			advSearchPage = new WRSAdvSearchPage();

			// Search for source account and verify search results
			advSearchPage.searchForDestPortfolio(destPortfolio, requestId);

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();

		} finally {
			LOG.warn("--------------END OF THE TEST-------------------"
					+ currentTestMethod);
			System.out.println("\n\n\n");
		}
	}
	
	

	@Test
	public void tVerifyBulkUpdatePage() throws Exception {
		LOG.warn(" --------------STARTING NEW TEST-------------------"
				+ currentTestMethod);
		try {
			WRSSearchPage search = new WRSSearchPage();
			search.searchForWireIds("381489", "381488");

			WRSBulkUpdateWires buw = new WRSBulkUpdateWires();

			// configureGrid.verifyTitleAndElements();

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();

		} finally {
			LOG.warn("--------------END OF THE TEST-------------------"
					+ currentTestMethod);
			System.out.println("\n\n\n");
		}
	}

	@Test
	public void tVerifyApprovingSpecificWire() throws Exception {
		LOG.warn(" --------------STARTING NEW TEST-------------------"
				+ currentTestMethod);
		try {
			WRSApprovalsPage approve = new WRSApprovalsPage();
			approve.approveSpecifiedWire("381265");

			// configureGrid.verifyTitleAndElements();

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();

		} finally {
			LOG.warn("--------------END OF THE TEST-------------------"
					+ currentTestMethod);
			System.out.println("\n\n\n");
		}
	}

	/*
	 * @Test(dataProvider = "requestData") public void tSearch(String... wireId)
	 * throws Exception {
	 * LOG.warn(" --------------STARTING NEW TEST-------------------"
	 * +currentTestMethod); try { wrsSearchPage = new WRSSearchPage();
	 * wrsSearchPage.searchForWireIds(wireId); WebDriver driver =
	 * wrsSearchPage.getDriver(); WiresTreeGrid SearchGrid = new
	 * WiresTreeGrid(driver); SearchGrid.setFilter("wire status",
	 * "funds moved");
	 * 
	 * } catch (Exception e) { e.printStackTrace(); Assert.fail(); }finally{
	 * LOG.
	 * warn("--------------END OF THE TEST-------------------"+currentTestMethod
	 * ); System.out.println("\n\n\n"); } }
	 */

	// Data provider method
	@DataProvider(name = "requestData")
	public Object[][] getData(Method m) {
		Object[][] retObjArr = null;
		/*
		 * try {
		 * 
		 * String methodName = m.getName(); String className =
		 * this.getClass().getName();
		 * System.out.println("Executing "+className+" "+ path+" "+ methodName);
		 * ClassConverter converter = new ClassConverter(className , path
		 * ,methodName); retObjArr =
		 * converter.getAllInputObjectAsTestNGExpects(false);
		 * 
		 * } catch (Exception e) { Setup.shutDown(); return null; }
		 */
		try {
			LOG.info("is the excel file path null? " + path);
			currentTestMethod = m.getName();
			LOG.warn("--Test Method is-- " + currentTestMethod);
			retObjArr = ReadFromExcel.getTableArray(path, sheet,
					currentTestMethod);
		} catch (Exception e) {
			Setup.shutDown();
			return null;
		}
		return (retObjArr);
	}

	// Quit method for the driver
	@AfterTest(alwaysRun = true)
	public void shutDown() throws Exception {
		AppWait.waitForTime(5l);
		Setup.shutDown();
	}

}
