package WebTesting_UCSC;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class MouseKeyCombinationTest {
	private WebDriver driver;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
		        "src/test/resources/chromedriver");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://selenium-testing-winwust.c9users.io/longselect.html");
	}

	@Test
	public void testShiftClick() {
		List<WebElement> options = driver.findElements(By.xpath("//select/option"));
		List<String> actual = new ArrayList<String>();
		String[] expected = new String[] {"row 2", "row 3", "row 4", "row 5", "row 6"}; 
		
		Actions builder = new Actions(driver);
		builder.click(options.get(1))
				.keyDown(Keys.SHIFT)
				.click(options.get(5))
				.keyUp(Keys.SHIFT)
				.perform();
		
		for (WebElement option : options) {
			if (option.isSelected()) {
				actual.add(option.getText());
			}
		}
		
		assertArrayEquals(expected, actual.toArray());
	}
	
	@Test
	public void testCommandClick() {
		List<WebElement> options = driver.findElements(By.xpath("//select/option"));
		List<String> actual = new ArrayList<String>();
		String[] expected = new String[] {"row 2", "row 4", "row 5"}; 
		
		Actions builder = new Actions(driver);
		builder.click(options.get(1))
				.keyDown(Keys.COMMAND)
				.click(options.get(5))
				.click(options.get(3))
				.click(options.get(4))
				.click(options.get(5))
				.keyUp(Keys.COMMAND)
				.build().perform();
		
		for (WebElement option : options) {
			if (option.isSelected()) {
				actual.add(option.getText());
			}
		}
		
		assertArrayEquals(expected, actual.toArray());		
	}

	@Test
	public void testSelectByIndex() {
		Select select = new Select(driver.findElement(By.tagName("select")));
		List<String> actual = new ArrayList<String>();
		String[] expected = new String[] {"row 2", "row 4", "row 5"}; 

		select.selectByIndex(1);
		select.selectByIndex(5);
		select.selectByIndex(3);
		select.selectByIndex(4);
		select.deselectByIndex(5);
		
		for (WebElement option : select.getAllSelectedOptions()) {
			actual.add(option.getText());
		}
		
		assertArrayEquals(expected, actual.toArray());		
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}
