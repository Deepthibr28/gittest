package WebTesting_UCSC;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import static org.junit.Assert.*;

import java.util.List;

public class AmazonSearchResult extends LoadableComponent<AmazonSearchResult>{
	private WebDriver driver;
	private String query;
	
	@FindBy(how=How.ID, using="s-results-list-atf")
	private WebElement resultList;
	
	public AmazonSearchResult(WebDriver driver, String query) {
		this.driver = driver;
		this.query = query;
		PageFactory.initElements(driver, this);
	}
	
	@Override
	protected void isLoaded() throws Error {
		assertEquals("Amazon.com: " + query, driver.getTitle());		
	}

	@Override
	protected void load() {
		// TODO Auto-generated method stub
	}

	public int getListSize() {
		List<WebElement> books = resultList.findElements(By.xpath("./li"));
		return books.size();
	}
	
	public String getFirstBookTitle() {
		WebElement first = resultList.findElement(By.xpath("./li//h2"));
		return first.getText();
	}
}
