package WebTesting_UCSC;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

public class FindElementByXPath {
	private WebDriver driver;

	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://selenium-testing-winwust.c9users.io/table.html");
	}

	@Test
	public void testFindElementByXPath() {
		WebElement firstInput = driver.findElement(By.xpath("//input"));
		String firstQuality = firstInput.getAttribute("value");
		assertEquals("12", firstQuality);
	}
	
	@Test
	public void testFindElementByXPath2() {
		WebElement secondInput = driver.findElement(By.xpath("(//input)[2]"));
		String secondQuality = secondInput.getAttribute("value");
		assertEquals("5", secondQuality);		
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}
