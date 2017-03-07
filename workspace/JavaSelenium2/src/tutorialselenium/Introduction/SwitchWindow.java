package tutorialselenium.Introduction;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SwitchWindow {
	WebDriver driver;
	String baseURL;

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseURL = "https://letskodeit.teachable.com/p/practice";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(baseURL);
	}

	@Test
	public void test() throws Exception {
	String parenthandle = driver.getWindowHandle();
	System.out.println("Parent handle: "+parenthandle);
	WebElement openwindow = driver.findElement(By.id("openwindow"));
	openwindow.click();
	Thread.sleep(2000);
	Set<String>handles = driver.getWindowHandles();
	for(String handle:handles){
		if(!handle.equals(parenthandle)){
			driver.switchTo().window(handle);
			WebElement searchBox = driver.findElement(By.id("search-courses"));
			searchBox.sendKeys("python");
			driver.close();
			break;
		}
	}
	driver.switchTo().window(parenthandle);
	driver.findElement(By.id("name")).sendKeys("Test Successful!");

		
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

}

