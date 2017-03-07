package tutorialselenium.Introduction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ieDemo {

	public static void main(String[] args) throws Exception {
		
		WebDriver driver;
		System.setProperty("webdriver.ie.driver", "C:\\Users\\Arjun BR\\workspace\\Downloads\\drivers\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		String baseURL = "http://www.google.com";
		
		driver.get(baseURL);
		Thread.sleep(2000);
		driver.quit();

	}

}
