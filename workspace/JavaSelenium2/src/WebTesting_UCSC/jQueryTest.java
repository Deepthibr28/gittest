package WebTesting_UCSC;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class jQueryTest {
	private WebDriver driver;
	private JavascriptExecutor js;

	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://selenium-testing-winwust.c9users.io/xpath.html");
		
		js = (JavascriptExecutor)driver;
		try {
			js.executeScript("return jQuery() != null");
		} catch (WebDriverException e) {
			injectJQuery(js);
		}		
	}

	@Test
	public void testJqueryContains() {
		List<WebElement> trs = (List<WebElement>)js
				.executeScript("return jQuery.find('tr:contains(\"Toys\")')");
		assertEquals("Toys $100 35", trs.get(0).getText());
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	private void injectJQuery(JavascriptExecutor js) {
		String script = "var head = document.getElementsByTagName('head')[0];" + 
				"var newScript = document.createElement('script');" + 
				"newScript.type = 'text/javascript';" +
				"newScript.src='https://code.jquery.com/jquery-2.2.3.min.js';" + 
				"head.appendChild(newScript);";
		js.executeScript(script);
	}
}
