package pages;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.xmlbeans.impl.regex.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;

import core.TestReports;
import pages.CampaignDuplicatePage;
import pages.BasePage;

public class ContactCreatePage extends BasePage {
	
	private WebDriver driver;
	
	@FindBy(xpath="//h1[@class='font-28 font-head breadcrumbs-title']")
	private WebElement Dashbrd;
	
	@FindBy(xpath="//h1[@class='font-28 font-head breadcrumbs-title']")
	private WebElement Contactpage;
	
	@FindBy(xpath="//a[@href='/recipients/add']")
	private WebElement createContactBtn;
	
	@FindBy(xpath="//input[@name='listname']")
	private WebElement listNameInput;	
	@FindBy(xpath="//button[@class='btn btnw-170 btn-primary']")
	private WebElement submitBtn;
	@FindBy(xpath="//p[text()='File from computer']")
	private WebElement importList;
	@FindBy(xpath="//p[text()='Copy & paste contacts']")
	private WebElement copyPaste;
	@FindBy(xpath="//p[text()='Add individual contacts']")
	private WebElement individual;
	@FindBy(xpath="//textarea[@id='textareaCopyPaste']")
	private WebElement copyPasteInput;
	@FindBy(xpath="//*[@id='dropzone']")
	private WebElement dropzone;
	@FindBy(xpath="//button[text()='OK']")
	private WebElement confirmBoxBtn;
	
	@FindBy(xpath="//input[@placeholder='Search']")
	private WebElement searchList;
	@FindBy(xpath="//p[@class='text-content font-15 mb-0']")
	private WebElement listCount;
	@FindBy(xpath="(//a[@class='d-block a-text-underline text-truncate'])[1]")
	private WebElement searchedResultName;
	
	
	
	
	
	public ContactCreatePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void createContact() throws IOException, InterruptedException, ParseException, java.text.ParseException {
		System.out.println("Entered page");
		Thread.sleep(1000);
		
		BasePage.waitForElement(driver,Dashbrd,50);
		driver.navigate().to("http://dash.vinmail.io/recipients");
		
		BasePage.waitForElement(driver,Contactpage,50);
		
//		Thread.sleep(1000);
		BasePage.ClickElement(driver,createContactBtn);
		Thread.sleep(1000);
		System.out.println("End");
		
	}
	public String createList(String listName) throws IOException, InterruptedException, ParseException, java.text.ParseException {
		listName = listName + getTime();
		BasePage.setText(driver, listNameInput,listName);
		saveAction();
		return listName;
	}
	public void copyPasteMethod(String domain, int count) throws IOException, InterruptedException, ParseException, java.text.ParseException {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		BasePage.ClickElement(driver,copyPaste);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		saveAction();
//		System.out.println("Click action done");
//		Thread.sleep(3000);
		String emailList = getEmailList(domain,count);
		emailList = emailList.replace("\n", Keys.chord(Keys.SHIFT, Keys.ENTER));
		BasePage.waitForElement(driver,copyPasteInput,20);
		BasePage.setText(driver, copyPasteInput,emailList);
		saveAction();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		saveAction();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		BasePage.ClickElement(driver,confirmBoxBtn);
		
		
	}
	public void importMethod(String filePath) throws IOException, InterruptedException, ParseException, java.text.ParseException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		BasePage.ClickElement(driver,importList);
		saveAction();
	}
	public void individualeMethod() throws IOException, InterruptedException, ParseException, java.text.ParseException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		BasePage.ClickElement(driver,individual);
		saveAction();
	}
	public void saveAction() throws IOException, InterruptedException, ParseException, java.text.ParseException {
		System.out.println("save with wait");
		
		BasePage.moveToElement(driver,submitBtn);
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		BasePage.waitForElement(driver,submitBtn,10);
		BasePage.javascriptClick(driver,submitBtn);
		
//		BasePage.ClickElement(driver,submitBtn);		
	}
	public String searchInList(String searchText) throws IOException, InterruptedException, ParseException, java.text.ParseException {
		System.out.println("save with wait");
		
		BasePage.moveToElement(driver,searchList);
		BasePage.setText(driver, searchList,searchText);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return BasePage.getText(driver, searchedResultName);
//		BasePage.ClickElement(driver,submitBtn);		
	}
	public String getEmailList(String domain, int count) {
		Long timestamp = getTime();
		String emails = "autoemail"+1+timestamp+"@"+domain;
		if(count>1) {
			for(int i=2;i<=count;i++) {
				emails = emails+"\n"+"autoemail"+i+timestamp+"@"+domain;
			}
		}

		return emails;
	}
	
	
	
	

}
