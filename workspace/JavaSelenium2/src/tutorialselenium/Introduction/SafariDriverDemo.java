package tutorialselenium.Introduction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class SafariDriverDemo {

	public static void main(String[] args) throws Exception {
		
		WebDriver driver;
		driver = new SafariDriver();
		String baseURL = "http://www.google.com";
		
		driver.get(baseURL);
		Thread.sleep(2000);
		driver.quit();

	}

}
