package WebTesting_UCSC;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JqueryTabsTest {
	private WebDriver driver;
	
	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("file:///D:/Deepthi_Home/Selenium/webtesting/workspace/jqueryTabs.html");
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void testTabsDefault() {
		JqueryTabs tabs = new JqueryTabs(driver.findElement(By.id("tabs")));
		assertEquals(4, tabs.getTabCount());
		assertEquals("Hello World", tabs.getSelectedTabTitle());
		assertEquals("tab1", tabs.getSelectedTabContent().getAttribute("id"));
	}
	
	@Test
	public void testTabSwitch() {
		JqueryTabs tabs = new JqueryTabs(driver.findElement(By.id("tabs")));
		tabs.selectTabByIndex(2);
		assertEquals("Embedded Form", tabs.getSelectedTabTitle());
		assertEquals("tab3", tabs.getSelectedTabContent().getAttribute("id"));
	}
	
	@Test
	public void TestTabSwitch2() {
		JqueryTabs tabs = new JqueryTabs(driver.findElement(By.id("tabs")));
		tabs.selectTabByTitle("Yellow Square");
		WebElement yellowSquare = tabs.getSelectedTabContent().findElement(By.id("square"));
		assertEquals("rgba(255, 255, 0, 1)", yellowSquare.getCssValue("background-color"));
		tabs.selectTabByTitle("Red Square");
		WebElement redSquare = tabs.getSelectedTabContent().findElement(By.id("square"));
		assertEquals("rgba(255, 0, 0, 1)", redSquare.getCssValue("background-color"));
	}
}
