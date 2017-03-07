package WebTesting_UCSC;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitCustomExpectedConditionThreeTest {
	private WebDriver driver;

	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://selenium-testing-winwust.c9users.io/jswaitec2.html");
	}

	@Test
	public void testClickButton() {
		WebElement input = driver.findElement(By.id("name"));
		input.sendKeys("John");
		WebElement button = driver.findElement(By.id("btn"));
		button.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.findElement(By.id("display")).isDisplayed();
			}
		});
		
		WebElement display = driver.findElement(By.id("display"));		
		assertEquals("John", display.getText());		
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}
