package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import pages.AddImagesPage;
import pages.DashboardPage;
import pages.EditFilePage;
import pages.FilesPage;
import pages.LoginPage;

/**
 * 
 * @author Abhijit Kambli
 *
 */
public class Verify_Upload_SingleImage extends BaseTest {
	
	@Test(priority=1,description="This test cases verifies single image upload")
	public void verify_upload_single_image(){
		
		Reporter.log("Navigating to login page", true);
		driver.get("https://demo.bigtreecms.org/admin/login/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//creation of Login page object to access Login Page methods
		LoginPage loginPage_obj = new LoginPage(driver);
		loginPage_obj.login("demo@bigtreecms.org", "demo");
		
		//creation of Dashboard page object to access Dashboard Page methods
		DashboardPage dashboardPage_obj = new DashboardPage(driver);
		dashboardPage_obj.clickFilesTab();
		
		FilesPage filesPage_obj = new FilesPage(driver);
		filesPage_obj.clickAddImagesLink();
		
		AddImagesPage addImagesPage_obj = new AddImagesPage(driver);
		addImagesPage_obj.clickFileDropZone();
				
		try {
			Thread.sleep(5000);
			Reporter.log("Executing Auto It script to upload single image file", true);
			Runtime.getRuntime().exec("C:\\Scripts\\ZeidlerQATest\\AutoITScripts\\singleImageUpload.exe");
			Thread.sleep(5000);
		} catch (Exception e) {
			Reporter.log("Auto It script failed to upload image file", true);
			e.printStackTrace();
		}
		
		addImagesPage_obj.clickContinueButton();
		
		EditFilePage editFilePage_obj = new EditFilePage(driver);
		Assert.assertTrue(editFilePage_obj.isthumbnailOfImageDisplayed(),"Thumbnail of uploaded image is not displayed on edit file page");
		editFilePage_obj.clickUpdateButton();
		
		try {
			Thread.sleep(4000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String image_name_recentUpload = driver.findElement(By.xpath("//a[contains(text(),'butterfly-small')]")).getText().trim();
		Assert.assertTrue(image_name_recentUpload.contains("butterfly-small"),image_name_recentUpload+"is not displayed");

		dashboardPage_obj.logout();

	}
}
