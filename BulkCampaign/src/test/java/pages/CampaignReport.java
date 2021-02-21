package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignReport extends BasePage{
	@FindBy(xpath="//*[@id='sidenav-main']")
	private WebElement menuOption;
	
	
	@FindBy(xpath="//span[text()='Reports']")
	private WebElement reportNav;
	
	@FindBy(xpath="//a[contains(@href,'/campaign-report') and @class='nav-link']")
	private WebElement naveLink;
	
    @FindBy(xpath="//*[@class='btn btn-filter mr-2 px-0 wid-50 btn-outline-primary']")
	private WebElement filter;
    
    @FindBy(xpath="//*[@id='camp_name']")
	private WebElement campName;
  
    
    @FindBy(xpath="//table[@class='table b-table table-list table-hover b-table-stacked-md']/tbody/tr/td[3]/div/div/div")
	private WebElement listSent;
    
    @FindBy(xpath="//table[@class='table b-table table-list table-hover b-table-stacked-md']/tbody/tr/td[3]/div/div/span")
   	private WebElement sentPercent;
    
  //table[@class='0
	
    @FindBy(xpath="//table[@class='table b-table table-list table-hover b-table-stacked-md']/tbody/tr/td[3]/div/div/span")
   	private WebElement openRatePercent;
	
	
  
    
    @FindBy(xpath="//table[@class='table b-table table-list table-hover b-table-stacked-md']/tbody/tr/td[4]/div/div/span")
   	private WebElement openPercent;
    

    @FindBy(xpath="//table[@class='table b-table table-list table-hover b-table-stacked-md']/tbody/tr/td[5]/div/div/div")
   	private WebElement click;
    
    @FindBy(xpath="//table[@class='table b-table table-list table-hover b-table-stacked-md']/tbody/tr/td[5]/div/div/span")
   	private WebElement clickPercent;
    
//    String unsubPercentage = driver.findElement(By.xpath("//table[@class='table b-table table-list table-hover b-table-stacked-md']/tbody/tr/td[6]/div/div/div")).getText();
    
    @FindBy(xpath="//table[@class='table b-table table-list table-hover b-table-stacked-md']/tbody/tr/td[6]/div/div/div")
   	private WebElement unsubPercent;
	
//    String unsub = driver.findElement(By.xpath("//table[@class='table b-table table-list table-hover b-table-stacked-md']/tbody/tr/td[6]/div/div/span")).getText();
    @FindBy(xpath="//table[@class='table b-table table-list table-hover b-table-stacked-md']/tbody/tr/td[6]/div/div/span")
   	private WebElement unsub;
	
 
	
    @FindBy(xpath=" //button[text()='View Report']")
   	private WebElement reportBtn;
	
    @FindBy(xpath="//button[@class='btn close-action-pop text-reset btn-link btn-lg")
   	private WebElement close;
    
    @FindBy(xpath="(//*[@class='font-weight-semi-bold count'])[1]")
   	private WebElement rSentCount;
    
    @FindBy(xpath="(//*[@class='font-weight-semi-bold count'])[5]")
   	private WebElement rOpensCount;
    
    @FindBy(xpath="(//*[@class='font-weight-semi-bold count'])[6]")
   	private WebElement rCliksCount;
    
    @FindBy(xpath="(//*[@class='font-weight-semi-bold count'])[7]")
   	private WebElement rUnsub;
	
	private WebDriver driver;
	
	public CampaignReport(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	// over view page
	public void checkReport() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        navigateReport();
        getFinishedCampaign();
	}
	
	public void navigateReport() {
		moveToElement(driver,menuOption);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		ClickElement(driver,reportNav);
		ClickElement(driver,naveLink);
			
	}
	
	public void getFinishedCampaign() {
		try {
			waitForClick(driver,filter);
			setText(driver,campName, "Campaign For Automation1");
			String sent = listSent.getText();
		    System.out.println("sent:"+ sent);
		    String sentPercentage = sentPercent.getText();
		    System.out.println("sentPercent:"+sentPercentage);
		    String OpenPercentage = openRatePercent.getText();
		    System.out.println("openRatePercent:"+OpenPercentage);
		    String openRatePercentage = openPercent.getText();
		    System.out.println("openRatePercentage:"+openRatePercentage);
		    String clicks = click.getText();
		    System.out.println("clicks:"+clicks);
		    String clickPercentage = clickPercent.getText();
		    System.out.println("clickPercentage:"+clickPercentage);
		    String unsubPercentage = unsubPercent.getText();
		    System.out.println("unsubPercentage:"+unsubPercentage);
		     
		    String unsubs = unsub.getText();
		    System.out.println("unsubs:"+unsubs);
		    viewReport(driver);
		    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		    driver.manage().window().maximize();
		    Thread.sleep(3000);
	        waitUntilPageLoad(driver,25);
	        String rSentCounts = rSentCount.getText();
		    System.out.println("clickPercentage:"+rSentCounts);
		    String rOpensCounts = rOpensCount.getText();
		    System.out.println("rOpensCount:"+rOpensCounts);
		     
		    String rCliksCounts = rCliksCount.getText();
		    System.out.println("rCliksCount:"+ rCliksCounts);
		     
		    String rUnsubs = rUnsub.getText();
		    System.out.println("rOpensCount:"+rUnsubs);
		    closeReport(driver);
		     
		 }catch(Exception e) {
	            System.out.println(e);
	        }
	
	}
	
	public void viewReport(WebDriver driver) {
		ClickElement(driver, reportBtn);
	}

	public void closeReport(WebDriver driver) {
		ClickElement(driver, close);
	}

}
