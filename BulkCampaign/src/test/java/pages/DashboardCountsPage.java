package pages;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.xmlbeans.impl.regex.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;

import core.TestReports;
import pages.CampaignDuplicatePage;
import pages.BasePage;

public class DashboardCountsPage extends BasePage {
	private WebDriver driver;
	
	@FindBy(xpath="//h1[@class='font-28 font-head breadcrumbs-title']")
	private WebElement Dashbrd;
	
	@FindBy(xpath="(//*[@class='font-20-8 text-secondary mb-1']/span)[2]")
	private WebElement openCount;
	@FindBy(xpath="(//*[@class='font-20-8 text-secondary mb-1']/span)[4]")
	private WebElement clickCount;
	
	public DashboardCountsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public String getOpenCount() throws IOException, InterruptedException, ParseException, java.text.ParseException {
		
		Thread.sleep(1000);
		
		BasePage.waitForElement(driver,Dashbrd,60);
		String open = BasePage.grabText(driver, "(//*[@class='font-20-8 text-secondary mb-1']/span)[2]");
		return open;
//		System.out.println("Getting open count");
//		System.out.println(BasePage.getText(driver, openCount));
//		return Integer.parseInt(BasePage.getText(driver, openCount));
//		
		
	}
	public String getClickCount() throws IOException, InterruptedException, ParseException, java.text.ParseException {
		
		System.out.println("Getting click count");
		Thread.sleep(1000);
		BasePage.waitForElement(driver,Dashbrd,50);
		return BasePage.grabText(driver, "(//*[@class='font-20-8 text-secondary mb-1']/span)[4]");
		
//		return 2;
//		return Integer.parseInt(BasePage.getText(driver, clickCount));

		

		
//		Thread.sleep(1000);		BasePage.ClickElement(driver,createContactBtn);

		
	}

}
