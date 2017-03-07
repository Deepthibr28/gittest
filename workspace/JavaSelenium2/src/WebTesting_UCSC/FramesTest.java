package WebTesting_UCSC;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FramesTest {
	private WebDriver driver;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
		        "src/test/resources/chromedriver");

		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("http://selenium-testing-winwust.c9users.io/frames.html");
	}

	@Test
	public void testLeftFrame() {
		driver.switchTo().frame("left");
		WebElement element = driver.findElement(By.id("square"));
		assertEquals("rgba(255, 0, 0, 1)", element.getCssValue("background-color"));
		driver.switchTo().defaultContent();
	}
	
	@Test
	public void testMiddleFrame() {
		driver.switchTo().frame("hello");
		WebElement element = driver.findElement(By.tagName("h1"));
		assertEquals("Hello World", element.getText());
		driver.switchTo().defaultContent();
	}
	
	@Test
	public void testRightFrame() {
		driver.switchTo().frame(driver.findElement(By.cssSelector("frame[src$='form.html']")));
		WebElement element = driver.findElement(By.xpath("//form/label"));
		assertEquals("Your Name", element.getText());
		
		WebElement input = driver.findElement(By.id("name"));
		WebElement button = driver.findElement(By.id("btn"));
		
		input.sendKeys("John");
		button.click();
		
		WebElement message = driver.findElement(By.tagName("p"));
		assertEquals("Hello John", message.getText());
		driver.switchTo().defaultContent();
	}
	
	@Test
	public void testAllFrames() {
		List<WebElement> frames = driver.findElements(By.tagName("frame"));
		
		int frameIndex = 0;
		WebElement element;
		for (WebElement frame : frames) {
			driver.switchTo().frame(frame);
			switch (frameIndex) {
				case 0:
					element = driver.findElement(By.id("square"));
					assertEquals("rgba(255, 0, 0, 1)", element.getCssValue("background-color"));				
					break;
				case 1:
					element = driver.findElement(By.tagName("h1"));
					assertEquals("Hello World", element.getText());
					break;
				case 2: 
					element = driver.findElement(By.xpath("//form/label"));
					assertEquals("Your Name", element.getText());				
					break;
				default:
					fail("invalid frame");
			}
			frameIndex++;
			driver.switchTo().defaultContent();
		}
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}
