package pages;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	
	public static void setText(WebDriver driver,String xpath, String text) {
		driver.findElement(By.xpath(xpath)).sendKeys(text);
	}
	
	public static void selectValue(WebElement select, String value) {
		Select sel = new Select(select);
		sel.selectByValue(value);
	}
	
	public static void setText(WebDriver driver,By locator, String text) {
		driver.findElement(locator).sendKeys(text);
	}
	
	public static void setText(WebDriver driver,WebElement ele, String text) {
		ele.sendKeys(text);
	}
	public static void click(WebDriver driver,String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}
	
	public static void click(WebDriver driver,By locator) {
		driver.findElement(locator).click();
	}
	
	public static String grabText(WebDriver driver,String xpath) {
		return driver.findElement(By.xpath(xpath)).getText();
	}
	
	public static void selectOption(WebElement ele,String text) {
		Select sel = new Select(ele);
		sel.selectByValue(text);
	}



public static void ClickElement(WebDriver driver,String locator){
	driver.findElement(By.xpath(locator)).click();
}
public static void ClickElement(WebDriver driver,WebElement ele){
	ele.click();
}
public static void EnterText(WebDriver driver,String locator,CharSequence text ) {
	driver.findElement(By.xpath(locator)).sendKeys(text);
}
/*public static void waitForXpath(WebDriver driver,String locator){
	WebDriverWait wait=new WebDriverWait(driver, 120);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
}*/

public static void moveToElement(WebDriver driver,String locator) {
	Actions action=new Actions(driver);
	action.moveToElement(driver.findElement(By.xpath(locator))).build().perform();
}

public static void moveToElement(WebDriver driver,WebElement ele) {
	Actions action=new Actions(driver);
	action.moveToElement(ele).build().perform();
}
public static void clear(WebDriver driver,WebElement ele) {
	   ele.clear();
}
public static void clear(WebDriver driver,String locator) {
	driver.findElement(By.xpath(locator)).clear();
}
public static WebElement waitForElement(WebDriver driver,String locator, long timeout) { // 25 
	return new WebDriverWait(driver,timeout)
	.ignoring(NoSuchElementException.class)
	.pollingEvery(Duration.ofSeconds(1))
	.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
}
/*
public static void waitForAlert(WebDriver driver, long timeout) { // 25 
	new WebDriverWait(driver,timeout)
	.ignoring(NoSuchElementException.class)
	.pollingEvery(Duration.ofSeconds(1))
	.until(ExpectedConditions.alertIsPresent());
}
*/
  public static void performScrollToElement(WebDriver driver, String locator) { 
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",  locator);
}
  
  public static void performScrollToElement(WebDriver driver, WebElement ele) { 
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",  ele);
	}



	
	public static WebElement waitForElement(WebDriver driver,WebElement ele, long timeout) { // 25 
		return new WebDriverWait(driver,timeout)
		.ignoring(NoSuchElementException.class)
		.pollingEvery(Duration.ofSeconds(1))
		.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	public static void waitForAlert(WebDriver driver, long timeout) { // 25 
		new WebDriverWait(driver,timeout)
		.ignoring(NoSuchElementException.class)
		.pollingEvery(Duration.ofSeconds(1))
		.until(ExpectedConditions.alertIsPresent());
	}
	public long getTime() {
	       return new java.util.Date().getTime();
	   }
	
//	public static void waitForClick(WebDriver driver, WebElement template) {
//		JavascriptExecutor jse = (JavascriptExecutor)driver;
//    	jse.executeScript("arguments[0].click()", template);
//	}

	public static void waitForClick(WebDriver driver, WebElement template) {
		// TODO Auto-generated method stub
		JavascriptExecutor jse = (JavascriptExecutor)driver;
    	jse.executeScript("arguments[0].click()", template);
	}
	
	public static String getDate(String format) {
	 DateFormat df = new SimpleDateFormat(format);
     Date dateobj = new Date(0);
     return df.format(dateobj);
	}
	
	public void scrollVertical(WebDriver driver,int pix1, int pix2) {
	       JavascriptExecutor js = (JavascriptExecutor) driver;
	       js.executeScript("window.scrollBy("+pix1+","+pix2+")");
	   }
	
	public void ScrollByVisibleElement(WebDriver driver,  WebElement Element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;        
        js.executeScript("arguments[0].scrollIntoView();", Element);
    }
	
	public static void javascriptClick(WebDriver driver,WebElement ele) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", ele);
	}
	
//	 public void waitUntilPageLoad(WebDriver driver) {
//	       new WebDriverWait(driver, 25).until(
//	                 webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
//	   }
	
	public void waitUntilPageLoad(WebDriver driver, int time) {
	       new WebDriverWait(driver, time).until(
	                 webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
	   }
	
	  public static String getText(WebDriver driver,WebElement ele) {
	        return ele.getText();
	    }
	  
	  public static void switchToFrame(WebDriver driver,WebElement ele) {
			driver.switchTo().frame(ele);
		}
	  
	  public static void goToPreviousTab(WebDriver driver) {
			((JavascriptExecutor)driver).executeScript("window.open()");
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(0));
		}
	  
	  public static void goToNewTabAndOpenLink(WebDriver driver, String url) {
			((JavascriptExecutor)driver).executeScript("window.open()");
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			driver.get(url);
		}
		

}
