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
public class AutoresponderCreatePage extends BasePage {
	private WebDriver driver;
	
	@FindBy(xpath="//h1[@class='font-28 font-head breadcrumbs-title']")
	private WebElement Dashbrd;
	
	@FindBy(xpath="//h1[@class='font-28 font-head breadcrumbs-title']")
	private WebElement Autoresponderpage;
	@FindBy(xpath="//a[text()='Create autoresponder']")
	private WebElement AutoresponderCreatePage;
	
	@FindBy(xpath="//button[@class='btn btn-outline-primary btnw-195 btn-outline-primary']")
	private WebElement chooseCampaignBtn;
	@FindBy(xpath="//input[@placeholder='Search']")
	private WebElement searchCampaign;
	@FindBy(xpath="(//*[@class='custom-control-label'])[2]")
	private WebElement campaignOptions;
	@FindBy(xpath="//button[text()='Continue']")
	private WebElement continueBtn;
	@FindBy(xpath="//input[@name='maxLimit']")
	private WebElement maxLimit;
	@FindBy(xpath="//input[@name='daterange']")
	private WebElement dateRange;
	@FindBy(xpath="//li[@data-range-key='Today']")
	private WebElement todayDate;
	@FindBy(xpath="//button[@class='btn btnw-170 btn-primary']")
	private WebElement submitBtn;
	@FindBy(xpath="//a[@href='/autoresponder']")
	private WebElement autoresponderLink;
	
	public AutoresponderCreatePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void createAutoresponder() throws IOException, InterruptedException, ParseException, java.text.ParseException {
		System.out.println("Entered page");
		Thread.sleep(1000);
		
		BasePage.waitForElement(driver,Dashbrd,50);
		driver.navigate().to("http://dash.vinmail.io/autoresponder");
		
		BasePage.waitForElement(driver,Autoresponderpage,50);
		
//		Thread.sleep(1000);
		BasePage.ClickElement(driver,AutoresponderCreatePage);
		Thread.sleep(1000);
		System.out.println("End");
		
	}
	public void chooseCampaign(String campName) throws IOException, InterruptedException, ParseException, java.text.ParseException {
		BasePage.ClickElement(driver,chooseCampaignBtn);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		BasePage.setText(driver, searchCampaign,campName);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		BasePage.waitForElement(driver,campaignOptions,30);
		BasePage.javascriptClick(driver, campaignOptions);
//		BasePage.ClickElement(driver,campaignOptions);
		BasePage.ClickElement(driver,continueBtn);
	}
	
	public void autoresponderSchedule(String limit,String dateRangeType) throws IOException, InterruptedException, ParseException, java.text.ParseException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		scrollVertical(driver,0,1000);
		BasePage.setText(driver, maxLimit,limit);
		BasePage.ClickElement(driver,dateRange);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if(dateRangeType=="today") {
			BasePage.javascriptClick(driver, todayDate);
//			BasePage.waitForElement(driver,todayDate,30);
//			BasePage.ClickElement(driver,todayDate);
		}
		
		BasePage.ClickElement(driver,submitBtn);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		BasePage.ClickElement(driver,autoresponderLink);
		
		
		
	}
}
