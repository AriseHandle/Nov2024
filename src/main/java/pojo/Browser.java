package pojo;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {
	
	public static WebDriver openBrowser(String url) {
		//Browser..setProperty("webdriver.chrome.driver", "C:\\Users\\91877\\Downloads\\chromedriver-win64 (12)\\chromedriver-win64\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get(url);
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		
		return driver;
		
	}
}
