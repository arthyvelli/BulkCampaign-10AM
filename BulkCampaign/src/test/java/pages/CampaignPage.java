package pages;

import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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

public class CampaignPage extends BasePage {
	//private TestReports reports;
	private WebDriver driver;
	String[] Senderid=new String[5];

	@FindBy(xpath="//h1[@class='font-28 font-head breadcrumbs-title']")
	private WebElement Dashbrd;   // driver.findElement(By.xpath())

	@FindBy(xpath="//h1[@class='font-28 font-head breadcrumbs-title']")
	private WebElement Campaignpage;


	public CampaignPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	 public void getSenderId(String senderid1,String senderid2,String senderid3,String senderid4,String senderid5) {
	//public void getSenderId(String senderid1,String senderid2) { 	
		Senderid[0]=senderid1;
		Senderid[1]=senderid2;
		Senderid[2]=senderid3;
		Senderid[3]=senderid4;
		Senderid[4]=senderid5;

	}
	public void Bulk_campaign1(String UserCount) throws IOException, InterruptedException, ParseException, java.text.ParseException{
		Thread.sleep(1000);
		//int userscount=excel.usercount(0);
		int userscount=Integer.parseInt(UserCount);

		//create a loop overall the rows of excel file to read it.
		//redirect to Campaign list page
		BasePage.waitForElement(driver,Dashbrd,50);
		driver.navigate().to("http://dash.vinmail.io/campaign");
		BasePage.waitForElement(driver,Campaignpage,50);
		//Take campaign duplicate
		CampaignDuplicatePage campdup=new CampaignDuplicatePage(driver);
		//int Campcount=excel.getnum(0, i, 2);
		System.out.println("No.of campaigns ="+userscount);
		String myTime = "13:00";
		/*SimpleDateFormat df = new SimpleDateFormat("HH:mm");
			Date d = df.parse(myTime); 
			Calendar cal = Calendar.getInstance();
			cal.setTime(d);				 
		 */
		for(int j=0;j<userscount;j++) 
		{
			campdup.DuplicateEdit(Senderid[j]);
			System.out.println("Campaign"+j+" = "+myTime);
			campdup.Schedule(myTime);
			campdup.Scheduleconfirm();

		}
		System.out.println("Executed Succesfully");
		LogoutPage LogOut= new LogoutPage(driver);
		LogOut.peformLogout();

	}
}
