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

public class MailBoxPage extends BasePage {
	
	private WebDriver driver;
	
	@FindBy(xpath="//h1[@class='font-28 font-head breadcrumbs-title']")
	private WebElement Dashbrd;
	
	@FindBy(name="_user")
	private WebElement userNameInput;
	@FindBy(name="_pass")
	private WebElement passwordInput;
	@FindBy(xpath="//*[@type='submit' and @id='rcmloginsubmit']")
	private WebElement loginBtn;
	
	@FindBy(xpath="//*[@type='text' and @id='quicksearchbox']")
	private WebElement searchBox;
	@FindBy(xpath="(//tr[@class='message unread']/td/span[3]/a)[1]")
	private WebElement unreadMessage;
	@FindBy(xpath="//iframe[@id='messagecontframe']")
	private WebElement messageFrame;
	@FindBy(xpath="(//tr[@class='message']/td/span[3]/a)[1]")
	private WebElement readMessage;
	@FindBy(xpath="//a[@href='#loadimages' and text()='Display images']")
	private WebElement displayImages;
	
	
	
	public MailBoxPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void loginToMailBox(String username, String password) throws IOException, InterruptedException, ParseException, java.text.ParseException {
		System.out.println("Getting open count");
		Thread.sleep(1000);
		BasePage.waitForElement(driver,Dashbrd,50);
		
		BasePage.goToNewTabAndOpenLink(driver, "https://regalwork.com/webmail/");
		BasePage.setText(driver,userNameInput ,username);
		BasePage.setText(driver, passwordInput,password);
		BasePage.waitForElement(driver,loginBtn,10);
		BasePage.ClickElement(driver,loginBtn);
	}
	public void searchForMessage(String searchText) throws IOException, InterruptedException, ParseException, java.text.ParseException {
		System.out.println("Searching a message");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Thread.sleep(1000);
		BasePage.setText(driver,searchBox ,searchText);
		
		
		
	}
	public void openUnreadMessage() throws IOException, InterruptedException, ParseException, java.text.ParseException {
		System.out.println("opening unreads");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Thread.sleep(1000);
		
		BasePage.waitForElement(driver,unreadMessage,10);
		BasePage.ClickElement(driver,unreadMessage);
		
		
		
	}
	public void createOpens() throws IOException, InterruptedException, ParseException, java.text.ParseException {
		System.out.println("Getting open count");
//		BasePage.waitForElement(driver,unreadMessage,20);
//		BasePage.javascriptClick(driver, displayImages);
//		BasePage.goToPreviousTab(driver);
		BasePage.switchToFrame(driver, messageFrame);
		WebElement displayClick = driver.findElement(By.linkText("Display images"));
		BasePage.moveToElement(driver, displayClick);
		BasePage.waitForElement(driver,displayClick,60);
		BasePage.javascriptClick(driver, displayClick);
		
	}
	
	public void createClicks(String linkText,boolean goPreviousTab) throws IOException, InterruptedException, ParseException, java.text.ParseException {
		System.out.println("Getting open count");
		WebElement clickLink = driver.findElement(By.linkText(linkText));
		BasePage.javascriptClick(driver, clickLink);	
		if(goPreviousTab==true) {
			Thread.sleep(3000);
			BasePage.goToPreviousTab(driver);
		}
		
			
	}
	
	

}
