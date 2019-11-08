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
public class LoginPage {
	
	//default level access to driver
	WebDriver driver;
	WebDriverWait wait;
	Actions act;
	
	//constructor
	public LoginPage(WebDriver driver){
		//initialization of instance driver variable
		this.driver = driver;
		
		//initialization of page factory init elements for this page
		PageFactory.initElements(driver, this);
		
		//defining wait time for explicit wait
		wait= new WebDriverWait(driver, 10);
		act= new Actions(driver);
		
	}
	
	//WebElements of LoginPage
	@FindBy(id="user")
	@CacheLookup
	WebElement email_field;
	
	@FindBy(id="password")
	@CacheLookup
	WebElement password_field;
	
	@FindBy(xpath="//input[@value='Login']")
	@CacheLookup
	WebElement login_button;
	
	public void login(String email,String pwd){
		try{
			email_field.clear();
			Reporter.log("Entering email id", true);
			email_field.sendKeys(email);
			
			password_field.clear();
			Reporter.log("Entering password", true);
			password_field.sendKeys(pwd);
			
			Reporter.log("Clicking login button", true);
			login_button.click();
			
		}catch(Exception e){
			Reporter.log("Login failed", true);
			e.printStackTrace();
		}

		
	}
	

}
