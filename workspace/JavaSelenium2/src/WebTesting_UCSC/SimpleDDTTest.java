package WebTesting_UCSC;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(Parameterized.class)
public class SimpleDDTTest {
	private WebDriver driver;
	
	private String height;
	private String weight;
	private String bmi;
	private String bmiCategory;
	
	@Parameters
	public static List<String[]> testData() {
		return Arrays.asList(new String[][] {
			{"160", "45", "17.6", "Underweight"},
			{"168", "70", "24.8", "Normal"},
			{"181", "89", "27.2", "Overweight"},
			{"178", "100", "31.6", "Obesity"}
		});
	}
	
	public SimpleDDTTest(String height, String weight, String bmi, String bmiCategory) {
		this.height = height;
		this.weight = weight;
		this.bmi = bmi;
		this.bmiCategory = bmiCategory;
	}

	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://selenium-testing-winwust.c9users.io/bmicalculator.html");
	}
	
	@Test
	public void testBMICalculator() {
		WebElement heightField = driver.findElement(By.name("heightCMS"));
		heightField.clear();
		heightField.sendKeys(height);
		
		WebElement weightField = driver.findElement(By.name("weightKg"));
		weightField.clear();
		weightField.sendKeys(weight);
		
		WebElement button = driver.findElement(By.id("Calculate"));
		button.click();
		
		WebElement bmiLabel = driver.findElement(By.name("bmi"));
		assertEquals(bmi, bmiLabel.getAttribute("value"));

		WebElement bmiCategoryLabel = driver.findElement(By.name("bmi_category"));
		assertEquals(bmiCategory, bmiCategoryLabel.getAttribute("value"));
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}
