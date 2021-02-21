package pages;
import java.util.Calendar;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import pages.CampaignElements;
import pages.BasePage;
import tests.TestBase;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.LogStatus;
public class CampaignDuplicatePage  {
	private WebDriver driver;
	
	@FindBy(xpath="//*[@id='app']/div/section/div[2]/div[1]/div/div[1]/form/div[4]/div[1]/div/div[2]")
	private WebElement SenderId;  
	@FindBy(xpath="//a[text()='Advanced']")
	private WebElement Advanceselect; 
	@FindBy(xpath="(//div/input[@placeholder='DD / MM / YY'])[2]")
	private WebElement SelectEndDate;
	@FindBy(name="monday-limit")
	private WebElement DateMon;
	@FindBy(name="tuesday-limit")
	private WebElement DateTue;
	@FindBy(name="wednesday-limit")
	private WebElement DateWed;
	@FindBy(name="thursday-limit")
	private WebElement DateThur;
	@FindBy(name="friday-limit")
	private WebElement DateFri;
	@FindBy(name="saturday-limit")
	private WebElement DateSat;
	@FindBy(name="sunday-limit")
    private WebElement DateSun;
	@FindBy(xpath="//li[contains(text(),'All days')]")
	private WebElement Allday;
	
	@FindBy(xpath="//button[@class='btn small-btn btn-outline-primary']")
	private WebElement Button_Edit;
	
	@FindBy(xpath="//*[@id='campaignSpeed']")
	private WebElement CampSpeed;
	
	@FindBy(xpath="(//span[@class='vue__time-picker time-picker']/input)[1]")
	private WebElement startime;
	@FindBy(xpath="(//span[@class='vue__time-picker time-picker']/input)[2]")
	private WebElement endtime;
	@FindBy(xpath="(//div[@name='monday']//span[@class='vue__time-picker time-picker']/input)[1]")
	private WebElement monstarttime;
	@FindBy(xpath="(//div[@name='monday']//span[@class='vue__time-picker time-picker']/input)[2]")
	private WebElement monendtime;
	@FindBy(xpath="(//div[@name='tuesday']//span[@class='vue__time-picker time-picker']/input)[1]")
	private WebElement tuestarttime;
	@FindBy(xpath="(//div[@name='tuesday']//span[@class='vue__time-picker time-picker']/input)[2]")
	private WebElement tueendtime;
	
	@FindBy(xpath="(//div[@name='wednesday']//span[@class='vue__time-picker time-picker']/input)[1]")
	private WebElement wedstarttime;
	@FindBy(xpath="(//div[@name='wednesday']//span[@class='vue__time-picker time-picker']/input)[2]")
	private WebElement wedendtime;
	@FindBy(xpath="(//div[@name='thursday']//span[@class='vue__time-picker time-picker']/input)[1]")
	private WebElement thurstarttime;
	@FindBy(xpath="(//div[@name='thursday']//span[@class='vue__time-picker time-picker']/input)[2]")
	private WebElement thurendtime;
	@FindBy(xpath="(//div[@name='friday']//span[@class='vue__time-picker time-picker']/input)[1]")
	private WebElement fristarttime;
	@FindBy(xpath="(//div[@name='friday']//span[@class='vue__time-picker time-picker']/input)[2]")
	private WebElement friendtime;
	@FindBy(xpath="(//div[@name='saturday']//span[@class='vue__time-picker time-picker']/input)[1]")
	private WebElement satstarttime;
	@FindBy(xpath="(//div[@name='saturday']//span[@class='vue__time-picker time-picker']/input)[2]")
	private WebElement satendtime;
	@FindBy(xpath="(//div[@name='sunday']//span[@class='vue__time-picker time-picker']/input)[1]")
	private WebElement sunstarttime;
	@FindBy(xpath="(//div[@name='sunday']//span[@class='vue__time-picker time-picker']/input)[2]")
	private WebElement sunendtime;
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
		
		
	public WebDriverWait wait;

