package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pojo.Browser;
import pom.SwagLabLoginPage;

@Listeners (test.Listeners.class)
public class SwagLabLoginTest extends BaseTest {
	
	@BeforeMethod
	public void launchApplication() {
		driver =Browser.openBrowser("https://www.saucedemo.com/");
	}
	
	@Test
	public void verifySwagLabLogin() {
		test =reports.createTest("verifySwagLabLogin");
		SwagLabLoginPage swagLabLoginPage =new SwagLabLoginPage(driver);
		swagLabLoginPage.enterUserName("standard_user");
		swagLabLoginPage.enterPassword("secret_sauce",driver);
		swagLabLoginPage.clickOnLogin();
		SoftAssert softAssert = new SoftAssert(); 
		softAssert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html" );//Hard Assert
		System.out.println("Thanks");
		softAssert.assertAll();
	}
	
	
	
	@AfterMethod
	public void closeBrowser() {
		//driver.close();
	}
}
