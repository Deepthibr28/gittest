package WebTesting_UCSC;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.PixelGrabber;
import java.util.Arrays;

public class ScreenshotChecker {
	public static boolean CompareScreenshot(String expectedFile, String actualFile) throws InterruptedException {
		Image expectedImage = Toolkit.getDefaultToolkit().getImage(expectedFile);
		Image actualImage = Toolkit.getDefaultToolkit().getImage(actualFile);
		
		PixelGrabber expectedGrab = new PixelGrabber(expectedImage, 0, 0, -1, -1, false);
		PixelGrabber actualGrab = new PixelGrabber(actualImage, 0, 0, -1, -1, false);
		
		int[] expectedData = null;
		int[] actualData = null;
		
		if (expectedGrab.grabPixels()) {
			int width = expectedGrab.getWidth();
			int height = expectedGrab.getHeight();
			expectedData = new int[width * height];
			expectedData = (int[])expectedGrab.getPixels();
		}
				
		if (actualGrab.grabPixels()) {
			int width = actualGrab.getWidth();
			int height = actualGrab.getHeight();
			actualData = new int[width * height];
			actualData = (int[])actualGrab.getPixels();
		}
		
		return Arrays.equals(expectedData, actualData);
	}
}
