package wrappers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Reporter;

public class GenericWrapper extends Reporter implements Wrapper {

	public RemoteWebDriver driver;
	
public  static Properties prop;
	
	public void loadObjects()
	{
		prop=new Properties();
		try {
			prop.load(new FileInputStream(new File("./src/test/java/Object.Properties")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	
	public void unLoadObjects()
	{
		prop=null;
	}
	
	public void invokeApp( String BrowserName,String URL)  {
		DesiredCapabilities dc=new DesiredCapabilities();
        dc.setPlatform(Platform.WINDOWS);
        dc.setVersion("10");
try {
	driver=new RemoteWebDriver(new URL("http://192.168.99.100:4545/wd/hub"),dc);
} catch (MalformedURLException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
		try {
			if(BrowserName.equalsIgnoreCase("Chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--start-maximized");
				driver=new ChromeDriver(chromeOptions);
			}
			//driver=new RemoteWebDriver(new URL("http://192.168.99.100:4545/wd/hub"));
			driver.manage().deleteAllCookies();
			driver.get(URL);
			WebDriverWait wait=new WebDriverWait(driver, 20);
			reportStep("PASS","The browser "+BrowserName+" is launched and loaded with the url "+URL);
		} catch (WebDriverException e) {
			reportStep("FAIL","browser is not responding");
		}
		
	}

	public void enterByXPath(String xpath, String text) {
		try {
			driver.findElementByXPath(xpath).sendKeys(text);
			  reportStep("PASS","The element with the Xpath value "+xpath+" is found and entered as "+text);
		} catch (ElementNotVisibleException e) {
			reportStep("FAIL","The element with the Xpath value "+xpath+ "is not visible");
		} catch (NoSuchElementException e) {
			reportStep("FAIL","The element with the Xpath value "+xpath+ "is not found");
		} catch(WebDriverException e) {
			reportStep("FAIL","Browser is not responding");
		}
		
	}
	public void clickByXPath(String xpath) {
		
		try{
			driver.findElementByXPath(xpath).click();
		   reportStep("PASS","The Elemet with the XPath value "+xpath+" is found and clicked");
	}  catch (NoSuchElementException e) {
		   reportStep("FAIL","The element with the Xpath value "+xpath+" is not found");
	}   catch (ElementNotVisibleException e) {
		   reportStep("FAIL","The element with the Xpath value "+xpath+" is not visible");
	}   catch (WebDriverException e) {
		   reportStep("FAIL","Browser is not responding");
	}
		finally {
		takeSnap();
		}
			
		}

	
	public long takeSnap() {
		long number=(long) (Math.floor(Math.random()*90000000L)+1000000000000L);
          try {
			File source= driver.getScreenshotAs(OutputType.FILE);
			   File  destination=new File("./reports/images/"+number+".jpg");
			   FileUtils.copyFile(source, destination);
		} catch (WebDriverException e) {
			reportStep("FAIL","browser is not responding");
		} catch (IOException e) {
			reportStep("FAIL","There is no input file to do an output file operation");
		}
         
          return number;
	}

	public void closeWindow() {
		
		try {
			driver.close();
			System.out.println("window is closed");
		} catch (WebDriverException e) {
			System.err.println("Browser is not responding");
		}		
	}

	public void closeAllWindows() {
		try {
			driver.quit();
			System.out.println("Browser is closed");
		} catch (WebDriverException e) {
                   System.err.println("Browser is not responding");
		}
	}
}
