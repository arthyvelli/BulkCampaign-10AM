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

public class TimeCampaignCreatePage extends BasePage {
	
	private WebDriver driver;
	
	@FindBy(xpath="//h1[@class='font-28 font-head breadcrumbs-title']")
	private WebElement Dashbrd;
	
	@FindBy(xpath="//*[@id='dropdownCreateCampaign__BV_button_']")
	private WebElement timeCampaignCreateDropDown;
	
	@FindBy(xpath="//button[text()='Schedule']")
	private WebElement scheduleBtn;
	@FindBy(xpath="//*[@id='modalScheduleCampaign___BV_modal_body_']/div/div/form/ul/li[2]/a")
	private WebElement advancedBtn;
	
	//Schedule
	@FindBy(xpath="//*[@id='modalScheduleCampaign___BV_modal_body_']/div/div/form/div[1]/div[2]/div[2]/div[2]/div/div/div/div/div[1]")
	private WebElement timezoneBtn;
//	@FindBy(xpath="//ul[@class='vs__dropdown-menu']")
//	private WebElement timezoneBtn;
	@FindBy(xpath="//input[@class='vs__search' and @type='search']")
	private WebElement timezoneSearch;
//	@FindBy(xpath="(//li[@role='option'])[1]")
//	private WebElement timezoneChoose;
	@FindBy(xpath="//*[@id='modalScheduleCampaign___BV_modal_body_']/div/div/form/div[1]/div[2]/div[2]/div[2]/div/div/div/div[2]/ul/li[1]")
	private WebElement timezoneChoose;
	@FindBy(xpath="//*[@id='modalScheduleCampaign___BV_modal_body_']/div/div/form/div[1]/div[1]/div[1]/div[2]/div/ul/li[1]")
	private WebElement allDaysChooseBtn;
	@FindBy(xpath="//*[@id='modalScheduleCampaign___BV_modal_body_']/div/div/form/div[1]/div[1]/div[1]/div[2]/div/ul/li[2]")
	private WebElement mondayChooseBtn;
	@FindBy(xpath="//*[@id='modalScheduleCampaign___BV_modal_body_']/div/div/form/div[1]/div[1]/div[1]/div[2]/div/ul/li[3]")
	private WebElement tuesdayChooseBtn;
	@FindBy(xpath="//*[@id='modalScheduleCampaign___BV_modal_body_']/div/div/form/div[1]/div[1]/div[1]/div[2]/div/ul/li[4]")
	private WebElement wednesdayChooseBtn;
	@FindBy(xpath="//*[@id='modalScheduleCampaign___BV_modal_body_']/div/div/form/div[1]/div[1]/div[1]/div[2]/div/ul/li[5]")
	private WebElement thursdayChooseBtn;
	@FindBy(xpath="//*[@id='modalScheduleCampaign___BV_modal_body_']/div/div/form/div[1]/div[1]/div[1]/div[2]/div/ul/li[6]")
	private WebElement fridayChooseBtn;
	@FindBy(xpath="//*[@id='modalScheduleCampaign___BV_modal_body_']/div/div/form/div[1]/div[1]/div[1]/div[2]/div/ul/li[7]")
	private WebElement saturdayChooseBtn;
	@FindBy(xpath="//*[@id='modalScheduleCampaign___BV_modal_body_']/div/div/form/div[1]/div[1]/div[1]/div[2]/div/ul/li[8]")
	private WebElement sundayChooseBtn;
	
	//Monday
	@FindBy(xpath="//input[@name='monday-limit']")
	private WebElement mondayLimit;
	@FindBy(xpath="(//input[@placeholder='HH:MM'])[1]")
	private WebElement mondayStartTime;
	@FindBy(xpath="(//input[@placeholder='HH:MM'])[2]")
	private WebElement mondayEndTime;
	
	//Tuesday
	@FindBy(xpath="//input[@name='tuesday-limit']")
	private WebElement tuesdayLimit;
	@FindBy(xpath="(//input[@placeholder='HH:MM'])[3]")
	private WebElement tuesdayStartTime;
	@FindBy(xpath="(//input[@placeholder='HH:MM'])[4]")
	private WebElement tuesdayEndTime;
	
