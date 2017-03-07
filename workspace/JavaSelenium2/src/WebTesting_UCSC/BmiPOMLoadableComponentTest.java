package WebTesting_UCSC;

import static org.junit.Assert.assertEquals;

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
public class BmiPOMLoadableComponentTest {
	private WebDriver driver;
	private BmiPageLoadableComponent bmiPage;

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
	
	public BmiPOMLoadableComponentTest(String height, String weight, String bmi, String bmiCategory) {
		this.height = height;
		this.weight = weight;
		this.bmi = bmi;
		this.bmiCategory = bmiCategory;
	}
	
	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		bmiPage = new BmiPageLoadableComponent(driver);
		bmiPage.get();
	}
	
	@Test
	public void testBMICalculator() throws InterruptedException {
		bmiPage.calculate(height, weight);
		assertEquals(bmi, bmiPage.getBmiValue());
		assertEquals(bmiCategory, bmiPage.getBmiCategory());
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
}
