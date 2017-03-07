package WebTesting_UCSC;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CssSelectorTest {
	private WebDriver driver;

	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://selenium-testing-winwust.c9users.io/xpath.html");
	}

	@Test
	public void testLinks() {
		WebElement safeLink = driver.findElement(By.cssSelector("li > a[href^='https']"));
		WebElement pdfLink = driver.findElement(By.cssSelector("li > a[href$='.pdf']"));
		WebElement googleLink = driver.findElement(By.cssSelector("li > a[href*='google']"));
		assertEquals("Facebook", safeLink.getText());
		assertEquals("Contract draft", pdfLink.getText());
		assertEquals("Google site", googleLink.getText());
	}
	
	@Test
	public void testForm() {
		// how about last-child and first-child?
		WebElement label = driver.findElement(By.cssSelector("form > label:last-of-type"));
		WebElement input = driver.findElement(By.cssSelector("form > input:first-of-type"));
		WebElement label2 = driver.findElement(By.cssSelector("form > input[name^='username'] + * + label"));
		assertEquals("Password:", label.getText()); // space is removed
		assertEquals("username2307", input.getAttribute("name"));
		assertEquals("Password:", label2.getText()); // why + * + label?
	}
	
	@Test
	public void testCheckboxes() {
		List<WebElement> unchecked = driver.findElements(By.cssSelector("ul#skills input[type='checkbox']:not(:checked)"));
		String[] expected = new String[] {"Python", "Ruby"};
		List<String> actual = new ArrayList<String>();
		for (WebElement uc : unchecked) {
			actual.add(uc.findElement(By.xpath("..")).getText());
		}
		assertArrayEquals(expected, actual.toArray());
	}
	
	@Test
	public void testCheckboxes2() {
		List<WebElement> checked = driver.findElements(By.cssSelector("ul#languages input[type='checkbox']:checked + label"));
		String[] expected = new String[] {"English", "Spanish"};
		List<String> actual = new ArrayList<String>();
		for (WebElement label : checked) {
			actual.add(label.getText());
		}
		assertArrayEquals(expected, actual.toArray());		
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}
