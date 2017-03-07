package edu.ucsce.webapptesting.examples.unit8;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(Parameterized.class)
public class BmiPageObjectModelTest {
	private WebDriver driver;
	private BmiPageSimplePOM bmiPage;

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
	
	public BmiPageObjectModelTest(String height, String weight, String bmi, String bmiCategory) {
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
		bmiPage = new BmiPageSimplePOM(driver);
	}
	
	@Test
	public void testBMICalculator() throws InterruptedException {
		bmiPage.setHeight(height);
		bmiPage.setWeight(weight);
		bmiPage.clickCalculate();
		assertEquals(bmi, bmiPage.getBmiValue());
		assertEquals(bmiCategory, bmiPage.getBmiCategory());
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
}
