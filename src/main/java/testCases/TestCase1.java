package testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.NotPewnedPage;
import utils.ProjectWrappers;

public class TestCase1 extends ProjectWrappers {
	
	@BeforeClass
	public void beforeClass()
	{
		testCaseName="PerseusCaseStudy";
		testCaseDescription="NotPwned Page";
		category="Functional";
		BrowserName="chrome";
	}
	@Test
	public void NotPwned() {
		new NotPewnedPage(driver,test)
		.enterEmail1("test@something.com")
		.clickSubmitBtn1();
	}
}