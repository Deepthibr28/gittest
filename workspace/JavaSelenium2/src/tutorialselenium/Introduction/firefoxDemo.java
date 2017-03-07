package tutorialselenium.Introduction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class firefoxDemo {

	public static void main(String[] args) {
		
		WebDriver driver;
		driver = new FirefoxDriver();
		String baseURL = "http://www.google.com";
		
		driver.get(baseURL);

	}

}
