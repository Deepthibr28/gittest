package WebTesting_UCSC;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import static org.junit.Assert.*;

public class AmazonHomePage extends LoadableComponent<AmazonHomePage> {
	private WebDriver driver;
	
	private String url = "http://www.amazon.com/";
	private String title = "Amazon.com";
	
	public AmazonHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@Override
	protected void isLoaded() throws Error {
		assertTrue("Amazon home page cannot be loaded", driver.getTitle().startsWith(title));
	}

	@Override
	protected void load() {
		driver.get(url);
	}
	
	public AmazonSearch getSearch() {
		return new AmazonSearch(driver);
	}
}
