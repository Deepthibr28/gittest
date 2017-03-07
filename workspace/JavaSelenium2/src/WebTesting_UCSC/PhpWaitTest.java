package WebTesting_UCSC;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PhpWaitTest {
	private WebDriver driver;

	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://selenium-testing-winwust.c9users.io/wait.php");
	}

	@Test
	public void testClickButton() {
		WebElement input = driver.findElement(By.id("name"));
		input.sendKeys("John");
		input.submit();
		WebElement display = driver.findElement(By.id("display"));		
		assertEquals("John", display.getText());
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}
