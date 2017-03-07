package WebTesting_UCSC;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.*;

public class CssTest {
	private WebDriver driver;
	
	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://selenium-testing-winwust.c9users.io/css.html");
	}
	
	@Test
	public void testH1Style() {
		WebElement h1 = driver.findElement(By.tagName("h1"));
		assertEquals("center", h1.getCssValue("text-align"));
		//assertEquals("#333333", h1.getCssValue("color"));
		assertEquals("rgba(51, 51, 51, 1)", h1.getCssValue("color"));
		//assertEquals("yellow", h1.getCssValue("background-color"));
		assertEquals("rgba(255, 255, 0, 1)", h1.getCssValue("background-color"));
	}
	
	@Test
	public void testH2Style() {
		WebElement h2 = driver.findElement(By.tagName("h2"));
		assertEquals("solid", h2.getCssValue("border-top-style"));
		assertEquals("1px", h2.getCssValue("border-top-width"));
		assertEquals("rgba(51, 51, 51, 1)", h2.getCssValue("border-top-color"));
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
}
