package WebTesting_UCSC;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementByIdTest {
	private WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./src/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();	
		driver.get("https://selenium-testing-winwust.c9users.io/helloworld.html");		
	}
	
	@Test
	public void testFindElementById() {
		
		WebElement element = driver.findElement(By.id("title"));
		String titleText = element.getText();
		
		assertEquals("Hello World", titleText);
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}
