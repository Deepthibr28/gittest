package WebTesting_UCSC;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Predicate;

public class FluentWaitPredicateTest {
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
		
		FluentWait<By> wait = new FluentWait<By>(By.id("display"))
				.withTimeout(10, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		
		wait.until(new Predicate<By>() {
			public boolean apply(By by) {
				return driver.findElement(by).isDisplayed();
			}
		});
		
		assertEquals("John", driver.findElement(By.id("display")).getText());
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}
