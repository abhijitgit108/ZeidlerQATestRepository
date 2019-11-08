package testcases;

import java.util.concurrent.TimeUnit;

import org.testng.Reporter;
import org.testng.annotations.Test;

import pages.AddImagesPage;
import pages.DashboardPage;
import pages.FilesPage;
import pages.LoginPage;

/**
 * 
 * @author Abhijit Kambli
 *
 */
public class Verify_Upload_MultipleImages extends BaseTest {

	@Test(priority=1,description="This test cases verifies multiple images upload with different formats")
	public void verify_upload_with_multiple_images(){
		
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
			Reporter.log("Executing Auto It script to upload multiple image file of different format", true);
			Runtime.getRuntime().exec("C:\\Scripts\\ZeidlerQATest\\AutoITScripts\\MultipleImageUpload.exe");
			Thread.sleep(5000);
		} catch (Exception e) {
			Reporter.log("Auto It script failed to upload image file", true);
			e.printStackTrace();
		}
		
		addImagesPage_obj.clickContinueButton();
		
		filesPage_obj.verify_NamesOfImages_Uploaded_InFileManagerResults("butterfly-small", "sunset-small");
		
	}
	
}