	public CampaignDuplicatePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void DuplicateEdit(String Senderid,String listname) throws InterruptedException{

		Thread.sleep(2000);	  
		//Select the dropdown
		BasePage.waitForElement(driver,CampaignElements.Dropdown,50);
		BasePage.ClickElement(driver,CampaignElements.Dropdown);

		//Select duplicate option
		BasePage.waitForElement(driver,CampaignElements.Dup,50);
		BasePage.ClickElement(driver,CampaignElements.Dup);
		//Confimr Duplicate
		BasePage.waitForElement(driver,CampaignElements.DupConfirm1,50);

		BasePage.ClickElement(driver,CampaignElements.DupConfirm1);
		//BasePage.performScrollToElement(driver, CampaignElements.Dupconfirm2);
		BasePage.waitForElement(driver,CampaignElements.Dupconfirm2,50);

		BasePage.ClickElement(driver,CampaignElements.Dupconfirm2);

		Thread.sleep(2000);
		//Click edit from dropdown
		BasePage.waitForElement(driver,CampaignElements.Dropdown,50);
		BasePage.ClickElement(driver,CampaignElements.Dropdown);

		BasePage.waitForElement(driver,CampaignElements.EditDup,50);
		BasePage.ClickElement(driver,CampaignElements.EditDup);
		//Select sender id 
				BasePage.performScrollToElement(driver,SenderId);

				Thread.sleep(2000);	
				WebElement sendidselct = driver.findElement(By.xpath("//*[@id='app']/div/section/div[2]/div[1]/div/div[1]/form/div[4]/div[1]/div/div[2]"));
				Actions builder = new Actions(driver);
				System.out.println("Sender Id"+Senderid);
				builder.moveToElement(sendidselct).sendKeys(sendidselct,Senderid).
				sendKeys(Keys.ENTER).build().perform();
				Thread.sleep(2000);
				//Select Choose contact form wizard
				BasePage.waitForElement(driver,CampaignElements.ChooseContactstage,30);
				BasePage.ClickElement(driver,CampaignElements.ChooseContactstage);

		//Select list	
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		BasePage.waitForElement(driver, recipientsSearch, 30);
		BasePage.setText(driver, recipientsSearch,listname);
        BasePage.javascriptClick(driver, recipientChoose);
      	BasePage.waitForElement(driver, submitBtn, 30);
		BasePage.ClickElement(driver,submitBtn);
		System.out.println("Recipients chosen");
		
		//schedule 
				BasePage.waitForElement(driver,CampaignElements.schedule,50);
				BasePage.ClickElement(driver,CampaignElements.schedule);
				System.out.println("Campaign Scheduled Successfully");


		
			

			}

			public void Schedule(String time) throws InterruptedException {

				BasePage.waitForElement(driver,CampaignElements.schedTime,50);
				Thread.sleep(1000);
				BasePage.clear(driver,CampaignElements.schedTime);
				Thread.sleep(1000);
				BasePage.ClickElement(driver,CampaignElements.schedTime);
				Thread.sleep(1000);
				BasePage.EnterText(driver,CampaignElements.schedTime,time);
			}
			public void Scheduleconfirm() throws InterruptedException  {
				try {
					BasePage.waitForElement(driver,CampaignElements.schedconfirm,50);
					Thread.sleep(1000);
					BasePage.ClickElement(driver,CampaignElements.schedconfirm);
					Thread.sleep(1000);

					BasePage.waitForElement(driver,CampaignElements.closeSuccessmessage,50);
					Thread.sleep(1000);
					BasePage.ClickElement(driver,CampaignElements.closeSuccessmessage);

				}
				catch(Exception e) {
					System.out.println(e);
					Thread.sleep(1000);
					BasePage.waitForElement(driver, CampaignElements.scheduleclosebutton, 25);
					System.out.println("trying to close the time windoe");
					BasePage.ClickElement(driver, CampaignElements.scheduleclosebutton);
					Thread.sleep(1000);
					BasePage.waitForElement(driver, CampaignElements.camaignpreviewclose, 25);
					BasePage.ClickElement(driver, CampaignElements.camaignpreviewclose);
					System.out.println("trying to close the camp windoe");

		              	      }

			        }