	//Wednesday
	@FindBy(xpath="//input[@name='wednesday-limit']")
	private WebElement wednesdayLimit;
	@FindBy(xpath="(//input[@placeholder='HH:MM'])[5]")
	private WebElement wednesdayStartTime;
	@FindBy(xpath="(//input[@placeholder='HH:MM'])[6]")
	private WebElement wednesdayEndTime;
	
	//Thursday
	@FindBy(xpath="//input[@name='thursday-limit']")
	private WebElement thursdayLimit;
	@FindBy(xpath="(//input[@placeholder='HH:MM'])[7]")
	private WebElement thursdayStartTime;
	@FindBy(xpath="(//input[@placeholder='HH:MM'])[8]")
	private WebElement thursdayEndTime;
	
	//Friday
	@FindBy(xpath="//input[@name='friday-limit']")
	private WebElement fridayLimit;
	@FindBy(xpath="(//input[@placeholder='HH:MM'])[9]")
	private WebElement fridayStartTime;
	@FindBy(xpath="(//input[@placeholder='HH:MM'])[10]")
	private WebElement fridayEndTime;
	
	//Saturday
	@FindBy(xpath="//input[@name='saturday-limit']")
	private WebElement saturdayLimit;
	@FindBy(xpath="(//input[@placeholder='HH:MM'])[11]")
	private WebElement saturdayStartTime;
	@FindBy(xpath="(//input[@placeholder='HH:MM'])[12]")
	private WebElement saturdayEndTime;
	
	//Sunday
	@FindBy(xpath="//input[@name='sunday-limit']")
	private WebElement sundayLimit;
	@FindBy(xpath="(//input[@placeholder='HH:MM'])[13]")
	private WebElement sundayStartTime;
	@FindBy(xpath="(//input[@placeholder='HH:MM'])[14]")
	private WebElement sundayEndTime;
	
	
	@FindBy(xpath="//button[text()='Edit']")
	private WebElement speedSetBtn;
	@FindBy(xpath="//input[@id='campaignSpeed']")
	private WebElement speedInput;
	
