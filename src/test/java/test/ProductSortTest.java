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
public class ProductSortTest extends BaseTest {

	@BeforeMethod
	public void launchApplication() {
		driver =Browser.openBrowser("https://www.saucedemo.com/");
		SwagLabLoginPage swagLabLoginPage = new SwagLabLoginPage(driver);
		swagLabLoginPage.enterUserName("standard_user");
		swagLabLoginPage.enterPassword("secret_sauce", driver);
		swagLabLoginPage.clickOnLogin();
	}
	
	@Test
	public void verifySortingOfProductWithZToA() {
		test =  reports.createTest("verifySortingOfProductWithZToA");
		SwagLabHomePage swagLabHomePage = new SwagLabHomePage(driver);
		String firstProduct =swagLabHomePage.getProductName(0);
		String lastProduct = swagLabHomePage.getProductName(5);
		swagLabHomePage.selectSortType("Name (Z to A)");
		Assert.assertEquals(swagLabHomePage.getProductName(0), lastProduct);
		Assert.assertEquals(swagLabHomePage.getProductName(5), firstProduct);
	}
	
	@Test (dependsOnMethods = "verifySortingOfProductWithZToA")
	public void verifySortingProductWithAtoZ() {
		test = reports.createTest("verifySortingProductWithAtoZ");
		SwagLabHomePage swagLabHomePage = new SwagLabHomePage(driver);
		swagLabHomePage.selectSortType("Name (Z to A)");
		String firstProduct =swagLabHomePage.getProductName(0);
		String lastProduct = swagLabHomePage.getProductName(5);
		swagLabHomePage.selectSortType("Name (A to Z)");
		Assert.assertEquals(swagLabHomePage.getProductName(0), lastProduct);
		Assert.assertEquals(swagLabHomePage.getProductName(5), firstProduct);
	}
	
	@Test
	public void verifySortingWithPriceLowToHigh() {
		test = reports.createTest("verifySortingWithPriceLowToHigh");
		SwagLabHomePage swagLabHomePage = new SwagLabHomePage(driver);
		swagLabHomePage.selectSortType("Price (low to high)");
		Assert.assertTrue(swagLabHomePage.getProductPrice(0)<=swagLabHomePage.getProductPrice(1));
		Assert.assertTrue(swagLabHomePage.getProductPrice(1)<=swagLabHomePage.getProductPrice(2));
		Assert.assertTrue(swagLabHomePage.getProductPrice(2)<=swagLabHomePage.getProductPrice(3));
		Assert.assertTrue(swagLabHomePage.getProductPrice(3)<=swagLabHomePage.getProductPrice(4));
		Assert.assertTrue(swagLabHomePage.getProductPrice(4)<=swagLabHomePage.getProductPrice(5));
	}
	
	@Test
	public void verifySortingWithPriceHighToLow() {
		test = reports.createTest("verifySortingWithPriceHighToLow");
		SwagLabHomePage swagLabHomePage = new SwagLabHomePage(driver);
		swagLabHomePage.selectSortType("Price (high to low)");
		Assert.assertTrue(swagLabHomePage.getProductPrice(0)>=swagLabHomePage.getProductPrice(1));
		Assert.assertTrue(swagLabHomePage.getProductPrice(1)>=swagLabHomePage.getProductPrice(2));
		Assert.assertTrue(swagLabHomePage.getProductPrice(2)>=swagLabHomePage.getProductPrice(3));
		Assert.assertTrue(swagLabHomePage.getProductPrice(3)>=swagLabHomePage.getProductPrice(4));
		Assert.assertTrue(swagLabHomePage.getProductPrice(4)>=swagLabHomePage.getProductPrice(5));
	}
}
