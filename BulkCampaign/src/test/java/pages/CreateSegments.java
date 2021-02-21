package pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import freemarker.core.ParseException;
      
public class CreateSegments extends BasePage{
//	public static String listName= "Default List";
	public static String[] arrData = {"Active", "Unknown", "Valid", "Opened", "Clicked"};
	
	
	@FindBy(xpath="//*[@id='sidenav-main']")
	private WebElement navDiv;
	
	@FindBy(xpath="//a[contains(@href,'/segment') and @class='nav-link']")
	private WebElement segmentBtn;
	
	@FindBy(xpath="//*[@id='segName']")
	private WebElement segmentName;
	
	@FindBy(xpath="//button[text()='Choose List']")
	private WebElement ChooseListBtn;
	
	@FindBy(xpath="//span[text()='List of 20 contacts']")
	private WebElement List;
	
	@FindBy(xpath="//button[text()='Continue']")
	private WebElement continueBtn;
	@FindBy(linkText = "Create segment")
	private WebElement createlink;
	
	@FindBy(xpath="//*[@placeholder='Search recipients']")
	private WebElement clickSearch;
	
	@FindBy(xpath="(//*[@class='vs__dropdown-toggle'])[6]")
	private WebElement dropdown;
	@FindBy(xpath="//button[@class='btn btnw-170 mr-3 btn-primary']")
	private WebElement submit;
	@FindBy(xpath="//*[@type='button' and text()='OK']")
	private WebElement okBtn;
	
//	@FindBy(xpath="//*p[@class='text-content font-15 mb-0']")
//	private WebElement countText;
	
	  @FindBy(xpath="//input[@placeholder='Search']")
	    private WebElement searchList;
	    @FindBy(xpath="//p[@class='text-content font-15 mb-0']")
	    private WebElement listCount;
	    @FindBy(xpath="(//a[@class='d-block a-text-underline text-truncate'])[1]")
	    private WebElement searchedResultName;
	
	private WebDriver driver;
	
	public CreateSegments(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// over view page
	public int[] createNav(String listname) throws InterruptedException {
		Thread.sleep(1000);	 
		System.out.println("settings selected");
		BasePage.waitForElement(driver,navDiv,50);
		BasePage.ClickElement(driver,navDiv);
		BasePage.waitForElement(driver,segmentBtn,50);
		BasePage.ClickElement(driver,segmentBtn);
		
		return  createSegmentPage(listname);
	}
	public int[] createSegmentPage(String listname) throws InterruptedException{
		Thread.sleep(1000);
		int beforCount = getCount();
		int loopCount = 0;
		for (int i = 1; i < 6; i++) 
		{
			loopCount += i;
		System.out.println(i);
		BasePage.ClickElement(driver,createlink);
		BasePage.waitForElement(driver,segmentName,50);
		BasePage.setText(driver,segmentName, "Segment "+getTime());
		BasePage.waitForElement(driver,ChooseListBtn,500);
		BasePage.waitForClick(driver,ChooseListBtn);
		WebElement List = driver.findElement(By.xpath("//span[text()='List of 20 contacts']"));
		BasePage.waitForElement(driver,List,50);
		BasePage.ClickElement(driver,List);
		BasePage.waitForElement(driver,continueBtn,50);
		BasePage.waitForClick(driver,continueBtn);
		setRule(driver, i);
		
		}
		int afterCount = getCount();
		int expectedCount = beforCount + 5;
//		System.out.println("afterCount"+ afterCount);
//		System.out.println("expectedCount"+ expectedCount);
		return new int[] { afterCount, expectedCount };
	}
	public void setRule(WebDriver driver, Integer value) {
		try {
		BasePage.waitForElement(driver,dropdown,50);
		BasePage.performScrollToElement(driver, dropdown);
		BasePage.ClickElement(driver,dropdown);
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		WebElement optn = driver.findElement(By.xpath("(//li[@class='vs__dropdown-option'])["+ value +"]"));
		BasePage.ClickElement(driver,optn);
		System.out.println("(//li[@class='vs__dropdown-option'])["+ value +"]");
		BasePage.waitForClick(driver,submit);
		System.out.println("submit button");
		BasePage.waitForElement(driver,okBtn,50);
		BasePage.waitForClick(driver,okBtn);
		}catch(Exception e) {
			System.out.println(e);
	    }
	}	
	
	public Integer getCount()  throws InterruptedException{
		Thread.sleep(1000);	
		String getCount= getText(driver, listCount);
		String count = getCount.replace("segments","");
		count = count.replaceAll("\\s", ""); 
		int Precount= Integer.parseInt(count); 
		return Precount;
	}
	
//	public String searchInList(String searchText) throws IOException, InterruptedException, ParseException, java.text.ParseException{      
//	System.out.println("save with wait");
//    BasePage.moveToElement(driver,searchList);
//    BasePage.setText(driver, searchList,searchText);
//    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//    return getText(driver, searchedResultName);   
//}
	
}
