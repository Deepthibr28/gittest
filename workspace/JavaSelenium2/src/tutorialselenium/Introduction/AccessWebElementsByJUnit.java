package tutorialselenium.Introduction;

import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AccessWebElementsByJUnit {
	private WebDriver driver;
	private String baseurl1, baseurl2, baseurl3;

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseurl1 = "http://letskodeit.teachable.com/p/practice";
		baseurl2 = "http://output.jsbin.com/osebed/2";
		baseurl3 = "file:///D:/Deepthi_Home/Selenium/webtesting/workspace/select.html";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void test_RadiobuttonAndCheckBoxes() throws Exception {
		driver.get(baseurl1);
		WebElement bmwradiobtn = driver.findElement(By.id("bmwradio"));
		bmwradiobtn.click();
		Thread.sleep(2000);
		WebElement benzradiobtn = driver.findElement(By.id("benzradio"));
		benzradiobtn.click();
		Thread.sleep(2000);
		List<WebElement> radiolist = driver.findElements(By.xpath("//input[@name='cars' and @type='radio']"));
		assertEquals(radiolist.size(), 3);
		for (WebElement i : radiolist) {
			System.out.println(i.getAttribute("value"));
		}
		Thread.sleep(2000);
		WebElement bmwchkbox = driver.findElement(By.id("bmwcheck"));
		bmwchkbox.click();
		WebElement benzchkbox = driver.findElement(By.id("benzcheck"));
		benzchkbox.click();
		assertTrue("True", benzchkbox.isSelected());
	}

	@Test
	public void test_DropDowns() throws Exception {
		driver.get(baseurl1);
		Select sel = new Select(driver.findElement(By.id("carselect")));
		assertEquals(sel.getOptions().size(), 3);
		sel.selectByValue("benz");
		Thread.sleep(2000);
		sel.selectByIndex(0);
	}

	@Test
	public void 
		asserttest_MultiSelect() throws Exception {
		driver.get(baseurl2);
		Select sel = new Select(driver.findElement(By.id("fruits")));
		assertEquals(sel.isMultiple(), true);
		sel.selectByVisibleText("Apple");
		Thread.sleep(2000);

		sel.deselectByValue("apple");
		Thread.sleep(2000);

		sel.selectByIndex(3);
		sel.selectByValue("orange");
		List<String> actualOptions = new ArrayList<String>();
		
		for (WebElement option : sel.getAllSelectedOptions())
		{
		actualOptions.add(option.getText());
		}
		System.out.println(actualOptions);
		Thread.sleep(2000);
		sel.deselectAll();
	}

	@Test
	public void test_SingleSelect() {
		driver.get(baseurl3);
		Select sel = new Select(driver.findElement(By.id("car")));
		List<String> expectedOptions =Arrays.asList("Pick a car", "Volvo", "Saab", "Mercedes", "Audi");
		List<String> actualOptions = new ArrayList<String>();
		for (WebElement option : sel.getOptions())
		{
		actualOptions.add(option.getText());
		}
		assertArrayEquals(expectedOptions.toArray(),actualOptions.toArray());
		
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

}
