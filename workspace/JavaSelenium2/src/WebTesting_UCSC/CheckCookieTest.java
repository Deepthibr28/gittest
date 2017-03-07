package WebTesting_UCSC;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CheckCookieTest {
	private WebDriver driver;

	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://selenium-testing-winwust.c9users.io/cookie.php");
	}

	@Test
	public void testCookie() {
		Cookie siteCookie = driver.manage().getCookieNamed("user");
		assertEquals("JohnDoe", siteCookie.getValue());
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}
