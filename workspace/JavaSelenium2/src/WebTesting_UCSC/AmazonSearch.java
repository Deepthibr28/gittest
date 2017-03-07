package WebTesting_UCSC;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AmazonSearch {
	private WebDriver driver;
	
	@FindBy(how=How.ID, using="twotabsearchtextbox")
	private WebElement search;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"nav-search\"]/form/div[2]/div/input")
	private WebElement searchButton;
	
	public AmazonSearch(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public AmazonSearchResult search(String query) {
		search.sendKeys(query);
		searchButton.click();
		return new AmazonSearchResult(driver, query);
	}
}
