package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
/**
 * 
 * @author Abhijit Kambli
 *
 */
public class AddImagesPage {

	//default level access to driver
		WebDriver driver;
		WebDriverWait wait;
		Actions act;
		
		//constructor
		public AddImagesPage(WebDriver driver){
			//initialization of instance driver variable
			this.driver = driver;
			
			//initialization of page factory init elements for this page
			PageFactory.initElements(driver, this);
			
			//defining wait time for explicit wait
			wait= new WebDriverWait(driver, 15);
			act= new Actions(driver);
			
		}
		
		//WebElements of LoginPage
		@FindBy(id="file_manager_dropzone")
		@CacheLookup
		WebElement file_manager_dropzone;
		
		@FindBy(xpath="//input[@value='Continue']")
		@CacheLookup
		WebElement continue_button;
		
		public void clickFileDropZone(){
			Reporter.log("Clicking to manually upload image file", true);
			wait.until(ExpectedConditions.elementToBeClickable(file_manager_dropzone)).click();
		}
		
		public void clickContinueButton(){
			Reporter.log("Clicking continue button", true);
			wait.until(ExpectedConditions.elementToBeClickable(continue_button)).click();
		}

}
