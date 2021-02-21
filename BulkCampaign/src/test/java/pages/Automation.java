package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
      
public class Automation extends BasePage{
	public static String listName= "one lac";
	 String[] autoName=new String[5];
	
	public static String campaign= "Pause campaign";
	@FindBy(xpath="//*[@id='sidenav-main']")
	private WebElement navDiv;
	
	/*@FindBy(xpath="//a[contains(@href,'/automation') and @class='nav-link']")
	private WebElement automation;*/
	
	@FindBy(xpath="//*[@id='sidenav-collapse-main']/ul/li[4]/a/span[2]")
	private WebElement automation;
	
	@FindBy(xpath="//*[@type='button' and text()='Create automation']")
	private WebElement automationCreateButton;
	
	@FindBy(xpath="//*[@id='name' and @name='name']")
	private WebElement nameText;
	
	@FindBy(xpath="//*[@name='target' and text()='Choose your target']")
	private WebElement target;
	
	@FindBy(xpath="//*[@class='form-control form-control-sm']")
	private WebElement search;
	
	@FindBy(xpath="//th[@role='columnheader' and @class='col-wid-50 pr-0']")
	private WebElement list;
	
	@FindBy(xpath="//*[@id='modalAutomationTargetAudiance___BV_modal_footer_']/div/div/div/button[1]")
	private WebElement continueList;
	
	@FindBy(xpath="(//*[@placeholder='DD / MM / YY' and @type='text'])[2]")
	private WebElement datepicker;
	
	@FindBy(xpath="//span[contains(@class, 'cell day today')]")
	private WebElement today;
	

	@FindBy(xpath="//input[@id='camp_name']")
	private WebElement searchWithAutomation;

	@FindBy(xpath="(//input[@placeholder='HH:MM'])[1]")
	private WebElement timeFeild1;




	@FindBy(xpath="(//input[@placeholder='HH:MM'])[2]")
	private WebElement timeFeild;
	
	@FindBy(xpath="//*[@class='btn btnw-170 btn-primary' and @type='button']")
	private WebElement continueBtn;
	
	@FindBy(xpath="//*[@class='btn img-invert btn-white border-0 btn-outline-primary' and @type='button']")
	private WebElement addCampaign;
	
	@FindBy(xpath="//*[@class='form-control form-control-sm']")
	private WebElement listSearch;
	
	@FindBy(xpath="(//*[@class='list-template-image'])[1]")
	private WebElement selectList;
	
	@FindBy(xpath="//*[@class='btn btn-primary']")
	private WebElement continueLisBtn;
	
	@FindBy(xpath="(//*[@class='btn btn-link dropdown-toggle auto-drop'])[1]")
	private WebElement ruleforCondition;
	
	@FindBy(linkText="Immediately")
	private WebElement condition;
	
	@FindBy(xpath="(//*[@class='btn btn-link dropdown-toggle auto-drop'])[1]")
	private WebElement rule;
	
	@FindBy(xpath="(//*[@class='btn btn-link dropdown-toggle auto-drop'])[2]")
	private WebElement ruleforSubscribe;
	
	@FindBy(linkText="Opened")
	private WebElement subscribe;
	
	@FindBy(xpath="(//button[text()[normalize-space() = 'Continue']])[2]")
	private WebElement continueCamp;
	
	@FindBy(xpath="//button[text()[normalize-space() = 'Publish']]")
	private WebElement publish;
	
	@FindBy(xpath="//a[contains(@href,'/automation') and @class='btn custom-close text-reset btn-link btn-lg']")
	private WebElement closePreview;
	
	//*[@class='btn btnw-170 btn-primary']
	
	//button[@class='btn btnw-170 btn-primary']
	
	private WebDriver driver;
	
//	duplicates
	
	@FindBy(xpath="//*[@class='btn btn-filter mr-2 px-0 wid-50 btn-outline-primary']")
	private WebElement filter;
	@FindBy(xpath="(//*[@class='vs__actions'])[3]")
	private WebElement statusDropdown;
	
	@FindBy(xpath="(//li[text()[normalize-space() = 'Completed']])")
	private WebElement activeStatus;
	@FindBy(xpath="//*[text()[normalize-space() = 'Toggle Dropdown']]")
	private WebElement toggleDropDown;
	
	@FindBy(linkText="Duplicate")
	private WebElement dulicate;
	
	@FindBy(xpath="//*[@class='custom-control-label']")
	private WebElement duplicateForList;
	
	@FindBy(xpath="(//button[text()[normalize-space() = 'Yes copy']])")
	private WebElement yesBtn;
	
	@FindBy(xpath="(//button[text()[normalize-space() = 'Edit Automation']])")
	private WebElement editAutoBtn;
	
