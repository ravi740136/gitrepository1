package appdriverng.common;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.internal.PropertiesFile;

import appdriverng.common.AppWait;

public class Setup {
	static Properties properties;
	static String appName;
	static String browserName;
	static String profileDir;
	static String appURL, searchSubURL, approvalsSubURL;
	static String pageURL, userName, passWord, dbServer, dbName;
	public static String successMessage = null;
	static final Logger LOG = Logger.getLogger("deshaw.automation");
	

	public static void setLogger() throws IOException {

		String sLogDir = "src/test/resources/logs/AppDriver_log_"
				+ System.getProperty("user.name") + "_"
				+ AppDate.todayForFoldername();
		File logDir = new File(sLogDir);
		logDir.mkdir();
		PatternLayout logPattern = new PatternLayout("["+appName+"Auto] %m (%F:%L)%n");
		LOG.addAppender(new ConsoleAppender(logPattern));
		LOG.addAppender(new FileAppender(logPattern, logDir + "/"
				+ "wires_log_"
				+ AppDate.todayForFilename() + ".log"));
		LOG.setLevel(Level.INFO);
	}

	public static void acceptWarnings() throws Exception {
		try {
			
			driver.findElement(
				By.cssSelector("html body div.ui-dialog div.ui-dialog-buttonpane button.ui-button"))
				.click();
			//driver.switchTo().alert().accept();
			AppWait.waitForTime(10l);
		} catch (Exception e) {
//e.printStackTrace();
		}
		
	}
	public static void verifyConfirmation(String message) throws Exception {
	
		AppWait.waitForTime(10l);
		Alert reqConfirm = driver.switchTo().alert();
		successMessage = reqConfirm.getText();
		LOG.warn("Success... Request got saved, Confirmation messsage is "
				+ successMessage);
		Assert.assertTrue(successMessage.contains(message));
		reqConfirm.accept();
		AppWait.waitForTime(10l);
		}

	

	
	public static String getPageURL(String pageClass) {
		try {
			LOG.warn(pageClass);
			pageURL = properties.getProperty("app." + appName + "." + pageClass
					+ ".URL");
			LOG.info(pageURL);
		} catch (Exception e) {
			Assert.fail("Unable to get page url with property" + "app."
					+ appName + "." + pageClass + ".URL");
		}
		return pageURL;
	}

	static String dataFile;
	static String dataSheet;

	public static String getDataSheet(String lModuleName) {
		dataSheet = properties.getProperty("app." + appName + "." + lModuleName
				+ ".dataSheetName");
		return dataSheet;
	}

	private static WebDriver driver;

	public static void init() throws FileNotFoundException, IOException {
		// load Properties
		properties = new Properties();
		//properties.load(new FileReader(new File("C:/mylocaldata/Developer/codebase/workspace1/ControlRoomTest/AppDriverNG/src/test/resources/config.properties")));
		properties.load(new FileReader(new File("src/test/resources/config.properties")));

		


		// get Config details
	appName = properties.getProperty("app.instance").toLowerCase();
		//setAppName(appName);
		
		setLogger();

		browserName = properties.getProperty("app." + appName + ".browser")
				.toLowerCase();
		profileDir = properties.getProperty("app." + appName + "."
				+ "firefoxProfileDir");

		appURL = properties.getProperty("app." + appName + ".instanceURL");
		setAppURL(appURL);

		dataFile = properties.getProperty("app." + appName + ".dataFile");
		setDataFile(dataFile);

		userName = properties.getProperty("app." + appName + ".db.userName");
		passWord = properties.getProperty("app." + appName + ".db.passWord");
		dbName = properties.getProperty("app." + appName + ".db.dbName");
		dbServer = properties.getProperty("app." + appName + ".db.dbServer");
	}

	public static String getDataFile() {
		return dataFile;
	}

	private static void setDataFile(String lDataFile) {
		dataFile = "src/test/resources/" + lDataFile;
	
		
	}

	public static WebDriver getDriver()  {

		if (driver == null) {
			if ("firefox".equals(browserName)) {
				if (!(profileDir == null || profileDir == "" || profileDir
						.equalsIgnoreCase("none"))) {
					FirefoxProfile prof = new FirefoxProfile(new File(
							profileDir));
	
					prof.setPreference("browser.tabs.autoHide", true);
					driver = new FirefoxDriver(prof);
				
			
					
				} else {
					driver = new FirefoxDriver();
	
				}
				
			}

			else if ("Internet Explorer".equalsIgnoreCase(browserName)) {
				driver = new InternetExplorerDriver();

			} else if ("chrome".equals(browserName)) {
				driver = new ChromeDriver();

			}
			driver.manage().window().maximize();
		}

		return driver;

	}

	public static String getAppURL() {
		return appURL;
	}

	private static void setAppURL(String lAppURL) {
		appURL = lAppURL;
	}

	public static String getAppName() {
		return appName;
	}

	public static void setAppName(String lAppName) {
		appName = lAppName;
	}

	public static void shutDown() {
		// driver=lDriver;
		LOG.warn("Quitting at the end of the Test..");
		driver.quit();
	}

	public static WebDriver switchWindow(String title) {
		for (String s : driver.getWindowHandles()) {
			try{
			if (driver.switchTo().window(s).getTitle().contains(title)) {
				return driver;
			}
			}
			catch (Exception UnhandledAlertException){
				UnhandledAlertException.printStackTrace();
				//Alert a = driver.switchTo().alert();
				//System.out.println(a.getText());
				//a.accept();
			}
		}
		return null;
	}


	public static void acceptDuplicateWire() {
		try {
			// Accept Duplicate wire warning message
			Alert a = driver.switchTo().alert();
			if (a.getText().contains(
					"This is a duplicate of the Wire specified")) {
				a.accept();
			}
		} catch (Exception e) {

		}
	}



	public static String getWireId(String idString)
			throws ClassNotFoundException, SQLException {
		String requestId = "";
		String wireId = "";

		if (idString.startsWith("wire#")) {
			wireId = parseStringAndGetId(idString);
		}

		else {
			requestId = parseStringAndGetId(idString);
			wireId = AppDatabase.getLatestWireId(requestId);
		}

		return wireId;
	}

	public static String parseStringAndGetId(String message) {
		String id = null;
		Pattern p = Pattern.compile("\\d+");
		Matcher m = p.matcher(message);
		if (m.find()) {
			id = m.group();
		}
		return id;
	}
}
