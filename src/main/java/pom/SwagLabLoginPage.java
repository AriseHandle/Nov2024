package pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SwagLabLoginPage {

	@FindBy (xpath = "//input[@placeholder='Username']") private WebElement userName;
	@FindBy (xpath = "//input[@placeholder='Password']") private WebElement password;
	@FindBy (xpath = "//input[@id='login-button']") private WebElement login;
	
	public SwagLabLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void enterUserName(String user) {
		userName.sendKeys(user);
	}
	
	public void enterPassword(String pass, WebDriver driver) {
		password.sendKeys(pass);
	}
	
	public void clickOnLogin() {
		login.click();
	}
}
