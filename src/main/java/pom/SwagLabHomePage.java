package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SwagLabHomePage {
	@FindBy (xpath = "//button[@id='react-burger-menu-btn']")private WebElement menu; 
	@FindBy (xpath = "//a[@id='logout_sidebar_link']")private WebElement logout;
	@FindBy (xpath = "//button[text()='Add to cart']")private List<WebElement> addToCart;
	@FindBy (xpath = "//div[@class='inventory_item_name ']")private List<WebElement> productName;
	@FindBy (xpath = "//div[@class='inventory_item_price']")private List<WebElement> price;
	@FindBy (xpath = "//select[@class='product_sort_container']")private WebElement sort;
	@FindBy (xpath = "//a[@class='shopping_cart_link']")private WebElement cart;
	@FindBy (xpath = "//a[@id='about_sidebar_link']")private WebElement about;
	@FindBy (xpath = "//button[text()='Remove']")private List<WebElement> remove;
	
	public SwagLabHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnMenu() {
		menu.click();
	}
	
	public void clickOnLogOut() {
		logout.click();
	}

	public void addProductToCart(int index) {
		addToCart.get(index).click();
	}
	
	public void removeProductFromCart(int index) {
		remove.get(index).click();
	}
	
	public boolean isRemoveButtonDisplayed(int index) {
		return remove.get(index).isDisplayed();
	}
	
	public String getProductName(int index) {
		return productName.get(index).getText(); 
	}
	
	public double getProductPrice(int index) {
		String p =price.get(index).getText();
		return Double.parseDouble(p.substring(1));
	}
	
	public void selectSortType(String sortType) {
		Select select = new Select(sort);
		select.selectByVisibleText(sortType);
	}
	
	public void clickOnCart() {
		cart.click();
	}

	public void clickOnAbout() {
		about.click();
	}
}
