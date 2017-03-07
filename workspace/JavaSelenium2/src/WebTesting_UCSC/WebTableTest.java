package WebTesting_UCSC;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebTableTest {
	private WebDriver driver;
	
	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("file:///D:/Deepthi_Home/Selenium/webtesting/workspace/webtable.html");
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void testTable() {
		WebTable table = new WebTable(driver.findElement(By.id("students")));
		assertTrue(table.hasHeader());
		assertEquals(table.getRowCount(), 4);
		assertEquals(table.getColumnCount(), 4);
		assertEquals(table.getCellData(3, 3), "MBA");
		assertEquals(table.getCellData(1, 1), "101");
	}
	
	@Test
	public void testTableWithoutHeader() {
		WebTable table = new WebTable(driver.findElement(By.id("professors")));
		assertFalse(table.hasHeader());
		assertEquals(table.getRowCount(), 3);
		assertEquals(table.getColumnCount(), 3);
		assertEquals(table.getCellData(2, 1), "Carl");
	}
}
