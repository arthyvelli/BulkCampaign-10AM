package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AbCampaign extends BasePage{
	
	public static String listname= "Default List";
	
	@FindBy(xpath="//*[@id='dropdownCreateCampaign__BV_toggle_']")
	private WebElement abToggle;
	
	
	@FindBy(linkText="A/B Split Campaign")
	private WebElement abSplit;
	
	@FindBy(xpath="//input[@name='name']")
	private WebElement nameField;
	
	@FindBy(xpath="//span[contains(text(), 'A')]")
	private WebElement campaignA;
	
	@FindBy(xpath="//*[@id='subject']")
	private WebElement subject;
	
	
	@FindBy(xpath="//*[@id='sname']")
	private WebElement senderName;
	
	
	@FindBy(xpath="//*[@id='modalDefineEmail___BV_modal_body_']/div[2]/div/form/div[3]/div[1]")
	private WebElement templateTableA;
	
	@FindBy(xpath="//*[@id='modalDefineEmail___BV_modal_body_']/div[2]/div/form/div[3]/div[1]/div[2]/ul/li[2]")
	private WebElement templateA;
	
	@FindBy(xpath="//*[@id='modalDefineEmail___BV_modal_footer_']/div/button[1]")
	private WebElement chooseTempalteA;
	
	
	
	@FindBy(xpath="//span[contains(text(), 'B')]")
	private WebElement campaignB;
	
	
	
//	@FindBy(xpath="//*[@id='subject']")
//	private WebElement subjectB;
//	
//	
//	@FindBy(xpath="//*[@id='sname']")
//	private WebElement senderNameB;
//	
	
	@FindBy(xpath="//*[@id='modalDefineEmail___BV_modal_body_']/div[2]/div/form/div[3]/div[1]")
	private WebElement templateTableB;
	
	@FindBy(xpath="//*[@id='modalDefineEmail___BV_modal_body_']/div[2]/div/form/div[3]/div[1]/div[2]/ul/li[2]")
	private WebElement templateB;
	
	@FindBy(xpath="//*[@id='modalDefineEmail___BV_modal_footer_']/div/button[1]")
	private WebElement chooseTempalteB;
	
	@FindBy(xpath="//*[@id='sidenav-main']")
	private WebElement navDiv;
	
	@FindBy(xpath="//h1[@class='font-28 font-head breadcrumbs-title']")
	private WebElement Dashbrd;
	
	@FindBy(xpath="(//span[text()='Choose Template'])[1]")
	private WebElement chooseTemplate;
	
	@FindBy(xpath="(//*[@id='template___BV_tab_button__'])[1]")
	private WebElement templateTab;
	
	@FindBy(xpath="(//*[@class='active-radio'])[1]")
	private WebElement selectTemplate;
	
	@FindBy(xpath="(//button[@class='btn btnw-170 mr-2 btn-primary'])[1]")
	private WebElement selButton;
	
	@FindBy(xpath="//*[@id='app']/div/section/div[2]/div[1]/div/div/div/div/div[8]/div[1]/span[2]/img")
	private WebElement setting;
	
	@FindBy(xpath="(//*[@type='text' and @placeholder='Search'])[2]")
	private WebElement searchText;
	
	@FindBy(xpath="(//input[@class='custom-control-input'])[1]")
	private WebElement listSelect;
	
	@FindBy(xpath="//*[@id='modalCamChooseRecipients___BV_modal_footer_']/div/button[1]")
	private WebElement btnContinue;
	
	
//	WebElement ruleSetting = driver.findElement(By.xpath("//*[@id='app']/div/section/div[2]/div[1]/div/div/div/div/div[9]/div[1]/span[2]"));
	@FindBy(xpath="//*[@id='app']/div/section/div[2]/div[1]/div/div/div/div/div[9]/div[1]/span[2]")
	private WebElement ruleSetting;
	
	
	@FindBy(xpath="//input[@id='limit']")
	private WebElement limit;
	
    @FindBy(xpath="//input[@name='waitingTime']")
	private WebElement waitingTime;
    
    @FindBy(xpath="//img[@src='/img/tick-70.e912a264.svg']")
	private WebElement ticket;
    
    @FindBy(xpath="//*[@class='swal2-confirm btn btn-primary btnw-170' and text()='OK']")
	private WebElement close;
    
    @FindBy(xpath="//*[@id='app']/div/section/div[2]/div[9]/div/div/div[2]/button[2]")
	private WebElement publish;
    
    @FindBy(xpath="//a[contains(@href,'/campaign')]")
	private WebElement OKbtn;
    
	private WebDriver driver;
	
	@FindBy(xpath="//*[@class='text-content font-15 mb-0']")
	private WebElement countText;
	
	public AbCampaign(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public int[] abCreateAction() throws InterruptedException {
		Thread.sleep(1000);
		BasePage.waitForElement(driver,Dashbrd,50);
		driver.navigate().to("http://dash.vinmail.io/campaign");
		int beforCount = getCount();
		waitUntilPageLoad(driver,25);
		waitForElement(driver,abToggle,50);
		waitForClick(driver,abToggle);
		waitForElement(driver,abSplit,50);
		waitForClick(driver,abSplit);
		String campaign=  createPage();
		System.out.println("campaign"+ campaign);
		Thread.sleep(1000);
		int afterCount = getCount();
		int expectedCount = beforCount + 1;
		return new int[] { afterCount, expectedCount };
		
	}
	
	public String createPage() {
		waitUntilPageLoad(driver,25);
		String automationName = "Automating AB Campaign"+ getTime();
		System.out.println(automationName);
		setText(driver, nameField, automationName);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        setupCampaignA();
        setupCampaignB();
        setupTemplateA();
        return automationName;
	}
//	create campaign A
	public void setupCampaignA() {
		try {
			Thread.sleep(3000);
			ClickElement(driver, campaignA);
			setText(driver, subject, "Automating Campaign A");
			setText(driver, senderName, "sonima");
			ClickElement(driver, templateTableA);
			ClickElement(driver, templateA);
			ClickElement(driver, chooseTempalteA);
		}catch(Exception e) {
			System.out.println(e);
	    }
	}
	
	public void setupCampaignB() {
		try {
			Thread.sleep(3000);
			ClickElement(driver, campaignB);
			setText(driver, subject, "Automating Campaign B");
			setText(driver, senderName, "sonima");
			ClickElement(driver, templateTableB);
			ClickElement(driver, templateB);
			ClickElement(driver, chooseTempalteB);
			scrollVertical(driver,0,500);
			driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		}catch(Exception e) {
			System.out.println(e);
	    }
	}
	
//	create template for A
	public void setupTemplateA() {
		try {
			Thread.sleep(3000);
	        waitForClick(driver, chooseTemplate);
	        waitForClick(driver, templateTab);
	        Thread.sleep(3000);
	        waitUntilPageLoad(driver,25);
	        waitForClick(driver, selectTemplate);
	        Thread.sleep(3000);
	        waitUntilPageLoad(driver,25);
	        waitForClick(driver, selButton);
	        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
	        System.out.println("clicked  a");
	        setupTemplateB();
		}catch(Exception e) {
			System.out.println(e);
//			driver.quit();
	    }
		}
	public void setupTemplateB() {
		try {
			Thread.sleep(3000);
	        waitForClick(driver, chooseTemplate);
	        waitForClick(driver, templateTab);
	        Thread.sleep(3000);
	        waitUntilPageLoad(driver,25);
	        waitForClick(driver, selectTemplate);
	        Thread.sleep(3000);
	        waitUntilPageLoad(driver,25);
	        waitForClick(driver, selButton);
	        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
	        scrollVertical(driver,0,500);
	        setRecipt();
	        scrollVertical(driver,0,500);
	        SetABRuleAndPublish();
		}catch(Exception e) {
			System.out.println(e);
//			driver.quit();
	    }
		}
	
	public void setRecipt() {
		try {
	    waitForClick(driver, setting);
	    Thread.sleep(3000);
	    setText(driver, searchText, listname);
	    waitForClick(driver, listSelect);
        waitForClick(driver, btnContinue);
		}catch(Exception e) {
			System.out.println(e);
	    }
    }
	
	public void SetABRuleAndPublish() {
		try {
		Thread.sleep(3000);
		waitForClick(driver, ruleSetting);
	    setText(driver, limit, "10");
	    setText(driver, waitingTime, "20");
	    scrollVertical(driver,0,1000);
	    Thread.sleep(1000);
	    waitForClick(driver, ticket);
	    Thread.sleep(3000);
	    driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	    waitForClick(driver, close);
	    waitForClick(driver, publish);
	    waitForClick(driver, OKbtn);
		}catch(Exception e) {
			System.out.println(e);
//			driver.quit();
	    }
	}
	
public int getCount() throws InterruptedException {
		
		Thread.sleep(1000);
		String getCount= getText(driver, countText);
		String count = getCount.replace("campaigns","");
		count = count.replaceAll("\\s", ""); 
		int Precount= Integer.parseInt(count); 
		return Precount;
	}
		

}
