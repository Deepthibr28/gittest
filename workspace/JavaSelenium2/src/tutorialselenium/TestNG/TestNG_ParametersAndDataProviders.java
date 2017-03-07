package tutorialselenium.TestNG;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import tutorialselenium.PageClasses.SearchPageFactory;

public class TestNG_ParametersAndDataProviders {
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
	
	@DataProvider(name="fieldsInputs")
	public static Object[][] searchData() {
		return new Object[][] {{"New York", "Chicago", "10/28/2014", "10/31/2014"},
				{"New York", "Boston", "12/28/2014", "12/31/2014"}};
	}
	
	@Parameters( { "origin", "dest", "depDate", "retDate" } )
	@Test
	public void searchFlights(String origin, String dest,
			String depDate, String retDate) throws Exception {
		searchPage.clickFlightsTab();
		searchPage.setOriginCity(origin);
		searchPage.setDestinationCity(dest);
		searchPage.setDepartureDate(depDate);
		searchPage.setReturnDate(retDate);
		searchPage.clickSearchButton();
	}
	
	@Test(dataProvider="fieldsInputs")
	public void searchFlightsWithMultiData(String origin, String dest,
			String depDate, String retDate) throws Exception {
		searchPage.clickFlightsTab();
		searchPage.setOriginCity(origin);
		searchPage.setDestinationCity(dest);
		searchPage.setDepartureDate(depDate);
		searchPage.setReturnDate(retDate);
		searchPage.clickSearchButton();
	}

	@AfterClass
	public void afterClass() {
	}

}
