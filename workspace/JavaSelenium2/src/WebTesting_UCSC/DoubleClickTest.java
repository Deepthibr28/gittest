package WebTesting_UCSC;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClickTest {
	private WebDriver driver;

	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://selenium-testing-winwust.c9users.io/dblclick.html");
	}

	@Test
	public void testDoubleClick() {
		WebElement element = driver.findElement(By.id("square"));
		assertEquals("rgba(255, 255, 0, 1)", element.getCssValue("background-color"));
		Actions builder = new Actions(driver);
		builder.doubleClick(element).perform();
		assertEquals("rgba(255, 0, 0, 1)", element.getCssValue("background-color"));
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

}
