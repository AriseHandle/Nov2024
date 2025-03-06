package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabYourInfoPage {

	@FindBy (xpath = "//input[@id='first-name']")private WebElement firstName;
	@FindBy (xpath = "//input[@id='last-name']")private WebElement lastName;
	@FindBy (xpath = "//input[@id='postal-code']")private WebElement zipCode;
	@FindBy (xpath = "//input[@id='continue']")private WebElement continueButton;
	@FindBy (xpath = "//button[@id='cancel']")private WebElement cancel;
	
	public SwagLabYourInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void enterFirstName(String customerFirstName){
		firstName.sendKeys(customerFirstName);
	}
	
	public void enterLastName(String customerLastName) {
		lastName.sendKeys(customerLastName);
	}
	
	public void enterZipCode(String zip) {
		zipCode.sendKeys(zip);
	}
	
	public void clickOnContinue() {
		continueButton.click();
	}
	
	public void clickOnCancel() {
		cancel.click();
	}
}
