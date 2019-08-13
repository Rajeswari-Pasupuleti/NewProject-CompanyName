package testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC003 {
	
	public RemoteWebDriver driver;
    
	   @BeforeClass
	    public void inintialization() {
	  
		   System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
	       driver=new ChromeDriver();
		   System.out.println("launching chrome browser");
		   driver.manage().window().fullscreen();
		   driver.manage().deleteAllCookies();
		   driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		   driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		   
	    }
		@Test()
		    public void verifyEmailId1() throws InterruptedException, IOException {
		    driver.get("https://haveibeenpwned.com/");
		    driver.findElementByXPath("//input[@id='Account']").sendKeys("test@something.com"); 
		    Thread.sleep(1000);
		    driver.findElementByXPath("//button[@id='searchPwnage']").click();
		    Thread.sleep(3000);
		    
		//scrolling down 
		    JavascriptExecutor js=(JavascriptExecutor)driver;
		    js.executeScript("window.scrollBy(0,500)");
		    
		//screenshot
		    TakesScreenshot srcShot=((TakesScreenshot)driver);
		    File SrcFile=srcShot.getScreenshotAs(OutputType.FILE);
		    File DestFile=new File("./snaps/image.png");
		    FileUtils.copyFile(SrcFile,DestFile);
			
		}
		
		@AfterClass
		public void tearDown() {
			driver.close();
		}
	    

}
