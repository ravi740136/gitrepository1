package appdriverng.common;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;




public class AppWait{
	static final Logger LOG = Logger.getLogger("deshaw.automation");
	
	//Wait time in seconds
	public final static Long DEFAULT_WAIT_TIME = 60l;
	static WebDriver driver = Setup.getDriver();

	public static void waitForElement(final String locator,final String locValue, long time){
		WebDriverWait wait;
		ExpectedCondition<Boolean> e = new ExpectedCondition<Boolean>() {
		      public Boolean apply(WebDriver d) {
		        //d.findElement(By.id("sec2_grid_container")).isDisplayed();
		    	  if (locator.trim().equalsIgnoreCase("xpath")){
		        d.findElement(By.xpath(locValue)).isDisplayed();		        
		    	  }
		    	  else if (locator.trim().equalsIgnoreCase("id")){
				        d.findElement(By.id(locValue)).isDisplayed();				        
				    	  }
		    	  else if (locator.trim().equalsIgnoreCase("cssSelector")){
				        d.findElement(By.cssSelector(locValue)).isDisplayed();				        
				    	  }
		    	  else if (locator.trim().equalsIgnoreCase("name")){
				        d.findElement(By.name(locValue)).isDisplayed();				        
				    	  }
		    	  
		        return Boolean.valueOf(true);
		      }
		    };
		wait = new WebDriverWait(driver, time);
		wait.until(e);		
	}
	
	public static void waitForElement(final String locator,final String locValue){
		WebDriverWait wait;
		ExpectedCondition<Boolean> e = new ExpectedCondition<Boolean>() {
		      public Boolean apply(WebDriver d) {
		        //d.findElement(By.id("sec2_grid_container")).isDisplayed();
		    	  if (locator.trim().equalsIgnoreCase("xpath")){
		        d.findElement(By.xpath(locValue)).isDisplayed();		        
		    	  }
		    	  else if (locator.trim().equalsIgnoreCase("id")){
				        d.findElement(By.id(locValue)).isDisplayed();				        
				    	  }
		    	  else if (locator.trim().equalsIgnoreCase("cssSelector")){
				        d.findElement(By.cssSelector(locValue)).isDisplayed();				        
				    	  }
		    	  else if (locator.trim().equalsIgnoreCase("name")){
				        d.findElement(By.name(locValue)).isDisplayed();				        
				    	  }
		    	  
		        return Boolean.valueOf(true);
		      }
		    };
		wait = new WebDriverWait(driver, DEFAULT_WAIT_TIME);
		wait.until(e);		
	}
	
	public static void waitForTime(Long TimeInSeconds) throws Exception{
		LOG.info("waiting for given time");
		Thread.sleep(TimeInSeconds*1000);		
	}
	
	public static WebElement waitForElement(final WebElement element){
		
		return new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(element));
				
	}
	

}
