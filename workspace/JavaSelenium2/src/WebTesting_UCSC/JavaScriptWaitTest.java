package WebTesting_UCSC;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JavaScriptWaitTest {
	private WebDriver driver;

	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://selenium-testing-winwust.c9users.io/jswait.html");
	}

	@Test
	public void testClickButton() {
//		WebElement input = driver.findElement(By.id("name"));
//		input.sendKeys("John");
//		WebElement button = driver.findElement(By.id("btn"));
//		button.click();
//		
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		WebElement display = driver.findElement(By.id("display"));		
//		assertEquals("John", display.getText());
				
		WebElement input = driver.findElement(By.id("name"));
		input.sendKeys("John");
		WebElement button = driver.findElement(By.id("btn"));
		button.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("display")));
		
		WebElement display = driver.findElement(By.id("display"));		
		assertEquals("John", display.getText());		
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}
