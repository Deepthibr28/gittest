package WebTesting_UCSC;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigationUCSCE {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		
		driver.get("http://www.ucsc-extension.edu/");
		
		// first approach using to()
		WebElement ul = driver.findElement(By.cssSelector("#section-footer ul.menu:first-child"));
		List<WebElement> links = ul.findElements(By.tagName("a"));
		List<String> urls = new ArrayList<String>();
		for (WebElement link : links) {
			urls.add(link.getAttribute("href"));
		}
		for (int i = 0; i < urls.size(); i++) {
			driver.navigate().to(urls.get(i));
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver d) {
					return ((JavascriptExecutor)d).executeScript("return document.readyState").equals("complete");
				}
			});
			File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFile, new File("src/screenshots/screen"+i+".png"));
		}

		// second approach using back()
//		WebElement ul = driver.findElement(By.cssSelector("#section-footer ul.menu:first-child"));
//		List<WebElement> links = ul.findElements(By.tagName("a"));
//		
//		for (int i = 0; i < links.size(); i++) {
//			WebElement link = driver.findElement(By.cssSelector("#section-footer ul.menu:first-child > li.leaf:nth-child("+(i+1)+") > a"));
//			link.click();
//			WebDriverWait wait = new WebDriverWait(driver, 30);
//			wait.until(new ExpectedCondition<Boolean>() {
//				public Boolean apply(WebDriver d) {
//					return ((JavascriptExecutor)d).executeScript("return document.readyState").equals("complete");
//				}
//			});
//			File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//			FileUtils.copyFile(srcFile, new File("src/screenshots/screen"+(i+1)+".png"));
//			driver.navigate().back();
//			wait.until(new ExpectedCondition<Boolean>() {
//				public Boolean apply(WebDriver d) {
//					return ((JavascriptExecutor)d).executeScript("return document.readyState").equals("complete");
//				}
//			});
//		}

		driver.quit();
	}

}
