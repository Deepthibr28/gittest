package tutorialselenium.PageClasses;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class FrameworkTestCase {
	private WebDriver driver;
	private String baseUrl;
	SearchPageFactory searchPage;

	@Before
	public void beforeClass() {
		driver = new FirefoxDriver();
		baseUrl = "https://www.expedia.com/";
		
		searchPage = new SearchPageFactory(driver);

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}

	@Test
	public void test() throws Exception {
		searchPage.clickFlightsTab();
		searchPage.setOriginCity("New York");
		searchPage.setDestinationCity("San Francisco");
		searchPage.setDepartureDate("10/28/2017");
		searchPage.setReturnDate("10/31/2017");
		searchPage.clickSearchButton();
		
	}

	@After
	public void afterClass() throws Exception {
		WebDriverWait wait= new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("acol-interstitial")));
		driver.quit();
		Wait<WebDriver> wait1= new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS).pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		WebElement display = wait1.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver d) {
				return d.findElement(By.id("display"));
			}
		});
	}
}