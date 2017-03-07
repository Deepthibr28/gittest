package WebTesting_UCSC;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CheckElementStateTest {
	private WebDriver driver;

	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://selenium-testing-winwust.c9users.io/enable.html");
	}

	@Test
	public void testCheckBox() {
		WebElement chkbox = driver.findElement(By.cssSelector("input[type=checkbox]"));
		WebElement select = driver.findElement(By.tagName("select"));
		WebElement display = driver.findElement(By.id("display"));
		assertFalse(chkbox.isSelected());
		assertFalse(select.isEnabled());
		assertFalse(display.isDisplayed());
	}
	
	@Test
	public void testCheckBoxClick() {
		WebElement chkbox = driver.findElement(By.cssSelector("input[type=checkbox]"));
		chkbox.click();
		WebElement select = driver.findElement(By.tagName("select"));
		WebElement display = driver.findElement(By.id("display"));
		assertTrue(chkbox.isSelected());
		assertTrue(select.isEnabled());
		assertTrue(display.isDisplayed());
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}
