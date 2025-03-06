package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabCartPage {

	@FindBy (xpath = "//div[@class='cart_item']")private List<WebElement> produts;
	@FindBy (xpath = "//span[@data-test='title']")private WebElement title;
	@FindBy (xpath = "//button[@id='continue-shopping']")private WebElement continueShopping;
	@FindBy (xpath = "//button[@id='checkout']")private WebElement checkout;
	@FindBy (xpath = "//div[@class='inventory_item_name']")private List<WebElement> productName;
	@FindBy (xpath = "//div[@class='inventory_item_price']")private List<WebElement> productPrice;
	
	public SwagLabCartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public int getNumberProductInCart() {
		return produts.size();
	}
	
	public String getCartTitle() {
		return title.getText();
	}
	
	public void clicOnContinueShipping() {
		continueShopping.click();
	}
	
	public void clickOnCheckout() {
		checkout.click();
	}
	
	public String getProductName(int index) {
		return productName.get(index).getText();
	}
	
	public double getProductPrice(int index) {
		String price =productPrice.get(index).getText().substring(1);
		return Double.parseDouble(price);
	}
}
