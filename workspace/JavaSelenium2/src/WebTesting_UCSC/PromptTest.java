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

public class PromptTest {
	private WebDriver driver;

	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://selenium-testing-winwust.c9users.io/prompt.html");
	}

	@Test
	public void testPromptDismiss() {
		WebElement button = driver.findElement(By.cssSelector("input[type=button]"));
		button.click();
		
		Alert alert = driver.switchTo().alert();
		
		alert.dismiss();
		
		WebElement message = driver.findElement(By.tagName("p"));
		assertEquals("Hello World", message.getText());
	}
	
	@Test
	public void testPromptAccept() {
		WebElement button = driver.findElement(By.cssSelector("input[type=button]"));
		button.click();
		
		Alert alert = driver.switchTo().alert();
		
		alert.sendKeys("John");
		alert.accept();
		
		WebElement message = driver.findElement(By.tagName("p"));
		assertEquals("Hello John", message.getText());
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}
