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
public class EditFilePage {

	WebDriver driver;
	WebDriverWait wait;
	Actions act;
	
	public EditFilePage(WebDriver driver){
		this.driver= driver;
		wait= new WebDriverWait(driver, 10);
		act= new Actions(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='currently_wrapper']//a//img")
	@CacheLookup
	WebElement thumbNail_img_uploaded;
	
	@FindBy(xpath="//input[@value='Update File']")
	@CacheLookup
	WebElement update_btn;
	
	public boolean isElementDisplayed(WebElement element){
		try {
				if(element.isDisplayed()){
					return true;
				}	
		    } catch (Exception e) {
		    	e.printStackTrace(); 	
			}
		return false;
	}
	
	public boolean isthumbnailOfImageDisplayed(){
		 return isElementDisplayed(thumbNail_img_uploaded);
	}
	
	public void clickUpdateButton(){
		
		Reporter.log("Clicking update button", true);
		update_btn.click();
	}
}
