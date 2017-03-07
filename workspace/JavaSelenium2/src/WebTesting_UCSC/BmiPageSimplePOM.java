package WebTesting_UCSC;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BmiPageSimplePOM {
	private WebDriver driver;
	private By weight = By.name("weightKg");
	private By height = By.name("heightCMS");
	private By bmiValue = By.name("bmi");
	private By bmiCategory = By.name("bmi_category");
	private By calculate = By.id("Calculate");
	
	public BmiPageSimplePOM(WebDriver driver) {
		this.driver = driver;
	}
	
	public void setWeight(String weight) {
		driver.findElement(this.weight).sendKeys(weight);
	}
	public void setHeight(String height) {
		driver.findElement(this.height).sendKeys(height);
	}
	public String getBmiValue() {
		return driver.findElement(this.bmiValue).getAttribute("value");
	}
	public String getBmiCategory() {
		return driver.findElement(this.bmiCategory).getAttribute("value");
	}
	public void clickCalculate() {
		driver.findElement(calculate).click();
	}
}
