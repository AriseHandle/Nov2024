package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pojo.Browser;
import pom.SwagLabCartPage;
import pom.SwagLabHomePage;
import pom.SwagLabLoginPage;

@Listeners(test.Listeners.class)
public class AddToCartTest extends BaseTest {
	@BeforeMethod
	public void launchApplication() {
		driver =Browser.openBrowser("https://www.saucedemo.com/");
		SwagLabLoginPage swagLabLoginPage = new SwagLabLoginPage(driver);
		swagLabLoginPage.enterUserName("standard_user");
		swagLabLoginPage.enterPassword("secret_sauce", driver);
		swagLabLoginPage.clickOnLogin();
	}
	
	@Test
	public void verifyOnCLickingAddToCartRemoveOptionIsDisplayed() {
		test =reports.createTest("verifyOnCLickingAddToCartRemoveOptionIsDisplayed");
		SwagLabHomePage swagLabHomePage = new SwagLabHomePage(driver);
		swagLabHomePage.addProductToCart(0);
		Assert.assertTrue(swagLabHomePage.isRemoveButtonDisplayed(0));
	}
	
	@Test
	public void verfiyIfUserIsAbleProductToCart() {
		test =reports.createTest("verfiyIfUserIsAbleProductToCart");
		SwagLabHomePage swagLabHomePage = new SwagLabHomePage(driver);
		swagLabHomePage.addProductToCart(0);
		swagLabHomePage.clickOnCart();
		SwagLabCartPage swagLabCartPage = new SwagLabCartPage(driver);
		
	}
	
	@Test
	public void verifyIfUserIsAbletoRemoveAddedProductToCartFromHomePage() {
		reports.createTest("verifyIfUserIsAbletoRemoveAddedProductToCartFromHomePage");
		SwagLabHomePage swagLabHomePage = new SwagLabHomePage(driver);
		swagLabHomePage.addProductToCart(0);
		swagLabHomePage.clickOnCart();
		
		SwagLabCartPage swagLabCartPage = new SwagLabCartPage(driver);
		Assert.assertEquals(swagLabCartPage.getNumberProductInCart(), 1);
		swagLabCartPage.clicOnContinueShipping();
		swagLabHomePage.removeProductFromCart(0);
		swagLabHomePage.clickOnCart();
		Assert.assertEquals(swagLabCartPage.getNumberProductInCart(), 0);
		
	}
	
	@Test
	public void verifyUserIsAbleToRemoveProductFromCart() {
		
	}
	
	@Test
	public void verifyIfCorrectProuctIsAddedToCart() {
		test =reports.createTest("verifyIfCorrectProuctIsAddedToCart");
		SwagLabHomePage swagLabHomePage = new SwagLabHomePage(driver);
		swagLabHomePage.addProductToCart(0);
		String productNameOnHomePage =swagLabHomePage.getProductName(1);
		double priceOnHomePage =swagLabHomePage.getProductPrice(1);
		swagLabHomePage.clickOnCart();
		
		SwagLabCartPage swagLabCartPage = new SwagLabCartPage(driver);
		SoftAssert softAssert =new SoftAssert();
		softAssert.assertEquals(swagLabCartPage.getProductName(0),productNameOnHomePage);
		softAssert.assertEquals(swagLabCartPage.getProductPrice(0), priceOnHomePage);
		softAssert.assertAll();
	}
}
