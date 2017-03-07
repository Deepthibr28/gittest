package WebTesting_UCSC;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ConfirmationTest {
	private WebDriver driver;

	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://selenium-testing-winwust.c9users.io/confirm.html");
	}

	@Test
	public void testConfirmDismiss() {
		WebElement button = driver.findElement(By.cssSelector("input[type=button]"));
		button.click();
		
		Alert alert = driver.switchTo().alert();
		
		alert.dismiss();
		
		WebElement message = driver.findElement(By.tagName("p"));
		assertEquals("Thank you!", message.getText());
	}
	
	@Test
	public void testConfirmAccept() {
		WebElement button = driver.findElement(By.cssSelector("input[type=button]"));
		button.click();
		
		Alert alert = driver.switchTo().alert();
		
		alert.accept();
		
		String url = driver.getCurrentUrl();
		
		try {
			String host = new URI(url).getHost();
			System.out.println(url);
			System.out.println(host);
			
			assertEquals("www.google.com", host);
		} catch (URISyntaxException e) {
			fail("bad URL");
		}
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}
