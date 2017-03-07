package WebTesting_UCSC;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class BmiPage {
	private WebDriver driver;
	
	@FindBy(name = "heightCMS")
	private WebElement height;
	
	@FindBy(how = How.NAME, using = "weightKg")
	private WebElement weight;
	
	@FindBy(name = "bmi")
	private WebElement bmiValue;
	
	@FindBy(name = "bmi_category")
	private WebElement bmiCategory;
	
	@FindBy(id = "Calculate")
	private WebElement calculate;
	
	private String url = "http://selenium-testing-winwust.c9users.io/bmicalculator.html";
	
	public BmiPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		driver.get(url);
	}
	
	public void setHeight(String height) {
		this.height.sendKeys(height);
	}
	
	public void setWeight(String weight) {
		this.weight.sendKeys(weight);
	}
	
	public void clickCalculate() {
		this.calculate.click();
	}
	
	public String getBmiValue() {
		return this.bmiValue.getAttribute("value");
	}
	
	public String getBmiCategory() {
		return this.bmiCategory.getAttribute("value");
	}
	
	public void calculate(String height, String weight) {
		this.setHeight(height);
		this.setWeight(weight);
		this.clickCalculate();
	}
}