	@FindBy(xpath="(//button[text()[normalize-space() = 'Continue']])[2]")
	private WebElement continueAutoBtn;
	
	@FindBy(xpath="//*[@class='text-content font-15 mb-0']")
	private WebElement listCount;
	
	
	
	public Automation(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// over view page
	public int[] generateAutomation() throws InterruptedException {
		Thread.sleep(1000);	 
		System.out.println("settings selected");
		BasePage.waitForElement(driver,navDiv,50);
		BasePage.ClickElement(driver,navDiv);
		BasePage.waitForElement(driver,automation,50);
		BasePage.ClickElement(driver,automation);
		int beforCount = getCount();
		createAutomation();
		setUpAutomation();
		AutomationFlow();
		PublishPage();
		BasePage.waitForElement(driver,closePreview,50);
		BasePage.ClickElement(driver,closePreview);
		int afterCount = getCount();
		int expectedCount = beforCount + 1;
		return new int[] { afterCount, expectedCount };
		
	}
	
	public void createAutomation() throws InterruptedException {
//		Thread.sleep(1000);	 
		System.out.println("Click Create button for automation create");
		waitForElement(driver,automationCreateButton,50);
		waitForClick(driver,automationCreateButton);
		
	}
	
	public void setUpAutomation() throws InterruptedException {
		System.out.println("Action in automation setup page");
		waitForElement(driver,nameText,50);
		setText(driver,nameText, "Automation "+ getTime());
		waitForClick(driver,target);
		selectList();
		datepicker();
		waitForElement(driver,continueBtn,50);
		ClickElement(driver,continueBtn);
	}
	
	public void selectList() throws InterruptedException {
		Thread.sleep(1000);
		waitForElement(driver,search,50);
		setText(driver,search, listName);
		waitForElement(driver,list,50);
		ClickElement(driver,list);
		waitForElement(driver,continueList,50);
		ClickElement(driver,continueList);
		
		
	}
	
	public void datepicker() throws InterruptedException {
        Thread.sleep(1000);
        waitForElement(driver,datepicker,20);
        ClickElement(driver,datepicker);
        waitForElement(driver,today,20);
        ClickElement(driver,today);
        waitForElement(driver,timeFeild1,20);
        clear(driver,timeFeild1);
        ClickElement(driver,timeFeild1);
        Thread.sleep(1000);
       
        setText(driver,timeFeild1, "08:00");
        waitForElement(driver,timeFeild,20);
        clear(driver,timeFeild);
        ClickElement(driver,timeFeild);
       
        setText(driver,timeFeild, "18:00");
    }
	
	public void AutomationFlow() throws InterruptedException {
		Thread.sleep(1000);
		for (int i = 1; i < 6; i++) 
		{
		waitForElement(driver,addCampaign,50);
		waitForClick(driver,addCampaign);
		ChooseCampaignList(i);
		ScrollByVisibleElement(driver, continueCamp);
		}
		waitForElement(driver,continueCamp,100);
		waitForClick(driver,continueCamp);
		
	}

	public void ChooseCampaignList(int i) throws InterruptedException {
		Thread.sleep(1000);
		waitForElement(driver,listSearch,20);
		ClickElement(driver,listSearch);
		switch (i) {
		  case 1:
			  campaign = "Campaign For Automation"+ String.valueOf(i);
		    break;
		  case 2:
			  campaign = "Campaign For Automation"+ String.valueOf(i);
		    break;
		  case 3:
			  campaign = "Campaign For Automation"+ String.valueOf(i);
		    break;
		  case 4:
			  campaign= "Campaign For Automation"+ String.valueOf(i);
		    break;
		  case 5:
			  campaign = "Campaign For Automation"+ String.valueOf(i);
		    break;
		}
		setText(driver,listSearch,  campaign);
		waitForElement(driver,selectList,50);
		waitForClick(driver,selectList);
		waitForElement(driver,continueLisBtn,20);
		ClickElement(driver,continueLisBtn);
	}

	public void PublishPage() throws InterruptedException {
		waitForElement(driver,publish,100);
		ClickElement(driver,publish);
		Thread.sleep(1000);
	}
	
	public void condition(int i) throws InterruptedException {
		int k  = i;
		int l = i + 2;
		System.out.println("(//*[@class='btn btn-link dropdown-toggle auto-drop'])["+ k +"]");
		WebElement ruleforCondition1 = driver.findElement(By.xpath("(//*[@class='btn btn-link dropdown-toggle auto-drop'])["+ k +"]"));
		ScrollByVisibleElement(driver, ruleforCondition1);
		ClickElement(driver,ruleforCondition1);
		waitForElement(driver,condition,20);
		ClickElement(driver,condition);
		System.out.println("(//*[@class='btn btn-link dropdown-toggle auto-drop'])["+ l +"]");
		WebElement ruleforSubscribe2 = driver.findElement(By.xpath("(//*[@class='btn btn-link dropdown-toggle auto-drop'])["+ l +"]"));
		ScrollByVisibleElement(driver, ruleforSubscribe2);
		ClickElement(driver,ruleforSubscribe2);
		waitForElement(driver,subscribe,20);
		ClickElement(driver,subscribe);
		
	}
	 public void getautomationname(String automationName1,String automationName2,String automationName3,String automationName4,String automationName5) { 	
		 autoName[0]=automationName1;
		 autoName[1]=automationName2;
		 autoName[2]=automationName3;
		 autoName[3]=automationName4;
		 autoName[4]=automationName5;
	    	//Senderid[4]=senderid5;
	    	

	    	
	    }
	
	public void generatDupliAutomation(int i) throws InterruptedException {
	    Thread.sleep(1000);
	    int j=i;
	   
	   // getautomationname(automationName1, automationName2, automationName3, automationName4);
	    driver.navigate().to("http://dash.vinmail.io/automation");
	        //int beforCount = getCount();
	       
	    	
	       
	        	
	        	System.out.println("Automation "+ autoName[i]);
	        	waitForElement(driver,filter,20);
	        	waitForClick(driver,filter);
	        	waitForElement(driver,searchWithAutomation,20);
	        	waitForClick(driver,searchWithAutomation);
	        	clear(driver,searchWithAutomation);
	        	setText(driver,searchWithAutomation, autoName[i]);
	        	waitForElement(driver,toggleDropDown,20);
	        	waitForClick(driver,toggleDropDown);
	        	waitForElement(driver,dulicate,20);
	        	waitForClick(driver,dulicate);
	        	setDuplictes();
	        	setDuplictesDetails();
	        	waitForElement(driver,closePreview,20);
	        	ClickElement(driver,closePreview);
	        	Thread.sleep(1000);
	        	// waitForElement(driver,clear,20);
	        	//waitForClick(driver,clear);
	        }  
	       //     int afterCount = getCount();
	          //  int expectedCount =  beforCount + 1;
	          //  System.out.println("before:" + beforCount);
	          ////  System.out.println("after:"+ afterCount);
	          //  System.out.println("expected:"+expectedCount);
	           // return new int[] { afterCount, expectedCount };
	     
	/*
	public void generatDupliAutomation() throws InterruptedException {
	    Thread.sleep(1000);
	    BasePage.waitForElement(driver,navDiv,50);
		BasePage.ClickElement(driver,navDiv);
		BasePage.waitForElement(driver,automation,50);
		BasePage.ClickElement(driver,automation);
	        waitForElement(driver,filter,20);
	        waitForClick(driver,filter);
	        for (int i = 1; i < 4; i++) 
	        {
	            System.out.println(i);
	          
	            moveToElement(driver,statusDropdown);
	            waitForElement(driver,statusDropdown,50);
	            ClickElement(driver,statusDropdown);
	            waitForElement(driver,activeStatus,50);
	            ClickElement(driver,activeStatus);
	            waitForElement(driver,toggleDropDown,20);
	            waitForClick(driver,toggleDropDown);
	            waitForElement(driver,dulicate,20);
	            waitForClick(driver,dulicate);
	            setDuplictes();
	            setDuplictesDetails();
	            waitForElement(driver,closePreview,20);
	            ClickElement(driver,closePreview);
	            Thread.sleep(2000);
	        }
	        }

	 
*/
	    public void setDuplictes() throws InterruptedException {
	        Thread.sleep(1000);
	         waitForElement(driver,search,50);
	         setText(driver,search, listName);
	         Thread.sleep(1000);
	         waitForElement(driver,duplicateForList,50);
	         waitForClick(driver,duplicateForList);
	        // waitUntilPageLoad(driver, 1000);
	         datepicker();
	         waitForElement(driver,yesBtn,20);
	         ClickElement(driver,yesBtn);
	    }
	    
	    public void setDuplictesDetails() throws InterruptedException {
	        waitForElement(driver,editAutoBtn,20);
	        ClickElement(driver,editAutoBtn);
	        Thread.sleep(2000);
	        waitForElement(driver,continueAutoBtn,50);
	        ClickElement(driver,continueAutoBtn);
	        waitForElement(driver,continueAutoBtn,20);
	        ClickElement(driver,continueAutoBtn);
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        waitForElement(driver,publish,20);
	        waitForClick(driver,publish);
	    }
	
	public Integer getCount()  throws InterruptedException{
		Thread.sleep(1000);	
		String getCount= getText(driver, listCount);
		String count = getCount.replace("Records found","");
		count = count.replaceAll("\\s", ""); 
		int Count= Integer.parseInt(count); 
		return Count;
	}


}
