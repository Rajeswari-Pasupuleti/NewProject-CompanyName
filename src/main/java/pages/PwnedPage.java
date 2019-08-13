package pages;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.GenericWrapper;

public class PwnedPage extends GenericWrapper {
	
	public PwnedPage(RemoteWebDriver driver,ExtentTest test) {
		this.driver=driver;
		this.test=test;
	}
	@Test
	public PwnedPage enterEmail2(String text) {
		enterByXPath(prop.getProperty("PwnedPage.Email2.EnterByXPath"),text);
		return this;
	}
	@Test
	public PwnedPage clickSubmitBtn2() {
		System.out.print("Hello submit button testcase2");
		clickByXPath(prop.getProperty("PwnedPage.SubmitBtn2.ClickByXPath"));
		return this;
	}
	 


}
