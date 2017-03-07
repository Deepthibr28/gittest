package WebTesting_UCSC;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AmazonBookTest {
	private WebDriver driver;
	
	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.amazon.com/");
	}
	
	@Test
	public void testAmazonBookSearch() {
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchBox.clear();
		searchBox.sendKeys("Selenium WebDriver");
		
		WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"nav-search\"]/form/div[2]/div/input"));
		searchButton.click();
		
		WebElement result = driver.findElement(By.id("s-result-count"));
		
		assertEquals("1-16 of 64 results for \"Selenium WebDriver\"", result.getText());
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
}
