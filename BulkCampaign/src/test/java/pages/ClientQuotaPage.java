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

public class ClientQuotaPage extends BasePage {
	
	private WebDriver driver;
	
	@FindBy(xpath="//h1[@class='font-28 font-head breadcrumbs-title']")
	private WebElement Dashbrd;
	
	@FindBy(xpath="(//span[@class='font-weight-semi-bold'])[2]")
	private WebElement emailQuota;
	@FindBy(xpath="(//span[@class='font-weight-semi-bold'])[4]")
	private WebElement contactQuota;
	
	public ClientQuotaPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void goToAccountSettingsPage() throws IOException, InterruptedException, ParseException, java.text.ParseException {
		System.out.println("Entered page");
		Thread.sleep(1000);
		
		BasePage.waitForElement(driver,Dashbrd,50);
		driver.navigate().to("http://dash.vinmail.io/account");
		
//		BasePage.waitForElement(driver,Contactpage,50);
//		
////		Thread.sleep(1000);
//		BasePage.ClickElement(driver,createContactBtn);
//		Thread.sleep(1000);
//		System.out.println("End");
		
	}
	
	public String getEmailQuota() throws IOException, InterruptedException, ParseException, java.text.ParseException {
		BasePage.waitForElement(driver,emailQuota,50);
		
		String emailQ = BasePage.grabText(driver, "(//span[@class='font-weight-semi-bold'])[2]");
//		String first_word = s.split(" ")[0];
		return emailQ.split(" ")[0];
		
		
	}
	public String getContactQuota() throws IOException, InterruptedException, ParseException, java.text.ParseException {
		BasePage.waitForElement(driver,contactQuota,50);
		String contactQ = BasePage.grabText(driver, "(//span[@class='font-weight-semi-bold'])[4]");
		return contactQ;
//		return Integer.parseInt(contactQ);
		
	}
	
	

}
