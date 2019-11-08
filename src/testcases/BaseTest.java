package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

/**
 * 
 * @author Abhijit Kambli
 *
 */

	public class BaseTest {

		protected WebDriver driver;
		InternetExplorerOptions options;
	
		public WebDriver createLocalDriver(String browserName){
	
			if(browserName.equalsIgnoreCase("firefox")){
				System.setProperty("webdriver.gecko.driver", "C:\\Scripts\\ZeidlerQATest\\Drivers\\geckodriver.exe");
				Reporter.log("Launching browser", true);
				driver= new FirefoxDriver();
				Reporter.log("Maximizing browser", true);
				driver.manage().window().maximize();
				
			}else if(browserName.equalsIgnoreCase("chrome")){
				System.setProperty("webdriver.chrome.driver", "C:\\Scripts\\ZeidlerQATest\\Drivers\\chromedriver.exe");
				Reporter.log("Launching browser", true);
				driver= new ChromeDriver();
				Reporter.log("Maximizing browser", true);
				driver.manage().window().maximize();
				
			}else if(browserName.equalsIgnoreCase("ie")){
				System.setProperty("webdriver.ie.driver", "C:\\Scripts\\ZeidlerQATest\\Drivers\\IEDriverServer.exe");
				options= new InternetExplorerOptions();
				options.introduceFlakinessByIgnoringSecurityDomains();
				options.ignoreZoomSettings();
				Reporter.log("Launching browser", true);
				driver = new InternetExplorerDriver(options);
				Reporter.log("Maximizing browser", true);
				driver.manage().window().maximize();
				
			}else {
				Reporter.log("Invalid browser name, enter e.g firefox,chrome or ie", true);
			}
		
			return driver;
		}

		@BeforeClass
		@Parameters({"browser"})
		public void setUp(String browser){
			driver = createLocalDriver(browser);
		}
		
		@AfterClass
		public void tearDown(){
			
			if(driver!=null){
				
				try{
					
					Reporter.log("closing driver", true);
					driver.quit();
					Reporter.log("driver closed", true);
					
					
				}catch(WebDriverException e){
					Reporter.log("exception in driver teardown", true);
					e.printStackTrace();
				}
			}
			
		}
}
