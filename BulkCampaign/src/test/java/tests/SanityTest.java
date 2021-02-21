package tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.HashMap;

import org.apache.xmlbeans.impl.regex.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import core.TestConfig;
import core.TestReports;
import pages.CampaignPage;
import pages.CampaignReport;
import pages.CreateSegments;
import pages.LoginPage;

import pages.LogoutPage;
import pages.TimeBaseCampaignPage;
import pages.AbCampaign;
import pages.AccountSettings;
import pages.Automation;
import pages.CampaignGeneratePage;
import pages.TimeCampaignCreatePage;
import pages.AutoresponderCreatePage;
import pages.ContactCreatePage;
import pages.DashboardCountsPage;
import pages.MailBoxPage;
import pages.ClientQuotaPage;

public class SanityTest extends TestBase{
	LoginPage login;
	LogoutPage logout;
	AccountSettings  accountsettings;
	CreateSegments  segments;
	Automation  automation;
	CampaignGeneratePage CampGen;
	AbCampaign abCampaign;
	CampaignReport report;
	
	CampaignPage campaign;
	TimeBaseCampaignPage  tbcampaign;
	TimeCampaignCreatePage timeCamp;
	AutoresponderCreatePage autoresponder;
	ContactCreatePage contact;
	DashboardCountsPage DashboardCountsPage;
	MailBoxPage MailBoxPage;
	ClientQuotaPage ClientQuotaPage;
	
