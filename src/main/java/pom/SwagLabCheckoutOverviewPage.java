package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabCheckoutOverviewPage {

	@FindBy (xpath = "//div[@data-test='inventory-item']")private List<WebElement> products;
	@FindBy (xpath = "//div[@class='inventory_item_name']")private List<WebElement> productName;
	@FindBy (xpath = "//div[@class='inventory_item_price']")private List<WebElement> productPrice;
	@FindBy (xpath = "//div[@class='summary_subtotal_label']")private WebElement itemTotal;
	@FindBy (xpath = "//div[@class='summary_tax_label']")private WebElement tax;
	@FindBy (xpath = "//div[@class='summary_total_label']")private WebElement total;
	@FindBy (xpath = "//button[@id='cancel']")private WebElement cancel;
	@FindBy (xpath = "//button[@id='finish']")private WebElement finish;
	
	public SwagLabCheckoutOverviewPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public int getNumberOfProduct() {
		return products.size();
	}
	
	public String getProductName(int index) {
		return productName.get(index).getText();
	}
	
	public  double  getProductPrice(int index) {
		String price =productName.get(index).getText().substring(1);
		return Double.parseDouble(price);
	}
	
	public double getItemTotal() {
		String total =itemTotal.getText().substring(13);
		return Double.parseDouble(total);
	}
	
	public double getTax() {
		String taxAmount =tax.getText().substring(6);
		return Double.parseDouble(taxAmount);	
	}
	
	public double getPriceTotal() {
		String price = total.getText().substring(9);
		return Double.parseDouble(price);
	}
}
