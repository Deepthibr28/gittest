package WebTesting_UCSC;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class demoAmazonBook {

	public static void main(String[] args) throws InterruptedException {
		//WebDriver driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "./src/drivers/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://www.amazon.com/");
		
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchBox.clear();
		searchBox.sendKeys("Selenium WebDriver");
		
		WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"nav-search\"]/form/div[2]/div/input"));
		searchButton.click();
		
		WebElement result = driver.findElement(By.id("s-result-count"));
		System.out.println(result.getText());
		
		
		Thread.sleep(2000);
		
		driver.quit();
	}

}
