package WebTesting_UCSC;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AmazonSearchTest {
	private WebDriver driver;
	
	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void testBookSearch() {
		AmazonHomePage home = new AmazonHomePage(driver);
		home.get();
		AmazonSearchResult result = home.getSearch().search("selenium webdriver");
		assertEquals(16, result.getListSize());
		assertEquals("Selenium WebDriver Practical Guide", result.getFirstBookTitle());
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
}
