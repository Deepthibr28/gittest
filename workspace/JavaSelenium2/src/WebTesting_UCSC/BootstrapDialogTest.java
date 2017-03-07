package WebTesting_UCSC;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BootstrapDialogTest {
	private WebDriver driver;
	
	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://selenium-testing-winwust.c9users.io/bootstrapDialog.html");
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void testDefault() {
		BootstrapDialog dialog = new BootstrapDialog(driver.findElement(By.id("modalDlg")));
		assertFalse(dialog.getDialog().isDisplayed());
	}
	
	@Test
	public void testOpen() {
		driver.findElement(By.id("btn")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				WebElement dlg = d.findElement(By.id("modalDlg"));
				return dlg.getCssValue("display").equals("block");
			}
		});
		BootstrapDialog dialog = new BootstrapDialog(driver.findElement(By.id("modalDlg")));
		assertTrue(dialog.getDialog().isDisplayed());
		assertEquals("Hello World", dialog.getTitle());
		assertEquals("Hello World from Silicon Valley!!!", dialog.getBodyText());
	}
	
	@Test
	public void testOpenandClose() {
		driver.findElement(By.id("btn")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				WebElement dlg = d.findElement(By.id("modalDlg"));
				return dlg.getCssValue("display").equals("block");
			}
		});
		BootstrapDialog dialog = new BootstrapDialog(driver.findElement(By.id("modalDlg")));
		assertTrue(dialog.getDialog().isDisplayed());
		dialog.closeByIcon();
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				WebElement dlg = d.findElement(By.id("modalDlg"));
				return dlg.getCssValue("display").equals("none");
			}
		});
		assertFalse(dialog.getDialog().isDisplayed());
	}
}
