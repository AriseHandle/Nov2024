package utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;


public class Screenshot {
	
	public static void clickScreenShot(WebDriver driver, String name) throws IOException   {

		File source =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
		File destination = new File("C:\\Users\\91877\\OneDrive\\Documents\\Screenshot\\"+name+".png");
	
		FileHandler.copy(source, destination);
	}
}
