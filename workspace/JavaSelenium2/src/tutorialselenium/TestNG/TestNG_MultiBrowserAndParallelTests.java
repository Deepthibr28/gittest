package tutorialselenium.TestNG;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;


import tutorialselenium.PageClasses.SearchPageFactory;


public class TestNG_MultiBrowserAndParallelTests {
	private WebDriver driver;
	private String baseUrl;
	SearchPageFactory searchPage;
	static Logger log = Logger.getLogger(TestNG_DependentTests.class);

	@Parameters("browserType")
	@BeforeClass
	public void beforeClass(String browser) {
		if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			// http://chromedriver.storage.googleapis.com/index.html
			System.setProperty("webdriver.chrome.driver", "/Users/tomara/Desktop/selenium/chromedriver");
			driver = new ChromeDriver();
		}
		
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

	@AfterClass
	public void afterClass() throws Exception {
		Thread.sleep(10000);
		driver.quit();
	}

}
