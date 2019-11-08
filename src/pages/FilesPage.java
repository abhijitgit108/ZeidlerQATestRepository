package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
/**
 * 
 * @author Abhijit Kambli
 *
 */
public class FilesPage {
	
	WebDriver driver;
	WebDriverWait wait;
	Actions act;
	
	public FilesPage(WebDriver driver){
		this.driver= driver;
		act= new Actions(driver);
		wait= new WebDriverWait(driver, 10);
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(linkText="Add Images")
	@CacheLookup
	WebElement addImages_link;
	
	@FindBys(@FindBy(xpath="//ul[@id='js-file-manager-results']//li"))
	List<WebElement> images_uploaded_list;
	
	@FindBy(xpath="//li[1]//section[1]//img[1]")
	@CacheLookup
	WebElement thumbnail_image_recentUpload;
	
	public void clickAddImagesLink(){
		Reporter.log("Clcking AddImages Link", true);
		wait.until(ExpectedConditions.elementToBeClickable(addImages_link)).click();
	}
	
	public void verify_NamesOfImages_Uploaded_InFileManagerResults(String image1Name,String image2Name){
		Reporter.log("size of images uploaded list: "+images_uploaded_list.size(), true);
		
		for(WebElement table_row: images_uploaded_list){
			
			String imageName;
			
			for(int i=1;i<=images_uploaded_list.size();i++){
				
				String a="//li["+i+"]//section[2]";
				imageName = table_row.findElement(By.xpath(a)).getText().trim();
				
				if(imageName.contains(image1Name)){
					//butterfly-small
					Reporter.log("table contains image name :"+imageName.trim(), true);
					//System.out.println("table contains image name :"+imageName.trim());
					continue;
				}else if(imageName.contains(image2Name)){
					//"sunset-small"
					Reporter.log("table contains image name :"+imageName.trim(), true);
					//System.out.println("table contains image name :"+imageName.trim());
					continue;
				}
				else{
					
					Reporter.log("image name not found", true);
					//System.out.println("image name not found");
				}
			
			}
			break;
			
		}//end of outer for loop
			
	}//end of verify
	
	public boolean isThumbnailImage_Displayed_FilesPage(){
		return new EditFilePage(driver).isElementDisplayed(thumbnail_image_recentUpload);
	}
}
