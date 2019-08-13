package utils;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import wrappers.GenericWrapper;

public class ProjectWrappers  extends GenericWrapper{
	
	public String BrowserName;
	
	@BeforeSuite
	public void beforeSuite() 
	{
		startReport();
	}

	@AfterSuite
	public void afterSuite() 
	{
		endReport();
	}
	
	@BeforeTest
	public void beforeTest() {
		loadObjects();
	}
	
	
	@AfterTest
	public void afterTest() {
		unLoadObjects();
	}

  @BeforeMethod
  public void beforemethod() {
	 // System.out.println("I'm in before method");
	  System.out.println("testCaseName");
	  System.out.println("testCaseDescription");
	  test=startTestCase(testCaseName,testCaseDescription);
	  System.out.println("After testCaseDescription");
	  test.assignCategory(category);
	 //System.out.println("After testCaseDescription category");

	  //invokeApp(BrowserName,"https://haveibeenpwned.com");
	  invokeApp("chrome","https://haveibeenpwned.com/");
	  
  }
  
   @AfterMethod
     public void afterMethod()
   {
       endTestCase();
   }
	
}
