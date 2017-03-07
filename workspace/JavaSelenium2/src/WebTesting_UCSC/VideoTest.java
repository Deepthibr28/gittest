package WebTesting_UCSC;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class VideoTest {
	private WebDriver driver;
	
	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("file:///D:/Deepthi_Home/Selenium/webtesting/workspace/video.html");
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void testMetadata() {
		WebElement videoPlayer = driver.findElement(By.tagName("video"));
		JavascriptExecutor jsDriver = (JavascriptExecutor)driver;
		String src = (String)jsDriver.executeScript("return arguments[0].currentSrc", videoPlayer);
		int duration = ((Double)jsDriver.executeScript("return arguments[0].duration", videoPlayer)).intValue();
		
		assertEquals("https://selenium-testing-winwust.c9users.io/html5_mov.mp4", src);
		assertEquals(10, duration);
		
		System.out.println(videoPlayer.getSize().getWidth());
		System.out.println(videoPlayer.getSize().getHeight());
		System.out.println(videoPlayer.getLocation().getX());
		System.out.println(videoPlayer.getLocation().getY());
	}
	
	@Test
	public void testPlayAndPause() throws InterruptedException, IOException {
		WebElement videoPlayer = driver.findElement(By.tagName("video"));
		JavascriptExecutor jsDriver = (JavascriptExecutor)driver;
		jsDriver.executeScript("arguments[0].play()", videoPlayer);
		
		Thread.sleep(5000);
		
		jsDriver.executeScript("arguments[0].pause()", videoPlayer);
		
		Thread.sleep(1000);
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("target/screenshots/whole_screen.png"));
		
		FileUtils.copyFile(WebElementExtender.captureElementPicture(videoPlayer),
				new File("target/screenshots/movie.png"));
	}
}
