package WebTesting_UCSC;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DragAndDrop {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./src/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://www.dhtmlgoodies.com/scripts/arrange-table-rows/demo.html");
		WebElement row1 = driver.findElement(By.cssSelector("#row1 > .dg-arrange-table-rows-drag-icon"));
		Actions builder = new Actions(driver);
		
		builder.clickAndHold(row1);
		builder.moveByOffset(0, 100);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("dg-arrange-table-rows-insertion-marker")));
		builder.release().perform();
	}

}
