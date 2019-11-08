package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
/**
 * 
 * @author Abhijit Kambli
 *
 */
public class DashboardPage {

	WebDriver driver;
	WebDriverWait wait;
	Actions act;
	
	public DashboardPage(WebDriver driver){
		this.driver= driver;
		wait= new WebDriverWait(driver, 10);
		act= new Actions(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Files")
	@CacheLookup
	WebElement Files_tab;
	
	@FindBy(xpath="//a[@class='logout']")
	@CacheLookup
	WebElement logout_btn;
	
	public void clickFilesTab(){
		Reporter.log("Clicking Files tab from top menu", true);
		Files_tab.click();
	}
	
	public void logout(){
		Reporter.log("Clicking Logout button", true);
		logout_btn.click();
	}
}	
