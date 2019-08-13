package pages;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.GenericWrapper;

public class NotPewnedPage extends GenericWrapper {
	
	public NotPewnedPage(RemoteWebDriver driver,ExtentTest test) {
		this.driver=driver;
		this.test=test;
	}
	@Test
	public NotPewnedPage enterEmail1(String text) {
		enterByXPath(prop.getProperty("NotPwnedPage.Email1.enterByXPath"),text);
		return this;
	}
	@Test
	public NotPewnedPage clickSubmitBtn1() {
		clickByXPath(prop.getProperty("NotPwnedPage.SubmitBtn1.clickByXPath"));
		return this;
	}
	
}
