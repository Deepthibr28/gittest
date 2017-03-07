package WebTesting_UCSC;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ButtonsVisualTest {
	private WebDriver driver;
	
	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		driver.get("https://selenium-testing-winwust.c9users.io/buttons.html");
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void compareButtonVisuals() throws IOException, InterruptedException {
		List<WebElement> buttons = driver.findElements(By.tagName("button"));
		for (WebElement button: buttons) {
			FileUtils.copyFile(WebElementExtender.captureElementPicture(button), 
					new File("target/screenshots/" + button.getAttribute("id") + ".png"));
		}
		
		assertFalse(ScreenshotChecker.CompareScreenshot("target/screenshots/btn1.png", "target/screenshots/btn2.png"));
		assertTrue(ScreenshotChecker.CompareScreenshot("target/screenshots/btn1.png", "target/screenshots/btn3.png"));
		assertFalse(ScreenshotChecker.CompareScreenshot("target/screenshots/btn1.png", "target/screenshots/btn4.png"));
	}
}
