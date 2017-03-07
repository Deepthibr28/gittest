package tutorialselenium.Introduction;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FindEementsByLocators {
	private WebDriver driver;
	private String baseurl1, baseurl2, baseurl3;

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseurl1 = "file:///D:/Deepthi_Home/Selenium/webtesting/workspace/helloworld.html";
		baseurl2 = "file:///D:/Deepthi_Home/Selenium/webtesting/workspace/search.html";
		baseurl3 = "file:///D:/Deepthi_Home/Selenium/webtesting/workspace/links.html";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void test_find_element_by_id() {
		driver.get(baseurl1);
		WebElement el = driver.findElement(By.id("title"));
		assertEquals(el.getText(), "Hello World");
	}

	@Test
	public void test_find_element_by_name() {
		driver.get(baseurl2);
		WebElement el = driver.findElement(By.name("keyword"));
		el.clear();
		el.sendKeys("Deepthi");
		assertEquals(el.getAttribute("value"), "Deepthi");
	}

	@Test
	public void test_find_element_by_class_name() {
		driver.get(baseurl2);
		WebElement element = driver.findElement(By.className("label"));
		assertEquals("Search", element.getText());
	}

	@Test
	public void test_find_element_by_link_text() {
		driver.get(baseurl3);
		WebElement element = driver.findElement(By.linkText("Google site"));
		assertEquals("https://www.google.com/", element.getAttribute("href"));
	}

	@Test
	public void test_find_element_by_partial_link_text() {
		driver.get(baseurl3);
		WebElement element = driver.findElement(By.partialLinkText("MSN"));
		assertEquals("http://www.msn.com/", element.getAttribute("href"));
	}

	@Test
	public void test_find_elements_by_tag_name() {
		driver.get(baseurl3);
		List<WebElement> links = driver.findElements(By.tagName("a"));
		assertEquals(7, links.size());
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

}
