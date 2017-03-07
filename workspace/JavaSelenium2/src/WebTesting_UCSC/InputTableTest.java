package WebTesting_UCSC;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class InputTableTest {
	private WebDriver driver;
	
	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("file:///D:/Deepthi_Home/Selenium/webtesting/workspace/inputtable.html");
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void testInput() {
		WebTable table = new WebTable(driver.findElement(By.tagName("table")));
		WebElementExtender.highlightElement(table.getCellElement(1, 1));
		table.getCellElement(1, 1).sendKeys("John");
		WebElementExtender.highlightElement(table.getCellElement(2, 3));
		table.getCellElement(2, 3).sendKeys("Jack");
		WebElementExtender.highlightElement(table.getCellElement(4, 2));
		table.getCellElement(4, 2).sendKeys("Jason");
	}
}
