package tutorialselenium.TestNG;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import tutorialselenium.PageClasses.SearchPageFactory;

public class TestNG_DependentTests {
	private WebDriver driver;
	private String baseUrl;
	SearchPageFactory searchPage;
	static Logger log = Logger.getLogger(TestNG_DependentTests.class);
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		baseUrl = "https://www.expedia.com/";
		searchPage = new SearchPageFactory(driver);

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PropertyConfigurator.configure("log4j.properties");
		driver.get(baseUrl);
	}

	@Test
	public void searchFlights() throws Exception {
		searchPage.clickFlightsTab();
		searchPage.setOriginCity("New York");
		searchPage.setDestinationCity("San Francisco");
		searchPage.setDepartureDate("10/28/2017");
		searchPage.setReturnDate("10/31/2017");
		searchPage.clickSearchButton();
	}

	@Test(dependsOnMethods={ "searchFlights" })
	public void selectMorningFlight() {
		//searchPage.clickMorningFlight(driver);
	}

	@AfterClass
	public void afterClass() {
	}
}
