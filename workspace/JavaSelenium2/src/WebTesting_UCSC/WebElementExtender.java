package WebTesting_UCSC;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.WrapsDriver;

public class WebElementExtender {
	public static void highlightElement(WebElement element) {
		JavascriptExecutor driver = (JavascriptExecutor) ((WrapsDriver)element).getWrappedDriver();
		driver.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red');", element);
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			
		}
	}
	
	public static File captureElementPicture(WebElement element) throws IOException {
		WebDriver driver = ((WrapsDriver)element).getWrappedDriver();
		File screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		BufferedImage img = ImageIO.read(screen);
		
		int width = element.getSize().getWidth();
		int height = element.getSize().getHeight();
		int x = element.getLocation().getX();
		int y = element.getLocation().getY();
		
		BufferedImage dest = img.getSubimage(x, y, width, height);
		
		ImageIO.write(dest, "png", screen);
		
		return screen;
	}
}
