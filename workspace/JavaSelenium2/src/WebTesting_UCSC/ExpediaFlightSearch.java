package WebTesting_UCSC;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExpediaFlightSearch {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.expedia.com/");
		
		try {
			WebElement flightTab = driver.findElement(By.id("tab-flight-tab"));
			flightTab.click();
			WebElement fromLocation = driver.findElement(By.id("flight-origin"));
			fromLocation.clear();
			fromLocation.sendKeys("San Francisco, CA");
			WebElement toLocation = driver.findElement(By.id("flight-destination"));
			toLocation.clear();
			toLocation.sendKeys("New York, NY");
			WebElement departing = driver.findElement(By.id("flight-departing"));
			departing.clear();
			departing.sendKeys("07/20/2016");
			WebElement returning = driver.findElement(By.id("flight-returning"));
			returning.clear();
			returning.sendKeys("07/24/2016");
			
			WebElement adult = driver.findElement(By.id("flight-adults"));
			Select adultSelect = new Select(adult);
			adultSelect.selectByValue("3");
			
			WebElement children = driver.findElement(By.id("flight-children"));
			Select childrenSelect = new Select(children);
			childrenSelect.selectByValue("2");
			
			WebElement age1 = driver.findElement(By.id("flight-age-select-1"));
			Select age1Select = new Select(age1);
			age1Select.selectByValue("5");
			
			WebElement age2 = driver.findElement(By.id("flight-age-select-2"));
			Select age2Select = new Select(age2);
			age2Select.selectByValue("10");
			
			WebElement addCar = driver.findElement(By.id("flight-add-car-checkbox"));
			if (!addCar.isSelected()) {
				addCar.click();
			}
			
//			Thread.sleep(5000);
			
			WebElement searchButton = driver.findElement(By.id("search-button"));
			searchButton.click();
			
			WebElement status = driver.findElement(By.cssSelector("#wizardSearch .secondary-playback"));
			System.out.println(status.getText());
			
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("acol-interstitial")));
			
			List<WebElement> lis = driver.findElements(By.cssSelector("#flightModuleList > li"));
			
			for (WebElement li : lis) {
				System.out.println();
				System.out.println("Departure time: " + li.findElement(By.className("departure-time")).getText());
				System.out.print("Arrival time: " + li.findElement(By.className("arrival-time")).getText());
				try {
					li.findElement(By.className("next-day"));
					System.out.println(" (next day)");
				} catch (NoSuchElementException e) {
					System.out.println();
				}
				System.out.println("Price: " + 
						li.findElement(By.className("dollars")).getText() + 
						li.findElement(By.className("cents")).getText());
			}
		} finally {
			driver.quit();
		}
	}
}
