package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSettings extends BasePage{
	@FindBy(xpath="//*[@class='ico-sidebar profile-holder rounded-circle']")
	private WebElement settings;
	
	
	@FindBy(xpath="//a[contains(@href,'/account') and text()='Account settings']")
	private WebElement accountSettings;
	
	@FindBy(xpath="//h3[@class='font-17 font-weight-bold text-sub-head mb-0']")
	private WebElement planText;
	private WebDriver driver;
	
	public AccountSettings(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	// over view page
		public String overview() {
			BasePage.waitForElement(driver,settings,50);
			settings.click();
			BasePage.waitForElement(driver,accountSettings,50);
			accountSettings.click();
			BasePage.waitForElement(driver,planText,50);
			return planText.getText();
		}
		

}
