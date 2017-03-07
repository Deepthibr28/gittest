package tutorialselenium.Introduction;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SwitchFrameAndAlert {
	WebDriver driver;
	String baseURL,baseURL2;
	private JavascriptExecutor js;

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		js=(JavascriptExecutor)driver;
		baseURL = "https://letskodeit.teachable.com/p/practice";
		baseURL2= "file:///D:/Deepthi_Home/Selenium/webtesting/workspace/alert.html";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		
	}
	@Test
	public void testFrames() throws Exception {
		driver.get(baseURL);
		js.executeScript("window.scrollBy(0,1900);"); // scroll down
		Thread.sleep(2000);
		//driver.switchTo().frame("courses-iframe");// By id
		//driver.switchTo().frame("iframe-name"); // By name 
		driver.switchTo().frame(0); // By number
		System.out.println(driver.findElements(By.xpath("//iframe")).size());
		WebElement searchBox = driver.findElement(By.id("search-courses"));
		searchBox.sendKeys("python");
		driver.switchTo().defaultContent();
    }
	
	@Test
	public void testalert1() throws Exception {
		driver.get(baseURL);
		js.executeScript("window.scrollBy(0,100);");
		Thread.sleep(2000);
		driver.findElement(By.id("name")).sendKeys("Deepthi");
		driver.findElement(By.id("alertbtn")).click();
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
    }
	@Test
	public void testalert2() throws Exception {
		driver.get(baseURL);
		js.executeScript("window.scrollBy(0,100);");
		Thread.sleep(2000);
		driver.findElement(By.id("name")).sendKeys("Deepthi");
		driver.findElement(By.id("confirmbtn")).click();
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		//alert.accept();
		alert.dismiss();
		
    }
	//@Test
	public void testClickButton() {
		driver.get(baseURL2);
		WebElement button = driver.findElement(By.cssSelector("input[type=button]"));
		button.click();
		
		Alert alert = driver.switchTo().alert();
		
		assertEquals("Hello World", alert.getText());
		
		alert.accept();
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}


}
