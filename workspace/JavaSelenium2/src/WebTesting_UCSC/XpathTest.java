package WebTesting_UCSC;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class XpathTest {
	private WebDriver driver;

	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://selenium-testing-winwust.c9users.io/xpath.html");
	}

	@Test
	public void testFindListElements() {
		WebElement li1 = driver.findElement(By.xpath("//ul/li[position()=3]"));
		WebElement li2 = driver.findElement(By.xpath("//ul/li[last()-1]"));
		WebElement li3 = driver.findElement(By.xpath("(//li)[1]"));
		WebElement li4 = driver.findElement(By.xpath("(//li)[last()]"));
		assertEquals("3", li1.getText());
		assertEquals("2", li2.getText());
		assertEquals("1", li3.getText());
		assertEquals("Spanish", li4.getText());
	}
	
	@Test
	public void testFindLists() {
		WebElement ul = driver.findElement(By.xpath("(//li)[1]/.."));
		WebElement ul2 = driver.findElement(By.xpath("(//li)[last()]/.."));
		assertEquals("list", ul.getAttribute("id"));
		assertEquals("languages", ul2.getAttribute("id"));
	}
	
	@Test
	public void testInputValues() {
		WebElement input = driver.findElement(By.xpath("//input[@type='text'][starts-with(@name, 'username')]"));
		WebElement pass = driver.findElement(By.xpath("//input[@type='password'][starts-with(@name, 'password')]"));
		assertEquals("Type your username", input.getAttribute("value"));
		assertEquals("secret", pass.getAttribute("value"));
	}
	
	@Test
	public void testTable() {
		WebElement tb = driver.findElement(By.xpath("//td[text()='Books']/ancestor::table"));
		WebElement tr = driver.findElement(By.xpath("//tr[@id='row']/following-sibling::tr"));
		WebElement tr2 = driver.findElement(By.cssSelector("tbody > tr:nth-child(3)"));
		assertEquals("tbl", tb.getAttribute("id"));
		assertEquals("DVDs $45 200", tr.getText());
		assertEquals("Toys $100 35", tr2.getText());
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}