	@BeforeMethod
	public void Login_To_App() {
	
		
		driver().get(TestConfig.getProperty("APP_URL"));
	}
/*
	@Test(dataProvider="extractData",priority=1)
	public void Verify_Free_Plan(HashMap<String,String> data) throws ParseException, IOException, InterruptedException, Exception {
		System.out.println("Test For Verify Free plan");
		Thread.sleep(1000);
		login = new LoginPage(driver());
		report().logReport(LogStatus.INFO, "Application Launched", "Application launch successfull");
		login.peformLogin(data.get("username"),data.get("password"));
		report().logReport(LogStatus.INFO, "Username", data.get("username"));
		report().logReport(LogStatus.INFO, "Password", data.get("password"));
		report().logReport(LogStatus.INFO, "Login Successfull", "Login successfull");
		System.out.println("Launched driver Successufully");
		accountsettings = new AccountSettings(driver());
		String Actual= accountsettings.overview();
		System.out.println("plan:"+ Actual);
		assertEquals("Free plan", Actual);
	
	}
		
	
	@Test(dataProvider="extractData",priority=1)
	public void Verify_Segment_Create(HashMap<String,String> data) throws ParseException, IOException, InterruptedException, Exception {
		System.out.println("Test for Verify Segment Create");
		Thread.sleep(1000);
		login = new LoginPage(driver());
		login.peformLogin(data.get("username"),data.get("password"));
		report().logReport(LogStatus.INFO, "Username", data.get("username"));
		report().logReport(LogStatus.INFO, "Password", data.get("password"));
		report().logReport(LogStatus.INFO, "Login Successfull", "Login successfull");
		System.out.println("Launched driver successfully");
		segments = new CreateSegments(driver());
		int[] results = segments.createNav(data.get("listname"));
		System.out.println("Actual count"+ Integer.toString(results[0]));
		System.out.println("Expected count "+ Integer.toString(results[1]));
		assertEquals(Integer.toString(results[0]), Integer.toString(results[1]));
		
	}
	
	@Test(dataProvider="extractData",priority=1)
	public void Verify_Normal_campaign(HashMap<String,String> data) throws ParseException, IOException, InterruptedException, Exception {
		System.out.println("Hello");
		Thread.sleep(1000);
		login = new LoginPage(driver());
		report().logReport(LogStatus.INFO, "Application Launched", "Application launch successfull");
		
		login.peformLogin(data.get("username"),data.get("password"));
		report().logReport(LogStatus.INFO, "Username", data.get("username"));
		report().logReport(LogStatus.INFO, "Password", data.get("password"));
	
		report().logReport(LogStatus.INFO, "Login Successfull", "Login successfull");
		
		System.out.println("Launched driver Successfully");
		CampGen =  new CampaignGeneratePage(driver());
		CampGen.createCampaign();
		String listName = CampGen.createNewCampaign(data.get("campname"),data.get("subject"),data.get("templatename"));
		Thread.sleep(1000);
		CampGen.chooseRecipients(data.get("listname"));
		CampGen.publishNormalCampaign();
		Thread.sleep(1000);
		String listNewName = CampGen.searchInList(listName);
		Assert.assertEquals(listNewName,listName);
	}	
	
	@Test(dataProvider="extractData",priority=1)
	public void Verify_Automation(HashMap<String,String> data) throws ParseException, IOException, InterruptedException, Exception {
		System.out.println("Test for Verify Automation");
		Thread.sleep(1000);
		login = new LoginPage(driver());
		report().logReport(LogStatus.INFO, "Application Launched", "Application launch successfull");
		login.peformLogin(data.get("username"),data.get("password"));
		report().logReport(LogStatus.INFO, "Username", data.get("username"));
		report().logReport(LogStatus.INFO, "Password", data.get("password"));
		report().logReport(LogStatus.INFO, "Login Successfull", "Login successfull");
		System.out.println("Launched driver Successufully");
		automation = new Automation(driver());
		int[] results = automation.generateAutomation();
		System.out.println("Actual count"+ Integer.toString(results[0]));
		System.out.println("Expected count "+ Integer.toString(results[1]));
		assertEquals(Integer.toString(results[0]), Integer.toString(results[1]));
		
		
	}
	

	
	@Test(dataProvider="extractData",priority=1)
    public void Verify_DupliAutomation(HashMap<String,String> data) throws ParseException, IOException, InterruptedException, Exception {
        System.out.println("Test for Verify Automation susing duplicate");
        Thread.sleep(1000);
        login = new LoginPage(driver());
        report().logReport(LogStatus.INFO, "Application Launched", "Application launch successfully");
        login.peformLogin(data.get("username"),data.get("password"));
        report().logReport(LogStatus.INFO, "Username", data.get("username"));
        report().logReport(LogStatus.INFO, "Password", data.get("password"));
        report().logReport(LogStatus.INFO, "Login Successfully", "Login successfully");
        System.out.println("Launched driver successfully");
        automation = new Automation(driver());
        automation.getautomationname(data.get("automationname1"),data.get("automationname2"),data.get("automationname3"),data.get("automationname4"),data.get("automationname5"));
        for(int i=0;i<=4;i++) {
        automation.generatDupliAutomation(i);}
        //System.out.println("Actual count"+ Integer.toString(results[0]));
     //   System.out.println("Expected count "+ Integer.toString(results[1]));
       // assertEquals(Integer.toString(results[0]), Integer.toString(results[1]));
    }
	
	 * @Test(dataProvider="extractData",priority=1) public void
	 * Verify_generatDupliAutomation(HashMap<String,String> data) throws
	 * ParseException, IOException, InterruptedException, Exception {
	 * System.out.println("Test for Verify Automation susing duplicate");
	 * Thread.sleep(1000); login = new LoginPage(driver());
	 * report().logReport(LogStatus.INFO, "Application Launched",
	 * "Application launch successfully");
	 * login.peformLogin(data.get("username"),data.get("password"));
	 * report().logReport(LogStatus.INFO, "Username", data.get("username"));
	 * report().logReport(LogStatus.INFO, "Password", data.get("password"));
	 * report().logReport(LogStatus.INFO, "Login Successfully",
	 * "Login successfully"); System.out.println("Launched driver successfully");
	 * automation = new Automation(driver()); automation.generatDupliAutomation(); }
	
 
	
	
	

	@Test(dataProvider="extractData",priority=1)
	public void Verify_ABCampaign(HashMap<String,String> data) throws ParseException, IOException, InterruptedException, Exception {
		System.out.println("Test for Verify Automation susing duplicate");
		Thread.sleep(1000);
		login = new LoginPage(driver());
		report().logReport(LogStatus.INFO, "Application Launched", "Application launch successfully");
		login.peformLogin(data.get("username"),data.get("password"));
		report().logReport(LogStatus.INFO, "Username", data.get("username"));
		report().logReport(LogStatus.INFO, "Password", data.get("password"));
		report().logReport(LogStatus.INFO, "Login Successfully", "Login successfully");
		System.out.println("Launched driver successfully");
		abCampaign = new AbCampaign(driver());
		int[] results = abCampaign.abCreateAction();
		System.out.println("Actual count"+ Integer.toString(results[0]));
		System.out.println("Expected count "+ Integer.toString(results[1]));
		assertEquals(Integer.toString(results[0]), Integer.toString(results[1]));
	}
	
	@Test(dataProvider="extractData",priority=1)
	public void Verify_Campaign_Report(HashMap<String,String> data) throws ParseException, IOException, InterruptedException, Exception {
		System.out.println("Test for Verify Automation susing duplicate");
		Thread.sleep(1000);
		login = new LoginPage(driver());
		report().logReport(LogStatus.INFO, "Application Launched", "Application launch successfully");
		login.peformLogin(data.get("username"),data.get("password"));
		report().logReport(LogStatus.INFO, "Username", data.get("username"));
		report().logReport(LogStatus.INFO, "Password", data.get("password"));
		report().logReport(LogStatus.INFO, "Login Successfully", "Login successfully");
		System.out.println("Launched driver successfully");
		report = new CampaignReport(driver());
		report.checkReport();
	}
	*/
	@Test(dataProvider="extractData",priority=1)
	public void Verify_Time_Campaign(HashMap<String,String> data) throws ParseException, IOException, InterruptedException, Exception {
		System.out.println("Hello");
		 Thread.sleep(1000);
		login = new LoginPage(driver());
		report().logReport(LogStatus.INFO, "Application Launched", "Application launch successfull");
		
		login.peformLogin(data.get("username"),data.get("password"));
		report().logReport(LogStatus.INFO, "Username", data.get("username"));
		report().logReport(LogStatus.INFO, "Password", data.get("password"));
		
		report().logReport(LogStatus.INFO, "Login Successfull", "Login successfull");
		
		System.out.println("Launched driver Successfully");
		
		CampGen =  new CampaignGeneratePage(driver());
		CampGen.createCampaign();
		String listName = CampGen.createNewCampaign(data.get("campname"),data.get("subject"),data.get("templatename"));
		Thread.sleep(1000);
		CampGen.chooseRecipients(data.get("listname"));
		timeCamp = new TimeCampaignCreatePage(driver());
//		CampGen.publishNormalCampaign();
		timeCamp.goToScheduleTimeCamp();
		timeCamp.chooseTimeZone();
		timeCamp.chooseDay(data.get("scheduleday"));
		timeCamp.setTimeCampaignSpeed();
		timeCamp.publishTimeCamp();
		Thread.sleep(1000);
		String listNewName = CampGen.searchInList(listName);
		Assert.assertEquals(listNewName,listName);

	}
	/*
	@Test(dataProvider="extractData",priority=1)
	public void Verify_AutoResponder(HashMap<String,String> data) throws ParseException, IOException, InterruptedException, Exception {
		System.out.println("Hello");
		 Thread.sleep(1000);
		login = new LoginPage(driver());
		report().logReport(LogStatus.INFO, "Application Launched", "Application launch successfull");
		
		login.peformLogin(data.get("username"),data.get("password"));
		report().logReport(LogStatus.INFO, "Username", data.get("username"));
		report().logReport(LogStatus.INFO, "Password", data.get("password"));
		
		report().logReport(LogStatus.INFO, "Login Successfull", "Login successfull");
		
		System.out.println("Launched driver Successfully");
		
		CampGen =  new CampaignGeneratePage(driver());
		autoresponder = new AutoresponderCreatePage(driver());
//		CampGen.createCampaign();
		autoresponder.createAutoresponder();
		String listName = CampGen.createNewCampaign(data.get("campname"),data.get("subject"),data.get("templatename"));

//		String listName = CampGen.createNewCampaign("Automation AutoresponderTest","Auto Test subject","Automation Testing Template");
		Thread.sleep(1000);
		autoresponder.chooseCampaign(data.get("autorespondercampname"));
//		autoresponder.chooseCampaign("Autoresponder campaign");
		autoresponder.autoresponderSchedule("1", "today");
		Thread.sleep(1000);
		String listNewName = CampGen.searchInList(listName);
		Assert.assertEquals(listNewName,listName);
		

	}
	
	@Test(dataProvider="extractData",priority=1)
	public void Verify_Contact_Add(HashMap<String,String> data) throws ParseException, IOException, InterruptedException, Exception {
		System.out.println("Hello");
		 Thread.sleep(1000);
		login = new LoginPage(driver());
		report().logReport(LogStatus.INFO, "Application Launched", "Application launch successfull");
		
		login.peformLogin(data.get("username"),data.get("password"));
		report().logReport(LogStatus.INFO, "Username", data.get("username"));
		report().logReport(LogStatus.INFO, "Password", data.get("password"));
		
		report().logReport(LogStatus.INFO, "Login Successfull", "Login successfull");
		
		System.out.println("Launched driver Successfully");
		
		contact = new ContactCreatePage(driver());
		contact.createContact();
		Thread.sleep(1000);  
		String listName = contact.createList(data.get("listname"));
//		String count = data.get("listcount");
//		count = count.replaceAll("\\s", "");
//		int listcount = Integer.parseInt(count);
//		contact.importMethod("");
		Thread.sleep(1000);
		contact.copyPasteMethod(data.get("listdomain"),5);
		Thread.sleep(1000);
		String listNewName = contact.searchInList(listName);
		Assert.assertEquals(listNewName,listName);

		

	}
	
	@Test(dataProvider="extractData",priority=1)
	public void Verify_Quota(HashMap<String,String> data) throws ParseException, IOException, InterruptedException, Exception {
		System.out.println("Hello");
		 Thread.sleep(1000);
			login = new LoginPage(driver());
			report().logReport(LogStatus.INFO, "Application Launched", "Application launch successfull");
			
			login.peformLogin(data.get("username"),data.get("password"));
			report().logReport(LogStatus.INFO, "Username", data.get("username"));
			report().logReport(LogStatus.INFO, "Password", data.get("password"));
			
			report().logReport(LogStatus.INFO, "Login Successfull", "Login successfull");
			
			System.out.println("Launched driver Successfully");
		String emailQuota = data.get("emailquota");
		String clientQuota = data.get("contactquota");
		
		ClientQuotaPage = new ClientQuotaPage(driver());
		ClientQuotaPage.goToAccountSettingsPage();
		Thread.sleep(1000);
		String emailQuotaFound = ClientQuotaPage.getEmailQuota();
		emailQuotaFound = emailQuotaFound.replaceAll("\\s", "");
		String contactQuotaFound = ClientQuotaPage.getContactQuota();
		contactQuotaFound = contactQuotaFound.replaceAll("\\s", "");
		Assert.assertEquals(emailQuotaFound,emailQuota);
		Assert.assertEquals(contactQuotaFound,clientQuota);
		

	}
	
	
	
	@Test(dataProvider="extractData",priority=1)
	public void Verify_Open_Click(HashMap<String,String> data) throws ParseException, IOException, InterruptedException, Exception {
		 Thread.sleep(1000);
	        login = new LoginPage(driver());
	       
	        login.peformLogin(data.get("username"),data.get("password"));
	        report().logReport(LogStatus.INFO, "Username", data.get("username"));
	        report().logReport(LogStatus.INFO, "Password", data.get("password"));
	       
	        report().logReport(LogStatus.INFO, "Login Successfull", "Login successfull");
	        DashboardCountsPage = new DashboardCountsPage(driver());
	        MailBoxPage = new MailBoxPage(driver());
	        Thread.sleep(3000);
	        String DashOpen = DashboardCountsPage.getOpenCount();
	        DashOpen = DashOpen.replaceAll("\\s", "");
	        String DashClick = DashboardCountsPage.getClickCount();
	        DashClick = DashClick.replaceAll("\\s", "");
	        System.out.println(DashOpen+"opencount");
	        System.out.println(DashClick+"clickcount");
	        String username = data.get("mailboxusername");
	        String password = data.get("mailboxpassword");
//	        System.out.println(username);
	        Thread.sleep(1000);
	        MailBoxPage.loginToMailBox(username, password);
	        MailBoxPage.searchForMessage(data.get("subject"));
	        MailBoxPage.openUnreadMessage();
	        Thread.sleep(1000);
	        MailBoxPage.createOpens();
	        MailBoxPage.createClicks(data.get("linktext"),true);
	        Thread.sleep(3000);
	        String newOpenCount = DashboardCountsPage.getOpenCount();
	        newOpenCount = newOpenCount.replaceAll("\\s", "");
	        String newClickCount = DashboardCountsPage.getClickCount();
	        newClickCount = newClickCount.replaceAll("\\s", "");
	       
	        Assert.assertEquals(Integer.parseInt(newOpenCount),Integer.parseInt(DashOpen));
	        Assert.assertEquals(Integer.parseInt(newClickCount),Integer.parseInt(DashClick));
	}
	
		
	
	*/	
}

