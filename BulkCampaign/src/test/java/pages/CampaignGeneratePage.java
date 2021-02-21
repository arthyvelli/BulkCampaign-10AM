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
import org.openqa.selenium.JavascriptExecutor;

import com.relevantcodes.extentreports.LogStatus;

import core.TestReports;
import pages.CampaignDuplicatePage;
import pages.BasePage;

public class CampaignGeneratePage extends BasePage {
	
	private WebDriver driver;
	
	@FindBy(xpath="//h1[@class='font-28 font-head breadcrumbs-title']")
	private WebElement Dashbrd;
	
	//Campaign page
	@FindBy(xpath="//h1[@class='font-28 font-head breadcrumbs-title']")
	private WebElement Campaignpage;
	@FindBy(xpath="//h1[text()='Create Campaign']")
	private WebElement CampaignCreatePage;
	@FindBy(xpath="//*[@id='dropdownCreateCampaign__BV_button_']")
	private WebElement createButton;
	
	//Create page
	@FindBy(xpath="//input[@name='name' and @id='name']")
	private WebElement campName;
	@FindBy(xpath="//input[@name='subject' and @id='subject']")
	private WebElement campSubject;
	@FindBy(xpath="//input[@name='sname' and @id='sname']")
	private WebElement sName;
	@FindBy(xpath="//*[@id='app']/div/section/div[2]/div[1]/div/div[1]/form/div[4]/div[1]")
	private WebElement senderIdDropDown;
	@FindBy(xpath="//*[@id='app']/div/section/div[2]/div[1]/div/div[1]/form/div[4]/div[1]/div[2]/ul/li[2]")
	private WebElement senderIdElement;
	@FindBy(xpath="//button[text()='Choose email template']")
	private WebElement chooseTemplateBtn;
	@FindBy(linkText="Template gallery")
	private WebElement tempGalleryTab;
	@FindBy(xpath="//input[@placeholder='Search']")
	private WebElement tempSearch;
	@FindBy(xpath="//*[@id='template']/div[2]/div/ul/li[1]/div/div")
	private WebElement templateOptionChoose;
	@FindBy(xpath="//*[@id='modalChooseTemplate___BV_modal_footer_']/div/button[1]")
	private WebElement saveTemplateBtn;
	@FindBy(xpath="//*[@id='app']/div/section/div[2]/div[7]/div/div/div[2]/button[2]")
	private WebElement createCampBtn;
	
	
	//choose recipients
	@FindBy(xpath="//input[@placeholder='Search' and @class='form-control']")
	private WebElement recipientsSearch;
	@FindBy(xpath="(//div[@class='custom-control custom-control-inline custom-checkbox']/input[@class='custom-control-input'])[1]")
	private WebElement recipientChoose;
	@FindBy(xpath="//button[@class='btn btnw-170 btn-primary']")
	private WebElement submitBtn;
	
	@FindBy(xpath="//a[@href='/campaign']")
	private WebElement campaignLink;
	
	@FindBy(xpath="//input[@placeholder='Search']")
	private WebElement searchList;
	@FindBy(xpath="//p[@class='text-content font-15 mb-0']")
	private WebElement listCount;
	@FindBy(xpath="(//a[@class='d-block a-text-underline text-truncate'])[1]")
	private WebElement searchedResultName;

	public CampaignGeneratePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void createCampaign() throws IOException, InterruptedException, ParseException, java.text.ParseException {
		System.out.println("Entered page");
		Thread.sleep(1000);
		
		BasePage.waitForElement(driver,Dashbrd,50);
		driver.navigate().to("http://dash.vinmail.io/campaign");
		
		BasePage.waitForElement(driver,Campaignpage,50);
		
//		Thread.sleep(1000);
		BasePage.ClickElement(driver,createButton);
		Thread.sleep(1000);
		System.out.println("End");
		
	}
	
	public String createNewCampaign(String name, String subject, String templateName) throws IOException, InterruptedException, ParseException, java.text.ParseException {
//		BasePage.waitForElement(driver,CampaignCreatePage,50);
//		BasePage.setText(driver, subject, templateName);
		name = name + getTime();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		BasePage.setText(driver, campName,name);
		BasePage.setText(driver, campSubject,subject);
		BasePage.setText(driver, sName,"Automation Tester");
		BasePage.ClickElement(driver,senderIdDropDown);
		BasePage.ClickElement(driver,senderIdElement);
		scrollVertical(driver,0,1000);
		BasePage.waitForElement(driver, chooseTemplateBtn, 30);
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		BasePage.ClickElement(driver,chooseTemplateBtn);
		Thread.sleep(1000);
		BasePage.ClickElement(driver,tempGalleryTab);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		BasePage.setText(driver, tempSearch,templateName);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		BasePage.ClickElement(driver,templateOptionChoose);
		BasePage.ClickElement(driver,saveTemplateBtn);
		BasePage.waitForElement(driver,createCampBtn,30);
		BasePage.ClickElement(driver,createCampBtn);
		
		System.out.println("Campaign created");
		return name;
	}
	
	public void chooseRecipients(String listName) throws IOException, InterruptedException, ParseException, java.text.ParseException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		BasePage.waitForElement(driver, recipientsSearch, 30);
		BasePage.setText(driver, recipientsSearch,listName);
//		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		BasePage.javascriptClick(driver, recipientChoose);
//		BasePage.moveToElement(driver,recipientChoose);
//		BasePage.waitForElement(driver, recipientChoose, 60);
//		BasePage.ClickElement(driver,recipientChoose);
		BasePage.waitForElement(driver, submitBtn, 30);
		BasePage.ClickElement(driver,submitBtn);
		System.out.println("Recipients chosen");
//		BasePage.ClickElement(driver,createCampBtn);
	}
	
	public void publishNormalCampaign() throws IOException, InterruptedException, ParseException, java.text.ParseException {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		BasePage.waitForElement(driver, submitBtn, 30);
		BasePage.ClickElement(driver,submitBtn);
		BasePage.waitForElement(driver, campaignLink, 30);
		BasePage.ClickElement(driver,campaignLink);
	}
	
	public String searchInList(String searchText) throws IOException, InterruptedException, ParseException, java.text.ParseException {
		System.out.println("save with wait");
		
		BasePage.moveToElement(driver,searchList);
		BasePage.setText(driver, searchList,searchText);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return BasePage.getText(driver, searchedResultName);
//		BasePage.ClickElement(driver,submitBtn);		
	}
	

}
