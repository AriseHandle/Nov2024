package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.SwagLabHomePage;
import pom.SwagLabLoginPage;
import utility.Screenshot;

@Listeners(test.Listeners.class)
public class AboutPageTest extends BaseTest{

	@BeforeMethod
	public void launchApplication() {
		
		driver =Browser.openBrowser("https://www.saucedemo.com/");
		SwagLabLoginPage swagLabLoginPage = new SwagLabLoginPage(driver);
		swagLabLoginPage.enterUserName("standard_user");
		swagLabLoginPage.enterPassword("secret_sauce", driver);
		swagLabLoginPage.clickOnLogin();
	}
	
	@Test
	public void verifyIfAboutPageIsAccesscible() {
		test =reports.createTest("verifyIfAboutPageIsAccesscible");
		SwagLabHomePage swagLabHomePage = new SwagLabHomePage(driver);
		swagLabHomePage.clickOnMenu();
		swagLabHomePage.clickOnAbout();
		Assert.assertEquals(driver.getTitle(), "Sauce Labs: Cross Browser Testing, Selenium Testing & Mobile Testing");
		
		}
	
}
