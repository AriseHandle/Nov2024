package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.SwagLabHomePage;
import pom.SwagLabLoginPage;

@Listeners(test.Listeners.class)
public class SawgLabLogoutTest extends BaseTest{
	
	
	@BeforeMethod
	public void launchApplication() {
		driver =Browser.openBrowser("https://www.saucedemo.com/");
	}
	
	@Test
	public void verifyIfUserIsAbleToLogout(){
		test =reports.createTest("verifyIfUserIsAbleToLogout");
		SwagLabLoginPage swagLabLoginPage = new SwagLabLoginPage(driver);
		swagLabLoginPage.enterUserName("standard_user");
		swagLabLoginPage.enterPassword("secret_sauce", driver);
		swagLabLoginPage.clickOnLogin();
		
		SwagLabHomePage swagLabHomePage =new SwagLabHomePage(driver);
		swagLabHomePage.clickOnMenu();
		swagLabHomePage.clickOnLogOut();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
	}
	
	
}
