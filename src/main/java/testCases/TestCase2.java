package testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.PwnedPage;
import utils.ProjectWrappers;

public class TestCase2 extends ProjectWrappers {
	
	@BeforeClass
	public void beforeClass()
	{
		testCaseName="PerseusCaseStudy";
		testCaseDescription="Pwned Page";
		category="Functional";
		BrowserName="chrome";
	}
	@Test
	public void Pwned() {
		new PwnedPage(driver,test)
		.enterEmail2("qwerty@somehting.com")
		.clickSubmitBtn2();
	}

}
