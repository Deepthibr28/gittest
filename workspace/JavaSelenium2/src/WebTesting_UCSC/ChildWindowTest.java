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

public class ChildWindowTest {
	private WebDriver driver;

	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://selenium-testing-winwust.c9users.io/childwindow.html");
	}

	@Test
	public void testPopupWindow() {
		String parentWindowId = driver.getWindowHandle();
		System.out.println(parentWindowId);
		
		WebElement button = driver.findElement(By.cssSelector("input[type=button]"));
		button.click();
		
		driver.switchTo().window("HelpWindow");
		String popupWindowId = driver.getWindowHandle();
		System.out.println(popupWindowId);
		
		assertEquals("Q & A", driver.findElement(By.tagName("h1")).getText());

		driver.close();
		
		driver.switchTo().window(parentWindowId);
		
		WebElement button2 = driver.findElement(By.cssSelector("input[type=button]"));
		assertEquals("Click Me", button2.getAttribute("value"));
	}
	
	@Test
	public void TestPopupWindowByTitle() {
		String parentWindowId = driver.getWindowHandle();
		driver.findElement(By.cssSelector("input[type=button]")).click();
		
		for (String windowId : driver.getWindowHandles()) {
			driver.switchTo().window(windowId);
			String title = driver.getTitle();
			if (title.equals("Help")) {
				assertEquals("Q & A", driver.findElement(By.tagName("h1")).getText());
				driver.close();
				break;
			}
		}
		driver.switchTo().window(parentWindowId);
	}

	@Test
	public void TestPopupWindowByContent() {
		String parentWindowId = driver.getWindowHandle();
		driver.findElement(By.cssSelector("input[type=button]")).click();
		
		for (String windowId : driver.getWindowHandles()) {
			driver.switchTo().window(windowId);
			String content = driver.getPageSource();
			System.out.println(content);
			
			if (content.contains("Q & A")) {
				assertEquals("Q & A", driver.findElement(By.tagName("h1")).getText());
				driver.close();
				break;
			}
		}
		driver.switchTo().window(parentWindowId);
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

}
