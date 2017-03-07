package tutorialselenium.Introduction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class chromeDemo {

	public static void main(String[] args) throws Exception {
		
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Arjun BR\\workspace\\Downloads\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		String baseURL = "http://www.google.com";
		
		driver.get(baseURL);
		Thread.sleep(2000);
		driver.quit();

	}

}
