package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.SwagLabCartPage;
import pom.SwagLabCheckoutOverviewPage;
import pom.SwagLabHomePage;
import pom.SwagLabLoginPage;
import pom.SwagLabYourInfoPage;

@Listeners (test.Listeners.class)
public class CheckoutOverviewTest extends BaseTest {
	
	@BeforeMethod
	public void launchApplication() {
		driver =Browser.openBrowser("https://www.saucedemo.com/");
		SwagLabLoginPage swagLabLoginPage = new SwagLabLoginPage(driver);
		swagLabLoginPage.enterUserName("standard_user");
		swagLabLoginPage.enterPassword("secret_sauce", driver);
		swagLabLoginPage.clickOnLogin();
	}
	
	@Test
	public void verifyPriceCaculationOnCartOverviewPage() {
		test = reports.createTest("verifyPriceCaculationOnCartOverviewPage");
		SwagLabHomePage swagLabHomePage = new SwagLabHomePage(driver);
		swagLabHomePage.addProductToCart(0);
		swagLabHomePage.clickOnCart();
		
		SwagLabCartPage swagLabCartPage = new SwagLabCartPage(driver);
		swagLabCartPage.clickOnCheckout();
		
		SwagLabYourInfoPage swagLabYourInfoPage =new SwagLabYourInfoPage(driver);
		swagLabYourInfoPage.enterFirstName("Arise");
		swagLabYourInfoPage.enterLastName("Pune");
		swagLabYourInfoPage.enterZipCode("411032");
		swagLabYourInfoPage.clickOnContinue();
		
		SwagLabCheckoutOverviewPage swagLabCheckoutOverviewPage = new SwagLabCheckoutOverviewPage(driver);
		swagLabCheckoutOverviewPage.getTax();;

	}
	
}
