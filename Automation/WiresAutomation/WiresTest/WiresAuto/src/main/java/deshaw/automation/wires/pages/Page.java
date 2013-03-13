package deshaw.automation.wires.pages;




import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import appdriverng.common.Setup;

import com.thoughtworks.selenium.Selenium;

public abstract class Page {

	static final Logger LOG = Logger.getLogger("deshaw.automation");
	public static WebDriver driver=null;
	public Selenium selenium=null;
	protected String idString = null;
	
	String pageURL="";
	
	public Page(){
		driver=Setup.getDriver();
		open();		
	}
	
	public Page(String idString){
		driver=Setup.getDriver();
		this.idString = idString.toLowerCase().trim();
		open();		
	}

	
	public abstract void open() ;
	
	public WebDriver getDriver(){
		return driver;
	}
}