	@FindBy(xpath="//button[@class='btn mr-3 btnw-170 btn-primary']")
	private WebElement scheduleTimeCampBtn;
	@FindBy(xpath="//a[@class='btn custom-close text-reset btn-link btn-lg']")
	private WebElement closeTimeCamp;
	
	
	public TimeCampaignCreatePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void goToScheduleTimeCamp() throws IOException, InterruptedException, ParseException, java.text.ParseException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		BasePage.ClickElement(driver,scheduleBtn);
		BasePage.ClickElement(driver,advancedBtn);
	}
	public void chooseTimeZone() throws IOException, InterruptedException, ParseException, java.text.ParseException {
System.out.println("debuggging");
//		BasePage.javascriptClick(driver, scheduleBtn);
		BasePage.ClickElement(driver,timezoneBtn);
		BasePage.setText(driver, timezoneSearch,"Asia/Kolkata");
//		BasePage.ClickElement(driver,scheduleBtn);
		BasePage.ClickElement(driver,timezoneChoose);
		
			
		
	}
	
	public void chooseDay(String day) throws IOException, InterruptedException, ParseException, java.text.ParseException {
		switch(day) {
		  case "monday":
			  BasePage.ClickElement(driver,mondayChooseBtn);
			  setMondayData();
		    break;
		  case "tuesday":
			  BasePage.ClickElement(driver,tuesdayChooseBtn);
			  setTuesdayData();
		    break;
		  case "wenesday":
			  BasePage.ClickElement(driver,wednesdayChooseBtn);
			  setWednesdayData();
			break;
		  case "thursday":
			  BasePage.ClickElement(driver,thursdayChooseBtn);
			  setThursdayData();
			 break;
		  case "friday":
			  BasePage.ClickElement(driver,fridayChooseBtn);
			  setFridayData();
			 break;
		  case "saturday":
			  BasePage.ClickElement(driver,saturdayChooseBtn);
			  setSaturdayData();
			 break;
		  case "sunday":
			  BasePage.ClickElement(driver,sundayChooseBtn);
			  setSundayData();
			 break;
		  default:
			  BasePage.ClickElement(driver,allDaysChooseBtn);
			  setMondayData();
			  setTuesdayData();
			  setWednesdayData();
			  setThursdayData();
			  setFridayData();
			  setSaturdayData();
			  setSundayData();
		}
	}
	public void setMondayData() throws IOException, InterruptedException, ParseException, java.text.ParseException {
		BasePage.setText(driver, mondayLimit,"100");
		BasePage.ClickElement(driver,mondayStartTime);
		driver.findElement(By.linkText("10:30")).click();
		BasePage.ClickElement(driver,mondayEndTime);
		driver.findElement(By.linkText("17:30")).click();
		
	}
	public void setTuesdayData() throws IOException, InterruptedException, ParseException, java.text.ParseException {
		BasePage.setText(driver, tuesdayLimit,"100");
		BasePage.ClickElement(driver,tuesdayStartTime);
		driver.findElement(By.linkText("10:30")).click();
		BasePage.ClickElement(driver,tuesdayEndTime);
		driver.findElement(By.linkText("17:30")).click();
		
	}
	public void setWednesdayData() throws IOException, InterruptedException, ParseException, java.text.ParseException {
		BasePage.setText(driver, wednesdayLimit,"100");
		BasePage.ClickElement(driver,wednesdayStartTime);
		driver.findElement(By.linkText("10:30")).click();
		BasePage.ClickElement(driver,wednesdayEndTime);
		driver.findElement(By.linkText("17:30")).click();
		
	}
	public void setThursdayData() throws IOException, InterruptedException, ParseException, java.text.ParseException {
		BasePage.setText(driver, thursdayLimit,"100");
		BasePage.ClickElement(driver,thursdayStartTime);
		driver.findElement(By.linkText("10:30")).click();
		BasePage.ClickElement(driver,thursdayEndTime);
		driver.findElement(By.linkText("17:30")).click();
		
	}
	public void setFridayData() throws IOException, InterruptedException, ParseException, java.text.ParseException {
		BasePage.setText(driver, fridayLimit,"100");
		BasePage.ClickElement(driver,fridayStartTime);
		driver.findElement(By.linkText("10:30")).click();
		BasePage.ClickElement(driver,fridayEndTime);
		driver.findElement(By.linkText("17:30")).click();
		
	}
	public void setSaturdayData() throws IOException, InterruptedException, ParseException, java.text.ParseException {
		BasePage.setText(driver, saturdayLimit,"100");
		BasePage.ClickElement(driver,saturdayStartTime);
		driver.findElement(By.linkText("10:30")).click();
		BasePage.ClickElement(driver,saturdayEndTime);
		driver.findElement(By.linkText("17:30")).click();
		
	}
	public void setSundayData() throws IOException, InterruptedException, ParseException, java.text.ParseException {
		BasePage.setText(driver, sundayLimit,"100");
		BasePage.ClickElement(driver,sundayStartTime);
		driver.findElement(By.linkText("10:30")).click();
		BasePage.ClickElement(driver,sundayEndTime);
		driver.findElement(By.linkText("17:30")).click();
		
	}
	
	public void setTimeCampaignSpeed() throws IOException, InterruptedException, ParseException, java.text.ParseException {
		System.out.println("debug time");
		BasePage.ClickElement(driver,speedSetBtn);
		BasePage.clear(driver, speedInput);
		BasePage.setText(driver, speedInput,"100");
		
	}
	public void publishTimeCamp() throws IOException, InterruptedException, ParseException, java.text.ParseException {
		BasePage.ClickElement(driver,scheduleTimeCampBtn);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		BasePage.ClickElement(driver,closeTimeCamp);
	}

}
