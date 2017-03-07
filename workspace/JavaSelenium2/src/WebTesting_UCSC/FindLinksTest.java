package WebTesting_UCSC;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

public class FindLinksTest {
	private WebDriver driver;

	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://selenium-testing-winwust.c9users.io/links.html");
	}

	@Test
	public void testFindElementByLinkText() {
		WebElement element = driver.findElement(By.linkText("Google Link"));
		assertEquals("http://www.google.com/", element.getAttribute("href"));
	}
	
	@Test
	public void testFindElementByPartialLinkText() {
		WebElement element = driver.findElement(By.partialLinkText("MSN"));
		assertEquals("http://www.msn.com/", element.getAttribute("href"));
	}
	
	@Test
	public void testFindElementsByTagName() {
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		assertEquals(4, links.size());
		
		for(WebElement link : links) {
			System.out.println(link.getAttribute("href"));
		}
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}