	public void timeBaseSchedule() throws InterruptedException {
		
		try {
			BasePage.waitForElement(driver,CampaignElements.schedTime,50);
			Thread.sleep(1000);
			BasePage.clear(driver,CampaignElements.schedTime);
			Thread.sleep(1000);
			BasePage.waitForElement(driver,Advanceselect,30);
			BasePage.ClickElement(driver, Advanceselect);
			BasePage.ClickElement(driver, SelectEndDate);
			Calendar cal = Calendar.getInstance();
			int day=cal.get(Calendar.DAY_OF_MONTH);
			//int setendday=day+7;
			BasePage.ClickElement(driver, SelectEndDate);
			//Select All Days 
			BasePage.ClickElement(driver, Allday);
			//Enter Campaign for Monday
            BasePage.setText(driver, DateMon,"100000");
			BasePage.waitForElement(driver,monstarttime,50);
			Thread.sleep(1000);
			BasePage.clear(driver,monstarttime);
			Thread.sleep(1000);
			BasePage.ClickElement(driver,monstarttime);
			Thread.sleep(1000);
			BasePage.setText(driver,monstarttime,"08:00");
			BasePage.waitForElement(driver,monendtime,50);
			Thread.sleep(1000);
			BasePage.clear(driver,monendtime);
			Thread.sleep(1000);
			BasePage.ClickElement(driver,monendtime);
			Thread.sleep(1000);
			BasePage.setText(driver,monendtime,"18:00");
			
			
			//Enter Campaign for Tuesday
            BasePage.setText(driver, DateTue,"100000");
			BasePage.waitForElement(driver,tuestarttime,50);
			Thread.sleep(1000);
			BasePage.clear(driver,tuestarttime);
			Thread.sleep(1000);
			BasePage.ClickElement(driver,tuestarttime);
			Thread.sleep(1000);
			BasePage.setText(driver,tuestarttime,"08:00");
			BasePage.waitForElement(driver,tueendtime,50);
			Thread.sleep(1000);
			BasePage.clear(driver,tueendtime);
			Thread.sleep(1000);
			BasePage.ClickElement(driver,tueendtime);
			Thread.sleep(1000);
			BasePage.setText(driver,tueendtime,"18:00");
			
			
			//Enter Camapign for Wednesday
			BasePage.setText(driver, DateWed,"100000");
			
			//div[@name="tuesday"]//span[@class='vue__time-picker time-picker']/input
			BasePage.waitForElement(driver,wedstarttime,50);
			Thread.sleep(1000);
			BasePage.clear(driver,wedstarttime);
			Thread.sleep(1000);
			BasePage.ClickElement(driver,wedstarttime);
			Thread.sleep(1000);
			BasePage.setText(driver,wedstarttime,"08:00");
			BasePage.waitForElement(driver,wedendtime,50);
			Thread.sleep(1000);
			BasePage.clear(driver,wedendtime);
			Thread.sleep(1000);
			BasePage.ClickElement(driver,wedendtime);
			Thread.sleep(1000);
			BasePage.setText(driver,wedendtime,"18:00");
			

			//Enter Camapign for Thursday
			BasePage.setText(driver, DateThur,"100000");
						
			BasePage.waitForElement(driver,thurstarttime,50);
			Thread.sleep(1000);
			BasePage.clear(driver,thurstarttime);
			Thread.sleep(1000);
			BasePage.ClickElement(driver,thurstarttime);
			Thread.sleep(1000);
			BasePage.setText(driver,thurstarttime,"08:00");
			BasePage.waitForElement(driver,thurendtime,50);
			Thread.sleep(1000);
			BasePage.clear(driver,thurendtime);
			Thread.sleep(1000);
			BasePage.ClickElement(driver,thurendtime);
			Thread.sleep(1000);
			BasePage.setText(driver,thurendtime,"18:00");
			
			
			//Enter Campaign for Friday
			BasePage.setText(driver, DateFri,"100000");
						
			BasePage.waitForElement(driver,fristarttime,50);
			Thread.sleep(1000);
			BasePage.clear(driver,fristarttime);
			Thread.sleep(1000);
			BasePage.ClickElement(driver,fristarttime);
			Thread.sleep(1000);
			BasePage.setText(driver,fristarttime,"08:00");
			BasePage.waitForElement(driver,friendtime,50);
			Thread.sleep(1000);
			BasePage.clear(driver,friendtime);
			Thread.sleep(1000);
			BasePage.ClickElement(driver,friendtime);
			Thread.sleep(1000);
			BasePage.setText(driver,friendtime,"18:00");
			
			//Enter Campaign for Saturday
			BasePage.setText(driver, DateSat,"100000");
						
			BasePage.waitForElement(driver,satstarttime,50);
			Thread.sleep(1000);
			BasePage.clear(driver,satstarttime);
			Thread.sleep(1000);
			BasePage.ClickElement(driver,satstarttime);
			Thread.sleep(1000);
			BasePage.setText(driver,satstarttime,"08:00");
			BasePage.waitForElement(driver,satendtime,50);
			Thread.sleep(1000);
			BasePage.clear(driver,satendtime);
			Thread.sleep(1000);
			BasePage.ClickElement(driver,satendtime);
			Thread.sleep(1000);
			BasePage.setText(driver,satendtime,"18:00");
             
			//Enter Campaign for Sunday
			BasePage.setText(driver, DateSun,"100000");
						
			BasePage.waitForElement(driver,sunstarttime,50);
			Thread.sleep(1000);
			BasePage.clear(driver,sunstarttime);
			Thread.sleep(1000);
			BasePage.ClickElement(driver,sunstarttime);
			Thread.sleep(1000);
			BasePage.setText(driver,sunstarttime,"08:00");
			BasePage.waitForElement(driver,sunendtime,50);
			Thread.sleep(1000);
			BasePage.clear(driver,sunendtime);
			Thread.sleep(1000);
			BasePage.ClickElement(driver,sunendtime);
			Thread.sleep(1000);
			BasePage.setText(driver,sunendtime,"18:00");


			
			BasePage.ClickElement(driver, CampaignElements.schedconfirm);
			Thread.sleep(1000);

			BasePage.waitForElement(driver,CampaignElements.closeSuccessmessage,50);
			Thread.sleep(1000);
			BasePage.ClickElement(driver,CampaignElements.closeSuccessmessage);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
}




