package WebTesting_UCSC;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class IframeTest {
	private WebDriver driver;

	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://selenium-testing-winwust.c9users.io/iframe.html");
	}

	@Test
	public void testClickButton() {
		WebElement iframe = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(iframe);
		
		WebElement button = driver.findElement(By.cssSelector("input[type=button]"));
		button.click();
		
		Alert alert = driver.switchTo().alert();
		
		assertEquals("Hello World", alert.getText());
		
		alert.accept();
		
		driver.switchTo().defaultContent();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}
